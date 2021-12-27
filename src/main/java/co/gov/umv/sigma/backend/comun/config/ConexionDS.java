/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.config;

/**
 *
 * @author juanmetalmolina
 */
import javax.sql.DataSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Enumeration;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.Context;
import org.apache.log4j.Logger;
import oracle.jdbc.pool.OracleDataSource;
//@Stateless
//@Remote(IRemoteConnection.class)
public class ConexionDS { //implements IRemoteConnection{

    private static final Logger logger = Logger.getLogger( ConexionDS.class ); 
    private static Connection instancia = null;
    //private static String DatasourceJNDI = "java:/jboss/datasources/SIGMAUMVWorkFlowsDS";
    //private static String DatasourceJNDI = "java:/jboss/datasources/UMVWorkFlowsDSL";
    //private static String DatasourceJNDI = "java:/jboss/datasources/CaliopeDS";
    

    
    public synchronized static Connection obtenerInstancia() throws Exception {
        try {
            AppConfig config =  new AppConfig();
            Context ctx = new InitialContext();
            //OracleDataSource ds = (OracleDataSource)ctx.lookup(config.getProp().getProperty("datasource.jndi-name"));
            DataSource ds = (DataSource)ctx.lookup(config.getProp().getProperty("datasource.jndi-name"));
            if( ds != null ) {
            	//ds.setFastConnectionFailoverEnabled(true);
            	//ds.setImplicitCachingEnabled(true);
            	instancia = ds.getConnection();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.fatal( "Error conectando a Datasource UMVDS", ex);
        }
        return instancia;
    }
    
    /*public synchronized static Connection obtenerConexion() throws Exception {
        //OracleDataSourceFactory ds = OracleDataSource.
        try{
            
            Context ctx = new InitialContext();
            OracleDataSource ods  = (OracleDataSource)ctx.lookup(DatasourceJNDI);
            if( ods != null ) instancia = ods.getConnection();
        }
        catch(Exception ex){
            ex.printStackTrace();
            logger.error( "Error conectando a Datasource UMVDS", ex);
        }
        return instancia;
    }*/

    public static void desconectar(Connection instancia) throws Exception {

        if(instancia != null && !instancia.isClosed()) {
            instancia.close();
        }
    }

    /*public Connection conectar() {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup( DatasourceJNDI);
            if( ds != null ) instancia = ds.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.fatal( "Error conectando a Datasource UMVDS", ex);
        }
        return instancia;
    }*/
    
 }
