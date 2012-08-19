// $Id$
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

public class StatusFragment extends Fragment {

  private int numPoint;
  private int numWin;
  private int numGame;
  private int numSeq;

  private Activity activity;

  private TextView pointField;
  private TextView winField;
  private TextView gameField;
  private TextView seqField;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    activity = getActivity();
    return inflater.inflate(R.layout.status_fragment, container, false);
  }

  public void onStart() {
    super.onStart();

    int numPoint = 0;
    int numWin = 0;
    int numGame = 0;
    int numSeq = 0;

    pointField = (TextView) activity.findViewById(R.id.point_field);
    winField = (TextView) activity.findViewById(R.id.win_field);
    gameField = (TextView) activity.findViewById(R.id.game_field);
    seqField = (TextView) activity.findViewById(R.id.seq_field);

    setFields();
  }

  public void setFields() {
    pointField.setText("" + numPoint);
    winField.setText("" + numWin);
    gameField.setText("" + numGame);
    seqField.setText("" + numSeq);
    Log.i("cointoss:status", "" + numPoint + " " + numWin + " " + numGame + " " + numSeq);
  }

  public void addPoint(int n) {
    numPoint += n;
  }
  public void addWin(int n) {
    numWin += n;
  }
  public void addGame(int n) {
    numGame += n;
  }
  public void setSeq(int n) {
    if (n > numSeq) {
      numSeq = n;
    }
  }
}
