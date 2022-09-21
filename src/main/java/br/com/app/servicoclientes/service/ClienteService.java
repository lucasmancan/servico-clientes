package br.com.app.servicoclientes.service;

import br.com.app.servicoclientes.exceptions.ClienteNaoExisteException;
import br.com.app.servicoclientes.model.Cliente;
import br.com.app.servicoclientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(ClienteNaoExisteException::new);
    }
}
