package com.example.abdul;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class DemoActivityTest1 {

    @Rule
    public ActivityTestRule<DemoActivity> mActivityTestRule = new ActivityTestRule<>(DemoActivity.class);


    @Test
    public  void clickmeTest(){
        onView(withId(R.id.editTextValue))
                .perform(typeText("sageit"));
        onView(withId(R.id.buttonclickme)).perform(click()); //viewaction
        onView(withId(R.id.textViewresult))
                .check(matches(withText("sageit"))); //viewassertion

    }

}