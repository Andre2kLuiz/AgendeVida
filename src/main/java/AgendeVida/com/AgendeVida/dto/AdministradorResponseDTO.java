package AgendeVida.com.AgendeVida.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdministradorResponseDTO {
    private String id;
    private String nome;
    private String email;
    private String telefone;

}
