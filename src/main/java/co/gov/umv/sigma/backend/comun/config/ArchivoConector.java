/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.config;
/*
import co.gov.umv.caliope.cbo.ObjetoSalida;
import co.gov.umv.caliope.entity.TabLista;
import co.gov.umv.caliope.pkg.bll.IListaFAC;
import co.gov.umv.caliope.pkg.bll.imp.ListaFAC;
import co.gov.umv.caliope.pkg.bll.imp.ReporteFAC;
import co.gov.umv.caliope.pkg.cbo.ArchivoOE;
import co.gov.umv.caliope.pkg.cbo.ListaOE;
import co.gov.umv.caliope.pkg.dal.imp.ArchivoDAO;
*/
//import gov.mads.gestor.utl.fachada.IListadosFAC;
//import gov.mads.gestor.utl.fachada.impl.ListadosFAC;
//import gov.mads.gestor.utl.vista.ListarParametricoOE;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;

//import com.aspose.words.Document;
import com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator;
import com.sun.xml.bind.v2.runtime.reflect.opt.FieldAccessor_Double;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.test.Docx1;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
//import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
//import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import pl.jsolve.sweetener.io.Resources;
import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.VariablePattern;
import pl.jsolve.templ4docx.variable.ImageType;
import pl.jsolve.templ4docx.variable.ImageVariable;
import pl.jsolve.templ4docx.variable.TableVariable;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variable;
import pl.jsolve.templ4docx.variable.Variables;

/*import com.spire.xls.*;
import com.spire.doc.*;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.*;
import org.apache.pdfbox.pdmodel.font.*;
import com.grapecity.documents.excel.*;
import com.grapecity.documents.excel.drawing.*;*/
/**
 *
 * @author juanmetalmolina
 */
public class ArchivoConector {
    public String getFileName(MultivaluedMap<String, String> header) {

        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

        for (String filename : contentDisposition) {
                if ((filename.trim().startsWith("filename"))) {

                        String[] name = filename.split("=");

                        String finalFileName = name[1].trim().replaceAll("\"", "");
                        return finalFileName;
                }
        }
        return "unknown";
    }

    public String rutaParametrica() {
    	AppConfig app = new AppConfig();
    	
    	return app.getProp().getProperty("org.gov.umv.photoStorageDiagnostico");
    }
    
    public String rutaParametricaDocumento() {
    	AppConfig app = new AppConfig();
    	
    	return app.getProp().getProperty("org.gov.umv.carpetaDocumento");
    }
    
    public String rutaParametricaDocumentos() {
    	AppConfig app = new AppConfig();
    	
    	return app.getProp().getProperty("org.gov.umv.Documentos");
    }
    
    public String rutaParametricaMantenimientos() {
    	AppConfig app = new AppConfig();
    	
    	return app.getProp().getProperty("org.gov.umv.Mantenimientos");
    }
    
    public String rutaParametricaArchivos() {
    	AppConfig app = new AppConfig();
    	
    	return app.getProp().getProperty("org.gov.umv.Archivos");
    }
    
    /*public String obtenerRutaAdjuntoParametrica(String idUsuario) {

        IListaFAC fachadaLista = new ListaFAC();
        ListaOE listaOE = new ListaOE();
        TabLista lista = new TabLista((long) 1050);
        listaOE.setLista(lista);
        listaOE.setUsuario(idUsuario);
        listaOE.setFiltro("1050");
        ObjetoSalida objetoSalidaParametrica = fachadaLista.consultarLista(listaOE);
        return objetoSalidaParametrica.getRespuesta().get(0).get("valor").toString();
    }
    
    public String obtenerParametrica(String idUsuario, String filtro) {

        IListaFAC fachadaLista = new ListaFAC();
        ListaOE listaOE = new ListaOE();
        TabLista lista = new TabLista((long) 1050);
        listaOE.setLista(lista);
        listaOE.setUsuario(idUsuario);
        listaOE.setFiltro(filtro);
        ObjetoSalida objetoSalidaParametrica = fachadaLista.consultarLista(listaOE);
        return objetoSalidaParametrica.getRespuesta().get(0).get("valor").toString();
    }
    
    /*
    public String obtenerRutaReporteParametrica(Integer idUsuario) {

        IListadosFAC fachadaListados = new ListadosFAC();
        ListarParametricoOE listaOE = new ListarParametricoOE();
        listaOE.setIdUsuario(idUsuario);
        listaOE.setCategoria("REPORTE");
        ObjetoSalida objetoSalidaParametrica = fachadaListados.listarParametrico(listaOE);

        return objetoSalidaParametrica.getRespuesta().get(0).get("a102valor").toString();
    }

    public String obtenerRutaPlantillaParametrica(Integer idUsuario) {

        IListadosFAC fachadaListados = new ListadosFAC();
        ListarParametricoOE listaOE = new ListarParametricoOE();
        listaOE.setIdUsuario(idUsuario);
        listaOE.setCategoria("PLANTILLA");
        ObjetoSalida objetoSalidaParametrica = fachadaListados.listarParametrico(listaOE);

        return objetoSalidaParametrica.getRespuesta().get(0).get("a102valor").toString();
    }
*/    
    public File almacenarArchivo(Map<String, List<InputPart>> camposAdjuntoOE, String rutaAdjuntoParametrica, String username, Long idDocumento) throws Exception{
        File archivoS = null;
        try (InputStream lecturaAdjunto = camposAdjuntoOE.get("file").get(0).getBody(InputStream.class, null)){
        		String nombreCarpeta = "";
        		if(username.equals("")) {
        			nombreCarpeta = rutaAdjuntoParametrica  + File.separator + idDocumento;        			
        		}else {
        			nombreCarpeta = rutaAdjuntoParametrica + File.separator + username + File.separator + idDocumento;        			            	
        		}
        		File carpetaAdjunto = new File(nombreCarpeta);
                MultivaluedMap<String, String> header = camposAdjuntoOE.get("file").get(0).getHeaders();
                String nombreArchivo = getFileName(header);
                if (!carpetaAdjunto.exists())
                    carpetaAdjunto.mkdirs();
                /*else if (carpetaAdjunto.isDirectory())
                for (File antiguo : carpetaAdjunto.listFiles())
                    antiguo.delete();*/        
                //archivoAdjunto = new File();
                String nombreArchivoServ = nombreCarpeta+ File.separator +nombreArchivo;

                archivoS = new File(nombreArchivoServ);
                byte [] bytes = IOUtils.toByteArray(lecturaAdjunto);
                FileOutputStream fop = new FileOutputStream(archivoS);

                fop.write(bytes);
                fop.flush();
                fop.close();

            } catch (Exception e) {
            	e.printStackTrace();
                throw new Exception(e);
            }
        return archivoS;        
    }
    
    public File almacenarArchivoF(Map<String, List<InputPart>> camposAdjuntoOE, String rutaAdjuntoParametrica) throws Exception{
        File archivoS = null;
        try (InputStream lecturaAdjunto = camposAdjuntoOE.get("file").get(0).getBody(InputStream.class, null)){

                File carpetaAdjunto = new File(rutaAdjuntoParametrica );
                MultivaluedMap<String, String> header = camposAdjuntoOE.get("file").get(0).getHeaders();
                String nombreArchivo = getFileName(header);
                if (!carpetaAdjunto.exists())
                    carpetaAdjunto.mkdirs();
                /*else if (carpetaAdjunto.isDirectory())
                for (File antiguo : carpetaAdjunto.listFiles())
                    antiguo.delete();*/        
                //archivoAdjunto = new File();
                String nombreArchivoServ = rutaAdjuntoParametrica +  File.separator+nombreArchivo;

                archivoS = new File(nombreArchivoServ);
                byte [] bytes = IOUtils.toByteArray(lecturaAdjunto);
                FileOutputStream fop = new FileOutputStream(archivoS);

                fop.write(bytes);
                fop.flush();
                fop.close();

            }
            catch (NullPointerException e){
            	e.printStackTrace();
                return archivoS;
            }
            catch (Exception e) {
            	e.printStackTrace();
                throw new Exception(e);
            }
        return archivoS;        
    }
    
    public File almacenarArchivoF(Map<String, List<InputPart>> camposAdjuntoOE, String nombreArchivoSel,String rutaAdjuntoParametrica) throws Exception{
        File archivoS = null;
        try (InputStream lecturaAdjunto = camposAdjuntoOE.get(nombreArchivoSel).get(0).getBody(InputStream.class, null)){

                File carpetaAdjunto = new File(rutaAdjuntoParametrica );
                MultivaluedMap<String, String> header = camposAdjuntoOE.get(nombreArchivoSel).get(0).getHeaders();
                String nombreArchivo = getFileName(header);
                if (!carpetaAdjunto.exists())
                    carpetaAdjunto.mkdirs();
                /*else if (carpetaAdjunto.isDirectory())
                for (File antiguo : carpetaAdjunto.listFiles())
                    antiguo.delete();*/        
                //archivoAdjunto = new File();
                String nombreArchivoServ = rutaAdjuntoParametrica +  File.separator+nombreArchivo;

                archivoS = new File(nombreArchivoServ);
                byte [] bytes = IOUtils.toByteArray(lecturaAdjunto);
                FileOutputStream fop = new FileOutputStream(archivoS);

                fop.write(bytes);
                fop.flush();
                fop.close();

            }
            catch (NullPointerException e){
            	e.printStackTrace();
                return archivoS;
            }
            catch (Exception e) {
            	e.printStackTrace();
            	throw new Exception(e);
            }
        return archivoS;        
    }
    
    public static File generateDoc(String URL, String trg, Variables variable) throws Exception {
        // create new instance of docx template
        Docx docx = new Docx(URL);
        
        // set the variable pattern. In this example the pattern is as follows: #{variableName}
        docx.setVariablePattern(new VariablePattern("#{", "}"));

        // read docx content as simple text
        String content = docx.readTextContent();

        // and display it
        //System.out.println(content); 

        // find all variables satisfying the pattern #{...}
        java.util.List<String> findVariables = docx.findVariables();

        // and display it
        for (String var : findVariables) {
                //System.out.println("VARIABLE => " + var);
        }

        // prepare map of variables for template                    
        
        //var.addImageVariable(new ImageVariable("${photofooter}" , footer, ImageType.JPEG, 75, 75));
        // fill template by given map of variables
        docx.fillTemplate(variable);

        // save filled document
        docx.save(trg);
        
        /*String URLs = trg.replace(".docx", ".pdf");
        //System.out.println(URLs);*/
        return new File(trg);//ConvertToPDF(trg, URLs);
    }
    
    public static File generateDoc(ObjetoSalida os,HashMap<String, Integer> orden,String plantilla, String nuevaPlantilla ,Integer numeroFilas,
    		Integer anchoImg, Integer altoImg ) throws Exception {
        // create new instance of docx template
    	List<LinkedHashMap<String, Object>> datosReporte = os.getRespuesta(); 
    	Docx1 docx = new Docx1(plantilla);
        // set the variable pattern. In this example the pattern is as follows: #{variableName}
        docx.setVariablePattern(new VariablePattern("#{", "}"));
        AppConfig config = new AppConfig();
        // read docx content as simple text
        String content = docx.readTextContent();
        
        
        // and display it
        
        // find all variables satisfying the pattern #{...}
        
        Variables var = new Variables();
        LocalDate date = LocalDate.now();
        String dia = String.valueOf(date.getDayOfMonth());        
        String mes = devolverMesEspaniol(date.getMonth().name());
        String anio = String.valueOf(date.getYear());
        var.addTextVariable(new TextVariable("#{dia}",dia));
        var.addTextVariable(new TextVariable("#{mes}",mes));
        var.addTextVariable(new TextVariable("#{anio}",anio));
        //var.addImageVariable(new ImageVariable("#{logo}", "C:\\Users\\juanmetalmolina\\OneDrive\\Im�genes\\LogoAlcaldiaUMV.jpg", 200, 200)  );
        
        Integer width =  anchoImg != null ? anchoImg : Integer.parseInt(config.getProp().getProperty("org.gov.umv.width"));
        Integer height = altoImg  != null ? altoImg : Integer.parseInt(config.getProp().getProperty("org.gov.umv.height"));
        
        System.out.println("Objeto Salida" + os.getRespuesta());
        List<String> findVariables1 = docx.findVariables();

	     // and display it
	    for (String variable : findVariables1) {
	    	System.out.println("Variables " + variable);
	    	//var.addTextVariable(new TextVariable(variable,""));
	    }
        for (String nomColumna : datosReporte.get(0).keySet()) {
        	//System.out.println("Columna " + nomColumna );
        	String valor = "";
        	
        	if(nomColumna.contains("fecha")) {
        		String pattern = "yyyy-MM-dd";
				Format simpleDateFormat = new SimpleDateFormat(pattern);
				
        		Object obj = (datosReporte.get(0).get(nomColumna) == null) ? null: datosReporte.get(0).get(nomColumna);
        		valor = (obj == null ) ? "" : simpleDateFormat.format(obj);        		
        	}else {
        		valor = (datosReporte.get(0).get(nomColumna) == null) ? "": datosReporte.get(0).get(nomColumna).toString();
        	}
        	String etiqueta = "#{" + nomColumna + "}";
        	//System.out.println("Valor Global: " + valor);
        	if(etiqueta.contains("url") && !valor.equals("")) {
        		//valor = "D:\\Instaladores\\Images\\29401667_177799609519578_261420301231849472_n.jpg";
        		File logo = null;
        		//System.out.println("Valor " + valor);
        		if(valor.contains("http")) {
        			logo = Resources.asFile(new URL(valor), File.createTempFile("tmpPhoto", ".tmp" ));
        		//	System.out.println("Path URL" + logo.getAbsolutePath());
        		}
        		else {
        			logo = new File(valor);
        		//	System.out.println("Path " + logo.getAbsolutePath());
        		}
        		
        		var.addImageVariable(new ImageVariable(etiqueta, logo.getAbsolutePath(), ImageType.JPEG, width, height));        		
        		
        	}else{
        		if(etiqueta.contains("fecha")) {
        				
    				var.addTextVariable(new TextVariable(etiqueta,valor));
    				//System.out.println(" Si es Etiqueta: " + etiqueta +","+ " Valor: " + valor );
        		}else {
        			var.addTextVariable(new TextVariable(etiqueta,valor));
        			//System.out.println(" No es Etiqueta: " + etiqueta +","+ " Valor: " + valor );
        		}
        			        		
        		
        	}
        	
        	        	
        }
        if(!os.getRespuestaM().isEmpty()) {
        	System.out.println("Hay Multiples " + os.getRespuestaM().isEmpty());
        	System.out.println("Respuesta Valida " + os.getRespuestaM());
        	for(List<LinkedHashMap<String, Object>> datos:os.getRespuestaM()) {
        		List<List<Variable>> lad1 = new ArrayList<List<Variable>>();
                TableVariable tableVariable2 = new TableVariable();
                List<LinkedHashMap<String,Object>> datos1 = datos;
                Set<String> name = datos1.get(0).keySet();
                for (String n : name){
                    List<Variable> lad = new ArrayList<Variable>();                        
                    for(LinkedHashMap<String,Object> item : datos){
                        String etiqueta = "#{" + n +"}";
                        if(item.get(n) ==  null) {
                        	System.out.println("Vacio " + item.get(n) + " nombre " + n);
                        }
                        String valor = (item.get(n) ==  null) ? "" : item.get(n).toString();
                        System.out.println("Etiquetas " + etiqueta + " nombre " + n + " Valor " + valor);
                        lad.add(new TextVariable(etiqueta,valor));
                    }
                    lad1.add(lad);
                }
                
                for(List<Variable> it : lad1){
                    tableVariable2.addVariable(it);
                }
                var.addTableVariable(tableVariable2);
			}
        	
    		
		}
        	
        
        // and display it
        
        // prepare map of variables for template                    
        
        //var.addImageVariable(new ImageVariable("${photofooter}" , footer, ImageType.JPEG, 75, 75));
        // fill template by given map of variables
        docx.fillTemplate(var);
        List<String> findVariables = docx.findVariables();

	     // and display it
	    for (String variable : findVariables) {
	    	System.out.println("Variables Faltantes" + variable);
	    	var.addTextVariable(new TextVariable(variable," "));
	    }
	    
	    docx.fillTemplate(var);
        String contents = docx.readTextContent();
        System.out.println(contents);
        // and display it
        // save filled document
        String fileextension = "." + FilenameUtils.getExtension(nuevaPlantilla);
    	//nuevaPlantilla = nuevaPlantilla.replace(fileextension, "");
    	File resultado = new File(nuevaPlantilla);        
        String nombreResultado = resultado.getAbsolutePath();
        System.out.println("Nombre Resultado " + nombreResultado);
    	docx.save(nombreResultado);
    	String generarPdf = "SI";
        String URLs = nombreResultado.replace(".docx", ".pdf");
        //System.out.println(URLs);//*/
        ConvertToPDF(nombreResultado, URLs);
        if(generarPdf.equals("SI")) {
        	//return null;
        	return ConvertToPDF(nombreResultado, URLs);
        }else {
        	return resultado;
        }//*/
        
    }
/*
    private static String generarRutasArchivo(Long IdDocumento) {
    	ArchivoDAO archivo = new ArchivoDAO();
        ArchivoOE entrada = new ArchivoOE();
        String filtro = "ID_DOCUMENTO = " + IdDocumento;
        entrada.setFiltro(filtro);
    	ObjetoSalida os = archivo.consultarPorFiltroArchivo(entrada);
    	if(os.esRespuestaOperacionCorrecta()) {
    		String cadena = "";
    		for (LinkedHashMap<String,Object> item : os.getRespuesta()) {
    			String URL = (item.get("url_archivo") == null) ? "" : item.get("url_archivo").toString();  
    			if(!URL.equals("")) {
    				cadena = cadena + URL + ";";
    			}    			    			
    		}
    		return cadena;
    	}else {
    		return "";
    	}
    	
    }
 */   
    
    public File generarReporte(ObjetoSalida os,HashMap<String, Integer> orden,String plantilla, String nuevaPlantilla, Integer numeroFilas, boolean activado) throws Exception {

    	String fileextension = "." + FilenameUtils.getExtension(nuevaPlantilla);
    	List<LinkedHashMap<String, Object>> datosReporte = os.getRespuesta();
    	
    	nuevaPlantilla = nuevaPlantilla.replace(fileextension, "");
    	
    	//File directorio = new File("/home/juanmetalmolina/"); // @Todo No utilizar la ruta
        String excelFilePath = plantilla; // @Todo Modificar por la plantilla de la BD
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));//*/
         
        //Workbook libro = new XSSFWorkbook(new File(excelFilePath));
        XSSFWorkbook libro = new XSSFWorkbook(inputStream); 
        //libro.setVBAProject(inputStream);
        //XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja = (XSSFSheet) libro.getSheet(libro.getSheetName(0));
        //org.apache.log4j.Logger log = Logger.getLogger( ReporteFAC.class );
        CellStyle style = libro.createCellStyle();//Create style
        Font font = libro.createFont();//Create font
        font.setFontHeightInPoints((short)11);
        font.setFontName("Arial");
        //font.setColor(IndexedColors.GREY_40_PERCENT.getIndex());
        font.setBold(true);
        font.setItalic(false);
        //style.setFillBackgroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        //style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        //style.setAlignment(CellStyle.ALIGN_CENTER);
        
        style.setFont(font);//set it to bold
        if (datosReporte != null && !datosReporte.isEmpty()) {

            Integer numFila = numeroFilas-1; // 
            Row filaTitulos = hoja.getRow(numFila++);
            
            Integer numColumnaEncabezado = 0;
            
            HashMap<String, Integer> map = sortByComparator(orden, true);
            
            /*for (String nomColumna : map.keySet()) {
            	
            //for (String nomColumna : datosReporte.get(0).keySet()) {
                Cell celda = filaTitulos.createCell(numColumnaEncabezado++);
                celda.setCellStyle(style);
                celda.setCellValue(nomColumna);
            }*/

            for (LinkedHashMap<String, Object> fila : datosReporte) {
                //TreeMap<String, Object> sorted = new TreeMap<>(fila);
                
                
                Row filaDatos = hoja.createRow(numFila++);
                Integer numColumna = 0;
                //for (String nomColumna : sorted.keySet()) {
        	    for (String nomColumna : map.keySet()) {                           	
                	Cell celda = filaDatos.createCell(numColumna++);
                    //if(isNumeric((sorted.get(nomColumna) == null ? "" : sorted.get(nomColumna)).toString())){
                	if(isNumeric((fila.get(nomColumna) == null ? "" : fila.get(nomColumna)).toString())){
                		
                		double dato = Double.parseDouble((fila.get(nomColumna)).toString());
                        celda.setCellType(CellType.NUMERIC);
                		celda.setCellValue((double) (fila.get(nomColumna) == null ? 0 : dato));
                		
                		//double dato = Double.parseDouble((sorted.get(nomColumna)).toString());
                        //celda.setCellValue((double) (sorted.get(nomColumna) == null ? 0 : dato));
                    }else{
                        //celda.setCellValue(sorted.get(nomColumna) == null ? "" : (sorted.get(nomColumna)).toString());
                    	String texto = (fila.get(nomColumna) == null) ? "" : (fila.get(nomColumna)).toString();
                    	celda.setCellValue(texto);
                    }
                    
                    
                    
                }
            }
        } 
        if(activado) {
        	for (int i = 0 ; i < libro.getNumberOfSheets();i++) {
            	XSSFSheet hojan = (XSSFSheet) libro.getSheet(libro.getSheetName(i));
                String contrasenia = EncriptarN("ReporteIntervencion2020", "UMV");
            	//System.out.println(contrasenia);
                hojan.protectSheet(contrasenia);
            	hojan.enableLocking();
                
            }
        }
        
        //hoja.enableLocking();
        String generarPdf = "NO";
        File resultado = File.createTempFile(nuevaPlantilla + "_",fileextension);//, directorio);        
        libro.setForceFormulaRecalculation(true);
        try (FileOutputStream escrituraReporte = new FileOutputStream(resultado)) {
            libro.write(escrituraReporte);            
        } catch (Exception e) {
        	e.printStackTrace();
            throw new Exception(e);
        }
        String nombreResultado = resultado.getAbsolutePath();
        String URLs = nombreResultado.replace("." + FilenameUtils.getExtension(nombreResultado), ".pdf");  
        //generatePDF(nombreResultado, URLs);
        boolean b = resultado.setReadOnly();
        //System.out.println("El archivo es de solo lectura " + b);
        
        if(generarPdf.equals("SI")) {
        	          
        	//return ConvertExcelToPDF(nombreResultado, URLs);
        	return null;
        }else {
        	return resultado;
        }
        
    }
    
    private boolean isNumeric(String s) {
        return java.util.regex.Pattern.matches("\\d+", s);
    }
    
    public static File ConvertToPDF(String docPath, String pdfPath) {

    	File target = null; 
        try {
            InputStream doc = new FileInputStream(new File(docPath));
            XWPFDocument document = new XWPFDocument(doc);
            PdfOptions options = PdfOptions.create();
            OutputStream out = new FileOutputStream(new File(pdfPath));
            PdfConverter.getInstance().convert(document, out, options);
            document.close();
            out.close();
            target = new File(pdfPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return target;
    }//*/
    /*
    public static File ConvertExcelToPDF(String docPath, String pdfPath) {
        File target = null;
        //System.out.println("DocPath " + docPath);
        //System.out.println("pdfPath " + pdfPath);
        com.spire.xls.Workbook workbook = new com.spire.xls.Workbook();
        workbook.loadFromFile(docPath);
        //Fit to page
        workbook.getConverterSetting().setSheetFitToPage(true);
        Worksheet worksheet = workbook.getWorksheets().get(1);
        //Save as PDF document
        worksheet.saveToPdf(pdfPath);
        
        target = new File(pdfPath);
            
        return target;
    }*/
    /*private static void generatePDF(String docPath, String pdfPath) throws Exception {
    	Workbook workbook = new Workbook();
		// Open an excel file
    	//System.out.println("Nombre del archivo xlsx: " + docPath);
    	//System.out.println("Nombre del archivo pdf: " + pdfPath);
		InputStream fileStream = getResourceStream(docPath);
		workbook.open(fileStream);
			
		//save to an pdf file
		workbook.save(pdfPath);
    }*/
    
    private static InputStream getResourceStream(String resource) throws Exception{
	    return ArchivoConector.class.getClassLoader().getResourceAsStream(resource);
	}
    
    private static HashMap<String, Integer> sortByComparator(HashMap<String, Integer> unsortMap, final boolean order)
    {
        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });
        // Maintaining insertion order with the help of LinkedList
        HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
        	sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
    
    private static String devolverMesEspaniol(String month) {
    	String mes = "";
    	switch(month) {
    		case "JANUARY":{
    			mes = "enero";
    			break;
    		}
    		case "FEBRUARY":{
    			mes = "febrero";
    			break;
    		}
    		case "MARCH":{
    			mes = "marzo";
    			break;
    		}
    		case "APRIL":{
    			mes = "abril";
    			break;
    		}
    		case "MAY":{
    			mes = "mayo";
    			break;
    		}
    		case "JUNE":{
    			mes = "junio";
    			break;
    		}
    		case "JULY":{
    			mes = "julio";
    			break;
    		}
    		case "AUGUST":{
    			mes = "agosto";
    			break;
    		}
    		case "SEPTEMBER":{
    			mes = "septiembre";
    			break;
    		}
    		case "OCTOBER":{
    			mes = "octubre";
    			break;
    		}
    		case "NOVEMBER":{
    			mes = "noviembre";
    			break;
    		}
    		case "DECEMBER":{
    			mes = "diciembre";
    			break;
    		}
    		default:{
    			mes = "";
    		}
    	}
    	return mes;
    }
    
    public File exportarReporteCatalogo(List<LinkedHashMap<String, Object>> datosReporte,HashMap<String, Integer> orden,String plantilla, String nuevaPlantilla) throws Exception {

    	String fileextension = "." + FilenameUtils.getExtension(nuevaPlantilla);
    	
    	
    	nuevaPlantilla = nuevaPlantilla.replace(fileextension, "");
    	
    	//File directorio = new File("/home/juanmetalmolina/"); // @Todo No utilizar la ruta
        String excelFilePath = plantilla; // @Todo Modificar por la plantilla de la BD
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));//*/
         
        //Workbook libro = new XSSFWorkbook(new File(excelFilePath));
        XSSFWorkbook libro = new XSSFWorkbook(inputStream);    
        //XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja = (XSSFSheet) libro.getSheet(libro.getSheetName(0));
        //org.apache.log4j.Logger log = Logger.getLogger( ReporteFAC.class );
        CellStyle style = libro.createCellStyle();//Create style
        Font font = libro.createFont();//Create font
        font.setFontHeightInPoints((short)11);
        font.setFontName("Arial");
        //font.setColor(IndexedColors.GREY_40_PERCENT.getIndex());
        font.setBold(true);
        font.setItalic(false);
        //style.setFillBackgroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        //style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        //style.setAlignment(CellStyle.ALIGN_CENTER);
        
        style.setFont(font);//set it to bold
        if (datosReporte != null && !datosReporte.isEmpty()) {

            Integer numFila = 0; // 
            Row filaTitulos = hoja.getRow(numFila++);
            
            Integer numColumnaEncabezado = 0;
            
            HashMap<String, Integer> map = sortByComparator(orden, true);
            
            for (String nomColumna : map.keySet()) {
            	
            //for (String nomColumna : datosReporte.get(0).keySet()) {
                Cell celda = filaTitulos.createCell(numColumnaEncabezado++);
                celda.setCellStyle(style);
                celda.setCellValue(nomColumna);
            }//*/
            //System.out.println(datosReporte);
            for (HashMap<String, Object> fila : datosReporte) {
                //TreeMap<String, Object> sorted = new TreeMap<>(fila);
                
                
                Row filaDatos = hoja.createRow(numFila++);
                Integer numColumna = 0;
                //for (String nomColumna : sorted.keySet()) {
        	    for (String nomColumna : map.keySet()) {                           	
                	Cell celda = filaDatos.createCell(numColumna++);
                    //if(isNumeric((sorted.get(nomColumna) == null ? "" : sorted.get(nomColumna)).toString())){
                	if(isNumeric((fila.get(nomColumna) == null ? "" : fila.get(nomColumna)).toString())){
                		
                		double dato = Double.parseDouble((fila.get(nomColumna)).toString());
                		celda.setCellType(CellType.NUMERIC);
                		celda.setCellValue((double) (fila.get(nomColumna) == null ? 0 : dato));
                		
                		//double dato = Double.parseDouble((sorted.get(nomColumna)).toString());
                        //celda.setCellValue((double) (sorted.get(nomColumna) == null ? 0 : dato));
                    }else{
                        //celda.setCellValue(sorted.get(nomColumna) == null ? "" : (sorted.get(nomColumna)).toString());
                    	String texto = (fila.get(nomColumna) == null) ? "" : (fila.get(nomColumna)).toString();
                    	
                    	if(nomColumna.contains("fecha") && !texto.equals("")) {
                    		
                    		celda.setCellValue(texto.substring(0, 10));
                    	}else {
                    		celda.setCellValue(texto);
                    	}
                    	
                    	
                    }
                    
                    
                    
                }
            }
        }
        File resultado = File.createTempFile(nuevaPlantilla + "_",fileextension);//, directorio);        
        libro.setForceFormulaRecalculation(true);
        try (FileOutputStream escrituraReporte = new FileOutputStream(resultado)) {
            libro.write(escrituraReporte);
            libro.close();
            escrituraReporte.close();
            
        } catch (Exception e) {
        	e.printStackTrace();
            throw new Exception(e);
        }        
        return resultado;
    }
    
    public static String EncriptarN(String texto, String secretKey) {
    	 
        //String secretKey = "qualityinfosolutions"; //llave para encriptar datos
        String base64EncryptedString = "";
 
        try {
 
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
 
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
 
            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return base64EncryptedString;
    }
    
    public static String DesencriptarN(String textoEncriptado, String secretKey){
 
        //String secretKey = "qualityinfosolutions"; //llave para desenciptar datos
        String base64EncryptedString = "";
 
        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
 
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
 
            byte[] plainText = decipher.doFinal(message);
 
            base64EncryptedString = new String(plainText, "UTF-8");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return base64EncryptedString;
    }
    
    
}
