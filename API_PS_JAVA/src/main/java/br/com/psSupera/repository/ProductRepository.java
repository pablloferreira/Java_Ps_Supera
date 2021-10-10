package br.com.psSupera.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.psSupera.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
