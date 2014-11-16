/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fatec.lpbd.projetocurriculo;

import java.util.ArrayList;
import java.util.List;
import org.fatec.lpbd.projetocurriculo.controller.CurriculoHelper;
import org.fatec.lpbd.projetocurriculo.model.Employee.Address;
import org.fatec.lpbd.projetocurriculo.model.Employee.Email;
import org.fatec.lpbd.projetocurriculo.model.Employee.Employee;
import org.fatec.lpbd.projetocurriculo.model.Employee.Phone;
import org.fatec.lpbd.projetocurriculo.model.Employee.Profile;
import org.fatec.lpbd.projetocurriculo.model.db.dao.EmployeeDao;
import org.fatec.lpbd.projetocurriculo.model.db.dao.EmployeeDaoJPA;


/**
 *
 * @author Alexandre
 */
public class MainApp {
    public static void main(String[] args) {
    // ----- Teste de alguns métodos da Dao ------
        
    Long idd = 1L;
    Employee emp = new Employee();
    Address ad = new Address();
    List<Phone> phones = new ArrayList<Phone>();
    List<Email> emails = new ArrayList<Email>();
    List<Profile> profs = new ArrayList<Profile>();
   
//    List<VacantJob> vacants = new ArrayList<VacantJob>();
//    VacantJob vac = new VacantJob();
//    Profile pro = new Profile();
//    vac.setCode("32006");
//    vac.setVacant("Vaga de suporte técnico");
//    vac.setDescription("Suporte técnico aos usuários, manutenção, instalação de hardware e software");
//    pro.setPerfil("Técnico em informática");
//    vacants.add(vac);
//    pro.setVacants(vacants);
//    
//    vac.setProfile(pro);
//    
//    CompanyDao dao1 = new CompanyDaoJPA();
//    boolean i1 = dao1.insertVacant(vac);
    
    EmployeeDao empdao = new EmployeeDaoJPA();
    
    Profile pro = new Profile();
    pro.setPerfil("Técnico em manutenção");
    empdao.insertProfile(pro);
    
    Profile pro1 = new Profile();
    pro1.setPerfil("Técnico em administração");    
    empdao.insertProfile(pro1);
    
    Profile pro2 = new Profile();
    pro2.setPerfil("Técnico em logistica");
    empdao.insertProfile(pro2);    
    
    profs.add(pro);
    profs.add(pro1);
    profs.add(pro2);
    emp.setProfile(profs);
    
    emp.setName("José");
    emp.setLastName("Carlos da Silva");
    emp.setCpf("000.000.000-00");
    emp.setRg("00.000.000-X");
    emp.setPassword("12345sss");
    emp.setAge(21);
    
    ad.setStreet("Rua Quinta das Flores");
    ad.setNumber("1458");
    ad.setCity("Jacareí");
    ad.setState("SP");
    ad.setNeighborhood("Pq. das Orquideas");
    ad.setOwner(emp);
    emp.setAddress(ad);
    
    Phone phone = new Phone();
    phone.setNumber("3933-0012");
    phone.setType("Residencial");
    phone.setOwner(emp);
    phones.add(phone);
    Phone phone1 = new Phone();
    phone1.setNumber("98866-1234");
    phone1.setType("Celular");
    phone1.setOwner(emp);    
    phones.add(phone1);
    
    emp.setPhones(phones);
    
    Email em = new Email();
    em.setEmail("email1@email.com");
    em.setOwner(emp);
    emails.add(em);
    emp.setEmails(emails);
    
    CurriculoHelper ch = new CurriculoHelper(emp);

    //---- Lembrar de fazer  um set do atributo para relacionar o empregado.

//        user.setPassword("12345");
        EmployeeDao dao = new EmployeeDaoJPA();
        boolean i = dao.persist(emp);
        
        List<Employee> all = new ArrayList<Employee>();
        all = dao.list();
        for (Employee employee : all){
            System.out.println("Nome"+employee.getName()+"Rua"+employee.getAddress().getStreet());
            
        }
        //dao.remove(2L);
    }
    

}

