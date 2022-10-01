package com.salestax.products;

public class TaxedProduct extends Product{

  public TaxedProduct(String name, Double priceWithoutTax, int amount) {
    super(name, priceWithoutTax, amount);
  }

  /** @see Product#calculateTax() */
  @Override
  protected Double calculateTax() {
    return 0.0;
  }
}
