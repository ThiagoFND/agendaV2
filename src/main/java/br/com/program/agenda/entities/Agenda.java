package br.com.program.agenda.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agenda")
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", length = 50, nullable = true)
	private String nome;

	@Column(name = "sobrenome", length = 50, nullable = true)
	private String sobrenome;

	@Column(name = "email", length = 50, nullable = true)
	private String email;

	@Column(name = "descricao", length = 50, nullable = true)
	private String descricao;

	@Column(name = "numero", length = 50, nullable = true)
	private Long numero;

	@Column(name = "cpf", length = 50, nullable = true)
	private Long cpf;

	public Agenda() {

	}

	public Agenda(String nome, String sobrenome, String email, String descricao, Long numero, Long cpf) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.descricao = descricao;
		this.numero = numero;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, descricao, email, id, nome, numero, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(numero, other.numero)
				&& Objects.equals(sobrenome, other.sobrenome);
	}

}
