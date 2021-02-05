//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//
//
//public class TestSuiteDesireCapabilities extends BaseTest {
//    static WebDriver driver;
//    static InventoryPage invPage;
//    static CartPage cartPage;
//    static CheckoutPage checkoutPage;
//    static CheckoutStepTwoPage checkoutStepTwoPage;
//
//    @Before
//    public void loginToPage() {
//        driver = loginToBasePage();
//        LoginPage lgPage = new LoginPage(driver);
//        lgPage.enterUsername("standard_user")
//                .enterPassword("secret_sauce")
//                .submitLogin();
//        invPage = new InventoryPage(driver);
//        cartPage = new CartPage(driver);
//        checkoutPage = new CheckoutPage(driver);
//        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
//    }
//
//    @After
//    public void cleanUp() {
//        driver.close();
//    }
//
//    @Test
//    public void loginToPageAndAddToCart() {
//
//        // Add two products to cart
//        invPage.addToCart(Products.SAUCELABSBACKPACK.toString())
//               .addToCart(Products.SAUCELABSONESIE.toString());
//
//        // Go to Cart page
//        invPage.goToCart();
//
////        // Click options on left corner
////        invPage.clickOptions();
////        // Choose All About from options
////        invPage.chooseOptions("inventory");
//
//        // Remove one product from Cart
//        cartPage.removeProducts(Products.SAUCELABSBIKELIGHT.toString());
//
//        // Go to Checkout Page
//        checkoutPage.enterFirstName("Greg")
//                    .enterLastName("greg")
//                    .enterPostalCode("10102")
//                    .fillForm();
//
//        // Submit form on Checkout Step Two Page
//
//        checkoutStepTwoPage.submitForm();
//        Assert.assertTrue(checkoutStepTwoPage.completeOrder.getText().equals("THANK YOU FOR YOUR ORDER"));
//
//    }
//}
