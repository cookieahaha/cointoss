package me.kukkii.cointoss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameFragment extends Fragment implements OnClickListener {

  private CoinType type;
  private Coin guess;
  private Coin coin;
  private int result = -1;
  private String text= "";
  private int nLines = 0;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    Log.i("cointoss", "Bundle saveInstanceState=" + savedInstanceState);

    type = (CoinType) getArguments().getSerializable("type");

    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.game_fragment, container, false);
  }

  public void onStart() {
    super.onStart();

    int frontId = 0;
    int backId = 0;
    switch (type) {
    case PENNY :
      frontId = R.drawable.us_penny_front;
       backId = R.drawable.us_penny_back;
      break;
    case NICKEL :
      frontId = R.drawable.us_nickel_front;
       backId = R.drawable.us_nickel_back;
      break;
    case DIME :
      frontId = R.drawable.us_dime_front;
       backId = R.drawable.us_dime_back;
      break;
    case QUARTER :
      frontId = R.drawable.us_quarter_front;
       backId = R.drawable.us_quarter_back;
      break;
    case HALF :
      frontId = R.drawable.us_half_dollar_front;
       backId = R.drawable.us_half_dollar_back;
      break;
    case DOLLAR :
      frontId = R.drawable.us_dollar_coin_front;
       backId = R.drawable.us_dollar_coin_back;
      break;
    }

    ImageButton frontButton = (ImageButton) getActivity().findViewById(R.id.button_HEAD);
    frontButton.setImageResource(frontId);
    frontButton.setClickable(true);
    frontButton.setOnClickListener(this);

    ImageButton  backButton = (ImageButton) getActivity().findViewById(R.id.button_TAIL);
    backButton.setImageResource(backId);
    backButton.setClickable(true);
    backButton.setOnClickListener(this);
  }

  public void onClick(View view){
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
    TextView textView = (TextView) getActivity().findViewById(R.id.text);
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
