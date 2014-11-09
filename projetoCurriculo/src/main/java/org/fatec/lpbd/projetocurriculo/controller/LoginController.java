/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fatec.lpbd.projetocurriculo.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static org.apache.maven.wagon.PathUtils.user;
import org.fatec.lpbd.projetocurriculo.model.Company.Company;
import org.fatec.lpbd.projetocurriculo.model.Employee.Employee;
import org.fatec.lpbd.projetocurriculo.model.db.dao.CompanyDaoJPA;
import org.fatec.lpbd.projetocurriculo.model.db.dao.EmployeeDaoJPA;

/**
 *
 * @author Alexandre
 */
public class LoginController implements Initializable {
    
// Alterar para caixas correspondentes no FXML    
    @FXML
    private PasswordField pwfPassword;
// Alterar para caixas correspondentes no FXML
    @FXML
    private TextField txfLogin;   /* vai ser cpf ou cnpj */

    @FXML
    private Button btnOk;

    private Employee employee;
    
    private Company company;
    
    private EmployeeDaoJPA empDao;
    
    private CompanyDaoJPA compDao;

    @FXML
    void handleBtnOk(ActionEvent event) {
        //verifica se os campos sao validos
        if (!pwfPassword.getText().trim().isEmpty() && !txfLogin.getText().trim().isEmpty()) {
            if(txfLogin.getText().length() <= 11){
                employee = empDao.findByLogin(txfLogin.getText());
            }
            else{
                company = compDao.findByLogin(txfLogin.getText());
            }
            if (employee != null || company != null) {
                close();
            }
        } else {
            //mostra a mensagem de erro
            JOptionPane.showMessageDialog(null, "Invalid data.");
        }
    }

    @FXML
    void handleBtnClose(ActionEvent event) {
        close();
    }

    private void close() {
        getStage().close();
    }

    private Stage getStage() {
        return (Stage) btnOk.getScene().getWindow();
    }

    public Employee getEmployee() {
        return employee;
    }
    
    public Company getCompany() {
        return company;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        empDao = new EmployeeDaoJPA();
        compDao = new CompanyDaoJPA();
    }

}
