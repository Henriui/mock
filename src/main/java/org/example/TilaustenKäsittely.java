
package org.example;

public class TilaustenKäsittely {

    private IHinnoittelija hinnoittelija;

    public void setHinnoittelija(IHinnoittelija hinnoittelija) {
        this.hinnoittelija = hinnoittelija;
    }

    public void käsittele(Tilaus tilaus) {
        Asiakas asiakas = tilaus.getAsiakas();
        Tuote tuote = tilaus.getTuote();
        hinnoittelija.aloita();
        float prosentti = hinnoittelija.getAleProsentti(asiakas, tuote);

        if (tuote.getHinta() >= 100) {
            hinnoittelija.setAleProsentti(asiakas, prosentti + 5);
        }

        prosentti = hinnoittelija.getAleProsentti(asiakas, tuote);
        float alennusHinta = tuote.getHinta() * (1 - (prosentti / 100));
        asiakas.setSaldo(asiakas.getSaldo() - alennusHinta);
        hinnoittelija.lopeta();
    }
}
