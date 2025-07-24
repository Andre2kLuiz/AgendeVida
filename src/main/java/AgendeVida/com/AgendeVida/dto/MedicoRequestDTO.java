package AgendeVida.com.AgendeVida.dto;

import lombok.Data;

@Data
public class MedicoRequestDTO {
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String crm;
    private String especialidade;
}
