package br.com.app.servicoclientes.mapper;

import br.com.app.servicoclientes.model.Cliente;
import br.com.app.servicoclientes.dto.ClienteDTO;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getIdade());
    }

    public Cliente toDomain(ClienteDTO dto) {
        return new Cliente(dto.getId(), dto.getNome(), dto.getIdade());
    }
}
