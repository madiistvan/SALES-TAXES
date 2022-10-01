package com.salestax.helper;

import com.salestax.products.Product;

import java.util.ArrayList;
import java.util.List;

public class BillHelper {

  /**
   * @param products the products on the bill
   */
  public BillHelper(ArrayList<Product> products) {
    this.products = products;
  }

  /** Products the products on the bill */
  private ArrayList<Product> products;

  /** The calculated sales tax */
  private double salesTax = 0;

  /** The calculated total */
  private double total = 0;

  /** Calculates the sales tax */
  public void calculateSalesTax() {
    salesTax = products.stream().map(Product::calculateTotalTax).reduce(0.0, Double::sum);
  }

  /** Calculates the total */
  public void calculateTotal() {
    total = products.stream().map(Product::calculateFullPriceAfterTax).reduce(0.0, Double::sum);

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
