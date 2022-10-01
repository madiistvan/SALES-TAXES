package com.salestax.products;

public abstract class Product {

  /** The name of the product */
  protected String name;

  /** The price without tax */
  protected double priceWithoutTax;

  /** The amount purchased from this product */
  protected int amount;

  /** Calculates the  price after tax for one item. */
  protected Double calculatePriceAfterTax() {
    return 0.0;
  }

  /** Calculates the tax for one item. */
  protected abstract Double calculateTax();

  public Product(String name, Double priceWithoutTax, int amount) {

  }

  /** Calculates the full price after tax for all the items
   * @return the full price after tax
   */
  public double calculateFullPriceAfterTax() {
    return 0.0;
  }

  /** Calculates the total of tax for the amount of items
   * @return the total tax
   */
  public double calculateTotalTax() {
    return 0.0;
  }

  /**
   * Returns the variable:{@link #name}
   * @return The value of the variable.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the variable's {@link #name} value to the given value.
   * @param name The new value
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the variable:{@link #priceWithoutTax}
   * @return The value of the variable.
   */
  public double getPriceWithoutTax() {
    return priceWithoutTax;
  }

  /**
   * Sets the variable's {@link #priceWithoutTax} value to the given value.
   * @param priceWithoutTax The new value
   */
  public void setPriceWithoutTax(Double priceWithoutTax) {
    this.priceWithoutTax = priceWithoutTax;
  }

  /**
   * Returns the variable:{@link #amount}
   * @return The value of the variable.
   */
  public int getAmount() {
    return amount;
  }

  /**
   * Sets the variable's {@link #amount} value to the given value.
   * @param amount The new value
   */
  public void setAmount(int amount) {
    this.amount = amount;
  }
}
