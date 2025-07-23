package ru.iteco.fmhandroid.ui.test;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.page.AuthPage;

@RunWith(AndroidJUnit4.class)
public class AuthTest extends AuthPage {

    @Before
    public void setUpTest() {
        setUp(); // Инициализация decorView и запуск Activity
    }

    // TC-001: Успешная авторизация
    @Test
    public void successfulAuthorization() {
        enterLogin("login2");
        enterPassword("password2");
        clickSignIn();
        checkMainScreenIsDisplayed();
    }

    // TC-002: Пустые поля
    @Test
    public void emptyFieldsError() {
        clickSignIn();
        checkEmptyFieldsErrorIsDisplayed();
    }

    // TC-011: Неверный пароль
    @Test
    public void invalidPasswordError() {
        enterLogin("login2");
        enterPassword("wrongPassword");
        clickSignIn();
        checkErrorMessageIsDisplayed();
    }

    // TC-037: Пустой пароль
    @Test
    public void emptyPasswordError() {
        enterLogin("login2");
        clickSignIn();
        checkEmptyFieldsErrorIsDisplayed();
    }
}
