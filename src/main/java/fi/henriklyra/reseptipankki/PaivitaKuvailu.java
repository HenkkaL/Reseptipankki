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
 * Tekninen apuluokka, jonka tehtävänä on tarkkailla ja päivittää reseptinäkymän 
 * muokkaustilassa tapahtuvia reseptin kuvailuun kohdistuvia toimenpiteitä
 * @author Henkka
 * @see Reseptinakyma
 * @see Resepti
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
            Reseptikortisto.tallentamatonMuutos();
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
            this.resepti.setKuvailu(this.kuvailuKentta.getText());
            Reseptikortisto.tallentamatonMuutos();
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
            this.resepti.setKuvailu(this.kuvailuKentta.getText());
            Reseptikortisto.tallentamatonMuutos();
        }
    
}