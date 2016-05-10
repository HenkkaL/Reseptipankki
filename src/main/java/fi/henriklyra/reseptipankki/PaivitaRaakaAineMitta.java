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
 * Tekninen apuluokka, jonka tehtävänä on tarkkailla ja päivittää reseptinäkymän 
 * muokkaustilassa tapahtuvia reseptin raaka-aineen mittayksitkköön kohdistuvia 
 * toimenpiteitä
 * @author Henkka
 * @see Reseptinakyma
 * @see RaakaAine
 */
public class PaivitaRaakaAineMitta implements DocumentListener{
          
            private JTextField rAineMitta;
            RaakaAine rAine;
            
            public PaivitaRaakaAineMitta(JTextField rAineMitta, RaakaAine rAine){
                this.rAineMitta = rAineMitta;
                this.rAine = rAine;
            }

        @Override
        public void insertUpdate(DocumentEvent de) {
                this.rAine.setMitta(this.rAineMitta.getText());
                Reseptikortisto.tallentamatonMuutos();
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
                this.rAine.setMitta(this.rAineMitta.getText());
                Reseptikortisto.tallentamatonMuutos();
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
                this.rAine.setMitta(this.rAineMitta.getText());
                Reseptikortisto.tallentamatonMuutos();
        }
    
}