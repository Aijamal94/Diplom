package ru.iteco.fmhandroid.ui.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CustomViewMatcher {

    public static Matcher<View> recyclerViewSizeMatcher(final int expectedCount) {
        return new TypeSafeMatcher<View>() {

            @Override
            protected boolean matchesSafely(View view) {
                if (!(view instanceof RecyclerView)) {
                    return false;
                }
                RecyclerView recyclerView = (RecyclerView) view;
                return recyclerView.getAdapter() != null && recyclerView.getAdapter().getItemCount() == expectedCount;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("RecyclerView должно содержать " + expectedCount + " элементов");
            }
        };
    }
}

