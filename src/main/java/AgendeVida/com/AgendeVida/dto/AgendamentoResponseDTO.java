package AgendeVida.com.AgendeVida.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AgendamentoResponseDTO {
    private String id;
    private String nomePaciente;
    private String nomeMedico;
    private String unidade;
    private String status;
}
