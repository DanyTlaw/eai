package eai_bank;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author yps
 */
public class WriteToCsv {
    
    EAI_bank eaiB;
    
    // Delimiter
    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = ";";
    
    // CSV Headers
    private static final String KUNDE_HEADER = "KID;Vorname;Nachname;Adresse;Laendercode;Status";
    private static final String KONTO_HEADER = "KID;IBAN;Kontostand;Kontoart";
    
    public WriteToCsv(EAI_bank eaiB){
        this.eaiB = eaiB;
        
        // Check if the files already exist
        checkFiles();
        
        // Create CSV-Files
        writeCSVCustomers();
        writeCSVAccounts();
        
        // Information for the user
        JOptionPane.showMessageDialog(null, "Der CSV-Export der Daten war erfolgreich.", "CSV Export", JOptionPane.INFORMATION_MESSAGE);
    
        
    } 
    
    private void writeCSVCustomers(){
        
        FileWriter writer = null;
        
        try {
            
            // Define the file and open writer for the customers
            File csv_customers = new File("ziel_kunden.csv");
            writer = new FileWriter(csv_customers);
            
            // Write header
            writer.append(KUNDE_HEADER);
            writer.append(NEW_LINE);
            
            
            for(int i = 0; i < eaiB.intigratedCustomers.size();i++){
                
                // Write customer information 
                String tmpKID = eaiB.intigratedCustomers.get(i).KID + "";
                writer.append(tmpKID);
                writer.append(DELIMITER);
                writer.append(eaiB.intigratedCustomers.get(i).vorname);
                writer.append(DELIMITER);
                writer.append(eaiB.intigratedCustomers.get(i).nachname);
                writer.append(DELIMITER);
                writer.append(eaiB.intigratedCustomers.get(i).adresse);
                writer.append(DELIMITER);
                writer.append(eaiB.intigratedCustomers.get(i).lCode);
                writer.append(DELIMITER);
                writer.append(eaiB.intigratedCustomers.get(i).status);    
                writer.append(NEW_LINE);

            }

        } catch (Exception e) {
            System.out.println("Error writting the CSV-File for the customers.");
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                System.out.println("Error closing the FileWriter of the customers.");
            }
        }        
    }
    
    private void writeCSVAccounts(){
    
        FileWriter writer = null;
        try {
            // Define the file and open writer for the accounts
            File csv_accounts = new File("ziel_konten.csv");
            writer = new FileWriter(csv_accounts);

            // Write header
            writer.append(KONTO_HEADER);
            writer.append(NEW_LINE);

            for(int j = 0; j < eaiB.intigratedAccounts.size(); j++){

                // ID into String and append
                String tmpKID = eaiB.intigratedAccounts.get(j).KID + "";
                writer.append(tmpKID);
                writer.append(DELIMITER);

                writer.append(eaiB.intigratedAccounts.get(j).IBAN);
                writer.append(DELIMITER);

                String tmpKontostand = eaiB.intigratedAccounts.get(j).kontostand + "";
                writer.append(tmpKontostand);
                writer.append(DELIMITER);

                writer.append(eaiB.intigratedAccounts.get(j).kontoart);
                writer.append(NEW_LINE);
            }
        } catch (Exception e) {
            System.out.println("Error writting the CSV-File for accounts.");
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                System.out.println("Error closing the FileWriter of the accounts.");
            }
        }
    } // end 
    
    private void checkFiles(){
        
        // Check for an old customer file
        File csv_customers = new File("ziel_kunden.csv");
        if(csv_customers.isFile()){
            csv_customers.delete();
            System.out.println("Alte Kunden CSV-Datei entfernt.");
        }
        
        // Check for an old account file
        File csv_accounts = new File("ziel_konten.csv");
        if(csv_accounts.isFile()){
            csv_accounts.delete();
            System.out.println("Alte Konten CSV-Datei entfernt.");
        }
    }
}
