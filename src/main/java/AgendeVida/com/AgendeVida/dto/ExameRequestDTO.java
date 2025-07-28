package AgendeVida.com.AgendeVida.dto;

import lombok.Data;

@Data
public class ExameRequestDTO {
    private String pacienteId;
    private String agendamentoId;
    private String tipoExame;
    private String arquivoUrl;
}
