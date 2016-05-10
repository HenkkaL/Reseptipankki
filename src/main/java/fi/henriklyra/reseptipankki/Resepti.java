package fi.henriklyra.reseptipankki;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Tämä luokka määrittelee Reseptikortiston reseptin.
 *
 * @see Reseptikortisto
 * @see  Raaka-aine
 * @author Henkka
 */
public class Resepti implements Serializable, Comparable<Resepti>, Cloneable {
    /**
     * Reseptin nimi
     */
    private String nimi;
    /**
     * Reseptin pienimuotoinen kuvailu
     */
    private String kuvailu;
    /**
     * Reseptin nimen maksimipituus
     */
    public static final int NIMI_PITUUS = 30;
    /**
     * Kuvailuun käytettävän merkkijonon maksimipituus
     */
    public static final int KUVAILU_PITUUS = 300; 
    /**
     * Valmistuvaiheen kuvailuun käytettävän merkkijonon maksimipituus
     */
    public static final int VAIHE_PITUUS = 300; 
    /**
     * Luettelo raaka-aineista
     */
    private ArrayList<RaakaAine> rAineet;
    /**
     * Luettelo valmistusvaiheista
     */
    private ArrayList<String> vaiheet;


    /**
     * Parametritön konstruktori luo Reseptin, jolla on tyhjät kentät, mutta
     * valmiit listat raaka-aineita ja valmistusvaiheita varten.
     */
    public Resepti() {
        this.nimi = "";
        this.kuvailu = "";
        vaiheet = new ArrayList<>();
        rAineet = new ArrayList<>();
    }

    /**
     * Parametrillinen konstruktori luo Reseptin, jolla on nimi sekä valmiit
     * listat raaka-aineita ja valmistusvaiheita varten.
     *
     * @param nimi String muotoinen merkkijono, jonka maksimipituus on
     * NIMI_PITUUS
     */
    public Resepti(String nimi) {
        try{
            this.setNimi(nimi);
            this.kuvailu = "";
            vaiheet = new ArrayList<>();
            rAineet = new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Ongelmia reseptin luomisessa" + e);
        }      
    }

    /**
     * Metodi palauttaa reseptin nimen.
     *
     * @return Reseptin nimi String merkkijonona.
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * Metodi asettaa reseptin nimen, jolla on tietty sallittu pituus.
     *
     * @param nimi String muotoinen merkkijono, jonka maksimipituus on
     * NIMI_PITUUS
     * @return Palauttaa tiedon (boolean) operaation onnistumisesta.
     */
    public boolean setNimi(String nimi) {
        if (this.NIMI_PITUUS < nimi.length()) {
            return false;
        }
        this.nimi = nimi;
        return true;
    }

    /**
     * Metodi palauttaa reseptin kuvailun.
     *
     * @return Reseptin kuvailu String merkkijonona.
     */
    public String getKuvailu() {
        return kuvailu;
    }

    /**
     * Metodi asettaa reseptin kuvailun, jolla on tietty sallittu pituus.
     *
     * @param kuvailu String muotoinen merkkijono, jonka maksimipituus on
     * KUVAILU_PITUUS
     * @return Palauttaa tiedon (boolean) operaation onnistumisesta.
     */
    public boolean setKuvailu(String kuvailu) {
        if (this.KUVAILU_PITUUS < kuvailu.length()) {
            return false;
        }
        this.kuvailu = kuvailu;
        return true;
    }

    /**
     * Metodi palauttaa ArrayList -tyyppisen listan reseptiin liittyvistä
     * valmistusvaiheista
     *
     * @return ArrayList -tyyppinen lista reseptin valmistusvaiheista
     */
    public ArrayList<String> getVaiheet() {
        return vaiheet;
    }

    /**
     * Metodi palauttaa yhden tietyn (indeksin mukaisen) reseptiin liittyvän
     * tekovaiheen
     *
     * @param i int tyyppinen parametri, joka määrittelee sen indeksin, josta
     * valmistusvaihe haetaan.
     * @return Palauttaa String tyyppisen merkkijonon (reseptin
     * valimstusvaiheen)
     */
    public String getVaihe(int i) {
        try {
            this.vaiheet.get(i);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indeksiongelma");
        } catch (Exception e) {
            System.out.println(e);
        }
        return this.vaiheet.get(i);
    }

    /**
     * Metodi korvaa olemassaolevan valmistusvaiheen
     *
     * @param i int tyyppinen parametri, joka määrittelee sen indeksin, jonka
     * mukainen valmistusvaihe korvataan uudella.
     * @param vaihe String -muotoinen merkkijono, joka kuvailee uuden
     * valmistusvaiheen.
     * @return Palauttaa tiedon (boolean) operaation onnistumisesta.
     */
    public boolean setVaihe(int i, String vaihe) {
        try{
            if (vaihe.length() > VAIHE_PITUUS) 
            return false;
            this.vaiheet.set(i, vaihe);            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indeksiongelmia" + e);
            return false;
        } catch (Exception e) {
            System.out.println("Ongelmia vaiheen muokkaamisessa" + e);
            return false;
        }
        return true;
    }
    

    /**
     * Metodi lisää valmistusvaiheet sisältävään -ArrayListiin uuden
     * valmistusvaiheen
     *
     * @param vaihe String -muotoinen merkkijono, joka kuvailee
     * valmistusvaiheen.
     * @return Palauttaa tiedon (boolean) operaation onnistumisesta.
     */
    public boolean lisaaVaihe(String vaihe) {
        if (vaihe.length() > VAIHE_PITUUS) 
            return false;
        return this.vaiheet.add(vaihe);
    }

    /**
     * Metodi joka palauttaa reseptin raaka-aineet sisältän listan.
     *
     * @return Arraylist tyyppinen lista, joka pitää sisällään 
     * RaakaAine -olioita.
     */
    public ArrayList<RaakaAine> getRaakaAineet() {
        return rAineet;
    }


    /**
     * Metodin avulla voidaan tietty reseptiin kuuluva raaka-aine.
     *
     * @param i int tyyppinen parametri, joka osoittaa indeksin, josta raaka-ain
     * noudetaan.
     * @return Palattaa RaakaAine -tyyppisen muuttujan.
     */
    public RaakaAine getRaakaAine(int i) {
        try {
            this.rAineet.get(i);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indeksiongelma");
        } catch (Exception e) {
            System.out.println(e);
        }
        return this.rAineet.get(i);
    }

    /**
     * Metodi asettaa uuden RaakaAineen olemassaolevan tilalle.
     *
     * @param i integer tyyppinen muuttuja, joka osoittaa sen raaka-aineen joka
     * korvataan uudella.
     * @param rAine RaakaAine -tyyppinen olio, jolla olemassaoleva raaka-aine
     * korvataan.
     */
    public boolean setRaakaAine(int i, RaakaAine rAine) {
        try{
        this.rAineet.set(i, rAine);
                } catch (IndexOutOfBoundsException e) {
            System.out.println("Indeksiongelmia" + e);
            return false;
        } catch (Exception e) {
            System.out.println("Ongelmia raaka-aineen muokkaamisessa" + e);
            return false;
        }
        return true;
    }


    /**
     * Metodi lisää raaka-aineen raaka-ainelistaan.
     *
     * @param rAine RaakaAine tyyppinen olio, joka lisätään raaka-ainelistaan.
     */
    public void lisaaRaakaAine(RaakaAine rAine) {
        this.rAineet.add(rAine);
    }
    
    /**
     * Metodi poistaa reseptistä ne raaka-aineet ja valmistusvaiheet, joiden 
     * merkkijonot (muuttujat) ovat tyhjiä. 
     */
    public void puhdistaResepti(){
        for (int i = this.rAineet.size()-1; i >= 0; i--){
            if (this.rAineet.get(i).getNimi().trim().isEmpty())
                this.rAineet.remove(i);
        }
        for (int i = this.vaiheet.size()-1; i >= 0; i--){
            if (this.vaiheet.get(i).trim().isEmpty())
                this.vaiheet.remove(i);
        }
    }

    /**
     * Metodilla verrataan reseptien järjestystä näiden nimen perusteella¨.
     *
     * @param toinenResepti perametriksi annettava Resepti -tyyppinen muuttuja.
     * @return Int tyyppinen arvo, joka kertoo reseptien järjestyksen.
     */
    public int compareTo(Resepti toinenResepti) {
        return this.nimi.compareToIgnoreCase(toinenResepti.getNimi());
    }
    
    /**
     * Metodi tutkii onko resepti identtinen verrattavan reseptin suhteen
     * @param toinenResepti verratttava Resepti -olio
     * @return Boolean arvo, joka on tosi, jos reseptit ovat identtisiä
     */
    public boolean equals(Resepti toinenResepti){
        return (this.nimi.equals(toinenResepti.getNimi()) && this.kuvailu.equals(toinenResepti.getKuvailu()) 
                && this.rAineet.equals(toinenResepti.getRaakaAineet()) && this.vaiheet.equals(toinenResepti.getVaiheet()));
    }
    
    /**
     * Metodi kopioi reseptin parametriksi annettavan reseptin mukaan
     * @param kopioitava Resepti -olio, josta tehdään kopio
     * @return Boolean arvo, joka on tosi, jos reseptin kopioiminen onnistui
     */
    public boolean kopioi(Resepti kopioitava){
        try{
        this.nimi = kopioitava.getNimi();
        this.kuvailu = kopioitava.getKuvailu();
        this.rAineet = kopioitava.getRaakaAineet();
        this.vaiheet = kopioitava.getVaiheet();
        
        return true;        
        } catch (Exception e) {
            return false;
        }
        
    }
            

    /**
     * Metodi palauttaa reseptin tiedot String -tyyppisenä merkkijonona.
     *
     * @return String tyyppinen merkkijono reseptin tiedoista.
     */
    @Override
    public String toString() {
        
        return nimi + "; Kuvailu: " + kuvailu + "; Vaiheet: " + this.vaiheet + "; Raaka-Aineet: " + this.rAineet;
    }

}
