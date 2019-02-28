package com.chris.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chris.cursomc.domain.Cliente;
import com.chris.cursomc.repositories.ClienteRepository;
import com.chris.cursomc.security.UserSS;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private ClienteRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Cliente cli = repo.findByEmail(username);
		if (cli == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserSS(cli.getId(), username, cli.getSenha(), cli.getPerfis());
	}

}
