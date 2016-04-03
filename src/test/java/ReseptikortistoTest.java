/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fi.henriklyra.reseptipankki.*;
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

    RaakaAine rAine1, rAine2, rAine3;
    Resepti resepti1, resepti2, resepti3;
    Reseptikortisto rk;

    public ReseptikortistoTest() {
    }

    @Before
    public void setUp() {
        rAine1 = new RaakaAine("makaroni", "dl", "5");
        rAine2 = new RaakaAine("suola", "tl", "151");
        rAine3 = new RaakaAine("lohi", "kg", "0,5");
        resepti1 = new Resepti("Jauhelihalaatikko");
        resepti2 = new Resepti("lohilaatikko");
        resepti3 = new Resepti("kalakeito");
        resepti1.lisaaVaihe("1vaihe");
        resepti2.lisaaVaihe("2vaihe");
        resepti3.lisaaVaihe("3vaihe");
        rk = new Reseptikortisto();
        resepti1.lisaaRaakaAine(rAine1);
        resepti2.lisaaRaakaAine(rAine2);
        resepti3.lisaaRaakaAine(rAine3);
        resepti1.setKuvailu("haettava merkkijono on titityy");
        resepti2.setKuvailu("toisen reseptin kuvailu");

        rk.lisaaResepti(resepti1);
        rk.lisaaResepti(resepti2);
        rk.lisaaResepti(resepti3);

    }

    @Test
    public void lisataanreseptiOlio() {
        Resepti testi = new Resepti("Testi");
        assertEquals(rk.lisaaResepti(testi), true);
    }

    @Test
    public void lisataanreseptiNimi() {
        assertEquals(rk.lisaaTyhjaResepti("testi"), true);
    }

    @Test
    public void tallennetaan() {
        assertEquals(rk.tallenna(), true);
    }

    @Test
    public void tallennetaanJaSuljetaanSekaAvataan() {
        rk.tallennaJaSulje();
        assertEquals(rk.tallesta(), true);
    }

    @Test
    public void haetaanNimella() {
        ArrayList<Resepti> testi;
        testi = rk.nimiHaku("laAti");
        assertEquals(2, testi.size());
    }

    @Test
    public void taysihakutestiVaihe() {
        ArrayList<Resepti> testi;
        testi = rk.taysiHaku("3VAiH");
        assertEquals(1, testi.size());
    }

    @Test
    public void taysihakutestiKuvailu() {
        ArrayList<Resepti> testi;
        testi = rk.taysiHaku("ITITY");
        assertEquals(1, testi.size());
    }

    @Test
    public void taysihakutestiRaakaAine() {
        ArrayList<Resepti> testi;
        testi = rk.taysiHaku("5");
        assertEquals(3, testi.size());
    }

    @Test
    public void poistetaanReseptiTarkastellaanTallennustilaa() {
        rk.poistaResepti(resepti1);
        assertEquals(false, Reseptikortisto.tallennustila());
    }

}
