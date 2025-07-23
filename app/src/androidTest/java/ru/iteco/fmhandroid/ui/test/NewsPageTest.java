package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.page.NewsPage;

@RunWith(AndroidJUnit4.class)
public class NewsPageTest {

    private final NewsPage newsPage = new NewsPage();

    @Before
    public void setUpTest() {
        Allure.step("Запуск приложения");
        ActivityScenario.launch(AppActivity.class);
    }

    /**
     * TC-001: Создание новости
     */
    @Test
    public void createNewsTest() {
        Allure.step("Создание новости");

        newsPage.clickEditButton();
        newsPage.clickCreateButton();
        newsPage.inputCategory("Объявление");
        newsPage.inputTitle("Тестовая новость");
        newsPage.inputPublishDate("01.01.2025");
        newsPage.inputPublishTime("12:00");
        newsPage.inputDescription("Описание тестовой новости");
        newsPage.clickSaveButton();
        newsPage.viewCreatedNews("Тестовая новость");
    }

    /**
     * TC-002: Редактирование новости
     */
    @Test
    public void editNewsTest() {
        Allure.step("Редактирование новости");

        newsPage.clickEditButton();
        // Допустим, новость находится на позиции 0
        newsPage.viewCreatedNews("Тестовая новость");
        newsPage.clickCreateButton();
        newsPage.inputTitle("Изменённый заголовок");
        newsPage.clickSaveButton();
        newsPage.viewCreatedNews("Изменённый заголовок");
    }

    /**
     * TC-003: Удаление новости
     */
    @Test
    public void deleteNewsTest() {
        Allure.step("Удаление новости");

        newsPage.clickEditButton();
        // Допустим, новость находится на позиции 0
        newsPage.deleteNews("Изменённый заголовок");
        newsPage.verifyNewsDeleted("Изменённый заголовок");
    }
}
