package ru.iteco.fmhandroid.ui.test;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.page.AuthPage;
import ru.iteco.fmhandroid.ui.page.ThematicQuotesPage;

@RunWith(AndroidJUnit4.class)
public class ThematicQuotesTest {

    private final ThematicQuotesPage quotesPage = new ThematicQuotesPage();
    private final AuthPage authPage = new AuthPage();

    @Before
    public void setUpTest() {
        Allure.step("Запуск приложения");
        ActivityScenario.launch(AppActivity.class);
    }

    /**
     * TC-001: Проверка отображения нужного количества цитат
     */
    @Test
    public void shouldDisplayCorrectQuotesCount() {
        quotesPage.checkQuotesCount(9); // Подставь реальное ожидаемое количество цитат
    }

    /**
     * TC-002: Проверка отображения конкретной цитаты
     */
    @Test
    public void shouldDisplayConcreteQuote() {
        quotesPage.checkQuoteIsDisplayed();
    }

    /**
     * TC-003: Проверка раскрытия описания цитаты
     */
    @Test
    public void shouldOpenQuoteAndSeeDescription() {
        quotesPage.checkQuoteIsDisplayed();
        quotesPage.clickQuote();
        quotesPage.checkDescriptionIsDisplayed();
    }
}
