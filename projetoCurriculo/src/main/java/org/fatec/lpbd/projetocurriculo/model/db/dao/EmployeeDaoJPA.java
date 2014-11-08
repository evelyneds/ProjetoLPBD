/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fatec.lpbd.projetocurriculo.model.db.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.fatec.lpbd.projetocurriculo.model.Employee.Address;
import org.fatec.lpbd.projetocurriculo.model.Employee.Employee;
import org.fatec.lpbd.projetocurriculo.model.Employee.Phone;

/**
 *
 * @author Alexandre
 */
public class EmployeeDaoJPA implements EmployeeDao {
    private EntityManagerFactory factory;
    
    private String jpql = "SELECT o FROM User o";
    private String searchUser = "SELECT u FROM USER u WHERE u.id = ?";
    private String searchLogin = "SELECT u FROM USER u WHERE u.login = ?";
    private String searchItem = "SELECT u FROM USER u where name like ? order by name";

    public EmployeeDaoJPA() {
        factory = Persistence.createEntityManagerFactory("projeto");

    }

        public boolean persist(Employee employee) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(employee);
            
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return true;
    }
    
}
