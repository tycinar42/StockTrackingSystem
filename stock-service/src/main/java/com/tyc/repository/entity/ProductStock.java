package com.tyc.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tblproductstock")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String brand;
    private String model;
    private String name;
    private int piece;
}
