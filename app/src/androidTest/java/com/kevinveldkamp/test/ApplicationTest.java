package com.kevinveldkamp.test;

import android.app.Application;
import android.os.Bundle;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import com.kevinveldkamp.ceasarcalc.CalcScreen;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();

    }

    @SmallTest
    public void testRomConversion() {
        CalcScreen cs = new CalcScreen();

        int number = 4056;

        String result = cs.romConversion(number);

        assertEquals("MMMMLVI",result);
    }


    @SmallTest
    public void testDataLoad(){

        CalcScreen cs = new CalcScreen();

        String s1="s1";
        String s2="s2";
        String s3 ="s3";
        String s4 = "s4";
        String s5 = "s5";
        String s6 = "s6";
        cs.updateValues(s1);
        cs.updateValues(s2);
        cs.updateValues(s3);
        cs.updateValues(s4);
        cs.updateValues(s5);
        cs.updateValues(s6);

        String comparison = cs.getCurrentValues().peekLast();
        assertEquals(s2,comparison);
    }



    @Override
    protected void tearDown() throws Exception{
        super.tearDown();
    }

}