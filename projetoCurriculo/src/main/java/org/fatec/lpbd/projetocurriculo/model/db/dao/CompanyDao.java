/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fatec.lpbd.projetocurriculo.model.db.dao;

import java.util.List;
import org.fatec.lpbd.projetocurriculo.model.Company.Company;
import org.fatec.lpbd.projetocurriculo.model.Company.Vaga;

/**
 *
 * @author Alexandre
 */
public interface CompanyDao {
    boolean persist(Company company);
    
    List<Company> list();
    
    List<Vaga> listVagas(long id);
    
    int remove(long id);

    
}
