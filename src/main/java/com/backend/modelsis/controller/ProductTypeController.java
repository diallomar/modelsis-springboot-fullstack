package com.backend.modelsis.controller;

import com.backend.modelsis.entites.ProductType;
import com.backend.modelsis.services.ProductTypeServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/productTypes")
@CrossOrigin("http://localhost:4200")
public class ProductTypeController {
    private final ProductTypeServices productTypeServices;

    @PostMapping("")
    public ProductType postProductType(@RequestBody ProductType productType){

        return productTypeServices.postProductType(productType);
    }
    @PutMapping("/{id}")
    public ProductType putProductType(@PathVariable int id, @RequestBody ProductType productType){
        return productTypeServices.putProductType(id, productType);
    }

    @GetMapping("")
    public List<ProductType> getProductTypes(){
        return productTypeServices.getProductTypes();
    }

    @GetMapping("/{id}")
    public Optional<ProductType> getProductTypeByID(@PathVariable int id){
        return productTypeServices.getProductTypeByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductType(@PathVariable int id){
        productTypeServices.deleteProductType(id);
    }
}
