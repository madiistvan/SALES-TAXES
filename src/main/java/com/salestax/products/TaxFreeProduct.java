package com.salestax.products;

import com.salestax.helper.TaxHelper;

public class TaxFreeProduct extends Product{
  public TaxFreeProduct(String name, Double priceWithoutTax, int amount) {
    super(name, priceWithoutTax, amount);
  }

  /** @see Product#calculateTax() */
  @Override
  protected Double calculateTax() {
    return TaxHelper.TAX_FREE;
  }
}
