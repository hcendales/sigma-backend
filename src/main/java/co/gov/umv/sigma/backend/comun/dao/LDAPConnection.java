package co.gov.umv.sigma.backend.comun.dao;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.ldap.core.CollectingAuthenticationErrorCallback;

import co.gov.umv.sigma.backend.administracion.cbo.UMVPerson;
import co.gov.umv.sigma.backend.administracion.cbo.UMVPersonLogin;
import co.gov.umv.sigma.backend.comun.config.AppConfig;

/**
 * 
 * @author juanmetalmolina
 *
 */
public class LDAPConnection {
	
	/*private static String INITIAL_CONTEXT = "com.sun.jndi.ldap.LdapCtxFactory";
	//private static final String URL = "ldap://192.168.150.11:389/";
	private static String URL = "ldap://192.168.100.42:389/";
	private static String USERNAME = "CN=Proyecto GISUMV,OU=Sistemas,OU=Usuarios,OU=UMVSEDADM,DC=umv,DC=gov,DC=co";
	private static String PASSWORD = "SIGUmv.2018*";
	private static String BASE = "DC=umv,DC=gov,DC=co";
	private static String ERRLDAPAUTHCODE = "49";
	*/
	private static String INITIAL_CONTEXT;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	private static String BASE;
	private static String ERRLDAPAUTHCODE = "49";
	
	public static DirContext connectToLDAP() throws NamingException{
		  
		  AppConfig config = new AppConfig();
		  INITIAL_CONTEXT = config.getProp().getProperty("ldap.initialcontext");		  
		  URL = config.getProp().getProperty("ldap.urls");
		  USERNAME = config.getProp().getProperty("ldap.username");
		  BASE = config.getProp().getProperty("ldap.base");
		  PASSWORD = config.getProp().getProperty("ldap.password");
		  Hashtable<String, String>  env = new Hashtable<String, String>();
		  env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT);
		  env.put(Context.PROVIDER_URL, URL+BASE);
		  env.put(Context.SECURITY_AUTHENTICATION,"simple");
		  env.put(Context.SECURITY_PRINCIPAL, USERNAME);
		  env.put(Context.SECURITY_CREDENTIALS,PASSWORD);
		  DirContext ctx = new InitialDirContext(env);
		  System.out.println("Authentication Success!");
		  return ctx;
	}
	
	public static void closeConnectionToLDAP(DirContext ctx) {
	    try {
	        ctx.close();
	    } catch (NamingException e) {
	        e.printStackTrace();
	    }
	}
	
	public static boolean correctLogin(String username, String password) { //El usuario ya viene con toda la ruta
	    try {
	    	
	        Hashtable<String, String> env = new Hashtable<String, String>();
	        env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT);
	        env.put(Context.PROVIDER_URL, URL+BASE);
	        env.put(Context.SECURITY_AUTHENTICATION,"simple");
	        env.put(Context.SECURITY_PRINCIPAL, username);
	        env.put(Context.SECURITY_CREDENTIALS,password);
	        DirContext ctx = new InitialDirContext(env);
	        ctx.close();
	        return true;
	    }catch (AuthenticationException authEx) {
	    	authEx.printStackTrace();
            return false;
	    }catch (NamingException e) {
	    	e.printStackTrace();
	        return false;
	    }
	    
	}
	
	public static UMVPerson validarUsuario(UMVPersonLogin OE) throws Exception {
  	  	
		NamingEnumeration<?> results = null;
		DirContext authContext = null;
		CollectingAuthenticationErrorCallback errorCallback = new CollectingAuthenticationErrorCallback();

		UMVPerson person = new UMVPerson();
		try {
		    authContext = connectToLDAP();
		    SearchControls controls = new SearchControls();
		    controls.setCountLimit(500000);
		    controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		    //results = authContext.search("", "(objectClass=person)", controls);
		    results = authContext.search("", "(sAMAccountName="+OE.getUsername()+")", controls);
		    SearchResult result = (SearchResult) results.next(); // Sabemos que habra un solo resultado
		    person.setUsername(result.getAttributes().get("sAMAccountName").get().toString());
    	    person.setDistinguishedName(result.getAttributes().get("distinguishedName").get().toString());
    	    if(correctLogin(person.getDistinguishedName(), OE.getPassword())) {
    	    	person.setEmail(result.getAttributes().get("userPrincipalName").get().toString());
			    person.setNombres(result.getAttributes().get("givenName").get().toString());
			    person.setDisplayName(result.getAttributes().get("displayName").get().toString());
			    person.setApellidos(result.getAttributes().get("sn").get().toString());
			    ArrayList<String> memberOf = new ArrayList<String>();
			    person.setNumDocumento(result.getAttributes().get("employeeid").get().toString());
			    //System.out.println("Hola" + result.getAttributes().get("employeeid").get().toString());
			    
			    for(Enumeration<?> vals = result.getAttributes().get("memberOf").getAll(); vals.hasMoreElements();){
			            memberOf.add((String)vals.nextElement());
			    }
		        person.setRoles(memberOf);
		        person.setAuthenticationMessage("0");
    	    }else {
    	    	person.setUsername("");
			    person.setDistinguishedName("");
			    person.setEmail("");
			    person.setNombres("");
			    person.setDisplayName("");
			    person.setApellidos("");
				    
    	    }
    	    //1) lookup the ldap account
    	    System.out.println("Authentication Success!");
		    
		}/* catch (AuthenticationException authEx) {
		    System.out.println("Authentication failed!");
		    authEx.printStackTrace();
		    return person;
		} catch (NamingException namEx) {
		    System.out.println("Something went wrong!");
		    namEx.printStackTrace();
		    //throw new RuntimeException(namEx);
		    return person;
		}//*/
		catch(Exception ex) {
			ex.printStackTrace();
			errorCallback.execute(ex);
			Exception err = errorCallback.getError();
			System.out.println(ErrorMessage(err));
			person.setAuthenticationMessage(ErrorMessage(err));
			return person;
		}
		finally {
			if (results != null) {
				try {
					results.close();
				} catch (Exception e) {
		    }
		}
			if (authContext != null) {
			    try {
			    	authContext.close();
			    } catch (Exception e) {
			    }
			}
		}
		return person;
   }    	
	
   public static String ErrorMessage(Exception error) {
	   if(error == null) {
			return "";
		}
		System.out.println(error.toString());
		Pattern p = Pattern.compile("code [1-9]*.*? -|, data [1-9]*.*?,");
		Matcher m = p.matcher(error.toString());
		try {
			m.find();
		    String errCode = m.group(0);
		    errCode = errCode.substring(5,errCode.length()-2);
		    if(errCode.equals(ERRLDAPAUTHCODE)) {
		    	m.find();
			    String dataCode = m.group(0);
			    //codigo de error especifico de autenticaci�m
			    dataCode = dataCode.substring(7,dataCode.length()-1);
		    	return dataCode;
		    }
		    return "";
		}catch(Exception e) {
			return "";
		}
   }
   public static boolean validarUsuarioLDAP(UMVPersonLogin OE) throws Exception {
  	  	
		NamingEnumeration<?> results = null;
		DirContext authContext = null;
		UMVPerson person = new UMVPerson();
		try {
		    authContext = connectToLDAP();
		    SearchControls controls = new SearchControls();
		    controls.setCountLimit(500000);
		    controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		    results = authContext.search("", "(sAMAccountName="+OE.getUsername().toLowerCase()+")", controls);
		    SearchResult result = (SearchResult) results.next(); // Sabemos que habra un solo resultado
		    person.setUsername(result.getAttributes().get("sAMAccountName").get().toString());
    	    person.setDistinguishedName(result.getAttributes().get("distinguishedName").get().toString());
    	    //System.out.println(result.toString());
    	    if(correctLogin(person.getDistinguishedName(), OE.getPassword())) {
    	    	//System.out.println(result.toString());
    	    	person.setAuthenticationResponse("SI");			    
    	    	System.out.println("AUTENTICACION CORRECTA!");
    	    }else {
    	    	System.out.println("Login invalido");
    	    	person.setAuthenticationResponse("NO");
			    
    	    		    
    	    }
    	    //1) lookup the ldap account
    	    
	    
		} catch (AuthenticationException authEx) {
		    System.out.println("AUTENTICACION FALLIDA!");
		    authEx.printStackTrace();
		    person.setAuthenticationResponse("NO");
		    
		} catch (NamingException namEx) {
		    System.out.println("ALGO MALO OCURRIO CON LA CONEXION AL SERVIDOR DE LDAP!");
		    namEx.printStackTrace();
		    person.setAuthenticationResponse("NO");
		    //throw new RuntimeException(namEx);
		    
		}//*/
		finally {
			if (results != null) {
				try {
					results.close();
				} catch (Exception e) {
					e.printStackTrace();
		    }
		}
			if (authContext != null) {
			    try {
			    	authContext.close();
			    } catch (Exception e) {
			    	e.printStackTrace();
			    }
			}
		}
		
		if (person.getAuthenticationResponse().equals("SI")) {
			return true;
		}else {
			return false;
		}
		
   }
}
