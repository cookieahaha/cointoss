package me.kukkii.cointoss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

public class AdFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
   /*
    AdView adView = (AdView) getActivity().findViewById(R.id.adView);
    adView.loadAd(new AdRequest());
   */

    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.ad_fragment, container, false);
  }

}
