/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.henriklyra.reseptipankki;

import java.util.ArrayList;

/**
 *
 * @author Henkka
 */
public class Resepti {

    private String nimi; //reseptin nimi
    private String kuvailu; //reseptin pienimuotoinen kuvailu
    private String vaihe; //yksittäinen valmistusvaihe
    private int nimiPituus = 50; //reseptin nimen maksimipituus
    private int kuvailuPituus = 300; //kuvailuun käytettävän merkkijonon maksimipituus
    private int vaihePituus = 300; //valmistuvaiheen kuvailuun käytettävän merkkijonon maksimipituus
    private ArrayList<RaakaAine> rAineet; //luettelo raaka-aineista
    private ArrayList<String> vaiheet; //luettelo valmistusvaiheista

    public Resepti() {
        this.nimi = "";
        this.kuvailu = "";
        vaiheet = new ArrayList<>();
        rAineet = new ArrayList<>();
    }

    public Resepti(String nimi) {
        if (this.setNimi(nimi)) {
            this.nimi = nimi;
        } else {
            this.nimi = "";
        }
        this.kuvailu = "";
        vaiheet = new ArrayList<>();
        rAineet = new ArrayList<>();
    }

    public String getNimi() {
        return nimi;
    }

    public boolean setNimi(String nimi) {
        if (this.nimiPituus < nimi.length()) {
            return false;
        }
        this.nimi = nimi;
        return true;
    }

    public String getKuvailu() {
        return kuvailu;
    }

    public boolean setKuvailu(String kuvailu) {
        if (this.kuvailuPituus < kuvailu.length()) {
            return false;
        }
        this.kuvailu = kuvailu;
        return true;
    }

    public ArrayList<String> getVaiheet() {
        return vaiheet;
    }

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

    public boolean setVaihe(int i, String vaihe) {
        if (vaihe.length() > vaihePituus) {
            return false;
        }
        this.vaiheet.set(i, vaihe);
        return true;
    }

    public boolean lisaaVaihe(String vaihe) {
        return this.vaiheet.add(vaihe);
    }

    public ArrayList<RaakaAine> getRaakaAineet() {
        return rAineet;
    }

    public void setRaakaAineet(ArrayList<RaakaAine> rAineet) {
        this.rAineet = rAineet;
    }

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

    public boolean lisaaRaakaAine(RaakaAine rAine) {
        return this.rAineet.add(rAine);
    }

    public boolean setRaakaAine(int i, RaakaAine rAine) {
        if (i < 0 || i >= rAineet.size()) {
            return false;
        }
        this.rAineet.set(i, rAine);
        return true;
    }

    @Override
    public String toString() {
        return "Resepti{" + "nimi=" + nimi + ", Vaiheet=" + vaiheet + ", rAineet=" + rAineet + '}';
    }

}
