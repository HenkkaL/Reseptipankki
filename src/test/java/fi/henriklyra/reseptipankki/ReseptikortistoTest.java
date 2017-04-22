/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.henriklyra.reseptipankki;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henkka
 */
public class ReseptikortistoTest {

    Reseptikortisto rKortisto;
    Resepti r, r1, r2, r3, r4, r5, r6, r7, r8;

    public ReseptikortistoTest() {
    }

    @Before
    public void setUp() {
        rKortisto = new Reseptikortisto();
        r1 = new Resepti("Kaalilaatikko");
        r2 = new Resepti("Lohilaatikko");
        r3 = new Resepti("Janssoninkiusaus");
        r4 = new Resepti("Lihapullat");
        r5 = new Resepti("Hernekeitto");
        r6 = new Resepti("Purjoperunasosekeitto");
        r7 = new Resepti("Kaalipiirakka");
        r8 = new Resepti("testiresepti");

        r1.setKuvailu("Perinteinen kaalilaatikko on kotiruokien ehdoton ykkönen. Tällä supersuositulla reseptillä kaalilaatikosta tulee juuri niin mehevä kuin kuuluukin. Resepti on kopioitu osoitteesta http://www.maku.fi/reseptit/perinteinen-kaalilaatikko");
        r2.setKuvailu("Lohilaatikko valmistuu kätevästi pakasteperunasta.");
        r3.setKuvailu("Janssoninkiusaus (ruots. Janssons frestelse) on ruotsalainen perinneruokalaji, joka pitkään tunnettiin vain yöruokana ja on tullut paljon muunnelluksi. Se tehdään raastamalla karkeasti perunaa, laittamalla sitä vuokaan kerroksittain anjoviksen kanssa ja kaatamalla päälle kermaa.");
        r4.setKuvailu("Nämä paremmat lihapullat ovat saaneet tittelinsä siitä, että makua pyöristämään on käytetty kermaviiliä. Jokainen päättäköön itse kumpi on parempi - kermaviilillä vai ilman. Makoisia ovat!");
        r5.setKuvailu("Hernekeitto on keittoruoka, joka valmistetaan suomalaisittain kuivatuista vihreistä herneistä ja sianlihasta.");
        r6.setKuvailu("Perinteinen purjo-perunasosekeitto on maistuva ja edullinen lounas. Käytä purjo kokonaan, jolloin saat keittoon kauniin vihreän värin. Paistetut perunankuoret tuovat keittoon rapsahtelevaa rakennetta.");
        r7.setKuvailu("Kaalipiirakassa lempeän mehevä kaali piiloutuu taikinakuoren alle.");
        rKortisto.lisaaResepti(r1);
        rKortisto.lisaaResepti(r2);
        rKortisto.lisaaResepti(r3);
        rKortisto.lisaaResepti(r4);
        rKortisto.lisaaResepti(r5);
        rKortisto.lisaaResepti(r6);
        rKortisto.lisaaResepti(r7);
        rKortisto.lisaaResepti(r8);
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
        rKortisto.tallenna();

    }

    @Test
    public void lisataanReseptiOlio() {
        Resepti r = new Resepti();
        assertEquals(true, rKortisto.lisaaResepti(r));
    }

    @Test
    public void lisataanOlemassaolevaReseptiOlio() {
        assertEquals(false, rKortisto.lisaaResepti(r7));
    }

    @Test
    public void lisataanReseptiNimi() {
        assertEquals(true, rKortisto.lisaaResepti("Jauhelihalaatikko"));
    }

    @Test
    public void lisataanNimetönResepti() {
        assertEquals(false, rKortisto.lisaaResepti(""));
    }

    @Test
    public void tallennetaan() {
        assertEquals(true, rKortisto.tallenna());
    }

    @Test
    public void tallennetaanJaSuljetaanSekaAvataan() {
        rKortisto.tallennaJaSulje();
        assertEquals(true, rKortisto.tallesta());
    }

    @Test
    public void tuoReseptiMetodi() {
        assertEquals(r8, rKortisto.tuoResepti(7));
    }

    @Test
    public void tuoReseptiKortistoMetodi() {
        ArrayList<Resepti> testi;
        testi = rKortisto.tuoKortisto();
        assertEquals(8, testi.size());
    }

    @Test
    public void haetaanNimella() {
        ArrayList<Resepti> testi;
        testi = rKortisto.nimiHaku("laAti");
        assertEquals(2, testi.size());
    }

    @Test
    public void taysihakutestiVaihe() {
        ArrayList<Resepti> testi;
        testi = rKortisto.taysiHaku("aistOkaSaris");
        assertEquals(1, testi.size());
    }

    @Test
    public void taysihakutestiKuvailu() {
        ArrayList<Resepti> testi;
        testi = rKortisto.taysiHaku("ittelIN");
        assertEquals(1, testi.size());
    }

    @Test
    public void taysihakutestiRaakaAine() {
        ArrayList<Resepti> testi;
        testi = rKortisto.taysiHaku("dL");
        assertEquals(1, testi.size());
    }

    @Test
    public void poistetaanResepti() {
        Resepti r = new Resepti("Testi");
        rKortisto.lisaaResepti(r);
        rKortisto.poistaResepti(r);
        assertEquals(8, rKortisto.kortistonKoko());
    }

    @Test
    public void poistetaanReseptiPaluuarvoTrue() {
        Resepti r = new Resepti("Testi");
        rKortisto.lisaaResepti(r);
        assertEquals(true, rKortisto.poistaResepti(r));
    }

    @Test
    public void poistetaanReseptiPaluuarvoFalse() {
        Resepti testi = new Resepti();
        assertEquals(false, rKortisto.poistaResepti(testi));
    }

    @Test
    public void poistetaanReseptiTarkastellaanTallennustilaa() {
        Resepti r = new Resepti("Testi");
        rKortisto.lisaaResepti(r);
        rKortisto.tallenna();
        rKortisto.poistaResepti(r);
        assertEquals(false, rKortisto.tallennustila());
    }

}
