package com.salestax.products;


public class TaxFreeProduct extends Product{
  public TaxFreeProduct(String name, Double priceWithoutTax, int amount) {
    super(name, priceWithoutTax, amount);
  }

  /** @see Product#calculateTax() */
  @Override
  protected Double calculateTax() {
    return 0.0;
  }
}
