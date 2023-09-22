package br.com.program.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.program.agenda.dto.AgendaDTO;
import br.com.program.agenda.services.AgendaService;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

	@Autowired
	private AgendaService agendaService;

	// Endpoint para adicionar um novo contato na agenda
	@PostMapping(value = "/criar",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public AgendaDTO create(@RequestBody AgendaDTO agenda) {
		return agendaService.create(agenda);
	}

	// Endpoint para obter todos os contatos da agenda
	@GetMapping(value = "/list",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AgendaDTO> findAll() {
		return agendaService.findAll();
	}

	// Endpoint para atualizar os dados da agenda
	@PutMapping(value = "/update",
		consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public AgendaDTO update(@RequestBody AgendaDTO agenda) {
		return agendaService.update(agenda);
	}

	// Endpoint para excluir um contato pelo id
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		agendaService.delete(id);
		return ResponseEntity.noContent().build();
	}	
}
