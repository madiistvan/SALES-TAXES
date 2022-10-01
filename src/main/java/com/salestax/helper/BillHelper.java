package com.salestax.helper;

import com.salestax.products.Product;

import java.util.List;

public class BillHelper {

  /**
   * @param products the products on the bill
   */
  public BillHelper(List<Product> products) {
    this.products = products;
  }

  /** Products the products on the bill */
  private List<Product> products;

  /** The calculated sales tax */
  private double salesTax = 0;

  /** The calculated total */
  private double total = 0;

  /** Calculates the sales tax */
  public void calculateSalesTax() {
  }

  /** Calculates the total */
  public void calculateTotal() {
  }

  /**
   * Returns the variable:{@link #    return products;}
   * @return The value of the variable.
   */
  public List<Product> getProducts() {
    return products;
  }

  /**
   * Returns the variable:{@link #salesTax}
   * @return The value of the variable.
   */
  public double getSalesTax() {
    return salesTax;
  }

  /**
   * Returns the variable:{@link #total}
   * @return The value of the variable.
   */
  public double getTotal() {
    return total;
  }

}
