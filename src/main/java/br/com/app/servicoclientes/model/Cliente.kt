package br.com.app.servicoclientes.model

import javax.persistence.*

@Entity
@Table(name = "clientes")
class Cliente(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,
        var nome: String? = null,
        var idade: Int? = null,
        @OneToMany(mappedBy = "cliente", cascade = arrayOf(CascadeType.ALL))
        var emails: Set<Email>? = mutableSetOf()
) {

//
//    constructor() {}
//    constructor(id: Int?, nome: String?, idade: Int?) {
//        this.nome = nome
//        this.id = id
//        this.idade = idade
//    }
}