package com.laprasdrum.audioresearch;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

public class AudioOutput {
    private final int streamType    = AudioManager.STREAM_MUSIC;
    private final int sampleRate    = 44100;
    private final int channelConfig = AudioFormat.CHANNEL_OUT_STEREO;
    private final int audioFormat   = AudioFormat.ENCODING_PCM_16BIT;
    private final int mode          = AudioTrack.MODE_STREAM;

    public AudioTrack resource;
    public int soundBufferSize;

    public AudioOutput() {
        soundBufferSize = AudioTrack.getMinBufferSize(sampleRate, channelConfig, audioFormat);
        resource = new AudioTrack(streamType, sampleRate, channelConfig, audioFormat, soundBufferSize, mode);
    }


    public void startPlayback() {
        resource.play();
    }

    public void stopPlayback() {
        resource.stop();
    }

    public Boolean isPlaying() {
        return resource.getPlayState() == AudioTrack.PLAYSTATE_PLAYING;
    }
}