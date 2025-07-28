package AgendeVida.com.AgendeVida.mapper;

import java.time.LocalDate;
import AgendeVida.com.AgendeVida.dto.ExameRequestDTO;
import AgendeVida.com.AgendeVida.dto.ExameResponseDTO;
import AgendeVida.com.AgendeVida.model.Agendamento;
import AgendeVida.com.AgendeVida.model.Exame;
import AgendeVida.com.AgendeVida.model.PacienteDetalhe;

public class ExameMapper {
    public static Exame toEntity(ExameRequestDTO dto, PacienteDetalhe paciente, Agendamento agendamento) {
        return Exame.builder()
                .pacienteDetalhe(paciente)
                .agendamento(agendamento)
                .tipoExame(dto.getTipoExame())
                .arquivoUrl(dto.getArquivoUrl())
                .dataEnvio(LocalDate.now())
                .build();
    }

    public static ExameResponseDTO toResponseDTO(Exame entity) {
        return new ExameResponseDTO(
                entity.getId(),
                entity.getTipoExame(),
                entity.getArquivoUrl(),
                entity.getDataEnvio());
    }
}
