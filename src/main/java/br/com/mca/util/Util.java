package br.com.mca.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Util {

    public static Date converterToDate(String stringData) {

        DateFormat df;
        Date data = new Date();
        
        try {
            df = new SimpleDateFormat("dd/MM/yyyy");
            data = df.parse(stringData);
        } catch (ParseException ex) {
            
                 JOptionPane.showInputDialog("Ocorreu um erro converterParaData: " + ex);
       
            
            
        }
        
        
        return data;

    }

    public static Object ConvertToString(Date data) {
        
        DateFormat df;
        String dataString = null;
        
        df = new SimpleDateFormat("dd/MM/yyyy");
        dataString = df.format(data);
        
        return dataString;
        
        
    }
    
    

}
