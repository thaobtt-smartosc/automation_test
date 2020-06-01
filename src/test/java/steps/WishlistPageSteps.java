package steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;


import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import data.DataTest;
import data.Product;
import io.qameta.allure.Step;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailPage;
import pages.WishlistPage;
import utility.InitDriver;

public class WishlistPageSteps {
	public LoginPage loginPage;
	public HomePage homePage;
	public ProductDetailPage productDetailPage;
	public WishlistPage wishlistPage;
	Product product1, product2;
	List<Product> listProduct;

	
	public WishlistPageSteps() {
	//	System.out.println("ttttttt");
		loginPage = new LoginPage(InitDriver.getDriver());
		homePage = new HomePage(InitDriver.getDriver());
		productDetailPage = new ProductDetailPage(InitDriver.getDriver());
		wishlistPage = new WishlistPage(InitDriver.getDriver());
		DataTest dataTest = new DataTest();
		product1 = dataTest.getProduct("product1");
		product2 = dataTest.getProduct("product2");
		listProduct = new ArrayList();
		listProduct.add(product1);
		listProduct.add(product2);
	}
	

	@And("clear product in wishlist")
	public void clearAllProductInWishlist() {
		wishlistPage.openWishlist();
		wishlistPage.removeAllProductInWishList();
	}

	@And("add 2 product to wishlist")
	public void addProducts() {
		for (Product product : listProduct) {
			productDetailPage.addProductToWishList(product);
			Assert.assertTrue("Add to wishlist unsucessfully.Plz check!",
					productDetailPage.messageSuccessDisplayWhenAddProductToWishList());
		}
	}

	@And("verify Product info is correct in wishlist page")
	public void verifyProductInfoInWishList() {
		for (Product product : listProduct) {
			Assert.assertTrue("Product " + product.getName() + " is not added to wishlist!",
					wishlistPage.checkProductNameDisplay(product));
			Assert.assertEquals("Price of product " + product.getName() + " is not correct",product.getPrice(), wishlistPage.getSummaryProductPrice(product).replace("\u00A0"," "));
		}
	}

	@Then("verify list product in wishlist")
	public void verifyProductInWishList() {
		addProducts();
		verifyProductInfoInWishList();
	}

}
