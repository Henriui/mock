package org.example;

public class mockHinnoittelija implements IHinnoittelija {
  private float alennus;

  public mockHinnoittelija(float alennus) {
    this.alennus = alennus;
  }

  public float getAleProsentti(Asiakas asiakas, Tuote tuote) {
    return alennus;
  }

  @Override
  public void setAleProsentti(Asiakas asiakas, float f) {
    this.alennus = f;
  }

  @Override
  public void aloita() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'aloita'");
  }

  @Override
  public void lopeta() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'lopeta'");
  }
}
