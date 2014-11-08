/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fatec.lpbd.projetocurriculo.model.Employee;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import org.fatec.lpbd.projetocurriculo.model.Company.Vaga;

/**
 *
 * @author Alexandre
 */

@Entity
public class Perfil {
    
@Id @GeneratedValue
private long id;
private String perfil;
@ManyToMany
private List<Employee> employees;
@OneToOne
private Vaga vaga;

    public Perfil() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }


    
}
