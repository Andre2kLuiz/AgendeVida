package AgendeVida.com.AgendeVida.mapper;

import AgendeVida.com.AgendeVida.dto.PacienteRequestDTO;
import AgendeVida.com.AgendeVida.dto.PacienteResponseDTO;
import AgendeVida.com.AgendeVida.model.PacienteDetalhe;
import AgendeVida.com.AgendeVida.model.Role;
import AgendeVida.com.AgendeVida.model.Usuario;

public class PacienteMapper {
    public static Usuario toUsuarioFromPaciente(PacienteRequestDTO dto) {
        return Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha()) // será criptografada depois
                .telefone(dto.getTelefone())
                .role(Role.PACIENTE)
                .build();
    }

    public static PacienteDetalhe toPacienteDetalhe(PacienteRequestDTO dto, Usuario usuario) {
        return PacienteDetalhe.builder()
                .usuario(usuario)
                .cpf(dto.getCpf())
                .dataNascimento(dto.getDataNascimento())
                .build();
    }

    public static PacienteResponseDTO toPacienteResponse(Usuario usuario, PacienteDetalhe detalhe) {
        return new PacienteResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                detalhe.getCpf(),
                detalhe.getDataNascimento());
    }
}
