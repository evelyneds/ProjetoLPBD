/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fatec.lpbd.projetocurriculo.model.Company;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.fatec.lpbd.projetocurriculo.model.Employee.Perfil;

/**
 *
 * @author Alexandre
 */
@Entity
public class Vaga {
@Id@GeneratedValue
private long id;
private String vaga;
private String descrição;

@OneToOne(mappedBy="vaga",orphanRemoval=true,fetch=FetchType.LAZY, 
cascade={CascadeType.ALL})
private Perfil  perfil;

//@OneToMany
//private List<Employee> employees;

@ManyToOne
private Company owner;
    
    
    
    
}
