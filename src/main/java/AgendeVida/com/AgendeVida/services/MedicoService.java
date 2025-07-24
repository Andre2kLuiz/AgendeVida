package AgendeVida.com.AgendeVida.services;

import org.springframework.stereotype.Service;

import AgendeVida.com.AgendeVida.dto.MedicoRequestDTO;
import AgendeVida.com.AgendeVida.dto.MedicoResponseDTO;
import AgendeVida.com.AgendeVida.mapper.CadastroMapper;
import AgendeVida.com.AgendeVida.model.MedicoDetalhe;
import AgendeVida.com.AgendeVida.model.Usuario;
import AgendeVida.com.AgendeVida.repositories.MedicoDetalheRepository;
import AgendeVida.com.AgendeVida.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final UsuarioRepository usuarioRepository;
    private final MedicoDetalheRepository medicoDetalheRepository;

    public MedicoResponseDTO cadastrtoMedico(MedicoRequestDTO dto) {

        Usuario usuario = CadastroMapper.toUsuarioFromMedico(dto);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        MedicoDetalhe detalhe = CadastroMapper.toMedicoDetalhe(dto, usuarioSalvo);
        medicoDetalheRepository.save(detalhe);

        return CadastroMapper.toMedicoResponse(usuarioSalvo, detalhe);
    }
}
