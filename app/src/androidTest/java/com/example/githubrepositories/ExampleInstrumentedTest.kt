package com.example.githubrepositories

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Rule
import org.junit.Test
import androidx.test.rule.ActivityTestRule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleInstrumentedTest {
    @get:Rule
    public var mActivityRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)


    @Test
    fun clickRepositoryRecyclerViewItem() {
        onView(withId(R.id.rv_repository))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()));
    }
}