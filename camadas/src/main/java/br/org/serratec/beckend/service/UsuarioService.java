package br.org.serratec.beckend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.serratec.beckend.dto.UsuarioDTO;
import br.org.serratec.beckend.dto.UsuarioInserirDTO;
import br.org.serratec.beckend.exception.EmailException;
import br.org.serratec.beckend.model.Usuario;
import br.org.serratec.beckend.repository.UsuarioRepository;

@Service
public class UsuarioService {
     
	private static final List<Usuario> UsuarioDTOs = null;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public List<UsuarioDTO> listar(){
		List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();
		List<Usuario> usuarios =  usuarioRepository.findAll();
		
		for (Usuario usuario : usuarios) {
			UsuarioDTO dto = new UsuarioDTO(usuario);
			usuarioDTOs.add(dto);
		}
		return usuarioDTOs;
	}
	
	public UsuarioDTO inserir (UsuarioInserirDTO usuarioInserirDTO) throws EmailException {
		Usuario u = usuarioRepository.findByEmail(usuarioInserirDTO.getEmail());
		if(u != null) {
			throw new EmailException("Email existente ! Insira outro");
		}
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setPerfil("Usuário Padrão");
		usuario.setSenha(bCryptPasswordEncoder.encode(usuarioInserirDTO.getSenha()));
		usuario =  usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario);
		
	}
	}

