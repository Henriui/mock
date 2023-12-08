package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.Mockito.*;

public class TilausKäsittelyMockitoTest {
  @Mock
  IHinnoittelija hinnoittelijaMock;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @ParameterizedTest
  @CsvSource({
      "100.0, 30.0, 20.0",
      "150.0, 130.0, 42.0",
      "80.0, 500.0, 100.0",
      "100.0, 100.0, 100.0",
  })
  public void testaaMockitoHinnoittelija(float alkuSaldo, float hinta, float alennus) {
    // Arrange

    float saldo = alkuSaldo - (hinta * (1 - alennus / 100));

    Asiakas asiakas = new Asiakas(alkuSaldo);
    Tuote tuote = new Tuote("Testaus", hinta);

    when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote))
        .thenReturn(alennus);

    doNothing().when(hinnoittelijaMock).setAlennusProsentti(asiakas, alennus + 5);

    TilaustenKäsittely käsittelijä = new TilaustenKäsittely();
    käsittelijä.setHinnoittelija(hinnoittelijaMock);
    käsittelijä.käsittele(new Tilaus(asiakas, tuote));

    assertEquals(saldo, asiakas.getSaldo(), 0.001);
    verify(hinnoittelijaMock, times(2)).getAlennusProsentti(asiakas, tuote);
    if (tuote.getHinta() >= 100.0) {
      verify(hinnoittelijaMock, times(1)).setAlennusProsentti(asiakas, alennus + 5);
    } else {
      verify(hinnoittelijaMock, times(0)).setAlennusProsentti(any(Asiakas.class), anyFloat());
    }
  }
}