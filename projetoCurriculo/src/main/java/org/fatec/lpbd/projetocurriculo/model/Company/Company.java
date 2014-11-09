/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fatec.lpbd.projetocurriculo.model.Company;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Alexandre
 */
@Entity
@Table(name="company")
public class Company implements Serializable{
    @Id @GeneratedValue   
    private Long id;
    private String companyName;
    private String Cnpj;
    private String password;
    @OneToMany(mappedBy="owner",orphanRemoval=true,fetch=FetchType.LAZY, 
cascade={CascadeType.ALL})
    private List<VacantJob> vacant;

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<VacantJob> getVacant() {
        return vacant;
    }

    public void setVacant(List<VacantJob> vacant) {
        this.vacant = vacant;
    }
    
    
    
}