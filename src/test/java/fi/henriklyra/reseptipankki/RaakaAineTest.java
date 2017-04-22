/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.henriklyra.reseptipankki;

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
public class RaakaAineTest {

    RaakaAine rAine;
    RaakaAine toinenAine;

    @Before
    public void setUp() {
        rAine = new RaakaAine("makaroni", "teelusikka", "5");
        toinenAine = new RaakaAine();
    }

    @Test
    public void konstruktori() {
        assertEquals("RaakaAine{nimi=, mitta=, maara=}", toinenAine.toString());
    }

    @Test
    public void kuormitettuKonstruktori() {
        assertEquals("RaakaAine{nimi=makaroni, mitta=teelusikka, maara=5}", rAine.toString());
    }

    @Test
    public void setteriSopivaNimi() {
        assertEquals(true, rAine.setNimi("sopiva nimi"));
    }

    @Test
    public void setteriPitkaNimi() {
        String apuri = "";
        for (int i = 0; i <= RaakaAine.R_AINE_NIMI_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals(false, rAine.setNimi(apuri));
    }

    @Test
    public void setteriRajaArvoNimi() {
        String apuri = "";
        for (int i = 0; i < RaakaAine.R_AINE_NIMI_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals(true, rAine.setNimi(apuri));
    }

    @Test
    public void getteriNimi() {
        assertEquals("makaroni", rAine.getNimi());
    }

    @Test
    public void nimenvaihto() {
        rAine.setNimi("tomaatti");
        String apuri = "";
        for (int i = 0; i <= RaakaAine.R_AINE_NIMI_PITUUS; i++) {
            apuri = apuri + "a";
        }
        rAine.setNimi(apuri);
        assertEquals("tomaatti", rAine.getNimi());
    }

    @Test
    public void setteriSopivaMitta() {
        assertEquals(true, rAine.setMitta("sopiva mitta"));
    }

    @Test
    public void setteriPitkaMitta() {
        String apuri = "";
        for (int i = 0; i <= RaakaAine.MITTA_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals(false, rAine.setMitta(apuri));
    }

    @Test
    public void setteriRajaArvoMitta() {
        String apuri = "";
        for (int i = 0; i < RaakaAine.MITTA_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals(true, rAine.setMitta(apuri));
    }

    @Test
    public void mitanvaihto() {
        rAine.setMitta("teelusikka");
        String apuri = "";
        for (int i = 0; i <= RaakaAine.MITTA_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals("teelusikka", rAine.getMitta());
    }

    @Test
    public void setteriSopivaMaara() {
        assertEquals(true, rAine.setMaara("sopiva maara"));
    }

    @Test
    public void setteriPitkamaara() {
        String apuri = "";
        for (int i = 0; i <= RaakaAine.MAARA_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals(false, rAine.setMaara(apuri));
    }

    @Test
    public void setteriRajaArvoMaara() {
        String apuri = "";
        for (int i = 0; i < RaakaAine.MAARA_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals(true, rAine.setMaara(apuri));
    }

    @Test
    public void maaranvaihto() {
        rAine.setMaara("9");
        String apuri = "";
        for (int i = 0; i <= RaakaAine.MAARA_PITUUS; i++) {
            apuri = apuri + "a";
        }
        assertEquals("9", rAine.getMaara());
    }

    @Test
    public void raakaAineEqualsToimii() {
        RaakaAine r1 = new RaakaAine();
        RaakaAine r2 = new RaakaAine();
        r1.setNimi("Nimi");
        r1.setMitta("mitta");
        r1.setMaara("määrä");
        r2.setNimi("Nimi");
        r2.setMitta("mitta");
        r2.setMaara("määrä");
        assertEquals(true, r1.equals(r2));
    }

    @Test
    public void raakaAineEqualsNimiEiToimi() {
        RaakaAine r1 = new RaakaAine();
        RaakaAine r2 = new RaakaAine();
        r1.setNimi("testi");
        r1.setMitta("mitta");
        r1.setMaara("määrä");
        r2.setNimi("Nimi");
        r2.setMitta("mitta");
        r2.setMaara("määrä");
        assertEquals(false, r1.equals(r2));
    }

    @Test
    public void raakaAineEqualsMittaEiToimi() {
        RaakaAine r1 = new RaakaAine();
        RaakaAine r2 = new RaakaAine();
        r1.setNimi("Nimi");
        r1.setMitta("testi");
        r1.setMaara("määrä");
        r2.setNimi("Nimi");
        r2.setMitta("mitta");
        r2.setMaara("määrä");
        assertEquals(false, r1.equals(r2));
    }

    @Test
    public void raakaAineEqualsMaaraToimi() {
        RaakaAine r1 = new RaakaAine();
        RaakaAine r2 = new RaakaAine();
        r1.setNimi("Nimi");
        r1.setMitta("mitta");
        r1.setMaara("testi");
        r2.setNimi("Nimi");
        r2.setMitta("mitta");
        r2.setMaara("määrä");
        assertEquals(false, r1.equals(r2));
    }

}
