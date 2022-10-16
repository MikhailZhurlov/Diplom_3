import io.qameta.allure.junit4.DisplayName;
import page.HomePage;
import constant.Constants;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationTest extends Constants {

    private final String URL = "https://stellarburgers.nomoreparties.site/";
    private final static String expectedErrorMessage = "Некорректный пароль";

    @DisplayName("Регистрация пользователя")
    @Test
    public void successRegisterTest(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .registerUser()
                .getTextEmailField();
        Assert.assertEquals(randomEmailUser, actual);
    }

    @DisplayName("Проверка ошибки для некорректного пароля.")
    @Test
    public void errorMessageBadPasswordTest(){
        String actual = new HomePage(URL)
                .clickOnPersonalAccountButton()
                .clickOnRegButton()
                .registerNewUserWithBadPassword();
        Assert.assertEquals(expectedErrorMessage, actual);
    }
}
