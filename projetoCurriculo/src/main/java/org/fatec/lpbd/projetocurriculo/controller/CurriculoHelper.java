/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fatec.lpbd.projetocurriculo.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fatec.lpbd.projetocurriculo.model.Employee.Employee;

/**
 *
 * @author imamura
 */
public class CurriculoHelper {
    
    
    public CurriculoHelper(Employee emp){
        
        Document doc = null;
        OutputStream os = null;
		
        try {
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
			
            //cria a stream de saída
            os = new FileOutputStream("/Users/imamura/Desktop/out.pdf");
			
            try {
                //associa a stream de saída ao
                PdfWriter.getInstance(doc, os);
            } catch (DocumentException ex) {
                Logger.getLogger(CurriculoHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
			
            //abre o documento
            doc.open();

            //adiciona o texto ao PDF
            String fullName = String.format("%1s %2s", emp.getName(), emp.getLastName());
            
            doc.add(titleString(fullName));

        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(CurriculoHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
                try {
                    //fechamento da stream de saída
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(CurriculoHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
    }
    
    
    public static Paragraph titleString(String text){
        Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
        Paragraph p = new Paragraph(text, f);
        p.setAlignment(Element.ALIGN_CENTER);
        return p;
    }
    
    
}
