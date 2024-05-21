package quangtester.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private String URl = "https://crm.anhtester.com/admin/authentication";
    private String PAGETEXT = "Login";


    By headerPage = By.xpath("//h1");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By messageErrorEmail = By.xpath("//div[@class='text-center alert alert-danger']");



    //Hàm xây dựng để truyền vào drive
    private WebDriver driver;

    public LoginPage (WebDriver _driver){
        driver = _driver;
    }


    //Các hàm xử lý trang login
    public  void  verifyHeaderPage(){
        Assert.assertEquals(driver.findElement(headerPage).getText(),"Login","Fail HeaderPage");
    }
    public void enterEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
    }
    public void enterPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }
    public void ClickOnButtonLogin(){
        driver.findElement(buttonLogin).click();
    }
    public void verifyErrorMessage(){
        Assert.assertTrue(driver.findElement(messageErrorEmail).isDisplayed(),"Fail. Error message no displays.");
        Assert.assertEquals(driver.findElement(messageErrorEmail).getText(),"Invalid email or password","content of the error message not match.");
    }
    public DashboardPage login(String email , String password){
        driver.get(URl);
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        ClickOnButtonLogin();

        return new DashboardPage();
    }
    public void loginEmailKhongHopLe(String email , String password){
        driver.get(URl);
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        ClickOnButtonLogin();
        //Kiểm tra massega thông báo lỗi
        verifyErrorMessage();

    }
}
