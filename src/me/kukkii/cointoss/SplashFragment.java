package me.kukkii.cointoss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class SplashFragment extends Fragment implements OnClickListener {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.splash_fragment, container, false);
    return view;
  }

  public void onStart() {
    super.onStart();

    int[] buttonIds = {
      R.id.button_penny,
      R.id.button_nickel,
      R.id.button_dime,
      R.id.button_quarter,
      R.id.button_half,
      R.id.button_dollar
    };
    for (int id : buttonIds) {
      Button button = (Button) getActivity().findViewById(id);
      Log.i("cointoss", "" + id + " -> " + button);
      button.setClickable(true);
      button.setOnClickListener(this);
    }

  }

  public void onClick(View view) {
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

    GameFragment fragment = new GameFragment();
    Bundle args = new Bundle();
    args.putSerializable("type", type);
    fragment.setArguments(args);

    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.main_fragment, fragment);
    transaction.addToBackStack(null);
    
    // Commit the transaction
    transaction.commit();
  }

}
