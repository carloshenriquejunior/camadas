package br.org.serratec.beckend.dto;

import java.util.Map;

import br.org.serratec.beckend.model.Usuario;

public class UsuarioInserirDTO {
	private String nome;
	private String email;
	private String senha;
	
	public UsuarioInserirDTO() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioInserirDTO(Long id, String nome, String email, String senha) {
		super();
		this.nome = Usuario.getNome();
		this.email = email;
		this.senha = senha;
	}

	public Map<String, ?> getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
