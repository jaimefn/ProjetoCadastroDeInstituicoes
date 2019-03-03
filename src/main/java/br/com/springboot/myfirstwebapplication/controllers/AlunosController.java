package br.com.springboot.myfirstwebapplication.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.springboot.myfirstwebapplication.entities.Alunos;
import br.com.springboot.myfirstwebapplication.entities.Instituicoes;
import br.com.springboot.myfirstwebapplication.repositories.RepositorioAlunos;
import br.com.springboot.myfirstwebapplication.repositories.RepositorioInstituicoes;

@Controller
@RequestMapping("/alunos")
public class AlunosController {

	@Autowired
	private RepositorioAlunos repositorioAlunos;
	
	@Autowired
	private RepositorioInstituicoes repositorioInstituicoes;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView resultado = new ModelAndView("alunos/index");
		
		resultado.addObject("alunos",repositorioAlunos.findAll());
		
		return resultado;
	}
	
	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView resultado = new ModelAndView("alunos/inserir");
		
		Alunos aluno = new Alunos();
		aluno.setInstituicao(new Instituicoes());
				
		resultado.addObject("aluno", aluno);
		resultado.addObject("instituicoes", repositorioInstituicoes.findAll());
		return resultado;
	}
	
	@PostMapping("/inserir")
	public String inserir(Alunos aluno) {
		
		repositorioAlunos.save(aluno);
		
		return "redirect:/alunos/index";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView resultado = new ModelAndView("alunos/editar");
		
		resultado.addObject("aluno", repositorioAlunos.findById(id).get());
		resultado.addObject("instituicoes",repositorioInstituicoes.findAll());
		return resultado;
	}
	
	@PostMapping("/editar")
	public String editar(Alunos aluno) {		
		
		repositorioAlunos.save(aluno);
		
		return "redirect:/alunos/index";
	}
	
	
	@GetMapping("/apagar/{id}")
	public String apagar(@PathVariable Long id) {
		
		repositorioAlunos.deleteById(id);
		
		return "redirect:/alunos/index";
	}
	
	@GetMapping({"/pesquisar/aluno/{name}","/pesquisar"})
	public @ResponseBody List<Alunos> pesquisar(@PathVariable Optional<String> name){
		
		if(name.isPresent()) {
			 return  repositorioAlunos.findByNameContaining(name.get());
		}else {
			return repositorioAlunos.findAll();
		}
	}

	
}
