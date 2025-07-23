package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

import androidx.test.espresso.intent.Intents;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class AboutApplicationPage {

    private final String privacyPolicyLink = "https://vhospice.org/#/privacy-policy";
    private final String userAgreementLink = "https://vhospice.org/#/terms-of-use";
    private final String appVersion = "1.0.0";

    private final int navMenuButton = R.id.main_menu_image_button;
    private final String aboutButtonText = "О приложении";
    private final int userAgreementID = R.id.about_terms_of_use_value_text_view;
    private final int versionID = R.id.about_version_value_text_view;
    private final int privacyPolicyID = R.id.about_privacy_policy_value_text_view;

    public void openAboutApplication() {
        Allure.step("Открыть экран 'О приложении'");
        onView(withId(navMenuButton)).check(matches(isDisplayed())).perform(click());
        onView(withText(aboutButtonText)).check(matches(isDisplayed())).perform(click());
    }

    public void checkAppVersion() {
        Allure.step("Проверить отображение версии приложения");
        onView(withId(versionID)).check(matches(isDisplayed())).check(matches(withText(appVersion)));
    }

    public void openUserAgreement() {
        Allure.step("Проверить открытие Пользовательского соглашения");
        Intents.init();
        onView(withId(userAgreementID)).check(matches(isDisplayed())).perform(click());
        intended(hasData(userAgreementLink));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }

    public void openPrivacyPolicy() {
        Allure.step("Проверить открытие Политики конфиденциальности");
        Intents.init();
        onView(withId(privacyPolicyID)).check(matches(isDisplayed())).perform(click());
        intended(hasData(privacyPolicyLink));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }
}
