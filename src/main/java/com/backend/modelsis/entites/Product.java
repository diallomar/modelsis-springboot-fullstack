package com.backend.modelsis.entites;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productID;
    @Column(nullable = false, unique = true)
    private String productName;
    private LocalDateTime createdAt;
    @ManyToOne
    private ProductType productType;

}
