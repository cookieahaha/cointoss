package me.kukkii.cointoss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends FragmentActivity{

  public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    if (findViewById(R.id.main_fragment) != null) {
      if (savedInstanceState != null) {
        return;
      }

      SplashFragment fragment = new SplashFragment();
            
      getSupportFragmentManager().beginTransaction().add(R.id.main_fragment, fragment).commit();
    }
  }

}
