package AgendeVida.com.AgendeVida.mapper;

import AgendeVida.com.AgendeVida.dto.UnidadeSaudeRequestDTO;
import AgendeVida.com.AgendeVida.dto.UnidadeSaudeResponseDTO;
import AgendeVida.com.AgendeVida.model.UnidadeSaude;

public class UnidadeSaudeMapper {
    public static UnidadeSaude toEntity(UnidadeSaudeRequestDTO dto) {
        return UnidadeSaude.builder()
                .nome(dto.getNome())
                .endereco(dto.getEndereco())
                .telefone(dto.getTelefone())
                .build();
    }

    public static UnidadeSaudeResponseDTO toResponseDTO(UnidadeSaude entity) {
        return new UnidadeSaudeResponseDTO(
                entity.getId(),
                entity.getNome(),
                entity.getEndereco(),
                entity.getTelefone());
    }
}
