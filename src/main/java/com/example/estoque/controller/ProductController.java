package com.example.estoque.controller;

import com.example.estoque.entity.Product;
import com.example.estoque.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// url onde esta API deve trabalhar.
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Requisição que recebe um "corpo" para a criação de novo usuário.
    @PostMapping
    public List<Product> create(@RequestBody Product product) {
        return productService.create(product);
    }

    // Requisição retorna todos os usuários do banco.
    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    // Requisição atualiza usuário novo de acordo com o id presente na requisição e os novos dados presente no "corpo" da requisição.
    @PutMapping(value = "{id}")
    public List<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    // Deleta um usuário a partir de um ID passado na própria requisição.
    @DeleteMapping(value = "{id}")
    public List<Product> delete(@PathVariable Long id) {
        return productService.delete(id);
    }
}
