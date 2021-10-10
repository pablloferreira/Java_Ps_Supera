package br.com.psSupera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.psSupera.repository.CarrinhoRepository;

@RestController
@RequestMapping({"/carrinho"})
public class CarrinhoController {
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	public CarrinhoController(CarrinhoRepository carrinhoRepository) {
		this.carrinhoRepository = carrinhoRepository;
	}
	
	@GetMapping
	public List findAll(){
	  return carrinhoRepository.findAll();
	}

}
