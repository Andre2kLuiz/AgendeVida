package AgendeVida.com.AgendeVida.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_agendamento")
    private String id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteDetalhe pacienteDetalhe;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private MedicoDetalhe medicoDetalhe;

    @ManyToOne
    @JoinColumn(name = "unidade_id", nullable = false)
    private UnidadeSaude unidadeSaude;

    @Column(name = "data_agendamento", nullable = false)
    private LocalDate dataAgendamento;

    @Column(name = "hora_agendamento", nullable = false)
    private LocalTime horaAgendamento;

    @Column(nullable = false)
    private String status; // AGENDADO, CONFIRMADO, CANCELADO

}
