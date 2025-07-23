package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class NewsPage extends BaseClass {

    private final int editButton = R.id.edit_news_material_button;
    private final int createButton = R.id.add_news_image_view;
    private final int categoryField = R.id.news_item_category_text_auto_complete_text_view;
    private final int titleField = R.id.news_item_title_text_input_edit_text;
    private final int publishDateField = R.id.news_item_publish_date_text_input_edit_text;
    private final int publishTimeField = R.id.news_item_publish_time_text_input_edit_text;
    private final int descriptionField = R.id.news_item_description_text_input_edit_text;
    private final int saveButton = R.id.save_button;
    private final int recyclerView = R.id.news_list_recycler_view;
    private final int deleteButton = R.id.delete_news_item_image_view;

    private final String warningMessage = "Заполните пустые поля";

    // Нажать на иконку "карандаш" для открытия панели редактирования
    public void clickEditButton() {
        Allure.step("Нажать на иконку редактирования (карандаш)");
        onView(withId(editButton)).check(matches(isDisplayed())).perform(click());
    }

    // Нажать на кнопку создания новости
    public void clickCreateButton() {
        Allure.step("Нажать на кнопку создания новости");
        onView(withId(createButton)).check(matches(isDisplayed())).perform(click());
    }

    // Заполнить поле "Категория"
    public void inputCategory(String category) {
        Allure.step("Заполнить поле Категория");
        onView(withId(categoryField)).check(matches(isDisplayed())).perform(replaceText(category), closeSoftKeyboard());
    }

    // Заполнить поле "Заголовок"
    public void inputTitle(String title) {
        Allure.step("Заполнить поле Заголовок");
        onView(withId(titleField)).check(matches(isDisplayed())).perform(replaceText(title), closeSoftKeyboard());
    }

    // Заполнить поле "Дата публикации"
    public void inputPublishDate(String date) {
        Allure.step("Заполнить поле Дата публикации");
        onView(withId(publishDateField)).check(matches(isDisplayed())).perform(replaceText(date), closeSoftKeyboard());
    }

    // Заполнить поле "Время публикации"
    public void inputPublishTime(String time) {
        Allure.step("Заполнить поле Время публикации");
        onView(withId(publishTimeField)).check(matches(isDisplayed())).perform(replaceText(time), closeSoftKeyboard());
    }

    // Заполнить поле "Описание"
    public void inputDescription(String description) {
        Allure.step("Заполнить поле Описание");
        onView(withId(descriptionField)).check(matches(isDisplayed())).perform(replaceText(description), closeSoftKeyboard());
    }

    // Нажать кнопку "Сохранить"
    public void clickSaveButton() {
        Allure.step("Нажать кнопку Сохранить");
        onView(withId(saveButton)).check(matches(isDisplayed())).perform(click());
    }

    // Проверить, что новость с указанным заголовком отображается в списке
    public void viewCreatedNews(String title) {
        Allure.step("Проверка наличия созданной новости с заголовком: " + title);
        onView(withText(title)).check(matches(isDisplayed()));
    }

    // Клик по новости с указанным заголовком
    public void openNewsByTitle(String title) {
        Allure.step("Открыть новость с заголовком: " + title);
        onView(withId(recyclerView)).perform(actionOnItem(allOf(ViewMatchers.hasDescendant(withText(title))), click()));
    }

    // Удаление новости (при открытом экране новости)
    public void deleteNews() {
        Allure.step("Удалить новость");
        onView(withId(deleteButton)).check(matches(isDisplayed())).perform(click());
    }

    // Проверка отображения системного предупреждения о незаполненных полях
    public void viewWarningMessage() {
        Allure.step("Проверка сообщения о незаполненных полях");
        onView(withText(warningMessage)).check(matches(isDisplayed()));
    }

}
