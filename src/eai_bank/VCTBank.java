/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eai_bank;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author dany
 */
public class VCTBank {
    
   private VctData beforeVctData;
    
    public VCTBank(){
        
        beforeVctData = new VctData();
        
    }
    
    //Method for integration of the VCT Bank data
    public void vctIntigration(EAI_bank eaiB){
     String vorname = null;
        String nachname= null;
        String adresse = null;
        String laendercode = null;
        String status = null;
        
        String IBAN = null;
        double kontostand = 0;
        String kontoart = null;
        
       //Do intigration until there is no data anymore
       try {
           while(beforeVctData.rs.next()){
               
               
               int kid = eaiB.intigratedCustomers.size() + 1;
               vorname = "";
               nachname= "";
               adresse = "";
               laendercode = "";
               status = "";
               
               IBAN = "";
               kontostand = 0;
               kontoart = "";
               
               boolean deleted = false;

               //If the Account is "Firma" no intigration is needed
               String kundenart = beforeVctData.rs.getString("Kundenart");
               if(kundenart.equalsIgnoreCase("Firma")){
                   deleted = true;
               }
               if(!deleted){

                    //Name intigration
                    String[] ganzername = beforeVctData.rs.getString("Kundenname").split(" ");

                    //Change "Umlaute"
                    for(int i = 0; i < ganzername.length; i++){
                        ganzername[i] = eaiB.replaceUmlaut(ganzername[i]);
                    }

                    if(ganzername.length==1){
                        vorname = ganzername[0];
                    }

                    else if(ganzername.length==2 ){
                        // Standard Name
                        vorname = ganzername[0];
                        nachname = ganzername[1];
                    }else{
                        //Name with 3 parts
                        //With Bender there has to be Dr. removed
                        if(ganzername[0].equalsIgnoreCase("Dr.")){
                            vorname = ganzername[1];
                            nachname = ganzername[2];
                        //To garantue correct migration M. has to be corrected
                        } else if(ganzername[0].equalsIgnoreCase("M.")){
                            vorname = "Michael M.";
                            nachname = "Richter";
                        } else{
                            vorname = ganzername[0];
                            nachname = ganzername[1] + " " + ganzername[2];
                        }
                    }

                    //If there isnt an excisting Account of this Client
                    if(!eaiB.checkClient(nachname)){

                         //Adress
                         String strassenname = beforeVctData.rs.getString("Strassenname");
                         String PLZ = beforeVctData.rs.getString("PLZ");
                         String stadt = beforeVctData.rs.getString("Stadt");

                         adresse = strassenname + ", " + PLZ + ", " + stadt;

                         //LCode
                         String land = beforeVctData.rs.getString("Land");

                         if(land.equalsIgnoreCase("Schweiz") || land.equalsIgnoreCase("Switzerland")){
                             laendercode = "CH";
                         }
                         else if(land.equalsIgnoreCase("Deutschland") || land.equalsIgnoreCase("Germany")){
                             laendercode = "DE";
                         }
                         else if(land.equalsIgnoreCase("The Netherlands")){
                             laendercode = "NL";
                         }

                         //Save customer and add him to the intigrated Customer ArrayList
                         IntiCustomer intiCust = new IntiCustomer(kid,vorname,nachname,adresse,laendercode,"");
                         eaiB.intigratedCustomers.add(intiCust);
                    }
                    /*
                        Account creation
                    */

                    //IBAN calculation: Daniel Herzog Bank Erfahrung and Internet 
                    String kontonummer = beforeVctData.rs.getString("Kontonummer");
                    String clearing = beforeVctData.rs.getString("Clearing");

                    String IbanOhnePP =  clearing + "000" + kontonummer +"121700";
                    double ibanPPBerechner = Double.parseDouble(IbanOhnePP);
                    double ppDbl = (98 - ibanPPBerechner%97);
                    int pp = (int) ppDbl;

                    IBAN = "CH" + pp + clearing + "000" +kontonummer;

                    //Kontostand
                    kontostand = Double.parseDouble(beforeVctData.rs.getString("Saldo"));


                    //Kontoart
                    kundenart = beforeVctData.rs.getString("Kundenart");
                    if(kundenart.equalsIgnoreCase("Firma")){
                        deleted = true;
                    }else{
                        kontoart = "Privatkonto";
                    }

                    //Save Account and add it to the intigrated Account Arraylist
                    IntiBankAccount intiBA = new IntiBankAccount(eaiB.returnClientID(nachname), IBAN, kontostand, kontoart);
                    eaiB.intigratedAccounts.add(intiBA);
                    }     
           }
       } catch (SQLException ex) {
           Logger.getLogger(VCTBank.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }
}
