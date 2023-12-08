package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TilausKäsittelyTest {
  @Test
  public void testaaFakeHinnoittelija() {
    float alkuSaldo = 100.0f;
    float hinta = 30.0f;
    float alennus = 20.0f;
    float saldo = alkuSaldo - (hinta * (1 - alennus / 100));

    Asiakas asiakas = new Asiakas(alkuSaldo);
    Tuote tuote = new Tuote("Testaus", hinta);
    IHinnoittelija hinnoittelija = new FakeHinnoittelija(alennus);
    TilaustenKäsittely käsittelijä = new TilaustenKäsittely();
    käsittelijä.setHinnoittelija(hinnoittelija);

    käsittelijä.käsittele(new Tilaus(asiakas, tuote));
    assertEquals(saldo, asiakas.getSaldo(), 0.001);
  }
}
