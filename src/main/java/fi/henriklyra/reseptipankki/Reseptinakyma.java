/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.henriklyra.reseptipankki;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Henkka
 */
public class Reseptinakyma extends javax.swing.JFrame {

    Resepti resepti;
    RaakaAine raakaAine;
    JPanel otsikkoYla, otsikkoAla, raakaAineetYla, raakaAineetAla, yksiRAine, valmistusvaiheetYla, valmistusvaiheetAla, yksivaihe;
    JLabel nimi, rAineet, vVaiheet, rAine, mitta, maara;
    JTextArea kuvailu, vaihe;
    JButton muokkaaNappi;
    Font leipateksti, otsikkoTeksti;

    /**
     * Creates new form Reseptinakyma
     */
    public Reseptinakyma(Resepti resepti) {
        this.resepti = resepti;
        raakaAine = new RaakaAine();
        this.leipateksti = new Font("Serif", Font.BOLD, 20);
        this.otsikkoTeksti = new Font("Serif", Font.BOLD, 30);
        initComponents();
        this.setVisible(true);

        //Luodaan otsikkonäkymä
        this.otsikko.setLayout(new BorderLayout());
        this.otsikkoYla = new JPanel();
        this.otsikkoYla.setLayout(new FlowLayout());
        this.nimi = new JLabel(this.resepti.getNimi());
        this.nimi.setFont(this.otsikkoTeksti);
        this.otsikkoYla.add(this.nimi);
        this.muokkaaNappi = new JButton("Muokkaa reseptiä");
        this.otsikkoYla.add(this.muokkaaNappi);
        this.otsikko.add(this.otsikkoYla, BorderLayout.NORTH);
        this.otsikko.repaint();
        this.otsikkoAla = new JPanel();
        this.otsikkoAla.setLayout(new FlowLayout());
        this.kuvailu = new JTextArea();
        this.kuvailu.setFont(this.leipateksti);
        this.kuvailu.setSize(700, 50);
        this.kuvailu.setLineWrap(true);
        this.kuvailu.setWrapStyleWord(true);
        kuvailu.setEditable(false);
        kuvailu.setText(resepti.getKuvailu());
        this.otsikkoAla.add(this.kuvailu);
        this.otsikko.add(this.otsikkoAla, BorderLayout.SOUTH);

        //Luodaan raaka-ainenäkymä
        this.raakaAinePaneeli.setLayout(new BorderLayout());

        //Luodaan raaka-aineiden otsikko 
        this.raakaAineetYla = new JPanel();
        this.raakaAineetYla.setLayout(new FlowLayout());
        this.rAineet = new JLabel("Raaka-aineet:");
        this.rAineet.setFont(this.otsikkoTeksti);
        this.raakaAineetYla.add(this.rAineet);
        this.raakaAinePaneeli.add(this.raakaAineetYla, BorderLayout.NORTH);

        //Luodaan lista raaka-aineisa
        this.raakaAineetAla = new JPanel();
        this.raakaAineetAla.setLayout(new GridLayout(this.resepti.getRaakaAineet().size(), 1));

        for (RaakaAine aine : this.resepti.getRaakaAineet()) {
            //Luodaan kukin raaka-aine erikseen
            this.yksiRAine = new JPanel();
            this.yksiRAine.setLayout(new FlowLayout());
            this.raakaAine = aine;
            this.maara = new JLabel(raakaAine.getMaara());
            this.maara.setFont(leipateksti);
            this.mitta = new JLabel(raakaAine.getMitta());
            this.mitta.setFont(leipateksti);
            this.rAine = new JLabel(raakaAine.getNimi());
            this.rAine.setFont(leipateksti);
            this.yksiRAine.add(this.maara);
            this.yksiRAine.add(this.mitta);
            this.yksiRAine.add(this.rAine);
            this.raakaAineetAla.add(this.yksiRAine);
        }
        this.raakaAinePaneeli.add(this.raakaAineetAla, BorderLayout.SOUTH);

        //Luodaan valmistusvaihenäkymä
        this.valmVaihePaneeli.setLayout(new BorderLayout());

        //Luodaan valmistusvaiheille otsikko
        this.valmistusvaiheetYla = new JPanel();
        this.valmistusvaiheetYla.setLayout(new FlowLayout());
        this.vVaiheet = new JLabel("Valmistusvaiheet:");
        this.vVaiheet.setFont(this.otsikkoTeksti);
        this.valmistusvaiheetYla.add(this.vVaiheet);
        this.valmVaihePaneeli.add(this.valmistusvaiheetYla, BorderLayout.NORTH);

        //Luodaan lista valmistusvaiheista
        this.valmistusvaiheetAla = new JPanel();
        this.valmistusvaiheetAla.setLayout(new GridLayout(this.resepti.getVaiheet().size(), 1));

        for (String uusiVaihe : this.resepti.getVaiheet()) {
            //Luodaan kukin valmistusvaihe erikseen ja asetetaan omaan paneeliinsa
            this.yksivaihe = new JPanel();
            this.yksivaihe.setLayout(new FlowLayout());
            this.vaihe = new JTextArea();
            this.vaihe.setFont(this.leipateksti);
            this.vaihe.setSize(700, 50);
            this.vaihe.setLineWrap(true);
            this.vaihe.setWrapStyleWord(true);
            this.vaihe.setEditable(false);
            this.vaihe.setText(uusiVaihe);
            this.yksivaihe.add(this.vaihe);
            this.valmistusvaiheetAla.add(this.yksivaihe);
        }
        this.valmVaihePaneeli.add(this.valmistusvaiheetAla, BorderLayout.SOUTH);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tausta = new javax.swing.JPanel();
        otsikko = new javax.swing.JPanel();
        raakaAinePaneeli = new javax.swing.JPanel();
        valmVaihePaneeli = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout otsikkoLayout = new javax.swing.GroupLayout(otsikko);
        otsikko.setLayout(otsikkoLayout);
        otsikkoLayout.setHorizontalGroup(
            otsikkoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 846, Short.MAX_VALUE)
        );
        otsikkoLayout.setVerticalGroup(
            otsikkoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout raakaAinePaneeliLayout = new javax.swing.GroupLayout(raakaAinePaneeli);
        raakaAinePaneeli.setLayout(raakaAinePaneeliLayout);
        raakaAinePaneeliLayout.setHorizontalGroup(
            raakaAinePaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        raakaAinePaneeliLayout.setVerticalGroup(
            raakaAinePaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout valmVaihePaneeliLayout = new javax.swing.GroupLayout(valmVaihePaneeli);
        valmVaihePaneeli.setLayout(valmVaihePaneeliLayout);
        valmVaihePaneeliLayout.setHorizontalGroup(
            valmVaihePaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        valmVaihePaneeliLayout.setVerticalGroup(
            valmVaihePaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout taustaLayout = new javax.swing.GroupLayout(tausta);
        tausta.setLayout(taustaLayout);
        taustaLayout.setHorizontalGroup(
            taustaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(otsikko, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(raakaAinePaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(valmVaihePaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        taustaLayout.setVerticalGroup(
            taustaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taustaLayout.createSequentialGroup()
                .addComponent(otsikko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(raakaAinePaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(valmVaihePaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(tausta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reseptinakyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reseptinakyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reseptinakyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reseptinakyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Reseptinakyma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel otsikko;
    private javax.swing.JPanel raakaAinePaneeli;
    private javax.swing.JPanel tausta;
    private javax.swing.JPanel valmVaihePaneeli;
    // End of variables declaration//GEN-END:variables

}
