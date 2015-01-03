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
    
    // Arrays with all the new integrated data 
    
    
    //Constructor loads all datas
    public JDBank(){
              
        Object[] SearchSparName = null;
        
        // Webservice not available, inform user and exit application
        try{
            SearchSparName = listeSparkontoNachname().toArray();
        }catch (Exception e){
            System.out.println("> Webservice nicht erreichbar.");
            System.out.println("> Beende Applikation.");
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

    
        //Schlaufe welche für jeden Kunden mit einem SparKonto ein zielkunde erstellt und die Daten richtig migriert
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
        
            
            // Vorname und Nachname
            if(beforeSparData.get(i).vName.value.toString().equalsIgnoreCase("Bendel")){
                vorname = "Oliver";
                nachname = "Bendel";
            } else {
                vorname = beforeSparData.get(i).vName.value.toString();
                nachname = beforeSparData.get(i).nName.value.toString();
            }
            
            //Wenn der Kunde noch nicht vorhanden ist erstelle den Kunden
            if(!eaiB.checkClient(nachname)){
                //Adresse
                 String[] plzOrt = beforeSparData.get(i).plzOrt.value.toString().split(" ");         
                 String plz = plzOrt[0];
                 String ort = plzOrt[1];
                 adresse = beforeSparData.get(i).strasse.value.toString() + ", " +plz + ", " + ort;
                 
                 //Laendercode wenn 4 stellig = CH wenn 5 stellig DE
                 if(plz.length()==4){
                     laendercode = "CH";
                 }else{
                     laendercode = "DE";
                 }
                 
                 //Status - nicht möglich hier zu setzen weil unbekannt 
                 status = "";
                 
                 //Kunden speichern
                 IntiCustomer client = new IntiCustomer(kid,vorname,nachname,adresse,laendercode,"");
                 eaiB.intigratedCustomers.add(client);
                 
            }
            
            //Konto wird erstellt
            //Sparkonten haben nur eine Kontonummer, da es sich aber um die gleiche bank handelt
            //ist CH und pp (27) immer gleich. Nur die BLZ ändert sich bei Roger der bei einer anderen Filiale
            //seine Konten hat.
            
            String kontonummer = beforeSparData.get(i).kontonummer.value.toString();

            
            //Also wenn Herr Mueller an der reihe ist wird eine andere BLZ genommen = 0901 (09010) da 5 stellig
            if(nachname.equalsIgnoreCase("Mueller")){
                IBAN = "CH27" + "09010" + "0000" + kontonummer;
            //Sonst die normale blz der filliale 2201 (22010) da 5 stellig
            }else{
                IBAN = "CH27" + "22010" + "0000" + kontonummer;
            }
            
            kontostand = Double.parseDouble(beforeSparData.get(i).kontostand.value.toString());
            //System.out.println(convertCurr(kundenSparkonto.get(i).kontostand.value.toString()));
            
            kontoart = "Sparkonto";

            IntiBankAccount account = new IntiBankAccount(eaiB.returnClientID(nachname),IBAN,kontostand,kontoart);
            eaiB.intigratedAccounts.add(account);
        }

        //Schleife welche schaut ob dieser Kunde mit einem Kontokorrentkonto schon mit diesem nachnamen existiert wenn ja setzt er vorhanden auf true
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
            
            // Vorname und Nachname
            if(beforeKorrentData.get(i).Vorname.value.toString().equalsIgnoreCase("Bendel")){
                vorname = "Oliver";
                nachname = "Bendel";
            } else {
                vorname = beforeKorrentData.get(i).Vorname.value.toString();
                nachname = beforeKorrentData.get(i).Nachname.value.toString();
            }

            //Wenn der Kunde noch nicht vorhanden ist erstelle den Kunden
            if(!eaiB.checkClient(nachname)){
                //Adresse 
                 String[] strasseUndPlzOrt = beforeKorrentData.get(i).Adresse.value.toString().split(",");         
                 String[] strasseUndPlzUndOrt = strasseUndPlzOrt[1].split(" ");
                 
                 String strasse = strasseUndPlzOrt[0];
                 String plz = strasseUndPlzUndOrt[1];
                 String ort = strasseUndPlzUndOrt[2];
                 
                 adresse = strasse + ", " +plz + ", " + ort;

                 //Laendercode
                 laendercode = beforeKorrentData.get(i).Land.value.toString();
                 
                 //Status
                 status = "";

                 IntiCustomer client = new IntiCustomer(kid,vorname,nachname,adresse,laendercode,"");
                 eaiB.intigratedCustomers.add(client);
            }
            
            //Konto wird erstellt
            
            //IBAN
            IBAN = beforeKorrentData.get(i).IBANKontonummer.value.toString();
            
            //Kontostand
            kontostand = Double.parseDouble(beforeKorrentData.get(i).Kontostand.value.toString());
            
            
            //Kontoart
            kontoart = "Kontokorrent";
                       
            IntiBankAccount account = new IntiBankAccount(eaiB.returnClientID(nachname),IBAN,kontostand,kontoart);
            eaiB.intigratedAccounts.add(account);
            
        }
    
    }
    
    
    //Webservice functions
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
