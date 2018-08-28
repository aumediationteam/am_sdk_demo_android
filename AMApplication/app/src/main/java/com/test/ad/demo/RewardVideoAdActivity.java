package com.test.ad.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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
            AMApplication.PLACEMENTID_REWARDVIDEO_ALL
            , AMApplication.PLACEMENTID_REWARDVIDEO_FACEBOOK
            , AMApplication.PLACEMENTID_REWARDVIDEO_ADMOB
            , AMApplication.PLACEMENTID_REWARDVIDEO_INMOBI
            , AMApplication.PLACEMENTID_REWARDVIDEO_FLURRY
            , AMApplication.PLACEMENTID_REWARDVIDEO_APPLOVIN
            , AMApplication.PLACEMENTID_REWARDVIDEO_MINTEGRAL
            , AMApplication.PLACEMENTID_REWARDVIDEO_MOPUB
            , AMApplication.PLACEMENTID_REWARDVIDEO_GDT
            , AMApplication.PLACEMENTID_REWARDVIDEO_CHARTBOOST
            , AMApplication.PLACEMENTID_REWARDVIDEO_TAPJOY
            , AMApplication.PLACEMENTID_REWARDVIDEO_IRONSOURCE
            , AMApplication.PLACEMENTID_REWARDVIDEO_UNITYAD
            , AMApplication.PLACEMENTID_REWARDVIDEO_VUNGLE
            , AMApplication.PLACEMENTID_REWARDVIDEO_ADCOLONY
            , AMApplication.PLACEMENTID_REWARDVIDEO_TOUTIAO
    };

    String unitGroupName[] = new String[]{
            "All network",
            "Facebook",
            "Admob",
            "Inmobi",
            "Flurry",
            "Applovin",
            "Mintegral",
            "Mopub",
            "GDT",
            "Chartboost",
            "Tapjoy",
            "iIronsource",
            "Unity3d",
            "Vungle",
            "Adcolony",
            "Toutiao"
    };


    int mCurrentSelectIndex;


    AMRewardVideoAd mRewardVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Spinner spinner = (Spinner) findViewById(R.id.video_spinner);
        // 声明一个ArrayAdapter用于存放简单数据
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                RewardVideoAdActivity.this, android.R.layout.simple_spinner_dropdown_item,
                unitGroupName);
        // 把定义好的Adapter设定到spinner中
        spinner.setAdapter(adapter);
        // 为第一个Spinner设定选中事件
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // 在选中之后触发
                Toast.makeText(RewardVideoAdActivity.this,
                        parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
                mCurrentSelectIndex = position;
                init();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

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
        String userid = "am_userid";
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

