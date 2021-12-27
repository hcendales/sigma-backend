package co.gov.umv.sigma.backend.comun.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
	private Properties prop;
	//private final static String PROPFILENAME = "application.properties"; 
	private final static String PROPFILENAME = "application-dev.properties";
	public AppConfig() {
		this.prop = new Properties();
		InputStream inputStream;
    	
    	try {
    		String propFileName = PROPFILENAME;
 
			inputStream = AppConfig.class.getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				this.prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public Properties getProp() {
		return this.prop;
	}	
	
}
