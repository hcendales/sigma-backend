/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.umv.sigma.backend.comun.cbo;


import org.apache.log4j.Logger;

/**
 *
 * @author juanmetalmolina
 */
public class ErrorClass {
    private static Logger logger; 
    
    public static void getMessage(ObjetoSalida objetoSalida, Class defined){
        try {
            logger = Logger.getLogger( defined );
        
            if(objetoSalida.getCodError() == CodError.OPERACION_CORRECTA && objetoSalida.getCodError() != null){
                logger.info(objetoSalida.getMsgError());
                //logger.info(objetoSalida.getRespuesta());
                //logger.info(objetoSalida.getCodError());
            }else{
                logger.error(objetoSalida.getMsgError());
            }
        }catch(Exception ex){
        	ex.printStackTrace();
            logger.fatal(objetoSalida.getMsgError());
        }
           
    }
    
    public static void getMessageException(ObjetoSalida objetoSalida, Class defined, Exception e) {
    	objetoSalida.setCodError(CodError.ERROR_INTERNO);
        objetoSalida.setMsgError(e.getMessage());
        e.printStackTrace();
        ErrorClass.getMessage(objetoSalida,defined);
    }
    
}
