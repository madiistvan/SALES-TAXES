package com.salestax.test.test;

import com.salestax.helper.BillHelper;
import com.salestax.products.ImportedProduct;
import com.salestax.products.ImportedTaxFreeProduct;
import com.salestax.products.Product;
import com.salestax.products.TaxFreeProduct;
import com.salestax.products.TaxedProduct;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Input3 {
  BillHelper billHelper;
  double delta = 0.0001;

  @Given("{int} imported bottle of perfume at {double} {int} bottle of perfume at {double} {int} packet of headache pills at {double} {int} box of imported chocolates at {double}")
  public void importedBottleOfPerfumeAtBottleOfPerfumeAtPacketOfHeadachePillsAtBoxOfImportedChocolatesAt(
    int amount1, double price1, int amount2, double price2, int amount3, double price3, int amount4, double price4) {
    ArrayList<Product> bill = new ArrayList();
    bill.add(new ImportedProduct("imported bottle of perfume",price1,amount1));
    bill.add(new TaxedProduct("bottle of perfume",price2,amount2));
    bill.add(new TaxFreeProduct("packet of headache",price3,amount3));
    bill.add(new ImportedTaxFreeProduct("box of imported chocolates",price4,amount4));
    billHelper = new BillHelper(bill);
  }

  @When("the bill is calculated for input 3")
  public void theBillIsCalculated() {
    billHelper.calculateTotal();
    billHelper.calculateSalesTax();
  }

  @Then("{int} imported bottle of perfume: {double} {int} bottle of perfume: {double} {int} packet of headache pills: {double} {int} imported box of chocolates: {double} Sales Taxes: {double} Total: {double}")
  public void importedBottleOfPerfumeBottleOfPerfumePacketOfHeadachePillsImportedBoxOfChocolatesSalesTaxesTotal(
    int amount1, double price1, int amount2, double price2, int amount3, double price3, int amount4, double price4, double salesTax, double total) {
    double[] prices = {price1,price2,price3,price4};
    for (int i = 0; i < billHelper.getProducts().size(); i++) {
      assertEquals(prices[i], billHelper.getProducts().get(i).calculateFullPriceAfterTax(),delta);
    }
    assertEquals(salesTax,billHelper.getSalesTax(), delta);
    assertEquals(total,billHelper.getTotal(), delta);
  }
}
