package br.com.app.servicoclientes.mapper;

import br.com.app.servicoclientes.model.Cliente;
import br.com.app.servicoclientes.dto.ClienteDTO;
import br.com.app.servicoclientes.model.ListaCliente;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ClienteMapper {
    public ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getIdade());
    }

    public ListaClienteDTO toDTO(ListaCliente lista) {
        return new ListaClienteDTO(lista.getClientes().stream().map(this::toDTO).collect(Collectors.toList()), lista.getPaginacao());
    }

    public Cliente toDomain(ClienteDTO dto) {
        return new Cliente(dto.getId(), dto.getNome(), dto.getIdade(), null);
    }
}
