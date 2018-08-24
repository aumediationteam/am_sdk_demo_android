package com.test.ad.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.automed.api.AMNetworkType;
import com.automed.api.AdError;
import com.automed.network.adcolony.AdColonyAMRewardedVideoSetting;
import com.automed.network.admob.AdmobAMRewardedVideoSetting;
import com.automed.network.applovin.ApplovinAMRewardedVideoSetting;
import com.automed.network.chartboost.ChartboostAMRewardedVideoSetting;
import com.automed.network.flurry.FlurryAMRewardedVideoSetting;
import com.automed.network.inmobi.InmobiAMRewardedVideoSetting;
import com.automed.network.mintegral.MintegralAMRewardedVideoSetting;
import com.automed.network.mopub.MopubAMRewardedVideoSetting;
import com.automed.network.tapjoy.TapjoyAMRewardedVideoSetting;
import com.automed.network.toutiao.TTAMRewardedVideoSetting;
import com.automed.network.unityads.UnityAdsAMRewardedVideoSetting;
import com.automed.network.vungle.VungleRewardedVideoSetting;
import com.automed.rewardvideo.api.AMRewardVideoAd;
import com.automed.rewardvideo.api.AMRewardVideoListener;


public class RewardVideoAdActivity extends Activity {

    private static String TAG = "RewardVideoAdActivity";
    String unitIds[] = new String[]{
            DemoApplicaion.mPlacementId_rewardvideo_all
            , DemoApplicaion.mPlacementId_rewardvideo_facebook
            , DemoApplicaion.mPlacementId_rewardvideo_admob
            , DemoApplicaion.mPlacementId_rewardvideo_inmobi
            , DemoApplicaion.mPlacementId_rewardvideo_flurry
            , DemoApplicaion.mPlacementId_rewardvideo_applovin
            , DemoApplicaion.mPlacementId_rewardvideo_mintegral
            , DemoApplicaion.mPlacementId_rewardvideo_mopub
            , DemoApplicaion.mPlacementId_rewardvideo_GDT
            , DemoApplicaion.mPlacementId_rewardvideo_CHARTBOOST
            , DemoApplicaion.mPlacementId_rewardvideo_TAPJOY
            , DemoApplicaion.mPlacementId_rewardvideo_IRONSOURCE
            , DemoApplicaion.mPlacementId_rewardvideo_UNITYAD
            , DemoApplicaion.mPlacementId_rewardvideo_vungle
            , DemoApplicaion.mPlacementId_rewardvideo_adcolony
            , DemoApplicaion.mPlacementId_rewardvideo_toutiao
    };

    String unitGroupName[] = new String[]{
            "All network",
            "facebook",
            "admob",
            "inmobi",
            "flurry",
            "applovin",
            "mintegral",
            "mopub",
            "gdt",
            "chartboost",
            "tapjoy",
            "ironsource",
            "unity3d",
            "vungle",
            "adcolony",
            "toutiao"
    };

    RadioGroup mRadioGroup;


    int mCurrentSelectIndex;


    AMRewardVideoAd mRewardVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mRadioGroup = (RadioGroup) findViewById(R.id.placement_select_group);

        for (int i = 0; i < unitIds.length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setPadding(20, 20, 20, 20);                 // 设置文字距离按钮四周的距离
            radioButton.setText(unitGroupName[i]);
            radioButton.setId(i);
            mRadioGroup.addView(radioButton);
        }

        mRadioGroup.check(0);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mCurrentSelectIndex = i;
                init();
            }
        });

//        mCurrentSelectIndex = 9;
        init();

        findViewById(R.id.is_ad_ready_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isReady = mRewardVideoAd.isAdReady();
                Toast.makeText(RewardVideoAdActivity.this, "video ad ready status:" + isReady, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.loadAd_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRewardVideoAd.load();
            }
        });

        findViewById(R.id.show_ad_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRewardVideoAd.show();
            }
        });

        findViewById(R.id.clean_ad_view_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRewardVideoAd.clean();
            }
        });

    }


    private void init() {
        if (mRewardVideoAd != null) {
            mRewardVideoAd.onDestory();
            mRewardVideoAd = null;
        }
        mRewardVideoAd = new AMRewardVideoAd(this, unitIds[mCurrentSelectIndex]);
        String userid = "test_userid_001";
        mRewardVideoAd.setUserData(userid, "");
        addSetting();
        mRewardVideoAd.setAdListener(new AMRewardVideoListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                Log.i(TAG, "onRewardedVideoAdLoaded");
                Toast.makeText(RewardVideoAdActivity.this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdFailed(AdError errorCode) {
                Log.i(TAG, "onRewardedVideoAdFailed error:" + errorCode.printStackTrace());
                Toast.makeText(RewardVideoAdActivity.this, "onRewardedVideoAdFailed:" + errorCode.printStackTrace(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdPlayStart() {
                Log.i(TAG, "onRewardedVideoAdPlayStart");
                Toast.makeText(RewardVideoAdActivity.this, "onRewardedVideoAdPlayStart", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdPlayEnd() {
                Log.i(TAG, "onRewardedVideoAdPlayEnd");
                Toast.makeText(RewardVideoAdActivity.this, "onRewardedVideoAdPlayEnd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdPlayFailed(AdError errorCode) {
                Log.i(TAG, "onRewardedVideoAdPlayFailed error:" + errorCode.printStackTrace());
                Toast.makeText(RewardVideoAdActivity.this, "onRewardedVideoAdPlayFailed:" + errorCode.printStackTrace(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdClosed(boolean isRewarded) {
                Log.i(TAG, "onRewardedVideoAdClosed reward:" + isRewarded);
                Toast.makeText(RewardVideoAdActivity.this, "onRewardedVideoAdClosed: isrewadr:" + isRewarded, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdPlayClicked() {
                Log.i(TAG, "onRewardedVideoAdPlayClicked");
                Toast.makeText(RewardVideoAdActivity.this, "onRewardedVideoAdPlayClicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addSetting() {

        AdmobAMRewardedVideoSetting _admobAMMediationSetting = new AdmobAMRewardedVideoSetting();
        mRewardVideoAd.addSetting(AMNetworkType.NETWORK_ADMOB, _admobAMMediationSetting);

        MintegralAMRewardedVideoSetting _mintegralAMMediationSetting = new MintegralAMRewardedVideoSetting();

        mRewardVideoAd.addSetting(AMNetworkType.NETWORK_MINTEGRAL, _mintegralAMMediationSetting);


        ApplovinAMRewardedVideoSetting _applovinAMMediationSetting = new ApplovinAMRewardedVideoSetting();

        mRewardVideoAd.addSetting(AMNetworkType.NETWORK_APPLOVIN, _applovinAMMediationSetting);


        FlurryAMRewardedVideoSetting _flurryAMMediationSetting = new FlurryAMRewardedVideoSetting();

        mRewardVideoAd.addSetting(AMNetworkType.NETWORK_FLURRY, _flurryAMMediationSetting);


        InmobiAMRewardedVideoSetting _inmobiAMMediationSetting = new InmobiAMRewardedVideoSetting();

        mRewardVideoAd.addSetting(AMNetworkType.NETWORK_INMOBI, _inmobiAMMediationSetting);


        MopubAMRewardedVideoSetting _mopubAMMediationSetting = new MopubAMRewardedVideoSetting();
        mRewardVideoAd.addSetting(AMNetworkType.NETWORK_MOPUB, _mopubAMMediationSetting);


        ChartboostAMRewardedVideoSetting _chartboostAMMediationSetting = new ChartboostAMRewardedVideoSetting();
        mRewardVideoAd.addSetting(AMNetworkType.NETWORK_CHARTBOOST, _chartboostAMMediationSetting);

        TapjoyAMRewardedVideoSetting _tapjoyAMMediationSetting = new TapjoyAMRewardedVideoSetting();
        mRewardVideoAd.addSetting(AMNetworkType.NETWORK_TAPJOY, _tapjoyAMMediationSetting);

//        IronsourceAMRewardedVideoSetting _ironsourceAMMediationSetting = new IronsourceAMRewardedVideoSetting();
//        mRewardVideoAd.addSetting(AMNetworkType.NETWORK_IRONSOURCE, _ironsourceAMMediationSetting);

        UnityAdsAMRewardedVideoSetting _unityAdAMMediationSetting = new UnityAdsAMRewardedVideoSetting();
        mRewardVideoAd.addSetting(AMNetworkType.NETWORK_UNITYADS, _unityAdAMMediationSetting);

        VungleRewardedVideoSetting vungleRewardVideoSetting = new VungleRewardedVideoSetting();
        vungleRewardVideoSetting.setOrientation(2);
        vungleRewardVideoSetting.setSoundEnable(true);
        mRewardVideoAd.addSetting(AMNetworkType.NETWORK_VUNGLE, vungleRewardVideoSetting);


        AdColonyAMRewardedVideoSetting adColonyAMRewardVideoSetting = new AdColonyAMRewardedVideoSetting();
        adColonyAMRewardVideoSetting.setEnableConfirmationDialog(false);
        adColonyAMRewardVideoSetting.setEnableResultsDialog(false);
        mRewardVideoAd.addSetting(AMNetworkType.NETWORK_ADCOLONY, adColonyAMRewardVideoSetting);

        TTAMRewardedVideoSetting ttAMRewardedVideoSetting = new TTAMRewardedVideoSetting();
        ttAMRewardedVideoSetting.setRequirePermission(true);
        mRewardVideoAd.addSetting(AMNetworkType.NETWORK_TOUTIAO, ttAMRewardedVideoSetting);


    }

    @Override
    protected void onResume() {
        super.onResume();
        mRewardVideoAd.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mRewardVideoAd.onPause();
    }
}

