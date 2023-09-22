package br.com.program.agenda.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.program.agenda.dto.AgendaDTO;
import br.com.program.agenda.entities.Agenda;
import br.com.program.agenda.exceptions.ResourceNotFoundException;
import br.com.program.agenda.mapper.DozerMapper;
import br.com.program.agenda.repositories.AgendaRepository;

@Service
public class AgendaService {

	// erramente para salvar logs e possivelmente auxiliar na identificação de
	// qualquer erro
	private Logger logger = Logger.getLogger(AgendaService.class.getName());

	@Autowired
	private AgendaRepository agendaRepositories;

	// serviço paracriar uma agenda
	public AgendaDTO create(AgendaDTO agenda) {

		logger.info("Creating one person!");
		var entity = DozerMapper.parseObject(agenda, Agenda.class);
		var vo = DozerMapper.parseObject(agendaRepositories.save(entity), AgendaDTO.class);
		return vo;
	}

	// serviço para listar todas as agendas
	public List<AgendaDTO> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(agendaRepositories.findAll(), AgendaDTO.class);
	}

	// serviço que atualiza algum dado da agenda caso necessário
	public AgendaDTO update(AgendaDTO agenda) {

		logger.info("Updating one agenda!");

		var entity = agendaRepositories.findById(agenda.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setNome(agenda.getNome());
		entity.setSobrenome(agenda.getSobrenome());
		entity.setCpf(agenda.getCpf());
		;
		entity.setEmail(agenda.getEmail());
		entity.setDescricao(agenda.getDescricao());
		entity.setNumero(agenda.getNumero());
		entity.setCpf(agenda.getCpf());

		var vo = DozerMapper.parseObject(agendaRepositories.save(entity), AgendaDTO.class);
		return vo;
	}

	// serviço para deletar agenda
	public void delete(Long id) {

		logger.info("Deleting one person!");

		var entity = agendaRepositories.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		agendaRepositories.delete(entity);
	}
}
