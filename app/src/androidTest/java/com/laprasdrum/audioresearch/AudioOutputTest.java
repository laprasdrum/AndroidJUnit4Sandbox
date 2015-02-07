package com.laprasdrum.audioresearch;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class AudioOutputTest {

    AudioOutput output;

    @Before
    public void setUp() throws Exception {
        output = new AudioOutput();
    }

    @Test
    public void checkAudioTrackFormat() {
        assertThat(output.resource.getStreamType(), is(AudioManager.STREAM_MUSIC));
        assertThat(output.resource.getSampleRate(), is(44100));
        assertThat(output.resource.getChannelConfiguration(), is(AudioFormat.CHANNEL_OUT_STEREO));
        assertThat(output.resource.getAudioFormat(), is(AudioFormat.ENCODING_PCM_16BIT));

        int expectedMinBufferSize = AudioTrack.getMinBufferSize(
                44100,
                AudioFormat.CHANNEL_OUT_STEREO,
                AudioFormat.ENCODING_PCM_16BIT
        );
        assertThat(output.soundBufferSize, is(expectedMinBufferSize));
    }

    @Test
    public void shouldPlayingStateBeTrueAfterPlayingAudioTrack() {
        output.startPlayback();
        assertThat(output.isPlaying(), is(true));
    }

    @Test
    public void shouldPlayingStateBeFalseUnlessPlayAudioTrack() {
        assertThat(output.isPlaying(), is(false));
        output.startPlayback();
        output.stopPlayback();
        assertThat(output.isPlaying(), is(false));
    }

    @Ignore
    @Test
    public void shouldBeNotInMainThread() {

    }
}
