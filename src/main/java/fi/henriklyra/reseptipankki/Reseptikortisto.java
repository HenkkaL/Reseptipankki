
package fi.henriklyra.reseptipankki;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Henkka
 */

public class Reseptikortisto {

    private static boolean onkoTallennettu;

    private Scanner lukija = new Scanner(System.in);
    private ArrayList<Resepti> reseptikortisto;
    private ArrayList<Resepti> hakutulos;
    private Resepti uusiResepti;
    
    /**
     * Metodi tallentaa ja sulkee reseptikortisto -tyyppisen tiedoston.
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
     * Metodi tallentaa reseptikortisto -tyyppisen tiedoston.
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
     * Metodi avaa reseptikortisto -tyyppisen tiedoston.
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
     * Metodi hakee reseptejä vertaamalla hakusanaa näiden nimiin.
     * @param hakusana String tyyppinen hakusana.
     * @return Palauttaa listan hakusanan sisältäneistä resepteistä.
     */

    public ArrayList<Resepti> nimiHaku(String hakusana) {
        hakutulos = new ArrayList<>();
          for (Resepti apuri : this.reseptikortisto) {
            if (apuri.getNimi().toLowerCase().matches(".*" + hakusana.toLowerCase() + ".*")) {
                this.hakutulos.add(apuri);               
            }
        }
        return hakutulos;
    }
    
    /**
     * Metodi hakee reseptejä vertaamalla hakusanaa näiden tietoihin.
     * @param hakusana String tyyppinen hakusana.
     * @return Palauttaa listan hakusanan sisältäneistä resepteistä.
     */    

    public ArrayList<Resepti> taysiHaku(String hakusana) {
        
        hakutulos = new ArrayList<>();
            for (Resepti apuri : this.reseptikortisto) {
            if (apuri.toString().toLowerCase().matches(".*" + hakusana.toLowerCase() + ".*")) {
                this.hakutulos.add(apuri);
            }        
        }
        return hakutulos;
    }
    
    /**
     * Metodi lisää reseptikortistoon uuden reseptin.
     * @param reseptinNimi Resepti -tyyppinn muuttuja.
     * @return Palauttaa tiedon operaation onnistumisesta.
     */
    
    public boolean lisaaResepti(String reseptinNimi){
        for (Resepti apuri : this.reseptikortisto) {
            if (apuri.getNimi().equalsIgnoreCase(reseptinNimi))
                return false;
        }            
        this.uusiResepti = new Resepti(reseptinNimi);
        this.reseptikortisto.add(uusiResepti);
        this.jarjesta();
        onkoTallennettu = false;
        return true;        
    }
    
    /**
     * Metodi järjestää reseptikortiston reseptit nimen mukaiseen järjestykseen.
     */
     
    public void jarjesta(){
        Collections.sort(this.reseptikortisto);
    }
    
    /**
     * Metodi poistaa reseptin reseptikortistosta.
     * @param poistettavaResepti Resepti -tyyppinen olio, joka on tarkoitus poistaa 
     * @return Palauttaa tiedon (boolean) operaation onnistumisesta.
     */
    
    public boolean poistaResepti(Resepti poistettavaResepti){
        if  (!this.reseptikortisto.contains(poistettavaResepti))
            return false;
        this.reseptikortisto.remove(poistettavaResepti);
        onkoTallennettu = false;
        return true;
    }
    
    /**
     * Luokkametodi kertoo, onko reseptikortisto tallennettu, sitten viimeisen muokkauksen.
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

}
