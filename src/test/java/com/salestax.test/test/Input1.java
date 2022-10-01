package com.salestax.test.test;

import com.salestax.helper.BillHelper;
import com.salestax.products.Product;
import com.salestax.products.TaxFreeProduct;
import com.salestax.products.TaxedProduct;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Input1 {
  BillHelper billHelper;
  double delta = 0.0001;

  @Given("{int} book at {double}, {int} music CD at {double}, {int} chocolate bar at {double}")
  public void book_at_music_cd_at_chocolate_bar_at(
    int amount1, double price1, int amount2, double price2, int amount3, double price3) {
    ArrayList<Product> bill = new ArrayList();
    bill.add(new TaxFreeProduct("book", price1, amount1));
    bill.add(new TaxedProduct("music CD", price2, amount2));
    bill.add(new TaxFreeProduct("chocolate", price3, amount3));
    billHelper = new BillHelper(bill);
  }

  @When("the bill is calculated for input 1")
  public void theBillIsCalculated() {
    billHelper.calculateTotal();
    billHelper.calculateSalesTax();
  }

  @Then("{int} book: {double} {int} music CD: {double} {int} chocolate bar: {double} Sales Taxes: {double} Total: {double}")
  public void book_music_cd_chocolate_bar_sales_taxes_total(
    int amount1, double price1, int amount2, double price2, int amount3, double price3, double salesTax, double total) {
    double[] prices = {price1, price2, price3};
    for (int i = 0; i < billHelper.getProducts().size(); i++) {
      assertEquals(prices[i], billHelper.getProducts().get(i).calculateFullPriceAfterTax(), delta);
    }
    assertEquals(salesTax, billHelper.getSalesTax(), delta);
    assertEquals(total, billHelper.getTotal(), delta);
  }
}
