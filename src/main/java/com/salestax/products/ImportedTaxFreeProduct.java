package com.salestax.products;

import com.salestax.helper.TaxHelper;

public class ImportedTaxFreeProduct extends Product{
  public ImportedTaxFreeProduct(String name, Double priceWithoutTax, int amount) {
    super(name, priceWithoutTax, amount);
  }

  /** @see Product#calculateTax() */
  @Override
  protected Double calculateTax() {
    return (TaxHelper.IMPORT_TAX/ 100 * priceWithoutTax );
  }
}
