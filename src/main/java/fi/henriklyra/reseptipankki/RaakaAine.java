/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.henriklyra.reseptipankki;

/**
 *
 * @author Henkka
 */
public class RaakaAine {

    private String nimi; //raaka-aineen nimi
    private String mitta; //käytettävä mittayksikkö
    private String maara; //raaka-aineen määrä. Merkkijono mahdollistaa sanalliset kuvailut esim. "hyppysellinen"
    private int nimiPituus = 50; //raaka-aineen nimen merkkijonon suurin sallittu pituus
    private int mittaPituus = 20; // mittayksikön merkkijonon suurin sallittu pituus
    private int maaraPituus = 20; //määrää kuvaavan merkkijonon suurin sallittu pituus
    
    
    public RaakaAine() {
        this.nimi = "";
        this.mitta = "";
        this.maara = "";        
    }

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

    public String getNimi() {
        return nimi;
    }

    public boolean setNimi(String nimi) {
        if (this.nimiPituus < nimi.length())
            return false;
        this.nimi = nimi;
        return true;
    }

    public String getMitta() {
        return mitta;
    }

    public boolean setMitta(String mitta) {
        if (this.mittaPituus < mitta.length())
            return false;
        this.mitta = mitta;
        return true;
    }

    public String getMaara() {
        return maara;
    }

    public boolean setMaara(String maara) {
        if (this.maaraPituus < maara.length())
            return false;
        this.maara = maara;
        return true;
    }

    @Override
    public String toString() {
        return "RaakaAine{" + "nimi=" + nimi + ", mitta=" + mitta + ", maara=" + maara + '}';
    }

}
