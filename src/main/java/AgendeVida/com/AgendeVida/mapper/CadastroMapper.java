package AgendeVida.com.AgendeVida.mapper;

import AgendeVida.com.AgendeVida.dto.MedicoRequestDTO;
import AgendeVida.com.AgendeVida.dto.MedicoResponseDTO;
import AgendeVida.com.AgendeVida.dto.PacienteRequestDTO;
import AgendeVida.com.AgendeVida.dto.PacienteResponseDTO;
import AgendeVida.com.AgendeVida.model.MedicoDetalhe;
import AgendeVida.com.AgendeVida.model.PacienteDetalhe;
import AgendeVida.com.AgendeVida.model.Role;
import AgendeVida.com.AgendeVida.model.Usuario;

public class CadastroMapper {
    // ---------- PACIENTE ----------
    public static Usuario toUsuarioFromPaciente(PacienteRequestDTO dto) {
        return Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha()) // será criptografada depois
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

    // ---------- MÉDICO ----------
    public static Usuario toUsuarioFromMedico(MedicoRequestDTO dto) {
        return Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .role(Role.MEDICO)
                .build();
    }

    public static MedicoDetalhe toMedicoDetalhe(MedicoRequestDTO dto, Usuario usuario) {
        return MedicoDetalhe.builder()
                .usuario(usuario)
                .crm(dto.getCrm())
                .especialidade(dto.getEspecialidade())
                .build();
    }

    public static MedicoResponseDTO toMedicoResponse(Usuario usuario, MedicoDetalhe detalhe) {
        return new MedicoResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                detalhe.getCrm(),
                detalhe.getEspecialidade());
    }
}
