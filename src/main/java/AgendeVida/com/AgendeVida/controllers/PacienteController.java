package AgendeVida.com.AgendeVida.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AgendeVida.com.AgendeVida.dto.PacienteRequestDTO;
import AgendeVida.com.AgendeVida.dto.PacienteResponseDTO;
import AgendeVida.com.AgendeVida.services.PacienteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/paciente")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> cadastroPaciente(@RequestBody PacienteRequestDTO dto) {
        return ResponseEntity.ok(pacienteService.cadastroPaciente(dto));
    }
}
