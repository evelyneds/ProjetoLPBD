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
import org.fatec.lpbd.projetocurriculo.model.Company.VacantJob;

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
    private String cpf;
    private String rg;
    
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
    private List<Profile> profiles;
    
    @ManyToMany(mappedBy="employees",fetch=FetchType.LAZY, 
cascade={CascadeType.ALL})
    private List<VacantJob> vacants;
    
    public Employee() {
    }


    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<AcademicHistory> getAcademics() {
        return academics;
    }

    public void setAcademics(List<AcademicHistory> academics) {
        this.academics = academics;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Profile> getProfile() {
        return profiles;
    }

    public void setProfile(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<VacantJob> getVacant() {
        return vacants;
    }

    public void setVacant(List<VacantJob> vacants) {
        this.vacants = vacants;
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
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    
     
     
    
    
}