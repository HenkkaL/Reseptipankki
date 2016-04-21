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
public class PaivitaNimi implements DocumentListener{
          
            private JTextField nimiKentta;
            Resepti resepti;
            
            public PaivitaNimi(JTextField nimiKentta, Resepti resepti){
                this.nimiKentta = nimiKentta;
                this.resepti = resepti;
            }

        @Override
        public void insertUpdate(DocumentEvent de) {
            this.resepti.setNimi(this.nimiKentta.getText());
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
            this.resepti.setNimi(this.nimiKentta.getText());
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
            this.resepti.setNimi(this.nimiKentta.getText());
        }
    
}
