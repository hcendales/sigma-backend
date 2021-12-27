package co.gov.umv.sigma.backend.externo.dto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.jose4j.json.internal.json_simple.JSONObject;

import com.google.gson.Gson;

import co.gov.umv.sigma.backend.administracion.cbo.UMVPersonLogin;
import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.config.AppConfig;
import co.gov.umv.sigma.backend.externo.cbo.ObjetoNegocioOE;

public class ExternoDTO {
	private final static Logger log = Logger.getLogger(ExternoDTO.class);
	
	public ObjetoSalida consumirExterno(ObjetoNegocioOE OE) {
		return generarJSON(OE);
	}
	
	public File consumirArchivoExterno(ObjetoNegocioOE OE) throws IOException{
		return generarArchivoExterno(OE);
	}
	
	private ObjetoSalida generarJSON(ObjetoNegocioOE OE) {
		ObjetoSalida os = new ObjetoSalida();
		JSONObject salida = new JSONObject();
		StringEntity params;
		//
		AppConfig config = new AppConfig();
		ObjetoNegocioOE OEE = new ObjetoNegocioOE();
		OEE.setUrl(config.getProp().getProperty("caliope.token"));
		OEE.setJson("{\"usuario\":\""+OE.getUsuario()+"\",\"username\":\""+OE.getUsuario()+"\"}");
		String token = traerToken(OEE);
		//
		log.info("JSON " + OE.getJson());
		log.info("URL " + OE.getUrl());
		try {
			params = new StringEntity(OE.getJson(),"UTF-8");
	        HttpClient client = new DefaultHttpClient();
	        HttpPost request = new HttpPost(OE.getUrl());                
	        request.setHeader("Accept", "application/json");
	        request.setHeader("Content-Type","application/json" );
	        request.setHeader("Authorization","Bearer "+ token);
	        request.setEntity(params);
	        HttpResponse response = client.execute(request);
	        StringBuilder result = new StringBuilder();
	        log.info("Status Code " + response.getStatusLine().getStatusCode());
	        if(response.getStatusLine().getStatusCode() == 200) {
		        InputStream inputStream = response.getEntity().getContent();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	            String inputLine;
	            while ((inputLine = reader.readLine()) != null) {
	                result.append(inputLine);
	            }
	            //se crea la nueva respuesta y se retorna
	            LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
	            List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
	            map.put("json",result);
	            respuesta.add(map);
	            os.setRespuesta(respuesta);
	            os.setCodError(CodError.OPERACION_CORRECTA);
	            os.setMsgError("Operacion exitosa!!");
		    }else {
		    	log.error("Status Code " + response.getStatusLine().getStatusCode());		        
		    	if(response.getStatusLine().getStatusCode() == 500) {
		    		InputStream inputStream = response.getEntity().getContent();
			        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		            String inputLine;
		            while ((inputLine = reader.readLine()) != null) {
		                result.append(inputLine);
		            }
		            log.error(" Resultado fallido " + result);
		            //se crea la nueva respuesta y se retorna
		            LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		            List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
		            map.put("json",result);
		            respuesta.add(map);
		            os.setRespuesta(respuesta);
		            os.setCodError(CodError.ERROR_INTERNO);
		            os.setMsgError("");
		    	}else {
		    		log.error("Status Code " + response.getStatusLine().getStatusCode());
		    		os.setCodError(CodError.ERROR_INTERNO);
		            os.setMsgError("El servicio no se ejecuto correctamente " + response.getStatusLine().getStatusCode());
		    	}
		    	
		    }
		} catch (Exception e) {
			os.setCodError(CodError.ERROR_INTERNO);
            os.setMsgError("Consulta No exitosa" + e.toString());
			e.printStackTrace();
		} 
        
		return os;
	}
	
	public ObjetoSalida generarJSONWithoutToken(UMVPersonLogin OE) {
		ObjetoSalida os = new ObjetoSalida();
		JSONObject salida = new JSONObject();
		StringEntity params;
		//
		AppConfig config = new AppConfig();
		ObjetoNegocioOE OEE = new ObjetoNegocioOE();
		String url = config.getProp().getProperty("caliope.autenticacion");
		String Json = "{\"usuario\":\""+OE.getUsuario()+"\",\"username\":\""+OE.getUsuario()+"\",\"password\":\""+OE.getPassword()+"\"}";
		//String token = traerToken(OEE);
		log.info(Json);
		try {
			params = new StringEntity(Json);
	        HttpClient client = new DefaultHttpClient();
	        HttpPost request = new HttpPost(url);                
	        request.setHeader("Accept", "application/json");
	        request.setHeader("Content-Type","application/json; charset=utf-8" );
	        request.setEntity(params);
	        HttpResponse response = client.execute(request);
	        StringBuilder result = new StringBuilder();
	        log.info("Status Code " + response.getStatusLine().getStatusCode());
	        if(response.getStatusLine().getStatusCode() == 200) {
	        	InputStream inputStream = response.getEntity().getContent();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	            String inputLine;
	            while ((inputLine = reader.readLine()) != null) {
	                result.append(inputLine);
	            }
	            //se crea la nueva respuesta y se retorna
	            LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
	            List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
	            
	            org.hornetq.utils.json.JSONObject jsontoken= new org.hornetq.utils.json.JSONObject(result.toString());  // these 4  add jsonObject to jsonArray
	            for (int tamaniojson = 0 ; tamaniojson < jsontoken.getJSONArray("respuesta").length(); tamaniojson++) {
	            	org.hornetq.utils.json.JSONObject obj = jsontoken.getJSONArray("respuesta").getJSONObject(tamaniojson);
	            	//log.info(obj);
	            	map = new Gson().fromJson(obj.toString(),LinkedHashMap.class);
	            	respuesta.add(map);
	            }
	            
	            
	            //map.put("json",result);
	            os.setRespuesta(respuesta);
	            os.setCodError(CodError.OPERACION_CORRECTA);
	            os.setMsgError("Consulta exitosa!!");
	            inputStream.close();
	            
	        }else {
	        	//System.out.println();
	        	log.error("Status Code " + response.getStatusLine().getStatusCode());
	        	if(response.getStatusLine().getStatusCode() == 500) {
		    		InputStream inputStream = response.getEntity().getContent();
			        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		            String inputLine;
		            while ((inputLine = reader.readLine()) != null) {
		                result.append(inputLine);
		            }
		            log.error(" Resultado " + result);
		            //se crea la nueva respuesta y se retorna
		            LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		            List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
		            map.put("json",result);
		            respuesta.add(map);
		            os.setRespuesta(respuesta);
		            os.setCodError(CodError.ERROR_INTERNO);
		            os.setMsgError("");
		    	}else {
		    		log.fatal("Status Code " + response.getStatusLine().getStatusCode());
		    		os.setCodError(CodError.ERROR_INTERNO);
		            os.setMsgError("El servicio no se ejecuto correctamente " + response.getStatusLine().getStatusCode());
		    	}
	        }
	        
		} catch (Exception e) {
			
			os.setCodError(CodError.ERROR_INTERNO);
            os.setMsgError("Consulta No exitosa!! " + e.toString());
			e.printStackTrace();
		} 
        
		return os;
	}
	
	private String traerToken(ObjetoNegocioOE OE) {
		String token = "";
		StringEntity params;
		try {
			log.info("JSON " + OE.getJson());
			log.info("URL " + OE.getUrl());
			
			params = new StringEntity(OE.getJson(),"UTF-8");
	        HttpClient client = new DefaultHttpClient();
	        HttpPost request = new HttpPost(OE.getUrl());                
	        request.setHeader("Accept", "application/json");
	        request.setHeader("Content-Type","application/json" );
	        //request.setHeader("Authorization","Bearer "+ token);
	        request.setEntity(params);
	        HttpResponse response = client.execute(request);
	        StringBuilder result = new StringBuilder();
	        log.info("Status Code " + response.getStatusLine().getStatusCode());
	        if(response.getStatusLine().getStatusCode() == 200) {
	        	InputStream inputStream = response.getEntity().getContent();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	            String inputLine;
	            while ((inputLine = reader.readLine()) != null) {
	                result.append(inputLine);
	            }
	            //se crea la nueva respuesta y se retorna
	            org.hornetq.utils.json.JSONObject jsontoken= new org.hornetq.utils.json.JSONObject(result.toString());  // these 4  add jsonObject to jsonArray
	            for (int tamaniojson = 0 ; tamaniojson < jsontoken.getJSONArray("respuesta").length(); tamaniojson++) {
	            	org.hornetq.utils.json.JSONObject obj = jsontoken.getJSONArray("respuesta").getJSONObject(tamaniojson);
	            	token = obj.getString("token");
	            }
	        }else {
	        	log.error("Status Code " + response.getStatusLine().getStatusCode());
	        	token = "";
	        }
	        
	        //log.info(token);
		} catch (Exception e) {
			log.error("Falle " + e.toString());
			e.printStackTrace();
		} 
		
		return token;
	}
	
	public ObjetoSalida generarObjetoSalida(ObjetoNegocioOE OE) {
		ObjetoSalida os = new ObjetoSalida();
		JSONObject salida = new JSONObject();
		StringEntity params;
		//
		AppConfig config = new AppConfig();
		ObjetoNegocioOE OEE = new ObjetoNegocioOE();
		OEE.setUrl(config.getProp().getProperty("caliope.token"));
		OEE.setJson("{\"usuario\":\""+OE.getUsuario()+"\",\"username\":\""+OE.getUsuario()+"\"}");
		String token = traerToken(OEE);
		//
		log.info("JSON " + OE.getJson());
		log.info("URL " + OE.getUrl());
		
		try {
			params = new StringEntity(OE.getJson(),"UTF-8");
	        HttpClient client = new DefaultHttpClient();
	        HttpPost request = new HttpPost(OE.getUrl());                
	        request.setHeader("Accept", "application/json");
	        request.setHeader("Content-Type","application/json" );
	        request.setHeader("Authorization","Bearer "+ token);
	        request.setEntity(params);
	        HttpResponse response = client.execute(request);
	        StringBuilder result = new StringBuilder();
	        log.info("Status Code " + response.getStatusLine().getStatusCode());
			
	        if(response.getStatusLine().getStatusCode() == 200) {
	        	InputStream inputStream = response.getEntity().getContent();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,StandardCharsets.UTF_8)); //ajuste para manejo de acentos.
	            String inputLine;
	            while ((inputLine = reader.readLine()) != null) {
	                result.append(inputLine);
	            }
	            //se crea la nueva respuesta y se retorna
	            LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
	            List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
	            
	            org.hornetq.utils.json.JSONObject jsontoken= new org.hornetq.utils.json.JSONObject(result.toString());  // these 4  add jsonObject to jsonArray
	            for (int tamaniojson = 0 ; tamaniojson < jsontoken.getJSONArray("respuesta").length(); tamaniojson++) {
	            	org.hornetq.utils.json.JSONObject obj = jsontoken.getJSONArray("respuesta").getJSONObject(tamaniojson);
	            	map = new Gson().fromJson(obj.toString(),LinkedHashMap.class);
	            	respuesta.add(map);
	            }
	            
	            
	            //map.put("json",result);
	            os.setRespuesta(respuesta);
	            os.setCodError(CodError.OPERACION_CORRECTA);
	            os.setMsgError("Consulta exitosa!!");
	            inputStream.close();
	            
	        }else {
	        	//System.out.println();
	        	log.error("Status Code " + response.getStatusLine().getStatusCode());
	        	if(response.getStatusLine().getStatusCode() == 500) {
		    		InputStream inputStream = response.getEntity().getContent();
			        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		            String inputLine;
		            while ((inputLine = reader.readLine()) != null) {
		                result.append(inputLine);
		            }
		            log.error(" Resultado " + result);
		            //se crea la nueva respuesta y se retorna
		            LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		            List<LinkedHashMap<String, Object>> respuesta = new ArrayList<LinkedHashMap<String, Object>>();
		            map.put("json",result);
		            respuesta.add(map);
		            os.setRespuesta(respuesta);
		            os.setCodError(CodError.ERROR_INTERNO);
		            os.setMsgError("");
		    	}else {
		    		log.fatal("Status Code " + response.getStatusLine().getStatusCode());
		    		os.setCodError(CodError.ERROR_INTERNO);
		            os.setMsgError("El servicio no se ejecuto correctamente " + response.getStatusLine().getStatusCode());
		    	}
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			os.setCodError(CodError.ERROR_INTERNO);
            os.setMsgError("Operacion fallida!! " + e.toString());
			e.printStackTrace();
		} 
        
		return os;
	}

	
	private File generarArchivoExterno(ObjetoNegocioOE OE) throws IOException {
        AppConfig config = new AppConfig();
        
        ObjetoNegocioOE OEE = new ObjetoNegocioOE();
		OEE.setUrl(config.getProp().getProperty("caliope.token"));
		OEE.setJson("{\"usuario\":\""+OE.getUsuario()+"\",\"username\":\""+OE.getUsuario()+"\"}");
		String token = traerToken(OEE);
		
        URL serverUrl = new URL(OE.getUrl());
        HttpURLConnection urlConnection = (HttpURLConnection)serverUrl.openConnection();
 
        // Indicate that we want to write to the HTTP request body
        urlConnection.setDoOutput(true);
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-Type", "application/json");
        urlConnection.setRequestProperty("Authorization", "Bearer " + token);
        // Writing the post data to the HTTP request body
        BufferedWriter httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
        httpRequestBodyWriter.write(OE.getJson());
        httpRequestBodyWriter.close();
        // Get a readable channel from url connection
        File f = null;
        if(urlConnection.getResponseCode() == 200) {
        	ReadableByteChannel readableChannelForHttpResponseBody = Channels.newChannel(urlConnection.getInputStream());
            // Create the file channel to save file
            FileOutputStream fosForDownloadedFile = new FileOutputStream(config.getProp().getProperty("org.gov.umv.ReporteCaliope"));
            FileChannel fileChannelForDownloadedFile = fosForDownloadedFile.getChannel();
     
            // Save the contents of HTTP response to local file
            fileChannelForDownloadedFile.transferFrom(readableChannelForHttpResponseBody, 0, Long.MAX_VALUE);
            
            f = new File(config.getProp().getProperty("org.gov.umv.ReporteCaliope"));

        } else {
        	f = null;
        }
        return f;
	}     
	
	private File generarArchivoExterno1(ObjetoNegocioOE OE) throws IOException {
        URL url = new URL(OE.getUrl());
        AppConfig config = new AppConfig();
        
        ObjetoNegocioOE OEE = new ObjetoNegocioOE();
		OEE.setUrl(config.getProp().getProperty("caliope.token"));
		OEE.setJson("{\"usuario\":\""+OE.getUsuario()+"\",\"username\":\""+OE.getUsuario()+"\"}");
		String token = traerToken(OEE);
		StringEntity params;
		params = new StringEntity(OE.getJson(),"UTF-8");
        HttpClient client = new DefaultHttpClient();
        HttpPost request = new HttpPost(OE.getUrl());                
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-Type","application/json" );
        request.setHeader("Authorization","Bearer "+ token);
        request.setEntity(params);
        HttpResponse response = client.execute(request);
        String saveDir = config.getProp().getProperty("org.gov.umv.Documentos");
        // always check HTTP response code first
        File f = null;
        System.out.println("Response Code " + response.getStatusLine().getStatusCode());
        if (response.getStatusLine().getStatusCode() == 200) {
        	String fileName = "";
        	String disposition = response.getFirstHeader("Content-Disposition").getValue();
            String fileURL = OE.getUrl();
            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }
        	
        	InputStream is = response.getEntity().getContent();
        	String saveFilePath = saveDir + File.separator + fileName;
             
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[is.available()];
            while ((bytesRead = is.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            is.close();
            System.out.println("Descargando Archivo Correctamente");
        }else {
        	System.out.println("No funciono algo ocurrio");
        }
        return f;
		
	}
	
	
}
