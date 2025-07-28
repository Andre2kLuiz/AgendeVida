package AgendeVida.com.AgendeVida.model;

import java.time.LocalDate;
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
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_exame")
    private String id;

    @ManyToOne
    @JoinColumn(name = "agendamento_id")
    private Agendamento agendamento;

    @ManyToOne
    @JoinColumn(name = "paciente_detalhe_id", nullable = false)
    private PacienteDetalhe pacienteDetalhe;

    @Column(name = "arquivo_url", nullable = false)
    private String arquivoUrl;

    @Column(name = "tipo_exame", nullable = false)
    private String tipoExame; // Ex: "Sangue", "Raio-X", etc.

    @Column(name = "data_envio", nullable = false)
    private LocalDate dataEnvio;
}
