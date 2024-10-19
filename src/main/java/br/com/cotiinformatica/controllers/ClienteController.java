package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ClienteRequestDto;
import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.repositories.ClienteRepository;

@RestController // define a classe como um controlador API (Spring Boot)
@RequestMapping("/api/clientes") // mapeia o ENDPOINT do controlador (endereço)
public class ClienteController {

	/*
	 * Serviço para cadastro de cliente na API
	 */

	@PostMapping // define o método como HTTP POST
	public String post(@RequestBody ClienteRequestDto request) throws Exception {

		// criando um objeto da classe Cliente (instância)
		var cliente = new Cliente();

		// capturando os dados enviados para a API (requisição)
		cliente.setId(UUID.randomUUID());
		cliente.setNome(request.getNome());
		cliente.setCpf(request.getCpf());
		cliente.setTelefone(request.getTelefone());
		cliente.setEmail(request.getEmail());

		// gravar o cliente no banco de dados
		var clienteRepository = new ClienteRepository();
		
		if (!clienteRepository.isExists(cliente.getCpf(), cliente.getId())) {

			clienteRepository.create(cliente);
			return "Cliente cadastrado com sucesso.";

		} else {
			return "O CPF '" + cliente.getCpf() + "' informado está cadastrado para outro cliente. Tente novamente.";
		}
	}

	/*
	 * Serviço para edição de cliente na API
	 */
	
	@PutMapping("{id}") // define o método como HTTP PUT
	public String put(@PathVariable UUID id, @RequestBody ClienteRequestDto request) throws Exception {

		var clienteRepository = new ClienteRepository();
		var cliente = clienteRepository.getByid(id);

		if (cliente != null) {

			// modificar os dados do cliente
			cliente.setNome(request.getNome());
			cliente.setCpf(request.getCpf());
			cliente.setTelefone(request.getTelefone());
			cliente.setEmail(request.getEmail());
			;
			
			if(!clienteRepository.isExists(cliente.getCpf(), cliente.getId())) {
				clienteRepository.update(cliente);			
				return "Cliente atualizado com sucesso.";
			}
			else {
				return "Não é possível atualizar os dados pois o CPF '"+ cliente.getCpf() +"' já pertence a outro cliente.";
			}		
			
		} else {

			return "Cliente não encontrado. Verifique o id informado";
				
		}
	}

	/*
	 * Serviço para exclusão de cliente na API
	 */
	
	@DeleteMapping("{id}") // define o método como HTTP DELETE
	public String delete(@PathVariable UUID id) throws Exception {
		
		var clienteRepository = new ClienteRepository();
		var cliente = clienteRepository.getByid(id);

		if (cliente != null) {

			clienteRepository.delete(id);

			return "Cliente exluido com sucesso.";

		} else {

			return "Cliente não encontrado. Verifique o id informado";
		}
	}

	/*
	 * Serviço para consulta de clientes na API
	 */
	@GetMapping // define o método como HTTP GET
	public List<Cliente> get() throws Exception {

		// instanciando o repositório e retornando a consulta de clientes
		var clienteRepository = new ClienteRepository();
		return clienteRepository.getAll();
	}
	
	/*
	 * Serviço de consulta de cliente por ID
	 */
	
	@GetMapping("{id}")
	public Cliente getById(@PathVariable UUID id)throws Exception{
		
		//istanciando o repositorio e retornando a consulta de cliente
		var clienteRepositry = new ClienteRepository();
		return clienteRepositry.getByid(id);
	}
}
