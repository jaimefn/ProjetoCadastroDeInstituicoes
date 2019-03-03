package br.com.springboot.myfirstwebapplication.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;

@Entity
public class Instituicoes {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=50)
	private String name;
	
	@Column(length=150)
	private String address;
	
	@OneToMany(mappedBy="instituicao")
	private Set<Alunos> aluno;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
