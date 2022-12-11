package org.souayrioss.visionarycroftingspringmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "order_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id ", nullable = false)
    private Long id;
    @ManyToOne
    private Product product;
    @Column(name = "total_price",nullable = false)
    private float totalPrice;
    @Column(nullable = false)
    private int quantity;
    @ManyToOne
    private Order order;



}