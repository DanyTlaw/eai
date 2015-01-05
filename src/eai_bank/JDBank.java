/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eai_bank;

import java.util.ArrayList;

/**
 *
 * @author dany
 */
public class JDBank {
    // Arrays with all the data from the webservice divided by Spar- Firmenkonto
    public ArrayList<JDSparData> beforeSparData = new ArrayList<JDSparData>();
    public ArrayList<JDKorrentData> beforeKorrentData = new ArrayList<JDKorrentData>();

    
    
    //Constructor loads all datas
    public JDBank(){
              
        Object[] SearchSparName = null;
        
        // Webservice not available, inform user and exit application
        try{
            SearchSparName = listeSparkontoNachname().toArray();
        }catch (Exception e){
            System.out.println("Webservice nicht erreichbar.");
            System.out.println("Beende Applikation.");
            System.exit(1);
        }
        
        //Loads and save every data from the Webservice (Sparkonten)
        for(Object sname : SearchSparName){
            JDSparData client = new JDSparData(sname);
            beforeSparData.add(client);
        }
     
        //Loads and saveevery data from the Webservice (Kontokorrent))
        Object[] SearchKorrentName = listeKontokorrentNachname().toArray();
        for(Object sname : SearchKorrentName){
            JDKorrentData kunde = new JDKorrentData(sname);
            beforeKorrentData.add(kunde);
        }
        
        System.out.println("Daten der Bank JD gesammelt.");
    }

    public void jdIntegration(EAI_bank eaiB){
        
        //Integration Sparkonto
        int kid = 0;
        String vorname = null;
        String nachname= null;
        String adresse = null;
        String laendercode = null;
        String status = null;
        
        String IBAN = null;
        double kontostand = 0;
        String kontoart = null;

    
        //Loop intigrates the data for each customer of jd bank with "Sparkonto"
        for(int i = 0; i < beforeSparData.size(); i++){
            
            kid = eaiB.intigratedCustomers.size() + 1;
            vorname = "";
            nachname= "";
            adresse = "";
            laendercode = "";
            status = ""; 

            IBAN = "";
            kontostand = 0;
            kontoart = "";
        
            
            // Name intigration
            if(beforeSparData.get(i).vName.value.toString().equalsIgnoreCase("Bendel")){
                vorname = "Oliver";
                nachname = "Bendel";
            }else if(beforeSparData.get(i).nName.value.toString().equalsIgnoreCase("HINKELMANN")){
                vorname = beforeSparData.get(i).vName.value.toString();
                nachname = "Hinkelmann";
            } 
            else {
                vorname = beforeSparData.get(i).vName.value.toString();
                nachname = beforeSparData.get(i).nName.value.toString();
            }
            
            //Checks if the client is already available or not and create an new Client if not
            if(!eaiB.checkClient(nachname)){
                //Adresse
                 String[] plzOrt = beforeSparData.get(i).plzOrt.value.toString().split(" ");         
                 String plz = plzOrt[0];
                 String ort = plzOrt[1];
                 adresse = beforeSparData.get(i).strasse.value.toString() + ", " +plz + ", " + ort;
                 
                 //lCode with 4 letters is always Switzerland
                 if(plz.length()==4){
                     laendercode = "CH";
                 }else{
                     laendercode = "DE";
                 }

                 //Save customers and add to Arraylist with intigrated Customers
                 IntiCustomer client = new IntiCustomer(kid,vorname,nachname,adresse,laendercode,"");
                 eaiB.intigratedCustomers.add(client);
                 
            }
            
            /*
                Account creation
                Sparkontos just have one accountnumber, it is a swiss bank so there will be always CH in the iban and all
                have pp (27) except Roger who has an other Account on an other place.
            
            */
        
            String kontonummer = beforeSparData.get(i).kontonummer.value.toString();
          
            //So here are the changes for Roger Mueller
            if(nachname.equalsIgnoreCase("Mueller")){
                IBAN = "CH27" + "09010" + "0000" + kontonummer;
            //For ther est the normal Iban
            }else{
                IBAN = "CH27" + "22010" + "0000" + kontonummer;
            }
            
            kontostand = Double.parseDouble(beforeSparData.get(i).kontostand.value.toString());
            
            kontoart = "Sparkonto";
            
            //Save Account and add to ArrayList with intigrated Accounts
            IntiBankAccount account = new IntiBankAccount(eaiB.returnClientID(nachname),IBAN,kontostand,kontoart);
            eaiB.intigratedAccounts.add(account);
        }

        //Loop intigrates the data for each customer of jd bank with "Sparkonto"
        for(int i = 0; i < beforeKorrentData.size(); i++){
            
            kid = eaiB.intigratedCustomers.size() + 1;
            vorname = "";
            nachname= "";
            adresse = "";
            laendercode = "";
            status = ""; 

            IBAN = "";
            kontostand = 0;
            kontoart = "";           
            
            //Name intigration
            if(beforeKorrentData.get(i).Vorname.value.toString().equalsIgnoreCase("Bendel")){
                vorname = "Oliver";
                nachname = "Bendel";
            } else {
                vorname = beforeKorrentData.get(i).Vorname.value.toString();
                nachname = beforeKorrentData.get(i).Nachname.value.toString();
            }

            //Creates a new Customer if he isnt in the intigrated ArrayList
            if(!eaiB.checkClient(nachname)){
                //Adress
                 String[] strasseUndPlzOrt = beforeKorrentData.get(i).Adresse.value.toString().split(",");         
                 String[] strasseUndPlzUndOrt = strasseUndPlzOrt[1].split(" ");
                 
                 String strasse = strasseUndPlzOrt[0];
                 String plz = strasseUndPlzUndOrt[1];
                 String ort = strasseUndPlzUndOrt[2];
                 
                 adresse = strasse + ", " +plz + ", " + ort;

                 //Laendercode
                 laendercode = beforeKorrentData.get(i).Land.value.toString();
                 
                 IntiCustomer client = new IntiCustomer(kid,vorname,nachname,adresse,laendercode,"");
                 eaiB.intigratedCustomers.add(client);
            }

            /*
                Account creation
            */
            
            //IBAN
            IBAN = beforeKorrentData.get(i).IBANKontonummer.value.toString();
            
            //Kontostand
            kontostand = Double.parseDouble(beforeKorrentData.get(i).Kontostand.value.toString());
            
            
            //Kontoart
            kontoart = "Kontokorrent";
                       
            //Save Account and add to ArrayList with intigrated Account
            IntiBankAccount account = new IntiBankAccount(eaiB.returnClientID(nachname),IBAN,kontostand,kontoart);
            eaiB.intigratedAccounts.add(account);
            
        }
    
    }
    
    
    // Webservice functions
    private static java.util.List<java.lang.String> listeSparkontoNachname() {
        ch.fhnw.wi.eai.bankjd.BankJDService service = new ch.fhnw.wi.eai.bankjd.BankJDService();
        ch.fhnw.wi.eai.bankjd.BankJD port = service.getBankJDPort();
        return port.listeSparkontoNachname();
    }

    private static java.util.List<java.lang.String> listeKontokorrentNachname() {
        ch.fhnw.wi.eai.bankjd.BankJDService service = new ch.fhnw.wi.eai.bankjd.BankJDService();
        ch.fhnw.wi.eai.bankjd.BankJD port = service.getBankJDPort();
        return port.listeKontokorrentNachname();
    }
    
    
}
