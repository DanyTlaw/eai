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
public class IntiBankAccount {
        int KID;
    
    //Account
    String IBAN;
    double kontostand;
    String kontoart;
    
    //Constructor 
    public IntiBankAccount(int KID, String IBAN, double kontostand, String kontoart){
        this.KID = KID;
        this.IBAN = IBAN;
        this.kontostand = kontostand;
        this.kontoart = kontoart;
       
    }
    
}
