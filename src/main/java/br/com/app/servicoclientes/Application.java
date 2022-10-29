package br.com.app.servicoclientes;

import br.com.app.servicoclientes.model.Cliente;
import br.com.app.servicoclientes.model.Email;
import br.com.app.servicoclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var list = new ArrayList<Cliente>();
		for (int i =0; i < 50000; i++){

			var cliente = new Cliente(null, "LUcsa" + i, i, null);
			var emails = new HashSet<Email>();
			emails.add(new Email(null, "1232132", cliente ));
			emails.add(new Email(null, "asdas", cliente ));
			emails.add(new Email(null, "12321ewq32", cliente ));
			emails.add(new Email(null, "123xca2132", cliente ));
			emails.add(new Email(null, "123asdas2132", cliente ));
			cliente.setEmails(emails);

			list.add(cliente);
		}
		clienteRepository.saveAll(list);
		System.out.printf("TERMINOUUU");
	}
}
