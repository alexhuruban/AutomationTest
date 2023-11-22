import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class CheckoutPage extends BasePage {
public WebDriverWait wait;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//a[text()='Food']")
    private WebElement foodMenu;

    @FindBy(css = " .product-info button")
    private WebElement addToCart;

    @FindBy(id = "city")
    private WebElement cityCart;

    @FindBy(id = "postcode")
    private WebElement postCode;

    @FindBy(id = "region_id")
    public WebElement cartRegion;

    @FindBy(id = "clickProceedToCheckout")
    public WebElement proceedToCheckout;

    @FindBy(id = "clickGuest")
    private WebElement selectGuest;

    @FindBy(id = "billing:city")
    private WebElement billingCity;

    @FindBy(id = "billing:address")
    private WebElement billingAddress;

    @FindBy(id = "billing:address2")
    private WebElement billingAddress2;

    @FindBy(id = "billing:firstname")
    public WebElement billingFirstName;

    @FindBy(id = "billing:lastname")
    public WebElement billingLastName;

    @FindBy(id = "billing:company")
    private WebElement billingCompany;

    @FindBy(id = "billing:email")
    private static WebElement billingEmail;

    @FindBy(id = "billing:postcode")
    private WebElement billingPostcode;

    @FindBy(id = "billing:telephone")
    private WebElement billingTelephone;

    @FindBy(css = "method-checkout-cart-methods-onepage-bottom button")
    private WebElement checkoutButton;

    @FindBy(id = "onepage-guest-register-button")
    private WebElement guestRegisterButton;

    @FindBy(id = "billing:region_id")
    public WebElement billingRegion;

    @FindBy(css = "#payment-buttons-container span > span")
    public WebElement paymentButton;

    @FindBy(css = "#shipping-method-buttons-container span > span")
    public WebElement shippingButton;

    @FindBy(css = ".btn-checkout")
    public WebElement btnCheckout;

    @FindBy(css = ".sub-title")
    public WebElement subTitle;

    @FindBy(css = ".product-cart-actions input")
    private WebElement quantity;

    @FindBy(css = ".product-cart-actions button")
    private WebElement updateCartButton;

    @FindBy(id = "advice-required-entry-billing:firstname")
    public WebElement requiredFirstName;

    @FindBy(id = "advice-required-entry-billing:lastname")
    public WebElement requiredLastName;

    @FindBy(id = "advice-required-entry-billing:street1")
    public WebElement requiredAddress;

    @FindBy(id = "advice-required-entry-billing:email")
    public WebElement requiredEmail;

    @FindBy(id = "advice-required-entry-billing:city")
    public WebElement requiredCity;

    @FindBy(id = "advice-required-entry-billing:postcode")
    public WebElement requiredPostCode;

    @FindBy(id = "advice-required-entry-billing:telephone")
    public WebElement requiredTelephone;

    @FindBy(id = "advice-required-entry-billing:region_id")
    public WebElement requiredRegionId;


    public void setBillingEmail() {
        billingEmail.sendKeys("asdf@example.com");
    }

    public void getFoodMenu() {
        foodMenu.click();

    }

    public void clickAddtoCart(){
        foodMenu.click();
    }

    public void setCityCart(){
        cityCart.sendKeys("Alabama");
    }

    public void setPostCode(){
        postCode.sendKeys("12345");
    }

    public void setCartRegion() {
        cartRegion.sendKeys("Alabama");
    }

    public void selectOption (WebElement element, String option) {
        Select optionSelect = new Select (element);
        optionSelect.selectByVisibleText(option);
    }

    public void clickToProceedCheckout(){
        proceedToCheckout.click();
    }

    public void clickGuest(){
        selectGuest.click();
    }

    public void setBillingCity() {
        billingCity.sendKeys("Alabama City");
    }

    public void setFirstName() {
        billingFirstName.sendKeys("Test");

    }

    public void setLastName() {
        billingLastName.sendKeys("Test 2");

    }

    public void setBillingCompany() {
        billingCompany.sendKeys("Test 5");

    }

    public void setBillingAddress() {
        billingAddress.sendKeys("adresa mea");
    }

    public void setBillingAddress2() {
        billingAddress2.sendKeys("adresa mea 2");
    }

    public void setBillingPostCode() {
        billingPostcode.sendKeys("12345");
    }

    public void setBillingTelephone() {
        billingTelephone.sendKeys("0123456789");
    }

    public void checkoutButton() {
        checkoutButton.click();
    }

    public void guestRegisterButton() {
        guestRegisterButton.click();
    }

    public void paymentButton() {
        paymentButton.click();
    }

    public void shippingButton() {
        shippingButton.click();
    }

    public void btnCheckout() {
        btnCheckout.click();
    }

    public void subTitle() { subTitle.click();}

    public void addItemToCart(){
        getFoodMenu();
        clickAddtoCart();
    }

    public void cartInfo(){
        setCityCart();
        setPostCode();
        selectOption(cartRegion, "Alabama");
        clickToProceedCheckout();
        assertEquals("CONTINUE SHOPPING" , subTitle.getText());
    }

    public void fillInMandatoryFields(){
        clickGuest();
        setFirstName();
        setLastName();
        setBillingCompany();
        setBillingAddress();
        setBillingCity();
        setBillingEmail();
        selectOption(billingRegion, "Alabama");
        setBillingPostCode();
        setBillingTelephone();
        setBillingAddress2();
    }

    public void continueButtons(){
        checkoutButton();
        clickWhenReady(shippingButton);
        clickWhenReady(paymentButton);
        clickWhenReady(btnCheckout);

    }

    public void clickWhenReady(WebElement locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void assertTextWhenReady(WebElement locator, String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(locator, expectedText));
        } catch (Exception e){
            System.out.println("Element or text not visible or incorrect");
        }
        assertEquals(expectedText, locator.getText());
    }

    public void checkoutWithUpdatedQuantityTest() {
        quantity.clear();
        quantity.sendKeys("2");
        updateCartButton.click();


    }

    public void fillMandatoryFieldsExcept(WebElement fieldToSkip){
        addItemToCart();
        cartInfo();
        clickGuest();
        fillInMandatoryFields();
        fieldToSkip.clear();
        checkoutButton.click();
    }

//    public void checkIfCheckoutFieldIsMandatory(WebElement locator) throws InterruptedException {
//        addItemToCart();
//        addPreliminaryInfo();
//        click.btn();
//        fillMandatoryFields();
//        locator.clear();
//        clickWhenReady(billingButton);
//        WebElement target = locator.findElement(By.xpath(".//following-sibling::div"));
//        assertWhenReady(target, "This is a required field.");

    public void fillMandatoryFieldsExceptSelect(WebElement fieldToSkip){
        addItemToCart();
        cartInfo();
        clickGuest();
        fillInMandatoryFields();
        selectOption(fieldToSkip , "Please select region, state or province");
        checkoutButton.click();
    }
    }






