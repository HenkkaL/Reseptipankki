/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.henriklyra.reseptipankki;

/**
 * Tekninen apuluokka, jonka tehtävänä on valvoa reseptinäkymän 
 * muokkaustilassa tapahtuvia reseptin tekstikenttiin päivitettävien 
 * merkkijonojen pituuksia.
 * Luokka on kopioitu osoiteesta:
 * http://www.java2s.com/Tutorial/Java/0260__Swing-Event/LimitJTextFieldinputtoamaximumlength.htm
 * @author Henkka
 * @see Resepti
 */
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class JTextFieldLimit extends PlainDocument {
  private int limit;
  JTextFieldLimit(int limit) {
    super();
    this.limit = limit;
  }

  JTextFieldLimit(int limit, boolean upper) {
    super();
    this.limit = limit;
  }

  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    if (str == null)
      return;

    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }
}