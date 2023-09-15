package com.backend.modelsis.services;

import com.backend.modelsis.entites.ProductType;
import com.backend.modelsis.repository.ProductTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ProductTypeServices {
    private final ProductTypeRepository productTypeRepository;

    public List<ProductType> getProductTypes(){
        return productTypeRepository.findAll();
    }

    public Optional<ProductType> getProductTypeByID(int id){
        return productTypeRepository.findById(id);
    }

    public ProductType postProductType(ProductType productType){
        return productTypeRepository.save(productType);
    }

    public ProductType putProductType(int id, ProductType productType){
        return productTypeRepository.findById(id).
                map(productType1 -> {
                    productType1.setProductTypeName(productType.getProductTypeName());
                    log.info("Type de Produit mis à jour");
                    return productTypeRepository.save(productType1);
                }).orElseThrow(() -> new RuntimeException("Ce type de produit n'a pas pu être modifié!"));
    }

    public void deleteProductType(int id){
        productTypeRepository.deleteById(id);
    }
}
