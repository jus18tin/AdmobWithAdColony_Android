package com.example.junhuali.testadmob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.*;
import com.google.android.gms.ads.reward.*;
import com.jirbo.adcolony.AdColonyAdapter;
import com.jirbo.adcolony.AdColonyBundleBuilder;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener{

    private RewardedVideoAd mAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAd = MobileAds.getRewardedVideoAdInstance(this);
        mAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();
    }

    private void loadRewardedVideoAd() {
        mAd.loadAd("ca-app-pub-4891026035420920/4645296696", new AdRequest.Builder().build());

        //change zone
//        AdColonyBundleBuilder.setZoneId("vz8b852a9c4aac480e88");
//        AdRequest adRequest = new AdRequest.Builder().addNetworkExtrasBundle(AdColonyAdapter.class, AdColonyBundleBuilder.build()).build();
//        mAd.loadAd("ca-app-pub-4891026035420920/4645296696", adRequest);
    }

    public void onDisplayButtonClicked(View view) {
        if (mAd.isLoaded()) {
            mAd.show();
        }
    }

    @Override
    public void onRewarded(RewardItem reward) {
        Toast.makeText(this, "======  onRewarded! currency: " + reward.getType() + "  amount:  ====" +
                reward.getAmount(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        Toast.makeText(this, "onRewardedVideoAdLeftApplication",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Toast.makeText(this, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        Toast.makeText(this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdOpened() {
        Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoStarted() {
        Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }
}
