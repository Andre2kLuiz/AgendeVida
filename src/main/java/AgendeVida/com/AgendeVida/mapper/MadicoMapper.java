package AgendeVida.com.AgendeVida.mapper;

import AgendeVida.com.AgendeVida.dto.MedicoRequestDTO;
import AgendeVida.com.AgendeVida.dto.MedicoResponseDTO;
import AgendeVida.com.AgendeVida.model.MedicoDetalhe;
import AgendeVida.com.AgendeVida.model.Role;
import AgendeVida.com.AgendeVida.model.Usuario;

public class MadicoMapper {

    public static Usuario toUsuarioFromMedico(MedicoRequestDTO dto) {
        return Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .telefone(dto.getTelefone())
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
