import io.qameta.allure.junit4.DisplayName;
import page.HomePage;
import com.codeborne.selenide.Selenide;
import constant.Constants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends Constants {

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }

    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    @Test
    public void loginButtonMainPageTest(){
        String actual = new HomePage(URL)
                .clickOnLoginButtonMainPage()
                .loginUser()
                .getEmailProfile();
        Assert.assertEquals(TEST_EMAIL, actual);
    }

    @DisplayName("вход через кнопку «Личный кабинет»")
    @Test
    public void loginPersonalAccountButtonTest(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .loginUser()
                .getEmailProfile();
        Assert.assertEquals(TEST_EMAIL, actual);
    }

    @DisplayName("вход через кнопку в форме регистрации")
    @Test
    public void loginRegistrationLinkTest(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .clickLoginLink()
                .loginUser()
                .getEmailProfile();
        Assert.assertEquals(TEST_EMAIL, actual);
    }

    @DisplayName("вход через кнопку в форме восстановления пароля.")
    @Test
    public void loginRecoverLinkTest(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .clickRecoverPasswordLink()
                .clickLoginLinkRecover()
                .loginUser()
                .getEmailProfile();
        Assert.assertEquals(TEST_EMAIL, actual);
    }
}
