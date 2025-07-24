package AgendeVida.com.AgendeVida.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MedicoResponseDTO {
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private String especialidade;
}
