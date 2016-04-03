/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fi.henriklyra.reseptipankki.RaakaAine;
import fi.henriklyra.reseptipankki.Resepti;
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
    public void konstruktori() {

        assertEquals("", resepti2.getNimi());
    }

    @Test
    public void kuormitettuKonstruktori() {
        assertEquals("lohilaatikko", resepti.getNimi());
    }

    @Test
    public void setteriNimi() {
        assertEquals(resepti.setNimi("makaronilaatikko"), true);
    }

    @Test
    public void setteriPitkaNimi() {
        assertEquals(resepti.setNimi("makaronilaatikkomakaronilaatikkomakaronilaatikkomakaronilaatikko"), false);
    }

    @Test
    public void nimiGetteri() {
        resepti.setNimi("makaronilaatikkomakaronilaatikkomakaronilaatikkomakaronilaatikko");
        assertEquals("lohilaatikko", resepti.getNimi());
    }

    @Test
    public void setterikuvailu() {
        assertEquals(resepti.setKuvailu("Hyvä arkirkiruoka ja helppo tehdä "), true);
    }

    @Test
    public void setteriPitkaKuvailu() {
        assertEquals(resepti.setNimi("Hyvä arkirkiruoka ja helppo tehdä Hyvä arkirkiruoka ja helppo tehdä "
                + "Hyvä arkirkiruoka ja helppo tehdä Hyvä arkirkiruoka ja helppo tehdä Hyvä arkirkiruoka ja helppo tehdä "
                + "Hyvä arkirkiruoka ja helppo tehdä Hyvä arkirkiruoka ja helppo tehdä Hyvä arkirkiruoka ja helppo tehdä "
                + "Hyvä arkirkiruoka ja helppo tehdä Hyvä arkirkiruoka ja helppo tehdä Hyvä arkirkiruoka ja helppo tehdä "
                + "Hyvä arkirkiruoka ja helppo tehdä Hyvä arkirkiruoka ja helppo tehdä "), false);
    }

    @Test
    public void kuvailuGetteri() {
        resepti.setKuvailu("Hyvä arkirkiruoka ja helppo tehdä ");
        assertEquals("Hyvä arkirkiruoka ja helppo tehdä ", resepti.getKuvailu());
    }

    @Test
    public void setteriIndeksiVaihe() {
        resepti.lisaaVaihe("1vaihe");
        assertEquals(resepti.setVaihe(0, "2vaihe"), true);
    }

    @Test
    public void getteriVaihe() {
        resepti.lisaaVaihe("1vaihe");
        assertEquals("1vaihe", resepti.getVaihe(0));
    }

    @Test
    public void lisataanVaihe() {
        assertEquals(resepti.lisaaVaihe("1vaihe"), true);
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
    public void lisataanJavaihdetaanRaine() {
        resepti.lisaaRaakaAine(rAine1);
        resepti.lisaaRaakaAine(rAine2);
        resepti.lisaaRaakaAine(rAine3);
        resepti.setRaakaAine(2, rAine1);
        assertEquals("RaakaAine{nimi=makaroni, mitta=dl, maara=5}", resepti.getRaakaAine(2).toString());
    }

}
