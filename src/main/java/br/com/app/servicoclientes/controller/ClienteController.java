package br.com.app.servicoclientes.controller;

import br.com.app.servicoclientes.dto.ClienteDTO;
import br.com.app.servicoclientes.exceptions.ClienteNaoExisteException;
import br.com.app.servicoclientes.mapper.ClienteMapper;
import br.com.app.servicoclientes.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    private final ClienteService clienteService;

    
    private final ClienteMapper clienteMapper;

    public ClienteController(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO salvar(@RequestBody ClienteDTO clienteDTO) {

        var cliente = clienteMapper.toDomain(clienteDTO);
        logger.info("Registrando cliente: " + clienteDTO);
        return clienteMapper.toDTO(clienteService.salvar(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id) {
        try {
            logger.info("Buscando cliente com Id: " + id);
            return ResponseEntity.ok().body(clienteMapper.toDTO(clienteService.buscarPorId(id)));
        } catch (ClienteNaoExisteException exception) {
            logger.info("Cliente não encontrado com id: " + id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<?> buscar(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        try {
            logger.info("Buscando todos os clientes ");


            var listaCliente = clienteService.buscarComPaginacao(page, size);

            return ResponseEntity.ok().body(clienteMapper.toDTO(listaCliente));
        } catch (ClienteNaoExisteException exception) {
            logger.info("Cliente não encontrado com id: ");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/paginacao")
    public ResponseEntity<?> buscarComPaginacao(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        try {
            logger.info("Buscando todos os clientes ");

            var listaCliente = clienteService.buscarComPaginacaoNova(page, size);

            return ResponseEntity.ok().body(clienteMapper.toDTO(listaCliente));
        } catch (ClienteNaoExisteException exception) {
            logger.info("Cliente não encontrado com id: ");
            return ResponseEntity.notFound().build();
        }
    }
}
