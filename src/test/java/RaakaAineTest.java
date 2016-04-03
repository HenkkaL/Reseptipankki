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
        assertEquals(rAine.setNimi("sopiva nimi"), true);
    }

    @Test
    public void setteriPitkaNimi() {
        assertEquals(rAine.setNimi("liianpitkänimiliianpitkaniminliianpitkänimiliianpitkanimin"), false);
    }

    @Test
    public void getteriNimi() {
        assertEquals(rAine.getNimi(), "makaroni");
    }

    @Test
    public void nimenvaihto() {
        rAine.setNimi("tomaatti");
        rAine.setNimi("liianpitkänimiliianpitkaniminliianpitkänimiliianpitkanimin");
        assertEquals(rAine.getNimi(), "tomaatti");
    }

    @Test
    public void setteriSopivaMitta() {
        assertEquals(rAine.setMitta("sopiva mitta"), true);
    }

    @Test
    public void setteriLiianPitkäMitta() {
        assertEquals(toinenAine.setMitta("liian pitkä mitta liian pitkä mitta"), false);
    }

    @Test
    public void mitanvaihto() {
        rAine.setMitta("teelusikka");
        rAine.setMitta("liian pitkä mitta liian pitkä mitta");
        assertEquals(rAine.getMitta(), "teelusikka");
    }

    @Test
    public void setteriSopivaMaara() {
        assertEquals(rAine.setMaara("sopiva maara"), true);
    }

    @Test
    public void setteriLiianPitkäMaara() {
        assertEquals(toinenAine.setMaara("liian pitkä maara liian pitkä maara"), false);
    }

    @Test
    public void maaranvaihto() {
        rAine.setMaara("9");
        rAine.setMaara("liian pitkä mitta liian pitkä mitta");
        assertEquals(rAine.getMaara(), "9");
    }

}
