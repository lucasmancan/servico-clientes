package br.com.app.servicoclientes.model

import javax.persistence.*

@Entity
@Table(name = "emails")
class Email(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,
        var email: String? = null,
        @ManyToOne(fetch = FetchType.LAZY)
        var cliente: Cliente? = null
)
