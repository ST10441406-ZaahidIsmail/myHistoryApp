package com.example.myimadassignment

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyUnitTest
{

    @Before
    fun setUp() {
        // Start MainActivity before each test
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testGenerateButton_withValidInput_shouldDisplayHistoricalFigure() {
        // Input a valid age
        onView(withId(R.id.editNumberAge)).perform(replaceText("78"))
        // Click the generate button
        onView(withId(R.id.btnAnswer)).perform(click())
        // Check if the result is displayed correctly
        onView(withId(R.id.displayResult)).check(matches(withText(containsString("Mahatma Gandhi"))))
    }

    @Test
    fun testGenerateButton_withInvalidInput_shouldDisplayNoFigureFound() {
        // Input an invalid age
        onView(withId(R.id.editNumberAge)).perform(replaceText("150"))
        // Click the generate button
        onView(withId(R.id.btnAnswer)).perform(click())
        // Check if the correct message is displayed
        onView(withId(R.id.displayResult)).check(matches(withText("No historical figure has been found from the input of your age")))
    }

    @Test
    fun testClearButton_shouldClearEditTextAndResult() {
        // Input an age
        onView(withId(R.id.editNumberAge)).perform(replaceText("40"))
        // Click the clear button
        onView(withId(R.id.btnClear)).perform(click())
        // Check if the edit text is cleared
        onView(withId(R.id.editNumberAge)).check(matches(withText("")))
        // Check if the result is cleared
        onView(withId(R.id.displayResult)).check(matches(withText("")))
    }
}
