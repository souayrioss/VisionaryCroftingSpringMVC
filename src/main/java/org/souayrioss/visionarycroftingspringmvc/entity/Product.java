package org.souayrioss.visionarycroftingspringmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 20,nullable = false,unique = true)
    private String reference;
    @Column(nullable = false,unique = true)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private float initialPrice ;
    @Column(nullable = false)
    private int quantity;
    @ManyToOne
    @JsonIgnore
    private Stock stock;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", initialPrice=" + initialPrice +
                ", quantity=" + quantity +
                '}';
    }
}
