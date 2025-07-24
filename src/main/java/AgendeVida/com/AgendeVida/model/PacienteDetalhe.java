package AgendeVida.com.AgendeVida.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paciente_detalhes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteDetalhe {

    @Id
    private String id; // mesmo ID do usuário

    @OneToOne
    @MapsId
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(nullable = false, unique = true)
    private String cpf;

    private LocalDate dataNascimento;
}
