package ru.iteco.fmhandroid.ui.test;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.page.AboutApplicationPage;



@RunWith(AndroidJUnit4.class)
public class AboutApplicationTest {

    private final AboutApplicationPage aboutPage = new AboutApplicationPage();

    @Before
    public void setUp() {
        Allure.step("Запуск приложения");
        ActivityScenario.launch(AppActivity.class);
    }

    /**
     * TC-001: Проверка открытия экрана 'О приложении' и отображения версии
     */
    @Test
    public void checkAboutApplicationVersionTest() {
        aboutPage.openAboutApplication();
        aboutPage.checkAppVersion();
    }

    /**
     * TC-002: Проверка открытия Пользовательского соглашения
     */
    @Test
    public void openUserAgreementTest() {
        aboutPage.openAboutApplication();
        aboutPage.openUserAgreement();
    }

    /**
     * TC-003: Проверка открытия Политики конфиденциальности
     */
    @Test
    public void openPrivacyPolicyTest() {
        aboutPage.openAboutApplication();
        aboutPage.openPrivacyPolicy();
    }
}
