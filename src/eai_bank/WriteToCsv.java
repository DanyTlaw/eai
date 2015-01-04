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
 * @author dany
 */
public class WriteToCsv {
    
    public WriteToCsv(){
    
        FileWriter writer = null;
        BufferedWriter bw = null;
        try {
            File csv = new File("EAI_bank.csv");
            writer = new FileWriter(csv);
            bw = new BufferedWriter(writer);
            
            

        } catch (IOException ex) {
            Logger.getLogger(WriteToCsv.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(WriteToCsv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
}
