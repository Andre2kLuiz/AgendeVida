package AgendeVida.com.AgendeVida.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import AgendeVida.com.AgendeVida.dto.PacienteRequestDTO;
import AgendeVida.com.AgendeVida.dto.PacienteResponseDTO;
import AgendeVida.com.AgendeVida.mapper.PacienteMapper;
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
        Usuario usuario = PacienteMapper.toUsuarioFromPaciente(dto);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        PacienteDetalhe detalhe = PacienteMapper.toPacienteDetalhe(dto, usuarioSalvo);
        pacienteDetalheRepository.save(detalhe);

        return PacienteMapper.toPacienteResponse(usuarioSalvo, detalhe);
    }

    public PacienteResponseDTO buscarPorId(String id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        PacienteDetalhe detalhe = pacienteDetalheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalhes do paciente não encontrados"));

        return PacienteMapper.toPacienteResponse(usuario, detalhe);
    }

    public List<PacienteResponseDTO> listarTodos() {
        List<PacienteDetalhe> detalhes = pacienteDetalheRepository.findAll();
        return detalhes.stream()
                .map(d -> PacienteMapper.toPacienteResponse(d.getUsuario(), d))
                .collect(Collectors.toList());
    }

    @Transactional
    public PacienteResponseDTO atualizar(String id, PacienteRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        PacienteDetalhe detalhe = pacienteDetalheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalhes do paciente não encontrados"));

        // Atualizar dados do usuário
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefone(dto.getTelefone());

        // Atualizar detalhes
        detalhe.setCpf(dto.getCpf());
        detalhe.setDataNascimento(dto.getDataNascimento());

        usuarioRepository.save(usuario);
        pacienteDetalheRepository.save(detalhe);

        return PacienteMapper.toPacienteResponse(usuario, detalhe);
    }

    @Transactional
    public void deletar(String id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Paciente não encontrado");
        }
        pacienteDetalheRepository.deleteById(id);
        usuarioRepository.deleteById(id);
    }
}
