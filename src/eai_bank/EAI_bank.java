/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eai_bank;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author dany
 */
public class EAI_bank {
    
    public static ArrayList<IntiCustomer> intigratedCustomers = new ArrayList<IntiCustomer>(); 
    public static ArrayList<IntiBankAccount> intigratedAccounts = new ArrayList<IntiBankAccount>(); 
    
    int kontostandCount;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Object of the new Bank gets created
        EAI_bank eaiB = new EAI_bank();
        
        //Object of JDBank and VCTBank gets generatet with all its data
        JDBank jdB = new JDBank();
        VCTBank vctB = new VCTBank();
        
        //Data integration
        vctB.vctIntigration(eaiB);
        jdB.jdIntegration(eaiB);

        //Status hinzufügen
        makeStatus(eaiB);
        
        //GUi geöffnet mit Daten
        GUI gui = new GUI(eaiB);
        
    }
    
    public EAI_bank(){
    
    }
    
    /*****************************Intigration Standard Methods*********************/
    
    //Method for setting the Member status
    public static String setStatus(double kontostand){
        
        String status = "";
        
        int gold = 1000000;
        int silber = 50000;
        int bronze = 0;
        
        if(kontostand>= gold){
             status = "Gold";
        }else if(kontostand<gold && kontostand >= silber){
             status = "Silber";
        }else if(kontostand<silber && kontostand >= bronze){
             status = "Bronze";
        }
        return status;
    }
    
    //Method with return of all accounts form one person
    public static double accountValue(EAI_bank eaiB, int i){
        double value = 0;
        double amount = 0;  
        int kid = eaiB.intigratedCustomers.get(i).KID;
        
        for(int j = 0; j< eaiB.intigratedAccounts.size(); j++){
            if(eaiB.intigratedAccounts.get(j).KID==kid){
                amount = eaiB.intigratedAccounts.get(j).kontostand;
                System.out.println(amount);
                value = value + amount;
            }

        }
        System.out.println(value);
        return value;
    }
    
    public static void makeStatus(EAI_bank eaiB){
        for(int i = 0; i< eaiB.intigratedCustomers.size(); i++){
            eaiB.intigratedCustomers.get(i).status = setStatus(accountValue(eaiB, i));
        }
    }
    
    //Method for convert "Umlauts"  
    public String replaceUmlaut(String input){
    String result =
        input
        .replaceAll("ü", "ue")
        .replaceAll("ö", "oe")
        .replaceAll("ä", "ae");
    
    return result;
    }
    
        // Formate Money output
    public static String convertCurr(String number){
        // Set locale to swiss
        Locale locale = new Locale("de", "CH");
        NumberFormat nformat = DecimalFormat.getCurrencyInstance(locale);
        
        // Set currency
        Currency currency = Currency.getInstance("CHF");
        nformat.setCurrency(currency);
        
        // Format the return variable
        BigDecimal amount = new BigDecimal(number);
        String formatted = nformat.format(amount.doubleValue());

       return formatted; 
    }
    
    public boolean checkClient(String name){
        
        for(int i = 0; i < intigratedCustomers.size();i++){
            if(intigratedCustomers.get(i).nachname.equalsIgnoreCase(name)){
                return true;
            }
            
        }
        return false;
    }

    /*****************************Helper Methods*********************/
    
    public int returnClientID(String name){
        
        int clientID = 0;
        //Schleife welche die ID des spezifischen Kunden nimmt nach nachnamen gesucht
        for(int i = 0; i < intigratedCustomers.size();i++){
            if(intigratedCustomers.get(i).nachname.equalsIgnoreCase(name)){
                clientID = intigratedCustomers.get(i).KID;
            }

        }
        return clientID;       
    }
    
    public static void writeSingleData(int cl){
        System.out.println("DRINNNNNNNNN");
        for(int i = 0; i < intigratedCustomers.size(); i++){
            if(intigratedCustomers.get(i).KID== cl){
            System.out.println("Kunde:");
            System.out.println("-------------------------------------------");
            System.out.println("KID:        " + intigratedCustomers.get(i).KID);
            System.out.println("Vorname:    " + intigratedCustomers.get(i).vorname);
            System.out.println("Nachname:   " + intigratedCustomers.get(i).nachname);
            System.out.println("Adresse:    " + intigratedCustomers.get(i).adresse);
            System.out.println("Ländercode: " + intigratedCustomers.get(i).lCode);
            System.out.println("Status      " + intigratedCustomers.get(i).status);
            System.out.println("-------------------------------------------");
            }
        }
        

    
        for(int i = 0; i < intigratedAccounts.size(); i++){
            if(intigratedAccounts.get(i).KID == cl){
                System.out.println("KID:        " + intigratedAccounts.get(i).KID);
                System.out.println("IBAN:       " + intigratedAccounts.get(i).IBAN);
                System.out.println("Kontostand: " + intigratedAccounts.get(i).kontostand);  
                System.out.println("Kontostand formatiert: " + convertCurr("" + intigratedAccounts.get(i).kontostand));
                System.out.println("Kontoart:   " + intigratedAccounts.get(i).kontoart);
                System.out.println("-------------------------------------------");
                
                
            }
            
        }    
    }
    
    public static void writeIntiData(){
        
        for(int i = 0; i < intigratedCustomers.size(); i++){
            System.out.println("Kunde:");
            System.out.println("-------------------------------------------");
            System.out.println("KID:        " + intigratedCustomers.get(i).KID);
            System.out.println("Vorname:    " + intigratedCustomers.get(i).vorname);
            System.out.println("Nachname:   " + intigratedCustomers.get(i).nachname);
            System.out.println("Adresse:    " + intigratedCustomers.get(i).adresse);
            System.out.println("Ländercode: " + intigratedCustomers.get(i).lCode);
            System.out.println("Status      " + intigratedCustomers.get(i).status);
            System.out.println("-------------------------------------------");
            
            for(int j = 0; j <intigratedAccounts.size(); j++){
                if(intigratedCustomers.get(i).KID == intigratedAccounts.get(j).KID){
                System.out.println("KID:        " + intigratedAccounts.get(j).KID);
                System.out.println("IBAN:       " + intigratedAccounts.get(j).IBAN);
                System.out.println("Kontostand: " + intigratedAccounts.get(j).kontostand);  
                System.out.println("Kontostand formatiert: " + convertCurr("" + intigratedAccounts.get(j).kontostand));
                System.out.println("Kontoart:   " + intigratedAccounts.get(j).kontoart);
                System.out.println("-------------------------------------------");
                }
            }             
        }
    } 
}

