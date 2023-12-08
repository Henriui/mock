package org.example;

public interface IHinnoittelija {
	public abstract float getAleProsentti(Asiakas asiakas, Tuote tuote);

  public abstract void setAleProsentti(Asiakas asiakas, float f);

  public abstract void aloita();

  public abstract void lopeta();
}
