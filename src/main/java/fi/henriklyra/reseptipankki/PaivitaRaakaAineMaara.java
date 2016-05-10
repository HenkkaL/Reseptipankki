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
 * muokkaustilassa tapahtuvia reseptin raaka-aineen määrään kohdistuvia 
 * toimenpiteitä
 * @author Henkka
 * @see Reseptinakyma
 * @see RaakaAine
 */
public class PaivitaRaakaAineMaara implements DocumentListener{
          
            private JTextField rAineMaara;
            RaakaAine rAine;
            
            public PaivitaRaakaAineMaara(JTextField rAineMaara, RaakaAine rAine){
                this.rAineMaara = rAineMaara;
                this.rAine = rAine;
            }

        @Override
        public void insertUpdate(DocumentEvent de) {
                this.rAine.setMaara(this.rAineMaara.getText());
                Reseptikortisto.tallentamatonMuutos();
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
                this.rAine.setMaara(this.rAineMaara.getText());
                Reseptikortisto.tallentamatonMuutos();
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
                this.rAine.setMaara(this.rAineMaara.getText());
                Reseptikortisto.tallentamatonMuutos();
        }
    
}