package com.backend.modelsis.entites;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productTypeID;
    @Column(nullable = false, unique = true)
    private String productTypeName;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Product> products;
}
