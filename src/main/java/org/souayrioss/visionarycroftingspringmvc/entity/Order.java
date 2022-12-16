package org.souayrioss.visionarycroftingspringmvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date date;
    @Column(name = "reference",nullable = false,unique = true)
    private String reference;
    private Date createdAt = new Date();
    @Column(name = "total_price",nullable = false)
    private double totalPrice;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    private OrderStatusEnum status;
    public enum OrderStatusEnum{
        CREATED,
        CANCELED,
        PAYED,
        DELIVERED
    }


}
