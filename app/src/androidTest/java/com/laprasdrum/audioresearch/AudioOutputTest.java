package com.laprasdrum.audioresearch;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class AudioOutputTest {
    @Before
    public void setUp() throws Exception {
        AudioOutput output = new AudioOutput();
    }


    @Test
    public void testStartPlayback() {
        assertEquals(10, 10);
    }

    @After
    public void tearDown() throws Exception {

    }

//    @Parameterized.Parameters
//    public static Collection<Object[]> data() {
//
//
//    }
}
