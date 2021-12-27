package co.gov.umv.sigma.backend.comun.cbo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FiltroAvanzado 
{
	Map<String, Object> filtros = new HashMap<String, Object>();
	
	public void agregarFiltro(String columna, Object valor)
	{
		filtros.put(columna,valor);
	}
	
	public String obtenerComoFiltro()
	{
		String filtro = "AND (";
		
		 Set<String> valores = filtros.keySet();
		 
         Iterator<String> iterator =  valores.iterator();

         while(iterator.hasNext()) {

             String key = iterator.next();
        
             if (filtros.get(key) != null)
     			filtro += " " +  key + " = " +  filtros.get(key) + " AND";
     		
         }
         
         if(!filtro.equals("AND ("))
 		{
 			if(filtro.endsWith("AND"))
 				filtro = filtro.substring(0, filtro.length() - 3);
 			
 			System.out.println("filtroaplicado"+ filtro);
 				
 			return filtro + " )";
 			
 		}
 		else
 			return null ;
		
	}
	
	
}
