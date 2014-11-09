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
import org.fatec.lpbd.projetocurriculo.model.Company.Company;
import org.fatec.lpbd.projetocurriculo.model.Company.VacantJob;

/**
 *
 * @author Alexandre
 */
public class CompanyDaoJPA {
     private EntityManagerFactory factory;
    
    private String jpql = "SELECT o FROM Employee o";
    private String searchUser = "SELECT u FROM USER u WHERE u.id = ?";
    private String searchLogin = "SELECT u FROM USER u WHERE u.login = ?";
    private String searchItem = "SELECT u FROM USER u where name like ? order by name";

    public CompanyDaoJPA() {
        factory = Persistence.createEntityManagerFactory("projeto");

    }

        public boolean persist(Company company) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(company);
            
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return true;
    }
        
    
    public List<Company> list() {
        List<Company> list = new ArrayList<Company>();
        EntityManager em = factory.createEntityManager();
        if (em != null) {
            try {
                TypedQuery<Company> query = em.createQuery(jpql, Company.class);
                list = query.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                em.close();
            }
        }
        return list;
    }
    
    public List<VacantJob> listVagas(long id){
         return null;
        
    }
    
    public int remove(long id) {
        int removed = -1;
        EntityManager em = factory.createEntityManager();
        try{
            em.getTransaction().begin();
            Company company= em.find(Company.class, id);
            em.remove(company);
            em.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        return removed;
    }
    
}
