package org.example.service;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.example.entity.Product;
import org.example.event.events.ProductAdditionEvent;
import org.example.repository.ProductRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public ProductService(ProductRepository productRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.productRepository = productRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Collection<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(UUID id){
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Продукт с id " + id + " не найден")
                );
    }

    public Product save(Product product){
        if (product.getId() != null && findById(product.getId()).getQuantity() == 0)
            applicationEventPublisher.publishEvent(new ProductAdditionEvent(this, product.getUsersSubscribe()));
        return productRepository.save(product);
    }

    public List<Product> save(List<Product> products){
        return products.stream().map(this::save).collect(Collectors.toList());
    }
}
