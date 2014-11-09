/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fatec.lpbd.projetocurriculo.model.db.dao;

import java.util.List;
import org.fatec.lpbd.projetocurriculo.model.Company.Company;
import org.fatec.lpbd.projetocurriculo.model.Company.VacantJob;

/**
 *
 * @author Alexandre
 */
public interface CompanyDao {
    boolean persist(Company company);
    
    //boolean insertVaga()
    
    List<Company> list();
    
    List<VacantJob> listVacant(long id);
    
    int remove(long id);
    
    Company findByLogin(String cnpj);

    
}
