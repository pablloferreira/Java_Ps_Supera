package br.com.psSupera.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.psSupera.model.Product;
import br.com.psSupera.repository.ProductRepository;

@RestController
@RequestMapping({"/product"})
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	ProductController(ProductRepository productRepository) {
	      this.productRepository = productRepository;
	  }
	
	@GetMapping
	public List findAll(){
	  return productRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Product>> findProductOrId(@PathVariable(name = "id", required = true) Long id) {
		return ResponseEntity.ok(productRepository.findById(id));
	}
	
	@PostMapping
	public Product create(@RequestBody Product product){
	    return productRepository.save(product);
	}
	
	@PutMapping(value="/{id}")
	  public ResponseEntity<Product> update(@PathVariable("id") long id,
	                                        @RequestBody Product product){
	    return productRepository.findById(id)
	        .map(record -> {
	            record.setName(product.getName());
	            record.setPrice(product.getPrice());
	            record.setScore(product.getScore());
	            record.setImage(product.getImage());
	            Product updated = productRepository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
	
	@DeleteMapping(path ={"/{id}"})
	  public ResponseEntity<?> delete(@PathVariable("id") long id) {
	    return productRepository.findById(id)
	        .map(record -> {
	            productRepository.deleteById(id);
	            return ResponseEntity.ok().build();
	        }).orElse(ResponseEntity.notFound().build());
	  }
	
}
