package AgendeVida.com.AgendeVida.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AgendeVida.com.AgendeVida.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, String> {
    List<Agendamento> findByPacienteDetalheId(String pacienteId);

    List<Agendamento> findByMedicoDetalheId(String medicoId);

    List<Agendamento> findByUnidadeSaudeId(String unidadeId);
}
