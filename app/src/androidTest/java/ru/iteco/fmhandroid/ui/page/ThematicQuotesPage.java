package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.utils.CustomViewMatcher;

public class ThematicQuotesPage {

    private final int butterflyButton = R.id.our_mission_image_button;
    private final int quoteBox = R.id.our_mission_item_list_recycler_view;

    private final String quoteItem = "Хоспис в своем истинном понимании - это творчество";
    private final String descriptionItem = "Нет шаблона и стандарта, есть только дух, " +
            "который живет в разных домах по-разному. " +
            "Но всегда он добрый, любящий и помогающий.";

    public void clickButterflyButton() {
        Allure.step("Шаг 1: Нажать на изображение бабочки");
        onView(withId(butterflyButton))
                .check(matches(isDisplayed()))
                .perform(click());
    }

    public void checkQuotesCount(int expectedCount) {
        Allure.step("Шаг 2: Проверить количество цитат");
        onView(withId(quoteBox))
                .check(matches(isDisplayed()))
                .check(matches(CustomViewMatcher.recyclerViewSizeMatcher(expectedCount)));
    }

    public void checkQuoteIsDisplayed() {
        Allure.step("Шаг 3: Проверка отображения конкретной цитаты");
        onView(withText(quoteItem))
                .check(matches(isDisplayed()));
    }

    public void clickQuote() {
        Allure.step("Шаг 4: Нажать на цитату");
        onView(withText(quoteItem))
                .perform(click());
    }

    public void checkDescriptionIsDisplayed() {
        Allure.step("Шаг 5: Проверка отображения описания цитаты");
        onView(withText(descriptionItem))
                .check(matches(isDisplayed()));
    }
}
