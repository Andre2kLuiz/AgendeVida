package AgendeVida.com.AgendeVida.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PacienteRequestDTO {

    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String cpf;
    private LocalDate dataNascimento;
}
