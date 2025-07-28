package AgendeVida.com.AgendeVida.mapper;

import AgendeVida.com.AgendeVida.dto.AgendamentoRequestDTO;
import AgendeVida.com.AgendeVida.dto.AgendamentoResponseDTO;
import AgendeVida.com.AgendeVida.model.Agendamento;
import AgendeVida.com.AgendeVida.model.MedicoDetalhe;
import AgendeVida.com.AgendeVida.model.PacienteDetalhe;
import AgendeVida.com.AgendeVida.model.UnidadeSaude;

public class AgendamentoMapper {
    public static Agendamento toEntity(AgendamentoRequestDTO dto, PacienteDetalhe paciente, MedicoDetalhe medico,
            UnidadeSaude unidade) {
        return Agendamento.builder()
                .pacienteDetalhe(paciente)
                .medicoDetalhe(medico)
                .unidadeSaude(unidade)
                .dataAgendamento(dto.getDataAgendamento())
                .horaAgendamento(dto.getHoraAgendamento())
                .status("AGENDADO")
                .build();
    }

    public static AgendamentoResponseDTO toResponseDTO(Agendamento entity) {
        return new AgendamentoResponseDTO(
                entity.getId(),
                entity.getPacienteDetalhe().getUsuario().getNome(),
                entity.getMedicoDetalhe().getUsuario().getNome(),
                entity.getUnidadeSaude().getNome(),
                entity.getStatus());
    }
}
