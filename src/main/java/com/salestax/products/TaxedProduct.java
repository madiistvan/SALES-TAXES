package com.salestax.products;

import com.salestax.helper.TaxHelper;

public class TaxedProduct extends Product{

  public TaxedProduct(String name, Double priceWithoutTax, int amount) {
    super(name, priceWithoutTax, amount);
  }

  /** @see Product#calculateTax() */
  @Override
  protected Double calculateTax() {
    return (TaxHelper.BASIC_SALES_TAX) / 100 * priceWithoutTax;
  }
}
