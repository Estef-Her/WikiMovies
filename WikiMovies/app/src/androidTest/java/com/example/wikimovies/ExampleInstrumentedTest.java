package com.example.wikimovies;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;
import com.example.wikimovies.Datos.Modelo;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    public static Modelo DATOS = new Modelo();
    @Test
    public void useAppContext() {
        DATOS.insertarDatosQuemados();
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.wikimovies", appContext.getPackageName());
    }
}
