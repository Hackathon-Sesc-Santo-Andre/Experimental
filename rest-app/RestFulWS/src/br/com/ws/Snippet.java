package br.com.ws;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("rest/main")
public class Snippet {
		@GET
		@Produces({MediaType.APPLICATION_XML})
		@Path("/ping")
		public Pessoa ping(){
			Pessoa pessoa = new Pessoa();
			pessoa.setNome("Nome da pessoa");
			pessoa.setSobreNome("Sobrenome");
			pessoa.setData(new Date());
			pessoa.setCpf("27910498309309");
			return pessoa;
		}
}

