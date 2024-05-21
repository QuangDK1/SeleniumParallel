package quangtester.com.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.keywords.WebUI;

import quangtester.com.pages.customers.AddNewCustomerPage;
import quangtester.com.pages.customers.CustomerDetailPage;
import quangtester.com.pages.customers.CustomersPage;
import quangtester.com.pages.DashboardPage;
import quangtester.com.pages.LoginPage;

public class CustomersTest extends BaseTest {
    //Các thuộc tính xác thực Customers Page
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customers Summary";

    //Objects thuộc Customers Page
    private By headerPageCustomers = By.xpath("(//div[@class='panel-body']//h4)[1]");
    private By buttonAddCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//div[@class='_buttons']//a[normalize-space()='Contacts']");
    private By inputSearch = By.xpath("//div[@id='clients_filter']//input[@type='search']");
    private By tdCustomerName = By.xpath("//tbody/tr[1]/td[3]/a");



    //Các hàm xử lý cho chức năng thuộc Customers Page
    public void verifyCustomersPage() {
        Assert.assertEquals(WebUI.getCurrentUrl(), PAGE_URL, "URL chưa đúng trang Customers.");
        Assert.assertTrue(WebUI.checkElementExist(headerPageCustomers), "Header Page Customers not existing.");
        Assert.assertEquals(WebUI.getTextElement(headerPageCustomers), PAGE_TEXT, "Header Page of Customers page not match.");

    }

    public quangtester.com.pages.customers.AddNewCustomerPage clickNewCustomerButton(){
        WebUI.clickElement(buttonAddCustomer);
        return new AddNewCustomerPage();
    }

    public void searchCustomer(String companyName){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputSearch, companyName);
        WebUI.sleep(2);
    }

    public CustomerDetailPage clickOnFirstRowCustomerName(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(tdCustomerName);

        return new CustomerDetailPage();
    }

}
