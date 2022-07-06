package com.example.appmagnoservices;




import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTest {
    public static final String STRING_TIPEADO = "TESTING";

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void editTextUserAndPasswordCase01(){

        onView(withId(R.id.edtUsuarioIngresar)).check(matches(isDisplayed()));
    }
    @Test
    public void editTextUserAndPasswordCase02(){

        onView(withId(R.id.edtUsuarioIngresar)).perform(typeText(STRING_TIPEADO)).
                check(matches(withText(STRING_TIPEADO)));

    }
    @Test
    public void btnIngresarText(){

        onView(withId(R.id.btnIngresar)).check(matches(withText("Ingresar")));
    }



    // 
    //La aplicación web deberá permitir loguear a los usuarios.
    //MUY ALTA
    //v1

    @Test
    public void logearUsuarioSuccesCase01(){

        String usuario ="roquemayo@gmail.com";
        String password = "roquemayo2";
        onView(withId(R.id.edtUsuarioIngresar)).perform(typeText(usuario),closeSoftKeyboard());
        onView(withId(R.id.edtPassIngresar)).perform(typeText(password),closeSoftKeyboard());

        onView(withId(R.id.btnIngresar)).perform(click());

        //onView(withId(R.id.menuItemCerrarSesion)).perform(click());
    }
    @Test
    public void logearUsuarioFailSuccesCase02(){

        String usuario ="roquemayo@gmail.com";
        String password = "roquemayo2";
        onView(withId(R.id.edtUsuarioIngresar)).perform(typeText(usuario),closeSoftKeyboard());
        onView(withId(R.id.edtPassIngresar)).perform(typeText(password),closeSoftKeyboard());

        onView(withId(R.id.btnIngresar)).perform(click());
        onView(withId(R.id.tvNombreUsuario)).check(matches(isDisplayed()));

        //onView(withId(R.id.menuItemCerrarSesion)).perform(click());
    }

    @Test
    public void logearUsuarioFailCase01(){

        String usuario ="roquemayo";
        String password = "roquemayo";
        onView(withId(R.id.edtUsuarioIngresar)).perform(typeText(usuario),closeSoftKeyboard());
        onView(withId(R.id.edtPassIngresar)).perform(typeText(password),closeSoftKeyboard());

        onView(withId(R.id.btnIngresar)).perform(click());
        onView(withId(R.id.edtUsuarioIngresar)).check(matches(isDisplayed()));
        //onView(withId(R.id.menuItemCerrarSesion)).perform(click());
    }
    @Test
    public void logearUsuarioFailCase02(){

        String usuario ="admin@magno.com";
        String password = "admin@magno.com";
        onView(withId(R.id.edtUsuarioIngresar)).perform(typeText(usuario),closeSoftKeyboard());
        onView(withId(R.id.edtPassIngresar)).perform(typeText(password),closeSoftKeyboard());

        onView(withId(R.id.btnIngresar)).perform(click());
        onView(withId(R.id.edtUsuarioIngresar)).check(matches(isDisplayed()));
        //onView(withId(R.id.menuItemCerrarSesion)).perform(click());
    }
}