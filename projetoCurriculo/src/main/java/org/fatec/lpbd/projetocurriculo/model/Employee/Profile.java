/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fatec.lpbd.projetocurriculo.model.Employee;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.fatec.lpbd.projetocurriculo.model.Company.VacantJob;

/**
 *
 * @author Alexandre
 */

@Entity
public class Profile {
    
@Id @GeneratedValue
private long id;
private String profile;
@ManyToMany
private List<Employee> employees;

@OneToMany(mappedBy="profile",orphanRemoval=true,fetch=FetchType.LAZY, 
cascade={CascadeType.ALL})
private List<VacantJob> vacants;

    public Profile() {
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<VacantJob> getVacants() {
        return vacants;
    }

    public void setVacants(List<VacantJob> vacants) {
        this.vacants = vacants;
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfile() {
        return profile;
    }

    public void setPerfil(String profile) {
        this.profile= profile;
    }


    
}
