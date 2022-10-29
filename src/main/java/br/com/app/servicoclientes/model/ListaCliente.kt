package br.com.app.servicoclientes.model

data class ListaCliente (val paginacao: Paginacao, val clientes: List<Cliente>){
}

data class Paginacao(val total: Long, val pagina: Int, val tamanho: Int) {}
