package com.salestax.products;

import com.salestax.helper.TaxHelper;

public class ImportedProduct extends Product {
  public ImportedProduct(String name, Double priceWithoutTax, int amount) {
    super(name, priceWithoutTax, amount);
  }

  /** @see Product#calculateTax() */
  @Override
  protected Double calculateTax() {
    return (TaxHelper.BASIC_SALES_TAX + TaxHelper.IMPORT_TAX) / 100 * priceWithoutTax;
  }
}
