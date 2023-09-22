package br.com.program.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.program.agenda.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
