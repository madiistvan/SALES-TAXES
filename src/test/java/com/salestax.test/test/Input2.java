package com.salestax.test.test;

import com.salestax.helper.BillHelper;
import com.salestax.products.ImportedProduct;
import com.salestax.products.ImportedTaxFreeProduct;
import com.salestax.products.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Input2 {
  BillHelper billHelper;
  double delta = 0.0001;

  @Given("{int} imported box of chocolates at {double} {int} imported bottle of perfume at {double}")
  public void importedBoxOfChocolatesAtImportedBottleOfPerfumeAt(
    int amount1, double price1, int amount2, double price2) {
    ArrayList<Product> bill = new ArrayList();
    bill.add(new ImportedTaxFreeProduct("imported box of chocolates",price1,amount1));
    bill.add(new ImportedProduct("imported bottle of perfume",price2,amount2));
    billHelper = new BillHelper(bill);
  }

  @When("the bill is calculated for input 2")
  public void theBillIsCalculated() {
    billHelper.calculateTotal();
    billHelper.calculateSalesTax();
  }

  @Then("{int} imported box of chocolates: {double} {int} imported bottle of perfume: {double} Sales Taxes: {double} Total: {double}")
  public void imported_box_of_chocolates_imported_bottle_of_perfume_sales_taxes_total(
    int amount1, double price1, int amount2, double price2, double salesTax, double total) {
    double[] prices = {price1,price2};
    for (int i = 0; i < billHelper.getProducts().size(); i++) {
      assertEquals(prices[i], billHelper.getProducts().get(i).calculateFullPriceAfterTax(),delta);
    }
    assertEquals(salesTax,billHelper.getSalesTax(), delta);
    assertEquals(total,billHelper.getTotal(), delta);
  }


}
