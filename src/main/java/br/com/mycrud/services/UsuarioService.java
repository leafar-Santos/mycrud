package br.com.mycrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mycrud.domain.Usuario;
import br.com.mycrud.exceptions.ObjectNotFoundException;
import br.com.mycrud.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario encontraPorId(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não econtrado Id: " + id + " Tipo: " + Usuario.class.getName()));
	}

	public List<Usuario> encontraTodos() {
		return repository.findAll();
	}

	public Usuario AtualizaUsuario(Integer id, Usuario obj) {
		Usuario newObj = encontraPorId(id);
		newObj.setNome(obj.getNome());
		newObj.setLogin(obj.getLogin());
		newObj.setSenha(obj.getSenha());
		return repository.save(newObj);

	}

	public Usuario criaUsuario(Usuario obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void deletaUsuario(Integer id) {
		encontraPorId(id);
		repository.deleteById(id);
	}

}
