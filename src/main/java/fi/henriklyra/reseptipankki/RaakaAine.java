package fi.henriklyra.reseptipankki;

import java.io.Serializable;

/**
 * Tämä luokka toteuttaa reseptissä käytetyn raaka-aineen.
 *
 * @see Resepti
 * @author Henkka
 */
public class RaakaAine implements Serializable, Cloneable {

    /**
     * Raaka-aineen nimi
     */
    private String nimi;
    /**
     * Raaka-aineen mittayksikkö
     */
    private String mitta;
    /**
     * Raaka-aineen määrä. Merkkijono mahdollistaa sanalliset kuvailut esim.
     * "hyppysellinen"
     */
    private String maara;
    /**
     * Raaka-aineen nimen merkkijonon suurin sallittu pituus
     */
    public static final int R_AINE_NIMI_PITUUS = 30; //raaka-aineen nimen merkkijonon suurin sallittu pituus
    /**
     * Raaka-aineen mittayksikön merkkijonon suurin sallittu pituus
     */
    public static final int MITTA_PITUUS = 20; // mittayksikön merkkijonon suurin sallittu pituus
    /**
     * Raaka-aineen määrän merkkijonon suurin sallittu pituus
     */
    public static final int MAARA_PITUUS = 20; //määrää kuvaavan merkkijonon suurin sallittu pituus

    /**
     * Parametritön konstruktori luo raaka-aineen, jonka kentät ovat tyhjiä
     * merkkijonoja.
     */
    public RaakaAine() {
        this.nimi = "";
        this.mitta = "";
        this.maara = "";
    }

    /**
     * Parametrillinen konstruktori, jolla voi määritellä raaka-aineen kaikki
     * kentät.
     *
     * @param nimi Raaka-aineen nimi.
     * @param mitta Raaka-aineen kanssa käytetty mittayksikkö.
     * @param maara Raaka-aineen määrä.
     */
    public RaakaAine(String nimi, String mitta, String maara) {
        try {
            this.setNimi(nimi);
            this.setMitta(mitta);
            this.setMaara(maara);
        } catch (Exception e) {
            System.out.println("Ongelmia Raaka-aineen luomisessa" + e);
        }
    }

    /**
     * Palauttaa raaka-aineen nimen.
     *
     * @return raaka-aineen nimi String merkkijonona
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * Metodi asettaa raaka-aineen nimen.
     *
     * @param nimi String -muotoinen parametri raaka-aineen nimestä.
     * @return palauttaa tiedon (boolean) operaation onnistumisesta.
     */
    public boolean setNimi(String nimi) {
        if (this.R_AINE_NIMI_PITUUS < nimi.length()) {
            return false;
        }
        this.nimi = nimi;
        return true;
    }

    /**
     * Palauttaa raaka-aineen kanssa käytetyn mittayksikön.
     *
     * @return raaka-aineen kanssa käytetty mittayksikkö String merkkijonona
     */
    public String getMitta() {
        return mitta;
    }

    /**
     * Metodi asettaa raaka-aineen kanssa käytetyn mittayksikön.
     *
     * @param mitta String -muotoinen parametri raaka-aineen kanssa käytetystä
     * mittayksiköstä.
     * @return palauttaa tiedon (boolean) operaation onnistumisesta.
     */
    public boolean setMitta(String mitta) {
        if (this.MITTA_PITUUS < mitta.length()) {
            return false;
        }
        this.mitta = mitta;
        return true;
    }

    /**
     * Palauttaa raaka-ainetta käytetyn määrän
     *
     * @return raaka-ainetta käytetty määrä String merkkijonona
     */
    public String getMaara() {
        return maara;
    }

    /**
     * Metodi asettaa raaka-aineen määrän.
     *
     * @param maara String muotoinen parametri raaka-aineen määrästä.
     * @return palauttaa tiedon (boolean) operaation onnistumisesta.
     */
    public boolean setMaara(String maara) {
        if (this.MAARA_PITUUS < maara.length()) {
            return false;
        }
        this.maara = maara;
        return true;
    }

    /**
     * Metodi tutkii onko raaka-aine identtinen verrattavan raaka-aineen suhteen
     *
     * @param toinenRA verrattava raaka-aine (RaakaAine)
     * @return Boolean arvo, joka on tosi, jos raaka-aineet ovat identtisiä
     */
    public boolean equals(RaakaAine toinenRA) {
        return (this.nimi.equals(toinenRA.getNimi()) && this.mitta.equals(toinenRA.getMitta())
                && this.maara.equals(toinenRA.getMaara()));
    }

    /**
     * Palauttaa raaka-aineen tiedot yhtenä merkkijonona.
     *
     * @return raaka-aineen tiedot String merkkijonona
     */
    @Override
    public String toString() {
        return "RaakaAine{" + "nimi=" + nimi + ", mitta=" + mitta + ", maara=" + maara + '}';
    }

}
