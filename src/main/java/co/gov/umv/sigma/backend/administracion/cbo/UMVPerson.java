package co.gov.umv.sigma.backend.administracion.cbo;

import java.util.ArrayList;

/**
 * Objeto generico para em paquetar una persona recuperada del LDAP.
 * 
 * @author carlos.rivera
 *
 */
public class UMVPerson {
	
	// sAMAccountName en el LDAP
	private String username;
	
	private String authenticationResponse;
	
	//Nombre completo
	private String displayName;
	
	//Atributo givenName en el LDAP
	private String nombres;
	
	//Atributo sn en el LDAP
	private String apellidos;
	
	
	//DN value LDAP
	private String distinguishedName;
	
	// Campo userPrincipalName  en LDAP
	private String email;
	
	//Lista de atributos memberOf 
	private ArrayList<String> roles;
	
	//Numero de identificacion Employeed ID
	private String numDocumento;
	
	//Mensaje de autenticacion
	private String authenticationMessage;
	
	/**
	 * Constructor de la clase UMVPerson, inicializa la lista de roles
	 */
	public UMVPerson (){
		
		//Lista de atributos memberOf 
		roles = new ArrayList<String>();
		
	}
	

	/**
	 * Constructor de la clase UMVPerson, inicializa la lista de roles
	 */
	public UMVPerson (String response){
		
		//Lista de atributos memberOf 
		roles = new ArrayList<String>();
		authenticationResponse = response;
	}
	
	/**
	 * 
	 * @return Un strinbg con el email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAuthenticationResponse() {
		return authenticationResponse;
	}
	
	/**
	 * 
	 * @param authenticationResponse
	 */
	public void setAuthenticationResponse(String authenticationResponse) {
		this.authenticationResponse = authenticationResponse;
	}
	
	/**
	 * 
	 * @return Lista ArrayList<String> con los roles del UMVPerson
	 */
	public ArrayList<String> getRoles() {
		return roles;
	}
	
	/**
	 * 
	 * @param roles
	 */
	public void setRoles(ArrayList<String> roles) {
		this.roles = roles;
	} 
	
	/**
	 * 
	 * @return 
	 */
	public String getDisplayName() {
		return displayName;
	}
	
	/**
	 * 
	 * @param displayName
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getDistinguishedName() {
		return distinguishedName;
	}
	
	
	/**
	 * 
	 * @param distinguishedName
	 */
	public void setDistinguishedName(String distinguishedName) {
		this.distinguishedName = distinguishedName;
	}

	/**
	 * 
	 * @return un String con los nombres del UMVPerson (estos son traidos del LDAP)
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * 
	 * @param nombres Nombres de la persona recuperados del LDAP
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * 
	 * @return Un String con los apellidos del UMVPerson
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * 
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	/**
	 * @return the numDocumento Un string con el numero de documento
	 */
	public String getNumDocumento() {
		return numDocumento;
	}


	/**
	 * @param numDocumento the numDocumento to set
	 */
	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}


	public String getAuthenticationMessage() {
		return authenticationMessage;
	}


	public void setAuthenticationMessage(String authenticationMessage) {
		this.authenticationMessage = authenticationMessage;
	}
	
	
	
}