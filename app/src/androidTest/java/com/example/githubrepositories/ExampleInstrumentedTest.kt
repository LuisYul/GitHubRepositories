package com.example.githubrepositories

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
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
    var mActivityRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkCorrectToolbarTitle() {
        onView(withText("GitHubRepositories")).check(matches(isDisplayed()))
    }

    @Test
    fun checkIfDetailFragmentIsDisplayedAfterClickRepository() {
        Thread.sleep(4000L)
        onView(withId(R.id.rv_repository))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.fragment_detail)).check(matches(isDisplayed()))
    }
}