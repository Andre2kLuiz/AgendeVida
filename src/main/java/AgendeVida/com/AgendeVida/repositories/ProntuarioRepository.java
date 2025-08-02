package AgendeVida.com.AgendeVida.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AgendeVida.com.AgendeVida.model.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, String> {
    List<Prontuario> findByPaciente_Id(String pacienteId);

    List<Prontuario> findByMedico_Id(String medicoId);

    Prontuario findByAgendamento_Id(String agendamentoId);
}
