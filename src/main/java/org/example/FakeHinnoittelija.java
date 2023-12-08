package org.example;

public class FakeHinnoittelija implements IHinnoittelija {
  private float alennus;

  public FakeHinnoittelija(float alennus) {
    this.alennus = alennus;
  }

  public float getAlennusProsentti(Asiakas asiakas, Tuote tuote) {
    return alennus;
  }

  @Override
  public void setAlennusProsentti(Asiakas asiakas, float f) {
    this.alennus = f;
  }

  @Override
  public void aloita() {
    return;
  }

  @Override
  public void lopeta() {
    return;
  }
}
