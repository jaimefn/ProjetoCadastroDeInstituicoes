package br.com.springboot.myfirstwebapplication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Alunos {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Instituicoes instituicao;
	
	@Column(length=100)
	private String name;
	
	@Column(precision=0)
	private int age;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instituicoes getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicoes instituicao) {
		this.instituicao = instituicao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
