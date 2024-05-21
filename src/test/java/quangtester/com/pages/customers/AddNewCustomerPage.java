package quangtester.com.pages.customers;

import quangtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class  AddNewCustomerPage {

    private String PAGE_URL = "https://crm.anhtester.com/admin/clients/client";
    private String PAGE_TEXT = "Customer Details";

    public By tabCustomerDetail = By.xpath("//a[@aria-controls='contact_info']");
    public By company = By.xpath("//input[@id='company']");
    public By vat = By.xpath("//input[@id='vat']");
    public By phoneNumber = By.xpath("//input[@id='phonenumber']");
    public By website = By.xpath("//input[@id='website']");
    public By dropdownGroups = By.xpath("//label[@for='groups_in[]']/following-sibling::div");
    public By inputGroups = By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']");
    private By currency = By.xpath("//button[@data-id='default_currency']");
    private By language = By.xpath("//button[@data-id='default_language']");
    private By address = By.xpath("//textarea[@id='address']");
    private By city = By.xpath("//input[@id='city']");
    private By state = By.xpath("//input[@id='state']");
    private By zipcode = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//label[@for='country']/following-sibling::div");
    private By inputCountry = By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']");
    private By buttonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");



    public void selectGroups(String groupName){
        WebUI.clickElement(dropdownGroups);
        WebUI.getWebElement(inputGroups).sendKeys(groupName, Keys.ENTER);
        WebUI.clickElement(dropdownGroups);
    }

    public void AddDataNewCustomer(String CUSTOMER_NAME) {
        WebUI.waitForPageLoaded();

        WebUI.setText(company, CUSTOMER_NAME);
        WebUI.setText(vat, "10");
        WebUI.setText(phoneNumber, "0123456789");
        WebUI.setText(website, "https://anhtester.com");
        selectGroups("Gold");
        WebUI.setText(address, "Vietnam");
        WebUI.setText(city, "Can Tho");
        WebUI.setText(state, "Can Tho");
        WebUI.setText(zipcode, "92000");
        WebUI.clickElement(dropdownCountry);
        WebUI.getWebElement(inputCountry).sendKeys("Vietnam", Keys.ENTER);
        WebUI.clickElement(buttonSave);

        WebUI.waitForPageLoaded();
    }

}
