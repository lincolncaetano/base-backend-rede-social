package br.com.dlcstudio.base.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.dlcstudio.base.domain.Usuario;
import br.com.dlcstudio.base.repositories.UsuarioRepository;
import br.com.dlcstudio.base.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario cli = repo.findByUsername(username);
		if (cli == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserSS(cli.getId(), cli.getUsername(), cli.getSenha());
	}
}
