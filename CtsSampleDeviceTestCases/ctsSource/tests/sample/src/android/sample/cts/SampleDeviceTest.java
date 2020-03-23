/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package android.sample.cts;

import android.sample.SampleDeviceActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

//import android.test.ActivityInstrumentationTestCase2;

/**
 * A simple compatibility test which tests the SharedPreferences API.
 *
 */

//@RunWith(AndroidJUnit4ClassRunner.class)
public class SampleDeviceTest
{
    @Rule
    public ActivityTestRule<SampleDeviceActivity> mActivityRule =
            new ActivityTestRule(SampleDeviceActivity.class);
    private static final String KEY = "foo";

    private static final String VALUE = "bar";

    /**
     * A reference to the activity whose shared preferences are being tested.
     */
    private SampleDeviceActivity mActivity;


    // Everything in @Before will be run after the @Rule, before @Test
    @Before
    public void setUp() throws Exception {
        // Start the activity and get a reference to it.
        mActivity = mActivityRule.getActivity();
    }

    // Whatever is in the @After will be executed After the test is completed
    @After
    public void tearDown() throws Exception {
        // Scrub the activity so it can be freed. The next time the setUp will create a new activity
        // rather than reusing the old one.
        mActivity = null;
    }

    /**
     * Tests the SharedPreferences API.
     *
     * This inserts the key value pair and assert they can be retrieved. Then it clears the
     * preferences and asserts they can no longer be retrieved.
     *
     * @throws Exception
     */
    @Test
    public void testSharedPreferences() throws Exception {
        // Save the key value pair to the preferences and assert they were saved.
        mActivity.savePreference(KEY, VALUE);
        assertEquals("Preferences were not saved", VALUE, mActivity.getPreference(KEY));

        // Clear the shared preferences and assert the data was removed.
        mActivity.clearPreferences();
        assertNull("Preferences were not cleared", mActivity.getPreference(KEY));
    }
}
