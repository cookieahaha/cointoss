package me.kukkii.cointoss;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SoundFragment extends Fragment implements OnClickListener {

    private SoundPool soundPool;
    private int soundId = 0;
    private int streamId = 0;
    boolean loaded = false;

    Button button = null;
    boolean current = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.sound_fragment, container, false);
    }

    public void onStart() {
      super.onStart();
      button = (Button) getActivity().findViewById(R.id.sound_button);
      button.setText(current?"ON":"OFF");
      button.setOnClickListener(this);

      if (! loaded) {
        // Context context = getApplicationContext();
        Activity activity = getActivity();
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        // Load the sound
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
          @Override
          public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
            loaded = true;
          }
        });
        soundId = soundPool.load(activity, R.raw.bigfish_104_world_hiphop_drums, 1);
      }
    }

    public void onResume() {
        super.onResume();
        if (current) {
          soundOn();
          button.setText(current?"ON":"OFF");
        }
    }

    public void onPause() {
        super.onPause();
        if (current) {
          soundOff();
          current = true; // for onResume
        }
    }

    public void soundOn() {
        // Getting the user sound settings
        Activity activity = getActivity();
        AudioManager audioManager = (AudioManager) activity.getSystemService(Activity.AUDIO_SERVICE);
        float actualVolume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;
        // Is the sound loaded already?
        if (loaded) {
          Log.i("Test", "Start playing sound ...");
          if (streamId == 0) {
            streamId = soundPool.play(soundId, volume, volume, 1, -1, 1f);
                                                                 // -1 for loop playback
            if (streamId != 0) {
              Log.i("Test", "Success, playing sound");
              current = true;
            }
            else {
              Log.e("Test", "Failed to play");
              current = false;
            }
          }
          else {
            soundPool.resume(streamId);
            current = true;
          }
        }
        else {
          Log.e("Test", "Not loaded, failed to play");
          current = false;
        }
    }

    public void soundOff() {
        soundPool.pause(streamId);
        current = false;
        Log.i("Test", "Stopped playing");
    }

    public void onClick(View view) {
        // Button button = (Button) view;
        // String text = button.getText().toString();
        if (current) {
          soundOff();
        }
        else {
          soundOn();
        }
        button.setText(current?"ON":"OFF");
    }

}
