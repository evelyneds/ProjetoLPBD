/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fatec.lpbd.projetocurriculo.controller;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fatec.lpbd.projetocurriculo.model.Employee.Email;
import org.fatec.lpbd.projetocurriculo.model.Employee.Employee;
import org.fatec.lpbd.projetocurriculo.model.Employee.Phone;
import org.fatec.lpbd.projetocurriculo.model.Employee.Profile;

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
            doc.add(separatorText("INFORMAÇÕES PESSOAIS"));
            doc.add(lineSeparator());
            doc.add(simpleText("    - Idade: " + emp.getAge()));
            doc.add(simpleText(streetStringFormat(emp)));
            doc.add(simpleText(cityStringFormat(emp)));
            doc.add(simpleText(phonesStringFormat(emp)));
            doc.add(simpleText(emailStringFormat(emp)));
            doc.add(spaceLine());
            doc.add(spaceLine());
            doc.add(separatorText("OBJETIVO"));
            doc.add(lineSeparator());
            doc.add(simpleText(objectivesStringFormat(emp)));
            doc.add(spaceLine());
            doc.add(spaceLine());
            doc.add(separatorText("FORMAÇÃO"));
            doc.add(lineSeparator());
            doc.add(separatorText("EXPERIÊNCIA PROFISSIONAL"));
            doc.add(lineSeparator());

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
    
    public static Paragraph simpleText(String text){
        Font f = new Font(FontFamily.COURIER, 10, Font.NORMAL);
        Paragraph p = new Paragraph(text, f);
        p.setAlignment(Element.PARAGRAPH);
        return p;
    }
    
    public static Paragraph titleString(String text){
        Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
        Paragraph p = new Paragraph(text, f);
        p.setAlignment(Element.ALIGN_CENTER);
        p.setSpacingAfter(20);
        return p;
    }
    
    public static Paragraph separatorText(String text){
        Font f = new Font(FontFamily.COURIER, 14, Font.BOLD);
        Paragraph p = new Paragraph(text, f);
        p.setSpacingAfter(-15);
        return p;
    }
    
    public static Chunk lineSeparator(){
        LineSeparator ls = new LineSeparator();
        return (new Chunk(ls));
    }
    
    
    public static Paragraph spaceLine(){
//        Font f = new Font(FontFamily.COURIER, 14, Font.BOLD);
        Paragraph p = new Paragraph("");
//        p.setSpacingAfter(-15);
        return p;
    }
    
    
    public static String cityStringFormat(Employee emp){
        String formStr = String.format("    - Cidade: %1s/%3s / Bairro: %2s ", emp.getAddress().getCity(), emp.getAddress().getNeighborhood(), emp.getAddress().getState());
        return formStr;
    }
    
    
    public static String streetStringFormat(Employee emp){
        String formStr = String.format("    - %1s nº %2s ", emp.getAddress().getStreet(), emp.getAddress().getNumber());
        return formStr;
    }
    
    
    public static String phonesStringFormat(Employee emp){
        String formStr = "    - Telefone: ";
        List<Phone> all = emp.getPhones();
        for (Phone ph : all){
            formStr = formStr + ph.getType() + ": " + ph.getNumber() + " ";
        }
        return formStr;
    }
    
    
    public static String emailStringFormat(Employee emp){
        String formStr = "    - Email: ";
        List<Email> all = emp.getEmails();
        for (Email em : all){
            formStr = formStr + em.getEmail() + " / ";
        }
        return formStr;
    }
    
    
    public static String objectivesStringFormat(Employee emp){
        String formStr = "    ";
        List<Profile> all = emp.getProfile();
        for (Profile pf : all){
            formStr = formStr + pf.getProfile() + " / ";
        }
        return formStr;
    }
}
