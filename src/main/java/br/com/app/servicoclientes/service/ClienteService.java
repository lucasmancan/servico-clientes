package br.com.app.servicoclientes.service;

import br.com.app.servicoclientes.exceptions.ClienteNaoExisteException;
import br.com.app.servicoclientes.model.Cliente;
import br.com.app.servicoclientes.model.ListaCliente;
import br.com.app.servicoclientes.model.Paginacao;
import br.com.app.servicoclientes.repository.ClienteRepository;
import org.springframework.data.domain.PageRequest;
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

    public ListaCliente buscarComPaginacao(Integer page, Integer size) {

        var pageable = clienteRepository.findAll2(PageRequest.of(page, size));

        return new ListaCliente(new Paginacao(pageable.getTotalElements(), pageable.getNumber(), pageable.getSize()), pageable.getContent());
    }


    public ListaCliente buscarComPaginacaoNova(Integer page, Integer size) {

        var ids = clienteRepository.findIds();

        var start = (page * size);
        var clientes = clienteRepository.findAllByIds(ids.subList(start,  start+ size));

        return new ListaCliente(new Paginacao(ids.size(), page, size), clientes);
    }
}
