package quangtester.com.testcases;


import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.drivers.DriverManager;
import quangtester.com.pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void loginTestSuccess(){
        loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login("admin@example.com","123456");
    }

    @Test
    public void loginTestInvalidEmail(){
        loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.loginEmailKhongHopLe("admin@example.com123", "123456");
    }

}
