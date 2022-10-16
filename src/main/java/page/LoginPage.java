package page;

import com.codeborne.selenide.SelenideElement;
import constant.Constants;


import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends Constants {
    protected final SelenideElement registrationLink = $x("//a[@class = 'Auth_link__1fOlj'][text() = 'Зарегистрироваться']");
    protected final SelenideElement emailRegField = $x("//label[text() = 'Email']/following-sibling::input");
    protected final SelenideElement passwordRegField = $x("//label[text() = 'Пароль']/following-sibling::input");
    protected final SelenideElement loginButtonMainPage = $x("//button[text() = 'Войти']");
    protected final SelenideElement personalAccountButton = $x("//p[text() = 'Личный Кабинет']");
    protected final SelenideElement recoverPasswordLink = $x("//a[@class = 'Auth_link__1fOlj'][text() = 'Восстановить пароль']");
    protected final SelenideElement textLogin = $x("//div[@class = 'Auth_login__3hAey']/h2");
    public RegistrationPage clickOnRegButton(){
        registrationLink.click();
        return new RegistrationPage();
    }

    public ForgotPasswordPage clickRecoverPasswordLink(){
        recoverPasswordLink.click();
        return new ForgotPasswordPage();
    }

    public String getTextEmailField(){
        return emailRegField.getValue();
    }

    public ProfilePage loginUser(){
        emailRegField.setValue(TEST_EMAIL);
        passwordRegField.setValue(TEST_Password);
        loginButtonMainPage.click();
        personalAccountButton.click();
        return new ProfilePage();
    }

    public String checkTextLogin(){
        return textLogin.getText();
    }
}
