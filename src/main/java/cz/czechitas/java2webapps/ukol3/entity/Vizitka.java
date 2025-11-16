package cz.czechitas.java2webapps.ukol3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
public class Vizitka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 100)
    @NotBlank
    private String jmeno;
    @Length(max = 100)
    @NotBlank
    private String prijmeni;
    @Length(max = 100)
    @NotBlank
    private String firma;
    @Length(max = 100)
    private String ulice;
    @Length(max = 100)
    private String obec;
    @Length(max = 5)
    @Pattern(regexp = "\\d{5}")
    private String psc;
    @Length(max = 100)
    @Email
    private String email;
    @Length(min = 9, max = 13)
    @Pattern(regexp = "\\+?\\d+")
    private String telefon;
    @Length(max = 100)
    private String web;

    public Vizitka() {
    }

    public Vizitka(String jmeno, String prijmeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
    }

    public Vizitka(String jmeno, String prijmeni, String firma, String ulice, String obec, String psc, String email, String telefon, String web) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.firma = firma;
        this.ulice = ulice;
        this.obec = obec;
        this.psc = psc;
        this.email = email;
        this.telefon = telefon;
        this.web = web;
    }

    public String getCelaAdresa() {
        if (ulice == null) {
            return obec;
        }
        return ulice + ", " + obec;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getObec() {
        return obec;
    }

    public void setObec(String obec) {
        this.obec = obec;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
