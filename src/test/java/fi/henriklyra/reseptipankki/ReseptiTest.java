/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.henriklyra.reseptipankki;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Henkka
 */
public class ReseptiTest {

    RaakaAine rAine1, rAine2, rAine3;
    Resepti resepti, resepti2;

    @Before
    public void setUp() {
        rAine1 = new RaakaAine("makaroni", "dl", "5");
        rAine2 = new RaakaAine("suola", "tl", "1");
        rAine3 = new RaakaAine("lohi", "kg", "0,5");
        resepti2 = new Resepti();
        resepti = new Resepti("lohilaatikko");
    }

    @Test
    public void konstruktoriNimi() {
        assertEquals("", resepti2.getNimi());
    }

    @Test
    public void konstruktoriKuvailu() {
        assertEquals("", resepti2.getKuvailu());
    }

    @Test
    public void konstruktoriRaakaAineet() {
        assertEquals(0, resepti2.getRaakaAineet().size());
    }

    @Test
    public void konstruktoriVaiheet() {
        assertEquals(0, resepti2.getVaiheet().size());
    }

    @Test
    public void kuormitettuKonstruktori() {
        assertEquals("lohilaatikko", resepti.getNimi());
    }

    @Test
    public void kuormitettuKonstruktoriKuvailu() {
        assertEquals("", resepti.getKuvailu());
    }

    @Test
    public void kuormitettuKonstruktoriRaakaAineet() {
        assertEquals(0, resepti.getRaakaAineet().size());
    }

    @Test
    public void kuormitettuKonstruktoriVaiheet() {
        assertEquals(0, resepti.getVaiheet().size());
    }

    @Test
    public void setteriNimi() {
        assertEquals(true, resepti.setNimi("makaronilaatikko"));
    }

    @Test
    public void setteriPitkaNimi() {
        String apuri = "";
        for (int i = 0; i <= Resepti.NIMI_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals(false, resepti.setNimi(apuri));
    }

    @Test
    public void setteriRajaArvoNimi() {
        String apuri = "";
        for (int i = 0; i < Resepti.NIMI_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals(true, resepti.setNimi(apuri));
    }

    @Test
    public void nimiGetteri() {
        String apuri = "";
        for (int i = 0; i <= Resepti.NIMI_PITUUS; i++) {
            apuri = apuri + "a";
        }
        resepti.setNimi(apuri);
        assertEquals("lohilaatikko", resepti.getNimi());
    }

    @Test
    public void setterikuvailu() {
        assertEquals(true, resepti.setKuvailu("Hyvä arkirkiruoka ja helppo tehdä "));
    }

    @Test
    public void setteriPitkaKuvailu() {
        String apuri = "";
        for (int i = 0; i <= Resepti.KUVAILU_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals(false, resepti.setKuvailu(apuri));
    }

    @Test
    public void setteriRajaArvoKuvailu() {
        String apuri = "";
        for (int i = 0; i < Resepti.KUVAILU_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals(true, resepti.setKuvailu(apuri));
    }

    @Test
    public void kuvailuGetteri() {
        resepti.setKuvailu("Hyvä arkirkiruoka ja helppo tehdä ");
        assertEquals("Hyvä arkirkiruoka ja helppo tehdä ", resepti.getKuvailu());
    }

    @Test
    public void setteriIndeksiVaihe() {
        resepti.lisaaVaihe("1vaihe");
        assertEquals(true, resepti.setVaihe(0, "2vaihe"));
    }

    @Test
    public void getteriVaihe() {
        resepti.lisaaVaihe("1vaihe");
        assertEquals("1vaihe", resepti.getVaihe(0));
    }

    @Test
    public void setteriPitkaVaihe() {
        resepti.lisaaVaihe("1vaihe");
        String apuri = "";
        for (int i = 0; i <= Resepti.VAIHE_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals(false, resepti.setVaihe(0, apuri));
    }

    @Test
    public void setteriRajaArvoVaihe() {
        resepti.lisaaVaihe("1vaihe");
        String apuri = "";
        for (int i = 0; i < Resepti.VAIHE_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals(true, resepti.setVaihe(0, apuri));
    }

    @Test
    public void lisataanPitkaVaihe() {
        resepti.lisaaVaihe("1vaihe");
        String apuri = "";
        for (int i = 0; i <= Resepti.VAIHE_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals(false, resepti.lisaaVaihe(apuri));
    }

    @Test
    public void lisataaRajaArvoVaihe() {
        resepti.lisaaVaihe("1vaihe");
        String apuri = "";
        for (int i = 0; i < Resepti.VAIHE_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals(true, resepti.lisaaVaihe(apuri));
    }

    @Test
    public void haetaanvaiheet() {
        resepti.lisaaVaihe("1vaihe");
        resepti.lisaaVaihe("2vaihe");
        resepti.lisaaVaihe("3vaihe");

        assertEquals(3, resepti.getVaiheet().size());
    }

    @Test
    public void lisataanJaVaihdetaanVaihe() {
        resepti.lisaaVaihe("1vaihe");
        resepti.lisaaVaihe("2vaihe");
        resepti.lisaaVaihe("3vaihe");
        resepti.setVaihe(2, "muokattu vaihe");
        assertEquals("muokattu vaihe", resepti.getVaihe(2));
    }

    @Test
    public void vaihdetaanVaiheYliIndeksin() {
        resepti.lisaaVaihe("1vaihe");
        resepti.lisaaVaihe("2vaihe");
        resepti.lisaaVaihe("3vaihe");
        assertEquals(false, resepti.setVaihe(3, "muokattu vaihe"));
    }

    @Test
    public void vaihdetaanVaiheAliIndeksin() {
        resepti.lisaaVaihe("1vaihe");
        resepti.lisaaVaihe("2vaihe");
        resepti.lisaaVaihe("3vaihe");
        assertEquals(false, resepti.setVaihe(-1, "muokattu vaihe"));
    }

    @Test
    public void lisataanJavaihdetaanRaine() {
        resepti.lisaaRaakaAine(rAine1);
        resepti.lisaaRaakaAine(rAine2);
        resepti.lisaaRaakaAine(rAine3);
        resepti.setRaakaAine(2, rAine1);
        assertEquals("RaakaAine{nimi=makaroni, mitta=dl, maara=5}", resepti.getRaakaAine(2).toString());
    }

    @Test
    public void testataanRAineetYliIndeksin() {
        resepti.lisaaRaakaAine(rAine1);
        resepti.lisaaRaakaAine(rAine2);
        resepti.lisaaRaakaAine(rAine3);
        assertEquals(false, resepti.setRaakaAine(3, rAine1));
    }

    @Test
    public void testataanRAineetAliIndeksin() {
        resepti.lisaaRaakaAine(rAine1);
        resepti.lisaaRaakaAine(rAine2);
        resepti.lisaaRaakaAine(rAine3);
        assertEquals(false, resepti.setRaakaAine(-1, rAine1));
    }

    @Test
    public void kopioidaanResepti() {
        Resepti r = new Resepti();
        r.kopioi(resepti);
        assertEquals(true, resepti.equals(r));
    }

    @Test
    public void verrataanSamannimisiaResepteja() {
        Resepti r1 = new Resepti("Testi");
        Resepti r2 = new Resepti("Testi");
        assertEquals(true, r1.equals(r2));
    }

    @Test
    public void verrataanErinimisiaResepteja() {
        Resepti r1 = new Resepti("Testi");
        Resepti r2 = new Resepti("Tesi");
        assertEquals(false, r1.equals(r2));
    }

    @Test
    public void verrataanKuvailuja() {
        resepti.kopioi(resepti2);
        resepti.setKuvailu("testi");
        assertEquals(false, resepti.equals(resepti2));
    }

    @Test
    public void verrataanEriraakaAineita() {
        resepti.kopioi(resepti2);
        resepti.lisaaRaakaAine(new RaakaAine("testi", "testi", "testi"));
        assertEquals(false, resepti.equals(resepti2));
    }

    @Test
    public void kopioidaanRaakaAineet() {
        resepti.kopioi(resepti2);
        resepti.lisaaRaakaAine(new RaakaAine("testi", "testi", "testi"));
        resepti.lisaaRaakaAine(new RaakaAine("testi1", "testi1", "testi1"));
        resepti2.kopioi(resepti);
        assertEquals(2, resepti2.getRaakaAineet().size());
    }

    @Test
    public void kopioidaanvalmistusvaiheet() {
        resepti.kopioi(resepti2);
        resepti.lisaaVaihe("testi");
        resepti.lisaaVaihe("testi1");
        resepti2.kopioi(resepti);
        assertEquals(2, resepti2.getVaiheet().size());
    }

    @Test
    public void verrataanValmistusvaiheita() {
        resepti.kopioi(resepti2);
        resepti.lisaaVaihe("testi");
        assertEquals(false, resepti.equals(resepti2));
    }

    @Test
    public void testataanToString() {
        Resepti r = new Resepti();
        r.setNimi("testiresepti");
        r.setKuvailu("testikuvailu");
        r.lisaaRaakaAine(new RaakaAine("jauhoja", "dl", "1"));
        r.lisaaVaihe("testivaihe");
        assertEquals("testiresepti; Kuvailu: testikuvailu; Vaiheet: [testivaihe]; Raaka-Aineet: [RaakaAine{nimi=jauhoja, mitta=dl, maara=1}]", r.toString());
    }
}
