/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fatec.lpbd.projetocurriculo.model.db.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.fatec.lpbd.projetocurriculo.model.Employee.Address;
import org.fatec.lpbd.projetocurriculo.model.Employee.Employee;
import org.fatec.lpbd.projetocurriculo.model.Employee.Phone;

/**
 *
 * @author Alexandre
 */
public class EmployeeDaoJPA implements EmployeeDao {
    private EntityManagerFactory factory;
    
    private String jpql = "SELECT o FROM Employee o";
    private String searchUser = "SELECT u FROM Employee u WHERE u.id = ?";
    private String searchLogin = "SELECT u FROM Employee u WHERE u.cpf = ?";
    private String searchItem = "SELECT u FROM Employee u where name like ? order by name";

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
        
    
    public List<Employee> list() {
        List<Employee> list = new ArrayList<Employee>();
        EntityManager em = factory.createEntityManager();
        if (em != null) {
            try {
                TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
                list = query.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                em.close();
            }
        }
        return list;
    }
    
    public int remove(long id) {
        int removed = -1;
        EntityManager em = factory.createEntityManager();
        try{
            em.getTransaction().begin();
            Employee employee= em.find(Employee.class, id);
            em.remove(employee);
            em.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        return removed;
    }
    
    public int update(Employee employee) {
        int updated = -1;
        EntityManager em = factory.createEntityManager();
        try {
            Employee employeeSearch = em.find(Employee.class, employee.getId());

            em.getTransaction().begin();
            em.merge(employee);
            em.getTransaction().commit();
            updated += 1; 

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        return updated;
    }
    
    public Employee findByLogin(String cpf) {
        EntityManager em = factory.createEntityManager();
        Employee employee = new Employee();
        try{
            TypedQuery<Employee> query = em.createQuery(searchLogin, Employee.class);
            query.setParameter(1, cpf);
            employee = query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }    
        return employee;
    }
    
}
