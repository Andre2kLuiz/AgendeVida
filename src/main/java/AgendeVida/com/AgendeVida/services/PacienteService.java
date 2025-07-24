package AgendeVida.com.AgendeVida.services;

import org.springframework.stereotype.Service;

import AgendeVida.com.AgendeVida.dto.PacienteRequestDTO;
import AgendeVida.com.AgendeVida.dto.PacienteResponseDTO;
import AgendeVida.com.AgendeVida.mapper.CadastroMapper;
import AgendeVida.com.AgendeVida.model.PacienteDetalhe;
import AgendeVida.com.AgendeVida.model.Usuario;
import AgendeVida.com.AgendeVida.repositories.PacienteDetalheRepository;
import AgendeVida.com.AgendeVida.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final UsuarioRepository usuarioRepository;
    private final PacienteDetalheRepository pacienteDetalheRepository;

    @Transactional
    public PacienteResponseDTO cadastroPaciente(PacienteRequestDTO dto) {
        Usuario usuario = CadastroMapper.toUsuarioFromPaciente(dto);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        PacienteDetalhe detalhe = CadastroMapper.toPacienteDetalhe(dto, usuarioSalvo);
        pacienteDetalheRepository.save(detalhe);

        return CadastroMapper.toPacienteResponse(usuarioSalvo, detalhe);
    }
}
