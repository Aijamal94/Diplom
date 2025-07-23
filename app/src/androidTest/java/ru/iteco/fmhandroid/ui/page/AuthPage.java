package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utils.LoadingPage.waitDisplayed;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.PerformException;

import org.hamcrest.Matchers;
import org.junit.Before;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;

public class AuthPage {

    private final String loginHint = "Логин";
    private final String passwordHint = "Пароль";
    private final String errorMessageEmpty = "Логин и пароль не могут быть пустыми";
    private final String errorMessageInvalid = "Что-то пошло не так. Попробуйте позднее.";

    private final int fieldLogin = R.id.login_text_input_layout;
    private final int fieldPassword = R.id.password_text_input_layout;
    private final int enterButton = R.id.enter_button;
    private final int mainPageID = R.id.container_list_news_include_on_fragment_main;

    private View decorView;

    @Before
    public void setUp() {
        ActivityScenario<AppActivity> scenario = ActivityScenario.launch(AppActivity.class);
        scenario.onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    public void enterLogin(String login) {
        Allure.step("Ввести логин: " + login);
        onView(withId(fieldLogin)).check(matches(isDisplayed())).perform(click());
        onView(withHint(loginHint)).perform(typeText(login), closeSoftKeyboard());
    }

    public void enterPassword(String password) {
        Allure.step("Ввести пароль: " + password);
        onView(withId(fieldPassword)).check(matches(isDisplayed())).perform(click());
        onView(withHint(passwordHint)).perform(typeText(password), closeSoftKeyboard());
    }

    public void clickSignIn() {
        Allure.step("Нажать на кнопку Войти");
        onView(withId(enterButton)).check(matches(isDisplayed())).perform(click());
    }

    public void checkMainScreenIsDisplayed() {
        Allure.step("Проверка, что открыта главная страница");
        onView(isRoot()).perform(waitDisplayed(mainPageID, 7000));
        onView(withId(mainPageID)).check(matches(isDisplayed()));
    }

    public void checkEmptyFieldsErrorIsDisplayed() {
        Allure.step("Проверка сообщения об ошибке: пустые поля");
        onView(withText(errorMessageEmpty))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    public void checkErrorMessageIsDisplayed() {
        Allure.step("Проверка сообщения об ошибке: неверный логин или пароль");
        onView(withText(errorMessageInvalid))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    public void checkPasswordEmptyErrorIsDisplayed() {
        Allure.step("Проверка сообщения об ошибке: пустое поле пароля");
        onView(withText(errorMessageEmpty))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }
}
