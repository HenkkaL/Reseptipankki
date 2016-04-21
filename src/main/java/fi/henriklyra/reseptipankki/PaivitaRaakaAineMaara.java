/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.henriklyra.reseptipankki;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Henkka
 */
public class PaivitaRaakaAineMaara implements DocumentListener{
          
            private JTextField rAineMaara;
            RaakaAine rAine;
            
            public PaivitaRaakaAineMaara(JTextField rAineNimi, RaakaAine rAine){
                this.rAineMaara = rAineMaara;
                this.rAine = rAine;
            }

        @Override
        public void insertUpdate(DocumentEvent de) {
                this.rAine.setMaara(this.rAineMaara.getText());
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
                this.rAine.setMaara(this.rAineMaara.getText());
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
                this.rAine.setMaara(this.rAineMaara.getText());
        }
    
}