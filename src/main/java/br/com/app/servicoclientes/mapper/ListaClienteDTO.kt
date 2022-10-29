package br.com.app.servicoclientes.mapper;

import br.com.app.servicoclientes.dto.ClienteDTO
import br.com.app.servicoclientes.model.Paginacao

data class ListaClienteDTO(val lista: List<ClienteDTO>, val paginacao: Paginacao)
