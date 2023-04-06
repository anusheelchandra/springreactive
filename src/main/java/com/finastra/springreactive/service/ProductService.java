package com.finastra.springreactive.service;

import com.finastra.springreactive.entity.Product;
import com.finastra.springreactive.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository repository;

  public Flux<Product> getAllProducts() {
    return this.repository.findAll();
  }

  public Mono<Product> getProductById(Long productId) {
    return this.repository.findById(productId);
  }

  public Mono<Product> createProduct(final Product product) {
    return this.repository.save(product);
  }

  public Mono<Product> updateProduct(Long productId, final Mono<Product> productMono) {
    return this.repository
        .findById(productId)
        .flatMap(
            p ->
                productMono.map(
                    u -> {
                      p.setName(u.getName());
                      return p;
                    }))
        .flatMap(this.repository::save);
  }

  public Mono<Void> deleteProduct(final Long id) {
    return this.repository.deleteById(id);
  }
}
