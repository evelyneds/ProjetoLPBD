/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fatec.lpbd.projetocurriculo.model.Employee;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Alexandre
 */
@Entity
@Table(name="employee")
public class Employee implements Serializable {
   @Id @GeneratedValue
   //@Column(name="id")
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String password;   
    private String Cpf;
    private String Rg;
    
    @OneToMany(mappedBy="owner",orphanRemoval=true,fetch=FetchType.LAZY, 
cascade={CascadeType.ALL})
    private List<Phone> phones;
    
    @OneToOne(mappedBy = "owner", orphanRemoval = true, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Address address;
    
    @OneToMany(mappedBy="owner",orphanRemoval=true,fetch=FetchType.LAZY, 
cascade={CascadeType.ALL})
    private List<Email> emails;
    
    @OneToMany(mappedBy="owner",orphanRemoval=true,fetch=FetchType.LAZY, 
cascade={CascadeType.ALL})
    private List<AcademicHistory> academics;
    
    @OneToMany(mappedBy="owner",orphanRemoval=true,fetch=FetchType.LAZY,
cascade={CascadeType.ALL})
    private List<Experience> experiences;
    
    @OneToMany(mappedBy="owner",orphanRemoval=true,fetch=FetchType.LAZY, 
cascade={CascadeType.ALL})
    private List<Language> languages;
    
    @ManyToMany(mappedBy = "employees",fetch=FetchType.LAZY, 
cascade={CascadeType.ALL})
    private List<Perfil> perfis;

     public Employee() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }
    
    
     
     
    
    
}
