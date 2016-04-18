/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.henriklyra.reseptipankki;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Henkka
 */
public class Ohjuri extends JFrame {
    
    
    private JPanel paneeli;
    private ArrayList<Resepti> reseptilista;
    private JButton reseptinappi;
    
    Reseptinakyma reseptikatselu;

    public void reseptilistaus(JPanel paneeli, ArrayList<Resepti> reseptilista) {
        this.paneeli = paneeli;
        this.paneeli.removeAll();
        //this.paneeli.setLayout(new BorderLayout());
        this.reseptilista = reseptilista;
        this.paneeli.setLayout(new GridLayout(this.reseptilista.size(), 1));
        for (int i = 0; i < this.reseptilista.size(); i++) {

            this.paneeli.add(this.luoReseptinappi(this.reseptilista.get(i)));
        }
        this.paneeli.repaint();
    }

    public JButton luoReseptinappi(Resepti uusiResepti) {       
        Resepti resepti;
        resepti = uusiResepti;
        this.reseptinappi = new JButton();
        reseptinappi.setLayout(new GridLayout(2, 1));
        reseptinappi.setSize(400, 100);
        JLabel rNimi = new JLabel();
        rNimi.setFont(new Font("Serif", Font.BOLD, 20));
        rNimi.setSize(100, 20);
        rNimi.setText(resepti.getNimi());
        JTextArea kuvailu = new JTextArea(4, 70);
        kuvailu.setFont(new Font("Serif", Font.BOLD, 12));
        kuvailu.setLineWrap(true);
        kuvailu.setWrapStyleWord(true);
        kuvailu.setEditable(false);
        kuvailu.setText(resepti.getKuvailu());
        reseptinappi.add(rNimi);
        reseptinappi.add(kuvailu);
        this.reseptinappi.addActionListener(e -> new Reseptinakyma(resepti));       
        return this.reseptinappi;       
    }

    public static void main(String[] args) {
         Reseptikortisto rKortisto = new Reseptikortisto();
         Resepti r1 = new Resepti("Kaalilaatikko");
         Resepti r2 = new Resepti("Lohilaatikko");
         Resepti r3 = new Resepti("Janssoninkiusaus");
         Resepti r4 = new Resepti("Lihapullat");
         Resepti r5 = new Resepti("Hernekeitto");
         Resepti r6 = new Resepti("Purjoperunasosekeitto");
         Resepti r7 = new Resepti("Kaalipiirakka");
         Resepti r8 = new Resepti("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        
         r1.setKuvailu("Perinteinen kaalilaatikko on kotiruokien ehdoton ykkönen. Tällä supersuositulla reseptillä kaalilaatikosta tulee juuri niin mehevä kuin kuuluukin. Resepti on kopioitu osoitteesta http://www.maku.fi/reseptit/perinteinen-kaalilaatikko");
         r2.setKuvailu("Lohilaatikko valmistuu kätevästi pakasteperunasta.");
         r3.setKuvailu("Janssoninkiusaus (ruots. Janssons frestelse) on ruotsalainen perinneruokalaji, joka pitkään tunnettiin vain yöruokana ja on tullut paljon muunnelluksi. Se tehdään raastamalla karkeasti perunaa, laittamalla sitä vuokaan kerroksittain anjoviksen kanssa ja kaatamalla päälle kermaa.");
         r4.setKuvailu("Nämä paremmat lihapullat ovat saaneet tittelinsä siitä, että makua pyöristämään on käytetty kermaviiliä. Jokainen päättäköön itse kumpi on parempi - kermaviilillä vai ilman. Makoisia ovat!");
         r5.setKuvailu("Hernekeitto on keittoruoka, joka valmistetaan suomalaisittain kuivatuista vihreistä herneistä ja sianlihasta.");
         r6.setKuvailu("Perinteinen purjo-perunasosekeitto on maistuva ja edullinen lounas. Käytä purjo kokonaan, jolloin saat keittoon kauniin vihreän värin. Paistetut perunankuoret tuovat keittoon rapsahtelevaa rakennetta.");
         r7.setKuvailu("Kaalipiirakassa lempeän mehevä kaali piiloutuu taikinakuoren alle.");
         r8.setKuvailu("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
         rKortisto.lisaaResepti(r1);
         rKortisto.lisaaResepti(r2);
         rKortisto.lisaaResepti(r3);
         rKortisto.lisaaResepti(r4);
         rKortisto.lisaaResepti(r5);
         rKortisto.lisaaResepti(r6);
         rKortisto.lisaaResepti(r7);
         rKortisto.lisaaResepti(r8);
        
         //rKortisto.tallesta();
         //ArrayList<Resepti> hakutulos = new ArrayList<>();
         //hakutulos = rKortisto.nimiHaku("laatikko");
         //System.out.println(hakutulos.size());
         //System.out.println(r5.getKuvailu());
         r1.lisaaRaakaAine(new RaakaAine("puuroriisiä", "dl", "1 1/2"));
         r1.lisaaRaakaAine(new RaakaAine("suolaa'", "tl", "1/2"));
         r1.lisaaRaakaAine(new RaakaAine("vettä", "dl", "4"));
         r1.lisaaRaakaAine(new RaakaAine("sipuli", "", "yksi"));
         r1.lisaaRaakaAine(new RaakaAine("keräkaalia", "g", "1000"));
         r1.lisaaRaakaAine(new RaakaAine("sika-nautajauhelihaa", "g", "400"));
         r1.lisaaRaakaAine(new RaakaAine("suolaa", "tl", "1"));
         r1.lisaaRaakaAine(new RaakaAine("mustapippuria", "tl", "1/4"));
         r1.lisaaRaakaAine(new RaakaAine("meiramia", "tl", "1"));
         r1.lisaaRaakaAine(new RaakaAine("ruokaöljyä", "rkl", "1"));
         r1.lisaaRaakaAine(new RaakaAine("siirappia", "rkl", "1"));
         r1.lisaaRaakaAine(new RaakaAine("lihalientä", "dl", "4"));
         r1.lisaaVaihe("Keitä riisi suolalla maustetussa vedessä, kunnes neste on imeytynyt riiseihin.");
         r1.lisaaVaihe("Kuori ja hienonna sipuli, leikkaa kaali suikaleiksi.");
         r1.lisaaVaihe("Paista jauheliha ja sipuli paistokasarissa kypsäksi. Mausta suolalla, pippurilla ja meiramilla ja siirrä lautaselle odottamaan.");
         r1.lisaaVaihe("Kuumenna öljy kasarissa ja lisää kaalisuikaleet. Hauduta kaalia kannen alla 5–10 minuuttia, kunnes se on hieman pehmentynyt. Mausta siirapilla.");
         r1.lisaaVaihe("Sekoita keskenään riisi, jauheliha ja kaalit. Levitä seos uunivuokaan.");
         r1.lisaaVaihe("Kaada päälle lihaliemi ja paista 200-asteisessa uunissa noin tunti. Jos pinta tummuu liikaa paiston aikana, peitä laatikko alumiinifoliolla.");
         r1.lisaaVaihe("Tarjoa kaalilaatikko puolukkasurvoksen kera.");
         System.out.println(rKortisto.tallenna());

         

    }

}
