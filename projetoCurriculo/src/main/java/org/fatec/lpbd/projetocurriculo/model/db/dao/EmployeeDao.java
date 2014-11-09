/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fatec.lpbd.projetocurriculo.model.db.dao;

import java.util.List;
import org.fatec.lpbd.projetocurriculo.model.Employee.Address;
import org.fatec.lpbd.projetocurriculo.model.Employee.Employee;
import org.fatec.lpbd.projetocurriculo.model.Employee.Phone;

/**
 *
 * @author Alexandre
 */
public interface EmployeeDao {
    boolean persist(Employee employee);
    
    List<Employee> list();
    
    int remove(long id);
    
    int update(Employee employee);
}

