package br.com.dlcstudio.base.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.dlcstudio.base.domain.Postagem;
import br.com.dlcstudio.base.domain.Usuario;
import br.com.dlcstudio.base.domain.UsuarioSeguido;
import br.com.dlcstudio.base.repositories.PostagemRepository;
import br.com.dlcstudio.base.repositories.UsuarioRepository;
import br.com.dlcstudio.base.repositories.UsuarioSeguidoRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioSeguidoRepository seguidoRepository;
	
	@Autowired
	private PostagemRepository postagemRepository;

	public void instantiateTestDatabase() throws ParseException {
		
		Usuario user = new Usuario(null, "Lincoln", "lincolncaetano@gmail.com", "lincolncaetano", pe.encode("123"));
		Usuario user2 = new Usuario(null, "Suely", "suely@gmail.com", "suelycaetano", pe.encode("123"));
		Usuario user3 = new Usuario(null, "Jessica", "jessicalincolncaetano@gmail.com", "jenatasha", pe.encode("123"));
		usuarioRepository.saveAll(Arrays.asList(user, user2, user3));
		
		UsuarioSeguido us1 = new UsuarioSeguido(user.getId(), user2.getId());
		UsuarioSeguido us2 = new UsuarioSeguido(user.getId(), user3.getId());
		UsuarioSeguido us3 = new UsuarioSeguido(user2.getId(), user.getId());
		UsuarioSeguido us4 = new UsuarioSeguido(user2.getId(), user3.getId());
		UsuarioSeguido us5 = new UsuarioSeguido(user3.getId(), user.getId());
		
		seguidoRepository.saveAll(Arrays.asList(us1,us2,us3,us4,us5));
		
		
		Postagem post1 = new Postagem();
		post1.setUsuario(user);
		post1.setPergunta("teste 1");
		
		Postagem post2 = new Postagem();
		post2.setUsuario(user);
		post2.setPergunta("teste 2");
		
		Postagem post3 = new Postagem();
		post3.setUsuario(user3);
		post3.setPergunta("teste 3");
		
		Postagem post4 = new Postagem();
		post4.setUsuario(user2);
		post4.setPergunta("teste 4");
		postagemRepository.saveAll(Arrays.asList(post1,post2,post3,post4));
			
	}
}
