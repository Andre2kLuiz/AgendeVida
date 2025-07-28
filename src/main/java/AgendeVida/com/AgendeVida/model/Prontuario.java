package AgendeVida.com.AgendeVida.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_prontuario")
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteDetalhe paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private MedicoDetalhe medico;

    @OneToOne
    @JoinColumn(name = "id_agendamento", nullable = false, unique = true)
    private Agendamento agendamento;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "data_registro", nullable = false)
    private LocalDate dataRegistro;
}
