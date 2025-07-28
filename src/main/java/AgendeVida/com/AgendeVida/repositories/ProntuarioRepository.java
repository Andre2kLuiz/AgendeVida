package AgendeVida.com.AgendeVida.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AgendeVida.com.AgendeVida.model.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, String> {
    List<Prontuario> findByPacienteId(Long pacienteId);

    List<Prontuario> findByMedicoId(Long medicoId);

    Prontuario findByAgendamentoId(Long agendamentoId);
}
