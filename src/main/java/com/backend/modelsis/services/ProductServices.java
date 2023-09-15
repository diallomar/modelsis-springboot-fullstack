package com.backend.modelsis.services;

import com.backend.modelsis.entites.Product;
import com.backend.modelsis.entites.ProductType;
import com.backend.modelsis.repository.ProductRepository;
import com.backend.modelsis.repository.ProductTypeRepository;
import com.backend.modelsis.utils.InfoProduct;
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
public class ProductServices {
    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductByID(int id){
        return productRepository.findById(id);
    }

    public Product postProduct(InfoProduct infoProduct){
        Product product = new Product();
        if (infoProduct.getIdProductType() != null) {
            Optional<ProductType> productType = productTypeRepository.findById(infoProduct.getIdProductType());
            productType.ifPresent(product::setProductType);
        }

        product.setProductName(infoProduct.getProductName());
        product.setCreatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    public Product putProduct(int id, InfoProduct infoProduct){
        ProductType productType;
        if (infoProduct.getIdProductType() != null) {
            Optional<ProductType> OptionalProductType = productTypeRepository.findById(infoProduct.getIdProductType());
            productType = OptionalProductType.get();
        } else {
            productType = null;
            log.info("Le Produit n'a pas pu être mis à jour");
        }
        return productRepository.findById(id).
                map(product1 -> {
                    product1.setProductName(infoProduct.getProductName());
                    product1.setProductType(productType);
                    product1.setCreatedAt(LocalDateTime.now());
                    log.info("Le Produit a été mis à jour");
                    return productRepository.save(product1);
                }).orElseThrow(() -> new RuntimeException("Ce produit n'a pas pu être modifié!"));
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
