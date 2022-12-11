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
@AllArgsConstructor
@ToString
@Table(name = "client")
public class Client extends User{
    @OneToMany(mappedBy = "client")
    private List<Order> orders;

    public Client(Long id, String uuid, String fullName, String email, String passswrd, String phone, RoleEnum role, List<Order> orders){
        super(id,uuid,fullName,email,passswrd,phone,role);
        this.orders = orders;
    }

    public Client() {
        setRole(RoleEnum.CLIENT);
    }
}
