package fi.henriklyra.reseptipankki;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Tämä luokka toteuttaa reseptikortiston ja sen hallintaan käytetyt metodit.
 *
 * @see Resepti
 * @author Henkka
 */
public class Reseptikortisto {
    
    /**
     * Luokkammuuttuja, jota käytetään reseptikortiston tallentamattomien
     * muutosten seuraamiseen
     */
    public static boolean onkoTallennettu;
    /**
     * Reseptikortisto on tietorakenne, joka pitää sisällään sovelluksen reseptit
     */
    private ArrayList<Resepti> reseptikortisto;
    private ArrayList<Resepti> hakutulos;
    private Resepti uusiResepti, resepti;
    
    /**
     * Parametritön konstruktori
     */
    public Reseptikortisto() {
        reseptikortisto = new ArrayList<>();
    }

    /**
     * Metodi tallentaa ja sulkee kortiston säilyttävän tiedoston.
     *
     * @return Palauttaa tiedon operaation onnistumisesta.
     */
    public boolean tallennaJaSulje() {
        try {
            FileOutputStream tiedosto = new FileOutputStream("suoritustiedosto");
            ObjectOutputStream oliotiedosto = new ObjectOutputStream(tiedosto);
            oliotiedosto.writeObject(reseptikortisto);
            oliotiedosto.flush();
            tiedosto.close();
            onkoTallennettu = true;
        } catch (Exception e) {
            onkoTallennettu = false;
            return false;            
        }
        return true;
    }

    /**
     * Metodi tallentaa kortiston säilyttävän tiedoston.
     *
     * @return Palauttaa tiedon operaation onnistumisesta.
     */
    public boolean tallenna() {
        try {
            FileOutputStream tiedosto = new FileOutputStream("suoritustiedosto");
            ObjectOutputStream oliotiedosto = new ObjectOutputStream(tiedosto);
            oliotiedosto.writeObject(reseptikortisto);
            oliotiedosto.flush();
            onkoTallennettu = true;
        } catch (Exception e) {
            onkoTallennettu = false;
            return false;
        }
        return true;
    }

    /**
     * Metodi avaa kortiston säilyttävän tiedoston.
     *
     * @return Palauttaa tiedon operaation onnistumisesta.
     */
    public boolean tallesta() {
        try {
            FileInputStream tiedosto = new FileInputStream("suoritustiedosto");
            ObjectInputStream oliotiedosto = new ObjectInputStream(tiedosto);
            reseptikortisto = (ArrayList<Resepti>) oliotiedosto.readObject();
            tiedosto.close();
            onkoTallennettu = true;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    /**
     * Metodilla voidaan hakea reseptikortiston tietyssä indeksissä sijaitseva
     * resepti
     * @param indeksi indeksi, josta resepti haetaan.
     * @return Resepti -olio, joka palautetaan.
     */
    public Resepti tuoResepti(int indeksi){        
        try{
            this.resepti = this.reseptikortisto.get(indeksi);
        } catch (Exception e) {
            System.out.println("Ongelmia !!! " + e);
        }
        return this.resepti;
    }
    
    /**
     * Metodilla palauttaa kutsujalle koko reseptikortiston.
     * @return reseptikortisto, joka on Resepti -olioista koostuva ArrayList.
     */
    public ArrayList<Resepti> tuoKortisto(){
        return this.reseptikortisto;
    }

    /**
     * Metodi hakee reseptejä vertaamalla hakusanaa näiden nimiin.
     *
     * @param hakusana String tyyppinen hakusana.
     * @return Palauttaa listan hakusanan sisältäneistä resepteistä.
     */
    public ArrayList<Resepti> nimiHaku(String hakusana) {
        hakusana.trim();
        hakutulos = new ArrayList<>();
        for (Resepti apuri : this.reseptikortisto) {
            if (apuri.getNimi().toLowerCase().contains(hakusana.toLowerCase())) {
                this.hakutulos.add(apuri);
            }
        }
        return hakutulos;
    }

    /**
     * Metodi hakee reseptejä vertaamalla hakusanaa näiden tietoihin.
     *
     * @param hakusana String tyyppinen hakusana.
     * @return Palauttaa listan hakusanan sisältäneistä resepteistä.
     */
    public ArrayList<Resepti> taysiHaku(String hakusana) {
        hakusana.trim();
        hakutulos = new ArrayList<>();
        for (Resepti apuri : this.reseptikortisto) {
            if (apuri.toString().toLowerCase().contains(hakusana.toLowerCase())) {
                this.hakutulos.add(apuri);
            }
        }
        Collections.sort(hakutulos);
        return hakutulos;
    }

    /**
     * Metodi lisää reseptikortistoon uuden valmiin reseptin.
     *
     * @param resepti Resepti -tyyppinen muuttuja.
     * @return Palauttaa tiedon operaation onnistumisesta.
     */
    public boolean lisaaResepti(Resepti resepti) {

        for (Resepti apuri : this.reseptikortisto) {
            if (apuri.equals(resepti)) {
                return false;
            }
        }
        this.uusiResepti = resepti;
        this.reseptikortisto.add(uusiResepti);
        this.jarjesta();
        onkoTallennettu = false;
        return true;
    } //tämä ehkä pois, tarvitaanko??????*/

    /**
     * Metodi lisää reseptikortistoon uuden tyhjän reseptin.
     *
     * @param reseptinNimi String -tyyppinn muuttuja.
     * @return Palauttaa tiedon operaation onnistumisesta.
     */
    public boolean lisaaResepti(String reseptinNimi) {

        
            if (reseptinNimi.isEmpty())
                return false;
        this.uusiResepti = new Resepti(reseptinNimi);
        this.reseptikortisto.add(uusiResepti);        
        this.tallentamatonMuutos();
        return true;
    }
    

    /**
     * Metodi järjestää reseptikortiston reseptit nimen mukaiseen järjestykseen.
     */
    public void jarjesta() {
        Collections.sort(this.reseptikortisto);
    }

    /**
     * Metodi poistaa reseptin reseptikortistosta.
     *
     * @param poistettavaResepti Resepti -tyyppinen olio, joka on tarkoitus
     * poistaa
     * @return Palauttaa tiedon (boolean) operaation onnistumisesta.
     */
    public boolean poistaResepti(Resepti poistettavaResepti) {
        if (!this.reseptikortisto.contains(poistettavaResepti)) 
            return false;        
        this.reseptikortisto.remove(poistettavaResepti);
        onkoTallennettu = false;
        return true;
    }

    /**
     * Luokkametodi kertoo, onko reseptikortisto tallennettu, sitten viimeisen
     * muokkauksen.
     *
     * @return Palauttaa tiedon (boolean) reseptikortiston tallennustilasta.
     */
    public static boolean tallennustila() {
        return onkoTallennettu;
    }

    /**
     * Luokkametodi muuttaa tallennustilan arvoa.
     */
    public static void tallentamatonMuutos() {
        onkoTallennettu = false;
    }
    
    /**
     * Metodi palauttaa tiedon kortiston koosta.
     * @return kokonaislukuarvo, joka kertoo reseptikortiston sisältämien
     * reseptien määrän
     */
    public int kortistonKoko(){
        return this.reseptikortisto.size();
    }

}
