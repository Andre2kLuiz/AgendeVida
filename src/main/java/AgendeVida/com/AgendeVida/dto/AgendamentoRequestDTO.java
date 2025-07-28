package AgendeVida.com.AgendeVida.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class AgendamentoRequestDTO {
    private String pacienteId;
    private String medicoId;
    private String unidadeId;
    private LocalDate dataAgendamento;
    private LocalTime horaAgendamento;
}
