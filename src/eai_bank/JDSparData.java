/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eai_bank;

import javax.xml.ws.Holder;

/**
 *
 * @author dany
 */
public class JDSparData {
    

    Holder vName = new Holder();
    Holder nName = new Holder();
    Holder strasse = new Holder();
    Holder plzOrt = new Holder();
    Holder zinsen = new Holder();
    Holder kontonummer = new Holder();
    Holder kontostand = new Holder();
    
    public JDSparData(Object nname){
     
        holeSparkonto("", nname.toString(), vName, nName, strasse, plzOrt, zinsen, kontonummer, kontostand);
        
    }

    private static void holeSparkonto(java.lang.String queryVorname, java.lang.String queryNachname, javax.xml.ws.Holder<java.lang.String> vorname, javax.xml.ws.Holder<java.lang.String> nachname, javax.xml.ws.Holder<java.lang.String> strasse, javax.xml.ws.Holder<java.lang.String> plzOrt, javax.xml.ws.Holder<java.lang.Float> zinsen, javax.xml.ws.Holder<java.lang.Long> kontonummer, javax.xml.ws.Holder<java.lang.Long> kontostand) {
        ch.fhnw.wi.eai.bankjd.BankJDService service = new ch.fhnw.wi.eai.bankjd.BankJDService();
        ch.fhnw.wi.eai.bankjd.BankJD port = service.getBankJDPort();
        port.holeSparkonto(queryVorname, queryNachname, vorname, nachname, strasse, plzOrt, zinsen, kontonummer, kontostand);
    }
}