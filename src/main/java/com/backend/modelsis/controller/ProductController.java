package com.backend.modelsis.controller;

import com.backend.modelsis.entites.Product;
import com.backend.modelsis.services.ProductServices;
import com.backend.modelsis.utils.InfoProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@CrossOrigin("http://localhost:4200")
public class ProductController {
    private final ProductServices productServices;

    @PostMapping("")
    public Product postProduct(@RequestBody InfoProduct infoProduct){
        Product product1 = productServices.postProduct(infoProduct);
        if (product1 != null) {
            log.info("Produit ajouté");
        }else {
            log.info("Le Produit n'a pas pu être ajouté");
        }
        return product1;
    }
    @PutMapping("/{id}")
    public Product putProduct(@PathVariable int id, @RequestBody InfoProduct infoProduct){
        return productServices.putProduct(id, infoProduct);
    }

    @GetMapping("")
    public List<Product> getProducts(){
        return productServices.getProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductByID(@PathVariable int id){
        return productServices.getProductByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productServices.deleteProduct(id);
    }
}
