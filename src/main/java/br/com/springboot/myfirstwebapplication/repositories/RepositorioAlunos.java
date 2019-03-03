package br.com.springboot.myfirstwebapplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.myfirstwebapplication.entities.Alunos;

public interface RepositorioAlunos extends JpaRepository<Alunos, Long> {
	
	List<Alunos> findByNameContaining(String name);

}
