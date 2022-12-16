package org.souayrioss.visionarycroftingspringmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User  implements Serializable {
    @Id
    @SequenceGenerator(name = "user_seq",sequenceName = "user_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "user_seq",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "uuid",unique = true,length = 60)
    private String uuid;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true,nullable = false,length = 60)
    private String email;

    @Column( nullable = false )
    private String password;

    @Column( nullable = false , unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    private  RoleEnum role;

    public enum RoleEnum{
        SUPPLIER ,
        CLIENT
    }


}
