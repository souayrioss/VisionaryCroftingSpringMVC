package org.souayrioss.visionarycroftingspringmvc.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "productRequest")
public class ProductRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "reference_product",nullable = false)
    private String productReference;

    @Column(nullable = false)
    private Integer quantity;
    @ManyToOne
    private Stock stock;
    @Enumerated(EnumType.STRING)
    private SupplyRequestEnum status = SupplyRequestEnum.OPEN;
    private LocalDate createdAt = LocalDate.now();
    @ManyToOne
    private Supplier supplier;


    public enum SupplyRequestEnum{
        OPEN,
        CANCELED,
        CONFIRMED,
        CLOSED
    }


}
