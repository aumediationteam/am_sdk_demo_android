package com.test.ad.demo;

import android.support.multidex.MultiDexApplication;

import com.automed.api.AMSDK;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;
import com.qq.e.ads.cfg.MultiProcessFlag;

/**
 * Created by Z on 2018/1/10.
 */

public class DemoApplicaion extends MultiDexApplication {

    //native线上
    public static final String appid = "a5b7fb36aa09e6";
    public static final String appKey = "1c8530c299b33df2a94cadd393dce60e";
    public static final String mPlacementId_native_all = "b5b7fb3dc00f2d";
    public static final String mPlacementId_native_facebook = "b5b7fb4021aa89";
    public static final String mPlacementId_native_admob = "b5b7fb40dbcc11";
    public static final String mPlacementId_native_inmobi = "b5b7fb41c80e5b";
    public static final String mPlacementId_native_flurry = "b5b7fb42798964";
    public static final String mPlacementId_native_applovin = "b5b7fb436be278";
    public static final String mPlacementId_native_mintegral = "b5b7fb45266108";
    public static final String mPlacementId_native_GDT = "b5b7fb479ab45a";
    public static final String mPlacementId_native_mopub = "b5b7fb47226236";


    //rv线上
    public static final String mPlacementId_rewardvideo_all = "b5b7fb4a004d1c";
    public static final String mPlacementId_rewardvideo_facebook = "b5b7fb4b96b23b";
    public static final String mPlacementId_rewardvideo_admob = "b5b7fb4c5b447e";
    public static final String mPlacementId_rewardvideo_inmobi = "b5b7fb4ddbfe50";
    public static final String mPlacementId_rewardvideo_flurry = "b5b7fb4ece82a9";
    public static final String mPlacementId_rewardvideo_applovin = "b5b7fb4fb3b459";
    public static final String mPlacementId_rewardvideo_mintegral = "b5b7fb5f21d17a";
    public static final String mPlacementId_rewardvideo_mopub = "b5b7fb6059097f";
    public static final String mPlacementId_rewardvideo_GDT = "b5b7fb6132dc9e";
    public static final String mPlacementId_rewardvideo_CHARTBOOST = "b5b7fb6210e1de";
    public static final String mPlacementId_rewardvideo_TAPJOY = "b5b7fb62e8cf90";
    public static final String mPlacementId_rewardvideo_IRONSOURCE = "b5b7fb63929536";
    public static final String mPlacementId_rewardvideo_UNITYAD = "b5b7fb6491e555";
    public static final String mPlacementId_rewardvideo_vungle = "b5b7fb65ec4669";
    public static final String mPlacementId_rewardvideo_adcolony = "b5b7fb66d12f92";
    public static final String mPlacementId_rewardvideo_toutiao = "b5b7fb67ddb2a0";


    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(getApplicationContext());
        Fresco.initialize(getApplicationContext());
        AMSDK.init(this, appid, appKey);
        MultiProcessFlag.setMultiProcess(true);
        AMSDK.setNetworkLogDebug(true);

    }
}
