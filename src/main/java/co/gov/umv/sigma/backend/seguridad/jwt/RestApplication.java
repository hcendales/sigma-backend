package co.gov.umv.sigma.backend.seguridad.jwt;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//import io.swagger.jaxrs.config.BeanConfig;


import co.gov.umv.sigma.backend.administracion.servicio.PersonaServicio;
import co.gov.umv.sigma.backend.administracion.servicio.UsuarioServicio;
import co.gov.umv.sigma.backend.comun.servicio.ArchivoServicio;
import co.gov.umv.sigma.backend.comun.servicio.DocumentoMVServicio;
import co.gov.umv.sigma.backend.externo.servicio.impl.ExternoServicio;
import co.gov.umv.sigma.backend.intervencion.servicio.impl.ActividadAgTipoIntervencionServicio;
import co.gov.umv.sigma.backend.intervencion.servicio.impl.AreaIntervencionServicio;
import co.gov.umv.sigma.backend.intervencion.servicio.impl.GestionPMTServicio;
import co.gov.umv.sigma.backend.intervencion.servicio.impl.InformeDiarioCuadrillaServicio;
import co.gov.umv.sigma.backend.intervencion.servicio.impl.IntervencionNovedadServicio;
import co.gov.umv.sigma.backend.intervencion.servicio.impl.IntervencionService;
import co.gov.umv.sigma.backend.intervencion.servicio.impl.PersonalIntervencionServicio;
import co.gov.umv.sigma.backend.intervencion.servicio.impl.ProgramacionDiariaServicio;
import co.gov.umv.sigma.backend.intervencion.servicio.impl.UnidadEjecutoraPersonaServicio;
import co.gov.umv.sigma.backend.intervencion.servicio.impl.ZonaCoberturaServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.AforoServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.AledanioServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.AlternativaServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.ApiqueServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.CargueServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.ConsultaServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.EquipoServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.FallaServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.GestionPendienteServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.GestionRecursoService;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.LugarServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.MantenimientoVialDocuServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.MantenimientoVialEventoServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.MantenimientoVialGestionServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.MantenimientoVialServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.OtroFactorServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.RadicadoVinculadoServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.RecursoServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.ServicioServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.UnidadMuestreoServicio;
import co.gov.umv.sigma.backend.mejoramiento.servicio.impl.VisitaServicio;
import co.gov.umv.sigma.backend.produccion.servicio.impl.GestionEnsayoServicio;
import co.gov.umv.sigma.backend.produccion.servicio.impl.LaboratorioServicio;
import co.gov.umv.sigma.backend.produccion.servicio.impl.ProduccioServicio;
import co.gov.umv.sigma.backend.reporte.servicio.ReporteServicio;
import co.gov.umv.sigma.backend.seguridad.servicio.impl.TokenServicio;
import co.gov.umv.sigma.backend.test.servicio.Testing;
import co.gov.umv.sigma.backend.utilidad.servicio.impl.GeneralServicio;
import co.gov.umv.sigma.backend.workflow.servicio.impl.ActividadServicio;
import co.gov.umv.sigma.backend.workflow.servicio.impl.DocumentoServicio;



@ApplicationPath("/api")
public class RestApplication extends Application {
    
	public RestApplication(){
		//System.out.println("Iniciando SiGMA");
		//init();
	}
	/*
	 private void init() {
	      
		 BeanConfig beanConfig = new BeanConfig();
         beanConfig.setVersion("1.0.0");
         beanConfig.setSchemes(new String[]{"http"});
         beanConfig.setHost("localhost:8080");
         beanConfig.setBasePath("/swagger-demo/api");
         beanConfig.setResourcePackage(UsuarioServicio.class.getPackage().getName());
         beanConfig.setTitle("RESTEasy, Swagger and Swagger UI Example");
         beanConfig.setDescription("Sample RESTful API built using RESTEasy, Swagger and Swagger UI");
         beanConfig.setScan(true);
	 }
	*/
	@Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> clazzes = new HashSet();
        
        clazzes.add(JWTFiltro.class);
        clazzes.add(TokenServicio.class);
        clazzes.add(ExternoServicio.class);
        clazzes.add(UsuarioServicio.class);
        clazzes.add(ConsultaServicio.class);
        clazzes.add(MantenimientoVialServicio.class);
        clazzes.add(MantenimientoVialDocuServicio.class);
        clazzes.add(MantenimientoVialGestionServicio.class);
        clazzes.add(FallaServicio.class);
        clazzes.add(OtroFactorServicio.class);
        clazzes.add(UnidadMuestreoServicio.class);
        clazzes.add(GeneralServicio.class);
        clazzes.add(ArchivoServicio.class);
        clazzes.add(DocumentoServicio.class);
        clazzes.add(ActividadServicio.class);
        clazzes.add(MantenimientoVialEventoServicio.class);
        clazzes.add(ServicioServicio.class);
        clazzes.add(RadicadoVinculadoServicio.class);
        clazzes.add(IntervencionNovedadServicio.class);
        clazzes.add(AreaIntervencionServicio.class);
        clazzes.add(ReporteServicio.class);
        clazzes.add(GestionEnsayoServicio.class);
        clazzes.add(AforoServicio.class);
        clazzes.add(InformeDiarioCuadrillaServicio.class);
        //RSG
        clazzes.add(GestionPendienteServicio.class); 
        clazzes.add(CargueServicio.class);
        clazzes.add(EquipoServicio.class);
        clazzes.add(LugarServicio.class);
        clazzes.add(PersonaServicio.class);
        clazzes.add(RecursoServicio.class);
        clazzes.add(ApiqueServicio.class);
        clazzes.add(AlternativaServicio.class);
        clazzes.add(LaboratorioServicio.class);
        clazzes.add(ProduccioServicio.class);
        clazzes.add(VisitaServicio.class);
        clazzes.add(GestionRecursoService.class);
        clazzes.add(IntervencionService.class);
        clazzes.add(GestionPMTServicio.class);
        clazzes.add(AledanioServicio.class);
        clazzes.add(ProgramacionDiariaServicio.class);
        clazzes.add(ActividadAgTipoIntervencionServicio.class);
        clazzes.add(UnidadEjecutoraPersonaServicio.class);
        clazzes.add(ZonaCoberturaServicio.class);
        clazzes.add(PersonalIntervencionServicio.class);
        clazzes.add(DocumentoMVServicio.class);
        
        
                   
        clazzes.add(Testing.class);
        
        return clazzes;
    }
    
    
}
