package com.laprasdrum.audioresearch;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class AudioInputTest {

    AudioInput input;

    @Before
    public void setUp() throws Exception {
        input = new AudioInput();
    }

    @Ignore
    @Test
    public void checkAudioTrackFormat() {
        // input
//        mBufferSize = AudioRecord.getMinBufferSize(
//                SoftModemConstants.SAMPLING_RATE,
//                AudioFormat.CHANNEL_IN_MONO,
//                AudioFormat.ENCODING_PCM_16BIT
//        );
//        int audioSource, int sampleRateInHz, int channelConfig, int audioFormat, int bufferSizeInBytes
//        mAudioRecord = new AudioRecord(
//                MediaRecorder.AudioSource.MIC,    // in.audioSource
//                SoftModemConstants.SAMPLING_RATE, // in.sampleRateInHz    = out
//                AudioFormat.CHANNEL_IN_MONO,      // in.channelConfig
//                AudioFormat.ENCODING_PCM_16BIT,   // in.audioFormat       = out
//                mBufferSize                       // in.bufferSizeInBytes
//        );

    }
}
