package br.com.dlcstudio.base.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.dlcstudio.base.domain.Usuario;
import br.com.dlcstudio.base.repositories.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void instantiateTestDatabase() throws ParseException {
		
		Usuario user = new Usuario(null, "Lincoln", "lincolncaetano@gmail.com", "lincolncaetano", pe.encode("123"));
		Usuario user2 = new Usuario(null, "Suely", "suely@gmail.com", "suelycaetano", pe.encode("123"));
		Usuario user3 = new Usuario(null, "Jessica", "jessicalincolncaetano@gmail.com", "jenatasha", pe.encode("123"));
		usuarioRepository.saveAll(Arrays.asList(user, user2, user3));
			
	}
}
