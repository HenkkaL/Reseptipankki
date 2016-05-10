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
 * muokkaustilassa tapahtuvia reseptin valmistusvaiheisiin kohdistuvia toimenpiteitä
 * @author Henkka
 * @see Reseptinakyma
 * @see Resepti
 */
public class PaivitaValmistusvaihe implements DocumentListener{
          
            private JTextArea valmistusvaiheKentta;
            Resepti resepti;
            int valmistusvaihe;
            
            
            public PaivitaValmistusvaihe(JTextArea valmistusvaiheKentta, Resepti resepti, int valmistusvaihe){
                this.valmistusvaiheKentta = valmistusvaiheKentta;
                this.resepti = resepti;
                this.valmistusvaihe = valmistusvaihe;
            }

        @Override
        public void insertUpdate(DocumentEvent de) {
            this.resepti.setVaihe(this.valmistusvaihe, this.valmistusvaiheKentta.getText());
            Reseptikortisto.tallentamatonMuutos();
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
            this.resepti.setVaihe(this.valmistusvaihe, this.valmistusvaiheKentta.getText());
            Reseptikortisto.tallentamatonMuutos();
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
            this.resepti.setVaihe(this.valmistusvaihe, this.valmistusvaiheKentta.getText());
            Reseptikortisto.tallentamatonMuutos();
        }

    
}
