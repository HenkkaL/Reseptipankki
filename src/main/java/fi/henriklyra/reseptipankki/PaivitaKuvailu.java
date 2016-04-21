/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.henriklyra.reseptipankki;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Henkka
 */
public class PaivitaKuvailu implements DocumentListener{
          
            private JTextArea kuvailuKentta;
            Resepti resepti;
            
            public PaivitaKuvailu(JTextArea nimiKentta, Resepti resepti){
                this.kuvailuKentta = nimiKentta;
                this.resepti = resepti;
            }

        @Override
        public void insertUpdate(DocumentEvent de) {
            this.resepti.setKuvailu(this.kuvailuKentta.getText());
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
            this.resepti.setKuvailu(this.kuvailuKentta.getText());
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
            this.resepti.setKuvailu(this.kuvailuKentta.getText());
        }
    
}