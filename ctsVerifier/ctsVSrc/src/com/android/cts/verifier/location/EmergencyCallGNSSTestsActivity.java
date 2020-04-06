/*
 * Copyright (C) 2017 The Android Open Source Project
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
 * limitations under the License
 */

package com.android.cts.verifier.location;

import android.location.cts.GnssMeasurementValuesTest;
import com.android.cts.verifier.location.base.EmergencyCallBaseTestActivity;
import java.util.concurrent.TimeUnit;

/**
 * Activity to execute CTS GnssMeasurementValuesTest while dialing emergency number.
 * It is a wrapper for {@link GnssMeasurementValuesTest} running with AndroidJUnitRunner.
 */
public class EmergencyCallGNSSTestsActivity extends EmergencyCallBaseTestActivity {
  // GNSS test has a longer timeout
  private static final long PHONE_CALL_DURATION_MS = TimeUnit.MINUTES.toMillis(2);

  public EmergencyCallGNSSTestsActivity() {
    super(GnssMeasurementValuesTest.class);
  }

  @Override
  protected long getPhoneCallDurationMs() {
    return PHONE_CALL_DURATION_MS;
  }

  @Override
  protected boolean showLocalNumberInputbox() {
    return false;
  }
}
