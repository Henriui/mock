package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TilausKäsittelyTest {
  @Test
  public void testaaKäsittelijäWithFakeHinnoittelija() {
    // Arrange
    float saldoAlku = 100.0f;
    float Hinta = 30.0f;
    float alennus = 20.0f;
    float saldoLop = saldoAlku - (Hinta * (1 - alennus / 100));
    Asiakas asiakas = new Asiakas(saldoAlku);
    Tuote tuote = new Tuote("Testaus", Hinta);
    IHinnoittelija hinnoittelija = new mockHinnoittelija(alennus);
    // Act
    TilaustenKäsittely käsittelijä = new TilaustenKäsittely();
    käsittelijä.setHinnoittelija(hinnoittelija);
    käsittelijä.käsittele(new Tilaus(asiakas, tuote));
    // Assert
    assertEquals(saldoLop, asiakas.getSaldo(), 0.001);
  }
}
