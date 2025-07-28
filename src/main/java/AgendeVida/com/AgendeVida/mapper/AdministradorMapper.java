package AgendeVida.com.AgendeVida.mapper;

import AgendeVida.com.AgendeVida.dto.AdministradorRequestDTO;
import AgendeVida.com.AgendeVida.dto.AdministradorResponseDTO;
import AgendeVida.com.AgendeVida.model.AdministradorDetalhe;
import AgendeVida.com.AgendeVida.model.Role;
import AgendeVida.com.AgendeVida.model.Usuario;

public class AdministradorMapper {
    public static Usuario toUsuarioFromAdministrador(AdministradorRequestDTO dto) {
        return Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha()) // criptografia no service
                .telefone(dto.getTelefone())
                .role(Role.EDMIN)
                .build();
    }

    public static AdministradorDetalhe toAdministradorDetalhe(AdministradorRequestDTO dto, Usuario usuario) {
        return AdministradorDetalhe.builder()
                .usuario(usuario)
                .build();
    }

    public static AdministradorResponseDTO toAdministradorResponse(Usuario usuario) {
        return new AdministradorResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone());
    }
}
