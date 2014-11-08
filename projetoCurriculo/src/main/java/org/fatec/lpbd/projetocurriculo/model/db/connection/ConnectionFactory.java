/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fatec.lpbd.projetocurriculo.model.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alexandre
 */
public class ConnectionFactory {
    public Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projeto","root","root");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
