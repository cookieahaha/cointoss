package me.kukkii.cointoss;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Cointoss extends Activity{

  private Coin guess;
  private Coin coin;
  private int result = -1;
  private String text= "";
  private int nLines = 0;

  public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }

  public void guess(View view){
    guess = null;
    int id = view.getId();
    if(id==R.id.button_HEAD){
      guess = Coin.HEAD;
    }
    if(id==R.id.button_TAIL){
      guess = Coin.TAIL;
    }
    game();
  }

  public void coin(){
    int random = (int)(Math.random()*2);
    if(random == 1){
      coin = Coin.HEAD;
    }
    else{
      coin = Coin.TAIL;
    }
  }

  public void compare(Coin guess,Coin coin){
    if(guess == coin){
      result = 1;   //win
    }
    if(guess != coin){
      result = 0;   //lose
    }
  }

  public void showResult(int result){
    TextView textView = (TextView) findViewById(R.id.text);
    nLines += 1;
    if (nLines > 10) {
      nLines -= 10;
      text = "";
    }
    text += "Your guess is " + ((guess == Coin.HEAD)?"FRONT":"BACK") + ".";
    if(result == 1){
      text += " You WON!\n";
    }
    if(result == 0){
      text += " You LOST!\n";
    }
    textView.setText(text);
  }

  public void game(){
    coin();
    compare(guess,coin);
    showResult(result);
  }

}
