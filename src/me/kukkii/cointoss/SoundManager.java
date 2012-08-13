package me.kukkii.cointoss;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.util.Log;
import static android.content.Context.AUDIO_SERVICE;

public class SoundManager {

  //singleton
  private static SoundManager manager = null;
  private static Context _context;
 
  public static void setContext(Context context) {
     _context = context;
     manager = new SoundManager(context);
  }

  public static SoundManager getSoundManager(){
    return manager;
  }
  //
  
  private MediaPlayer player;
  
  private SoundPool soundPool;
  private int soundID;
  boolean loaded = false;
  
  private boolean playing = true;
  private boolean sounding = true;
  
  public SoundManager(Context context) {
    // (Background) Music
    player = MediaPlayer.create(context, R.raw.bgm1);
    
    // Sound (Effect)
    soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
    soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
      // @Override
      public void onLoadComplete(SoundPool soundPool, int sampleId,
          int status) {
        loaded = true;
      }
    });
    soundID = soundPool.load(context, R.raw.janken, 1);
  }

  public void startPlay() {
    player.setLooping(true);
    player.start();
    player.setVolume(0.3F, 0.3F);
  }

  public void stopPlay(){
    // player.stop();
    player.pause();
  }

  public void sound(){
    AudioManager audioManager = (AudioManager) _context.getSystemService(AUDIO_SERVICE);
    float actualVolume = (float) audioManager
        .getStreamVolume(AudioManager.STREAM_MUSIC);
    float maxVolume = (float) audioManager
        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    float volume = actualVolume / maxVolume;
    // Is the sound loaded already?
    if (loaded) {
      soundPool.play(soundID, volume, volume, 1, 0, 1f);
      Log.e("Test", "Played sound");
    }
  }
  
  public void setPlaying(boolean playing){
    this.playing = playing;
  }
  
  public boolean isPlaying(){
    return playing;
  }
  
  public void setSounding(boolean sounding){
    this.sounding = sounding;
  }
  
  public boolean isSounding(){
    return sounding;
  }
  
}
