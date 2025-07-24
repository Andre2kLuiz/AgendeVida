package AgendeVida.com.AgendeVida.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import AgendeVida.com.AgendeVida.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findById(String id);

    Optional<Usuario> findByEmail(String email);
}
