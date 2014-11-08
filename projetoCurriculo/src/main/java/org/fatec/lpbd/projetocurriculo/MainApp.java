/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fatec.lpbd.projetocurriculo;

import java.util.ArrayList;
import java.util.List;
import org.fatec.lpbd.projetocurriculo.model.Employee.Address;
import org.fatec.lpbd.projetocurriculo.model.Employee.Employee;
import org.fatec.lpbd.projetocurriculo.model.Employee.Phone;
import org.fatec.lpbd.projetocurriculo.model.db.dao.EmployeeDao;
import org.fatec.lpbd.projetocurriculo.model.db.dao.EmployeeDaoJPA;


/**
 *
 * @author Alexandre
 */
public class MainApp {
    public static void main(String[] args) {
    Long idd = 1L;
    Employee emp = new Employee();
    Address ad = new Address();
    List<Phone> phones = new ArrayList<Phone>();
    //emp.setId(idd);
    
    
    emp.setName("Carlos");
    emp.setLastName("Leonardo");
    emp.setCpf("1299999999");
    emp.setRg("1234588");
    emp.setPassword("12345");
    ad.setStreet("Rua tres");
    ad.setOwner(emp);
    Phone phone = new Phone();
    phone.setNumber("3333333333");    
    phone.setOwner(emp);
    phones.add(phone);
    Phone phone1 = new Phone();
    phone1.setNumber("222222222");    
    phone1.setOwner(emp);
    phones.add(phone1);
    
//        user.setPassword("12345");
        EmployeeDao dao = new EmployeeDaoJPA();
        boolean i = dao.persist(emp);
    }
    
}
