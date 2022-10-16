import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import page.HomePage;
import constant.Constants;
import org.junit.Assert;
import org.junit.Test;

public class TransitionsTest extends Constants {

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }

    private static final String expected = "Вход";
    private static final String expectedHeading = "Соберите бургер";

    @DisplayName("переход по клику на «Личный кабинет")
    @Test
    public void checkTransitionPersonalAccountButtonTest(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .checkTextLogin();
        Assert.assertEquals(expected, actual);
    }

    @DisplayName("переход по клику на логотип Stellar Burgers.")
    @Test
    public void checkLogoClickTest(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .loginUser()
                .clickOnLogo();
        Assert.assertEquals(expectedHeading, actual);
    }

    @DisplayName("переход по клику на «Конструктор»")
    @Test
    public void checkConstructorLinkTest(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .loginUser()
                .clickOrderLink()
                .clickOnConstructorLink();
        Assert.assertEquals(expectedHeading, actual);
    }

    @DisplayName("выход по кнопке «Выйти» в личном кабинете")
    @Test
    public void logoutUserTest(){
        String actual = new HomePage(URL)
                .clickOnLoginButtonMainPage()
                .loginUser()
                .clickLogoutButton()
                .checkTextLogin();
        Assert.assertEquals(expected, actual);
    }
}
