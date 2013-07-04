package br.com.ws;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("rest/principal")
public class WSPrincipal {
	
	@GET
	@Path("/ping")
	public String ping(){
		return "Servidor no ar";
	}
	
	
	
	@GET
	@Path("/meuranking")
	@Produces({MediaType.APPLICATION_JSON})
	public MeuRanking getMyRanking(){
		MeuRanking meu = new MeuRanking();
		meu.setTotalToques(15);
		meu.setTempoInicio(new Date().getTime());
		meu.setTempoFim(new Date().getTime());
		
		return meu;
		
	}
	
	
	@GET
	@Path("/sendranking/{imei}")
	public boolean sendRanking(MeuRanking meuRanking, 
			@PathParam("imei") String imei){
		
		System.out.println(imei);
		
		
		
		return true;
		
		
	}
	
	
	@POST
	@Path("/sendranking")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean sendRanking(MeuRanking meuRanking){
		
		System.out.println(meuRanking);
		
		
		return true;
	}


}
