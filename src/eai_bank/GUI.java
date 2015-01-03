/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eai_bank;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dany
 */
public class GUI extends JFrame implements ActionListener{
    
    String[] names;
    EAI_bank eaiB;
    
    JButton jbtConsole;
    JButton jbtCSingle;
    
    JComboBox cmbClients;
    
    //Labels for person
    JLabel lblKID = new JLabel("Kunden ID: ");
    JLabel lblVorname = new JLabel("Vorname: ");
    JLabel lblNachname = new JLabel("Nachname: ");
    JLabel lblAdresse = new JLabel("Adresse: ");
    JLabel lblLCode = new JLabel("Ländercode: ");
    JLabel lblStatus = new JLabel("Status");
     
    public GUI(EAI_bank eaiB){
        
        this.eaiB = eaiB;
        
        this.setLayout(new BorderLayout());
        
        JPanel jplNorth = new JPanel();
        JPanel jplCenter = new JPanel();
       
        JPanel jplSouth = new JPanel();
        jplSouth.setLayout(new BoxLayout(jplSouth, BoxLayout.X_AXIS));

        JPanel jplData = new JPanel();
        jplData.setLayout(new GridLayout(4,1));
        
        
        ArrayList<JPanel> listAccounts = new ArrayList<JPanel>();
        //Labels for Person
        
        
        //Labels for Account
        
        names = new String[eaiB.intigratedCustomers.size()];
        //Save names in Combobox
        for(int i = 0; i< eaiB.intigratedCustomers.size();i++){

            names[i] = eaiB.intigratedCustomers.get(i).vorname +" "+ eaiB.intigratedCustomers.get(i).nachname;           
        }
      
       
        cmbClients = new JComboBox(names);
        jbtConsole = new JButton("Alle ausgeben");
        jbtCSingle = new JButton("Kunden ausgeben");
        
        cmbClients.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent event) {
                
                //Clear the current Data
                jplData.removeAll();
                listAccounts.removeAll(listAccounts);
                revalidate();
                
                JComboBox comboBox = (JComboBox) event.getSource();
                Object selected = comboBox.getSelectedItem();
                int nrAcc = 0;
                
                for(int i = 0; i < eaiB.intigratedCustomers.size();i++){
                    if(selected.equals(eaiB.intigratedCustomers.get(i).vorname + " "+ eaiB.intigratedCustomers.get(i).nachname)){
                        
                        //Display the choosen clients
                        JPanel jplInfo = new JPanel();
                        
                        jplInfo.setLayout(new GridLayout(7,2));
                        
                        jplInfo.add(new JLabel("Kunden ID: "));
                        jplInfo.add(new JLabel(Integer.toString(eaiB.intigratedCustomers.get(i).KID)));
                        
                        jplInfo.add(new JLabel("Vorname: "));
                        jplInfo.add(new JLabel(eaiB.intigratedCustomers.get(i).vorname));
                        
                        jplInfo.add(new JLabel("Nachname: "));
                        jplInfo.add(new JLabel(eaiB.intigratedCustomers.get(i).nachname));
                        
                        jplInfo.add(new JLabel("Adresse: "));
                        jplInfo.add(new JLabel(eaiB.intigratedCustomers.get(i).adresse));
                        
                        jplInfo.add(new JLabel("Ländercode: "));
                        jplInfo.add(new JLabel(eaiB.intigratedCustomers.get(i).lCode));
                        
                        jplInfo.add(new JLabel("Status: "));
                        jplInfo.add(new JLabel(eaiB.intigratedCustomers.get(i).status));
       
                        jplData.add(jplInfo);
                        
                        for(int j = 0; j < eaiB.intigratedAccounts.size(); j++){
                            if(eaiB.intigratedCustomers.get(i).KID == eaiB.intigratedAccounts.get(j).KID){                   
                                
                                JPanel jplAccount = new JPanel();
                                                         
                                jplAccount.setLayout(new GridLayout(5,2));

                                jplAccount.add(new JLabel("ID: "));
                                jplAccount.add(new JLabel(Integer.toString(eaiB.intigratedAccounts.get(j).KID)));

                                jplAccount.add(new JLabel("IBAN: "));
                                jplAccount.add(new JLabel(eaiB.intigratedAccounts.get(j).IBAN));

                                jplAccount.add(new JLabel("Kontostand: "));
                                jplAccount.add(new JLabel(eaiB.convertCurr(Double.toString(eaiB.intigratedAccounts.get(j).kontostand))));                           

                                jplAccount.add(new JLabel("Kontoart:"));
                                jplAccount.add(new JLabel(eaiB.intigratedAccounts.get(j).kontoart));

                                jplAccount.add(new JLabel("  "));
                                jplAccount.add(new JLabel("  "));
                                
                                listAccounts.add(jplAccount);
                                
                                jplData.add(listAccounts.get(nrAcc));

                                nrAcc++;
                            }  
                        }                                     
                    }
                }
             jplCenter.add(jplData);  
             validate();
            }
        });
        jbtConsole.addActionListener(this);
        jbtCSingle.addActionListener(this);
        
        jplNorth.add(cmbClients);
        jplCenter.add(jplData);
        jplSouth.add(jbtConsole);
        jplSouth.add(jbtCSingle);
        
        this.add(jplNorth, BorderLayout.NORTH);
        this.add(jplCenter, BorderLayout.CENTER);
        this.add(jplSouth, BorderLayout.SOUTH);
        this.setSize(700,600);
        this.setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbtConsole){
            eaiB.writeIntiData();
        }
        else if(e.getSource() == jbtCSingle){
            eaiB.writeSingleData(cmbClients.getItemCount());
        }
    }
        
    
}
