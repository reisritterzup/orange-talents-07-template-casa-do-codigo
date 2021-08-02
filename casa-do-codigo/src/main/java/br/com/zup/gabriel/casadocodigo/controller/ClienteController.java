package br.com.zup.gabriel.casadocodigo.controller;

import br.com.zup.gabriel.casadocodigo.dto.ClienteDto;
import br.com.zup.gabriel.casadocodigo.dto.ClienteRequestDto;
import br.com.zup.gabriel.casadocodigo.model.Cliente;
import br.com.zup.gabriel.casadocodigo.repository.ClienteRepository;
import br.com.zup.gabriel.casadocodigo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody @Valid ClienteRequestDto requestDto){
        Cliente model = clienteRepository.save(requestDto.toModel(enderecoRepository));
        return ResponseEntity.ok(new ClienteDto(model));
    }
}
