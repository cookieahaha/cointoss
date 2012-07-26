package me.kukkii.cointoss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class SplashActivity extends Activity{

  protected boolean _active = true;
  protected int _splashTime = 5000; // 5 secs - time to display the splash screen in ms


  public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);

   /*
    final Intent intent = new Intent(this, Cointoss.class);

    Thread splashTread = new Thread() {
      public void run() {
        try {
          int waited = 0;
          while(_active && (waited < _splashTime)) {
            sleep(100);
            if(_active) {
              waited += 100;
            }
          }
        } catch(InterruptedException e) {
          // do nothing
        } finally {
          finish();
          startActivity(intent);
          // stop();
        }
      }
    };
    splashTread.start();
   */

  }

  /*
  @Override
  public boolean onTouchEvent(MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_DOWN) {
        _active = false;
    }
    return true;
  }
  */

  public void play(View view) {
    Intent intent = new Intent(this, Cointoss.class);
    CoinType type = CoinType.UNKNOWN;
    switch (view.getId()) {
    case R.id.button_penny :
      type = CoinType.PENNY;
      break;
    case R.id.button_nickel :
      type = CoinType.NICKEL;
      break;
    case R.id.button_dime :
      type = CoinType.DIME;
      break;
    case R.id.button_quarter :
      type = CoinType.QUARTER;
      break;
    case R.id.button_half :
      type = CoinType.HALF;
      break;
    case R.id.button_dollar :
      type = CoinType.DOLLAR;
      break;
    default :
      type = CoinType.UNKNOWN;
      break;
    }
    intent.putExtra("type", type);
    startActivity(intent);
  }

}
