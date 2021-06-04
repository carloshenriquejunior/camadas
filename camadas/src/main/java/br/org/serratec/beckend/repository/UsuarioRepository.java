package br.org.serratec.beckend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.beckend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Usuario findByEmail(String email);
	
}
