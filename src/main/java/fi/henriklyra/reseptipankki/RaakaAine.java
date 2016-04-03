
package fi.henriklyra.reseptipankki;

import java.io.Serializable;

/**
 *Tämä luokka toteuttaa reseptissä käytetyn raaka-aineen.
 * @see Resepti
 * @author Henkka
 */
public class RaakaAine implements Serializable {

    private String nimi; //raaka-aineen nimi
    private String mitta; //käytettävä mittayksikkö
    private String maara; //raaka-aineen määrä. Merkkijono mahdollistaa sanalliset kuvailut esim. "hyppysellinen"
    public final int R_AINE_NIMI_PITUUS = 50; //raaka-aineen nimen merkkijonon suurin sallittu pituus
    public final int MITTA_PITUUS = 20; // mittayksikön merkkijonon suurin sallittu pituus
    public final int MAARA_PITUUS = 20; //määrää kuvaavan merkkijonon suurin sallittu pituus
    
    /**
     * Parametritön konstruktori luo raaka-aineen, jonka kentät ovat tyhjiä.
     */
    public RaakaAine() {
        this.nimi = "";
        this.mitta = "";
        this.maara = "";
    }
    
    /**
     * Parametrillinen konstruktori, jolla voi määritellä raaka-aineen kaikki kentät.
     * @param nimi String muotoinen merkkijono, joka kertoo raaka-aineen nimen.
     * @param mitta String muotoinen merkkijono, joka kertoo raaka-aineen kanssa käytetyn mittayksikön.
     * @param maara String muotoinen merkkijono, joka kertoo käytetyn raaka-aineen määrän.
     */

    public RaakaAine(String nimi, String mitta, String maara) {
        if (this.setNimi(nimi))
            this.nimi = nimi;
        else 
            this.nimi = "";
        if (this.setMitta(mitta))
            this.mitta = mitta;
        else
            this.mitta = "";
        if (this.setMaara(maara))
            this.setMaara(maara);
        else
            this.maara = "";
    }
    
    /**
     * Palauttaa raaka-aineen nimen.
     * @return raaka-aineen nimi String merkkijonona 
     */

    public String getNimi() {
        return nimi;
    }
    
    /**
     * Metodi asettaa raaka-aineen nimen.
     * @param nimi String -muotoinen parametri raaka-aineen nimestä.
     * @return palauttaa tiedon (boolean) operaation onnistumisesta.
     */

    public boolean setNimi(String nimi) {
        if (this.R_AINE_NIMI_PITUUS < nimi.length())
            return false;
        this.nimi = nimi;
        return true;
    }
    
    /**
     * Palauttaa raaka-aineen kanssa käytetyn mittayksikön.
     * @return raaka-aineen kanssa käytetty mittayksikkö String merkkijonona 
     */    

    public String getMitta() {
        return mitta;
    }
    
    /**
     * Metodi asettaa raaka-aineen kanssa käytetyn mittayksikön.
     * @param mitta String -muotoinen parametri raaka-aineen kanssa käytetystä mittayksiköstä.
     * @return palauttaa tiedon (boolean) operaation onnistumisesta.
     */    

    public boolean setMitta(String mitta) {
        if (this.MITTA_PITUUS < mitta.length())
            return false;
        this.mitta = mitta;
        return true;
    }
    
    /**
     * Palauttaa raaka-ainetta käytetyn määrän
     * @return raaka-ainetta käytetty määrä String merkkijonona 
     */

    public String getMaara() {
        return maara;
    }

    /**
     * Metodi asettaa raaka-aineen määrän.
     * @param maara String muotoinen parametri raaka-aineen määrästä.
     * @return palauttaa tiedon (boolean) operaation onnistumisesta.
     */    
    
    public boolean setMaara(String maara) {
        if (this.MAARA_PITUUS < maara.length())
            return false;
        this.maara = maara;
        return true;
    }

        /**
     * Palauttaa raaka-aineen tiedot.
     * @return raaka-aineen tiedot String merkkijonona 
     */
    @Override
    public String toString() {
        return "RaakaAine{" + "nimi=" + nimi + ", mitta=" + mitta + ", maara=" + maara + '}';
    }

}
