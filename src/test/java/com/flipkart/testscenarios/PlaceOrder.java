package com.flipkart.testscenarios;

import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.AddToCartPage;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.SearchProductPage;
import com.flipkart.pages.SelectProductPage;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class PlaceOrder extends TestBase {

	@BeforeClass
	public void setUp() {
		launchBrowser();
		navigateToURL();
	}

	@AfterClass
	public void tearDown() {
	}

	@Test(priority = 1)
	public void loginTest() {
		LoginPage loginPage = new LoginPage();
		boolean actResult = loginPage.validateLogin("9940521556", "ramkishoreviki2204");
		Assert.assertTrue(actResult);
	}

	@Test(priority = 2)
	public void searchProductTest() {
		SearchProductPage searchProductPage = new SearchProductPage();
		boolean actResult1 = searchProductPage.validateSearchProduct("dell laptop");
		Assert.assertTrue(actResult1);
	}

	@Test(priority = 3)
	public void selectProductTest() {
		SelectProductPage selectProductPage = new SelectProductPage();
		boolean actResult2 = selectProductPage.validateSelectProduct();
		Assert.assertTrue(actResult2);
	}
	
	@Test(priority = 4)
	public void AddToCartTest() {
		AddToCartPage addToCartPage = new AddToCartPage();
		addToCartPage.validateAddToCart();

}
}
