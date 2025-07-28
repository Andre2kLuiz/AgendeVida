package AgendeVida.com.AgendeVida.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExameResponseDTO {
    private String id;
    private String tipoExame;
    private String arquivoUrl;
    private LocalDate dataEnvio;
}
