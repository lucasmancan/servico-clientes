package br.com.app.servicoclientes.repository

import br.com.app.servicoclientes.model.Cliente
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository : JpaRepository<Cliente?, Int?> {

    @Query("SELECT a from Cliente a JOIN FETCH a.emails limit ", countQuery = "select count(a) from br.com.app.servicoclientes.model.Cliente a")
    fun findAll2(pageable: Pageable): Page<Cliente>

    @Query("SELECT a.id from Cliente a JOIN a.emails")
    fun findIds(): List<Int>

    @Query("SELECT a from Cliente a JOIN FETCH a.emails where a.id in :ids")
    fun findAllByIds(ids: List<Int>): List<Cliente>
}