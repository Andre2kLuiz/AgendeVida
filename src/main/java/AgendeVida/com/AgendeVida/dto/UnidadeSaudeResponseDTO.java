package AgendeVida.com.AgendeVida.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UnidadeSaudeResponseDTO {
    private String id;
    private String nome;
    private String endereco;
    private String telefone;
}
