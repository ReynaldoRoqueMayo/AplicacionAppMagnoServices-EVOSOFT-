package com.example.appmagnoservices;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.example.appmagnoservices.utilidades.ValidationPatterns;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidationPatternsTest {


    @Mock
    AwesomeValidation awesomeValidation;
    @Mock
    Context contex;
    @Mock
    EditText mockEdt;

    @Mock
    Activity registroActivity;

    ValidationPatterns validationPatterns;
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        registroActivity=mock(Activity.class);
        mockEdt= mock(EditText.class);
        contex= mock(Activity.class);
    }

    
    @Test
    public void validarEmailSucces(){




        mockEdt.setId(12);
        when(registroActivity.findViewById(12)).thenReturn(mockEdt);


        validationPatterns = new ValidationPatterns(registroActivity);

        validationPatterns.agregarPatronEmail(12);

        assertEquals(false,validationPatterns.validarCampos());


    }

}
