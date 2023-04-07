package com.devsuperior.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.devsuperior.dscatalog.entities.Product;

@DataJpaTest
public class ProductRepositoryTests {
	
	@Autowired
	private ProductRepository repository;

	@Test
	public void deveriaDeletarObjetoQuandoIdExistir() {
		
		long idExistente = 1L;
		
		repository.deleteById(idExistente);
		
		Optional<Product> resultado = repository.findById(idExistente);
		
		Assertions.assertFalse(resultado.isPresent());
		
	}
	
	@Test
	public void deveriaLancarEmptyResultDataAccessExceptionQuandoIdNaoExiste() {
		
		long idNaoExistente = 1000L;
		
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(idNaoExistente);
		});
		
	}
	
}
