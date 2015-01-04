/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eai_bank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tdanylaw
 */
public class WriteToFile {
    EAI_bank eaiB;
    
    public WriteToFile(EAI_bank eaiB){
        
        this.eaiB = eaiB;
        
        try {
            File newFile =  new File("EAI_bank.txt");
            
            newFile.createNewFile();
            
            FileWriter fw = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(fw);
           
            
            for(int i = 0; i < eaiB.intigratedCustomers.size();i++){
                bw.newLine();
                bw.write("*****************************Kunde********************************");
                bw.newLine();
                bw.write("Kunden ID:         " + eaiB.intigratedCustomers.get(i).KID);
                bw.newLine();
                bw.write("Vorname:           " + eaiB.intigratedCustomers.get(i).vorname);
                bw.newLine();
                bw.write("Nachname:          " + eaiB.intigratedCustomers.get(i).nachname);
                bw.newLine();
                bw.write("Addrese:           " + eaiB.intigratedCustomers.get(i).adresse);
                bw.newLine();
                bw.write("Ländercode:        " + eaiB.intigratedCustomers.get(i).lCode);
                bw.newLine();
                bw.write("Status:            " + eaiB.intigratedCustomers.get(i).status);
                bw.newLine();

                for(int j = 0; j < eaiB.intigratedAccounts.size(); j++){
                    if(eaiB.intigratedCustomers.get(i).KID==eaiB.intigratedAccounts.get(j).KID){
                        bw.write("------------------------------------------------------------------");
                        bw.newLine();
                        bw.write("ID:          " + eaiB.intigratedAccounts.get(j).KID);
                        bw.newLine();
                        bw.write("Kontoart:    " + eaiB.intigratedAccounts.get(j).kontoart);
                        bw.newLine();
                        bw.write("Kontostand:  " + eaiB.convertCurr(Double.toString(eaiB.intigratedAccounts.get(j).kontostand)));
                        bw.newLine();
                        bw.write("IBAN:        " + eaiB.intigratedAccounts.get(j).IBAN);
                        bw.newLine();                        
                    }
                }
            }
            bw.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
