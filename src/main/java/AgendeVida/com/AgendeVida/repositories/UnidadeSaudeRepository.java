package AgendeVida.com.AgendeVida.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import AgendeVida.com.AgendeVida.model.UnidadeSaude;

public interface UnidadeSaudeRepository extends JpaRepository<UnidadeSaude, String> {
    // Custom query methods can be defined here if needed
}
