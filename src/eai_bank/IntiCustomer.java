/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eai_bank;

/**
 *
 * @author dany
 */
public class IntiCustomer {
   
        int KID;
    
     //Customer
    String vorname;
    String nachname;
    String adresse;
    String lCode;
    String status;
    
    public IntiCustomer(int kid,String vorname, String nachname, String adresse, String lCode, String status){
        
        this.KID = kid;
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.lCode = lCode;
        this.status = status;
  
    }
    
}
