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
public class JDKorrentData {

    Holder Vorname = new Holder();
    Holder Nachname = new Holder();
    Holder Adresse = new Holder();
    Holder Land = new Holder();
    Holder Ranking = new Holder();
    Holder IBANKontonummer = new Holder();
    Holder Kontostand = new Holder();
    Holder BIC = new Holder();
    
    public JDKorrentData (Object nname){
     
        holeKontoKorrent("",nname.toString(), Vorname,Nachname,Adresse,Land,Ranking,IBANKontonummer,Kontostand,BIC);
        
    }

    private static void holeKontoKorrent(java.lang.String queryVorname, java.lang.String queryNachname, javax.xml.ws.Holder<java.lang.String> vorname, javax.xml.ws.Holder<java.lang.String> nachname, javax.xml.ws.Holder<java.lang.String> adresse, javax.xml.ws.Holder<java.lang.String> land, javax.xml.ws.Holder<java.lang.Integer> ranking, javax.xml.ws.Holder<java.lang.String> ibanKontonummer, javax.xml.ws.Holder<java.lang.Float> kontostand, javax.xml.ws.Holder<java.lang.String> bic) {
        ch.fhnw.wi.eai.bankjd.BankJDService service = new ch.fhnw.wi.eai.bankjd.BankJDService();
        ch.fhnw.wi.eai.bankjd.BankJD port = service.getBankJDPort();
        port.holeKontoKorrent(queryVorname, queryNachname, vorname, nachname, adresse, land, ranking, ibanKontonummer, kontostand, bic);
    }

    
}
