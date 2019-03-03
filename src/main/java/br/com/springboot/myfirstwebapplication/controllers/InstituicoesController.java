package br.com.springboot.myfirstwebapplication.controllers;

import java.util.ArrayList;
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

import br.com.springboot.myfirstwebapplication.entities.Instituicoes;
import br.com.springboot.myfirstwebapplication.repositories.RepositorioInstituicoes;
import net.bytebuddy.asm.Advice.Return;

@Controller
@RequestMapping("/instituicoes")
public class InstituicoesController {

	@Autowired
	private RepositorioInstituicoes repositoryInstituicoes;

	@GetMapping("/index")
	public ModelAndView index() {
		
		ModelAndView resultado = new ModelAndView("instituicoes/index");
		
		List<Instituicoes> lista = repositoryInstituicoes.findAll();
		
		resultado.addObject("instituicoes", lista);
		
		return resultado;
	}
	
	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView resultado = new ModelAndView("instituicoes/inserir");
		resultado.addObject("instituicao",new Instituicoes());
		return resultado;		
	}
	
	@PostMapping("/inserir")
	public String inserir(Instituicoes instituicao) {
		
		repositoryInstituicoes.save(instituicao);
		
		return "redirect:/instituicoes/index";
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView resultado = new ModelAndView("instituicoes/editar");
		
		Instituicoes instituicao = repositoryInstituicoes.getOne(id);
				
		resultado.addObject("instituicao",instituicao);
		return resultado;		
	}
	
	@PostMapping("/editar")
	public String editar(Instituicoes instituicao) {
		
		repositoryInstituicoes.save(instituicao) ;
		
		return "redirect:/instituicoes/index";
	}
	

	@GetMapping("/apagar/{id}")
	public String apagar(@PathVariable Long id) {
		
		repositoryInstituicoes.deleteById(id);
		
		return "redirect:/instituicoes/index";
				
	
	}
		
	@GetMapping({"/pesquisar/{name}","/pesquisar"})
	public @ResponseBody List<Instituicoes> pesquisar(@PathVariable Optional<String> name){
		
		if(name.isPresent()) {
			 return  repositoryInstituicoes.findByNameContaining(name.get());
		}else {
			return repositoryInstituicoes.findAll();
		}
	}

	
}
