package br.com.mycrud.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mycrud.domain.Usuario;
import br.com.mycrud.services.UsuarioService;

@RestController //Devo informar que é uma classe rest
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service; 
	
	
	//Busca por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id){
		
		Usuario obj = this.service.encontraPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//Retorna todos os usuários
	@GetMapping
	public ResponseEntity<List<Usuario>>findAll(){
		List<Usuario>list = service.encontraTodos();
		return ResponseEntity.ok().body(list);
	}
	
	
	//Faz update do usuário
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario>update(@PathVariable Integer id, @RequestBody Usuario obj){
		Usuario newObj = service.AtualizaUsuario(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	
	//Cria usuario
	@PostMapping
	public ResponseEntity<Usuario>create(@RequestBody Usuario obj){
		Usuario newObj = service.criaUsuario(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Deleta os dados do usuário
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		service.deletaUsuario(id);
		return ResponseEntity.noContent().build();
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
