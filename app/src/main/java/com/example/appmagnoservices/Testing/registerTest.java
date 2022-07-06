package com.example.appmagnoservices;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void RegisterCase01(){

        onView(withId(R.id.edtUsuarioIngresar)).check(matches(isDisplayed()));
        onView(withId(R.id.btnCrearCuenta)).perform(click());
        onView(withId(R.id.tituloOpcionesRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.rbtnPersona)).perform(click());
        onView(withId(R.id.btnOcionesContinuar)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.edtDniRegistro)).check(matches(isDisplayed()));

    }
    @Test
    public void RegisterCase01Fail(){

        onView(withId(R.id.edtUsuarioIngresar)).check(matches(isDisplayed()));
        onView(withId(R.id.btnCrearCuenta)).perform(click());
        onView(withId(R.id.tituloOpcionesRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.rbtnPersona)).perform(click());
        onView(withId(R.id.btnOcionesContinuar)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.edtDniRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.btnContinuarRegisro)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.edtDniRegistro)).check(matches(isDisplayed()));

    }
    @Test
    public void RegisterCase02Fail(){
        String correo ="roquemayo@gmail.com";

        onView(withId(R.id.edtUsuarioIngresar)).check(matches(isDisplayed()));





        onView(withId(R.id.btnCrearCuenta)).perform(click());
        onView(withId(R.id.tituloOpcionesRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.rbtnPersona)).perform(click());
        onView(withId(R.id.btnOcionesContinuar)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.edtDniRegistro)).check(matches(isDisplayed()));

        onView(withId(R.id.edtCorreoRegistro)).perform(typeText(correo),closeSoftKeyboard());

        onView(withId(R.id.btnContinuarRegisro)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.edtDniRegistro)).check(matches(isDisplayed()));



    }
    @Test
    public void RegisterCase03Fail(){
        String correo ="roquemayo@gmail.com";
        String pass="alexroque123";

        onView(withId(R.id.edtUsuarioIngresar)).check(matches(isDisplayed()));





        onView(withId(R.id.btnCrearCuenta)).perform(click());
        onView(withId(R.id.tituloOpcionesRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.rbtnPersona)).perform(click());
        onView(withId(R.id.btnOcionesContinuar)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.edtDniRegistro)).check(matches(isDisplayed()));

        onView(withId(R.id.edtCorreoRegistro)).perform(typeText(correo),closeSoftKeyboard());
        onView(withId(R.id.edtPassRegistro)).perform(typeText(correo),closeSoftKeyboard());


        onView(withId(R.id.btnContinuarRegisro)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.edtDniRegistro)).check(matches(isDisplayed()));



    }
    @Test
    public void RegisterCase04Fail(){
        String correo ="roquemayo@gmail.com";
        String pass="alexroque123";
        String cel="991619195";
        onView(withId(R.id.edtUsuarioIngresar)).check(matches(isDisplayed()));





        onView(withId(R.id.btnCrearCuenta)).perform(click());
        onView(withId(R.id.tituloOpcionesRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.rbtnPersona)).perform(click());
        onView(withId(R.id.btnOcionesContinuar)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.edtDniRegistro)).check(matches(isDisplayed()));

        onView(withId(R.id.edtCorreoRegistro)).perform(typeText(correo),closeSoftKeyboard());
        onView(withId(R.id.edtPassRegistro)).perform(typeText(pass),closeSoftKeyboard());
        onView(withId(R.id.edtCelularRegistro)).perform(typeText(cel),closeSoftKeyboard());

        onView(withId(R.id.btnContinuarRegisro)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.edtDniRegistro)).check(matches(isDisplayed()));



    }

    @Test
    public void RegisterCase05Fail(){
        String correo ="roquemayo@gmail.com";
        String pass="alexroque123";
        String cel="991619195";
        String DNI="991619195";
        onView(withId(R.id.edtUsuarioIngresar)).check(matches(isDisplayed()));





        onView(withId(R.id.btnCrearCuenta)).perform(click());
        onView(withId(R.id.tituloOpcionesRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.rbtnPersona)).perform(click());
        onView(withId(R.id.btnOcionesContinuar)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.edtDniRegistro)).check(matches(isDisplayed()));

        onView(withId(R.id.edtCorreoRegistro)).perform(typeText(correo),closeSoftKeyboard());
        onView(withId(R.id.edtPassRegistro)).perform(typeText(pass),closeSoftKeyboard());
        onView(withId(R.id.edtCelularRegistro)).perform(typeText(cel),closeSoftKeyboard());
        onView(withId(R.id.edtDniRegistro)).perform(typeText(DNI),closeSoftKeyboard());

        onView(withId(R.id.btnContinuarRegisro)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.edtDniRegistro)).check(matches(isDisplayed()));



    }
    @Test
    public void RegisterCase06Fail(){
        String correo ="roquemayo@gmail.com";
        String pass="alexroque123";
        String cel="991619195";
        String DNI="991619195";
        onView(withId(R.id.edtUsuarioIngresar)).check(matches(isDisplayed()));





        onView(withId(R.id.btnCrearCuenta)).perform(click());
        onView(withId(R.id.tituloOpcionesRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.rbtnPersona)).perform(click());
        onView(withId(R.id.btnOcionesContinuar)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.edtDniRegistro)).check(matches(isDisplayed()));

        onView(withId(R.id.edtCorreoRegistro)).perform(typeText(correo),closeSoftKeyboard());
        onView(withId(R.id.edtPassRegistro)).perform(typeText(pass),closeSoftKeyboard());
        onView(withId(R.id.edtCelularRegistro)).perform(typeText(cel),closeSoftKeyboard());
        onView(withId(R.id.edtDniRegistro)).perform(typeText(DNI),closeSoftKeyboard());

        onView(withId(R.id.btnContinuarRegisro)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.edtDniRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.btnCancelarRegistro)).perform(click());

        onView(withId(R.id.rbtnPersona)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).perform(typeText(correo),closeSoftKeyboard());
        onView(withId(R.id.edtPassRegistro)).perform(typeText(pass),closeSoftKeyboard());
        onView(withId(R.id.btnContinuarRegisro)).perform(click());
        onView(withId(R.id.edtCorreoRegistro)).check(matches(isDisplayed()));
        onView(withId(R.id.edtDniRegistro)).check(matches(isDisplayed()));

    }

}
