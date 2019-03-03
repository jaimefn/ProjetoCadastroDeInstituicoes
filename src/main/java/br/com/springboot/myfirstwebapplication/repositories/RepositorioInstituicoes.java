package br.com.springboot.myfirstwebapplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.myfirstwebapplication.entities.Instituicoes;

public interface RepositorioInstituicoes extends JpaRepository<Instituicoes, Long> {
	
	List<Instituicoes> findByNameContaining(String name);
}
