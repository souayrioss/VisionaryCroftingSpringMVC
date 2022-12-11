package org.souayrioss.visionarycroftingspringmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@Table(name = "supplier")
public class Supplier extends User{
    @OneToMany(mappedBy = "supplier")
    private List<ProductRequest> supplyRequests;

    public Supplier(Long id, String uuid, String fullName, String email, String passswrd, String phone, RoleEnum role, List<ProductRequest> productRequests){
        super(id,uuid,fullName,email,passswrd,phone,role);
        this.supplyRequests = productRequests;
    }
    public Supplier(){
        setRole(RoleEnum.SUPPLIER);
    }
}
