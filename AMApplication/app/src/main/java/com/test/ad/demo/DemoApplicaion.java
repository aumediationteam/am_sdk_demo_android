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

    //线上
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
    public static final String mPlacementId_native_mobpower = "b5bc6b08d181dd";
    public static final String mPlacementId_native_yeahmobi = "b5bc854d429053";
    public static final String mPlacementId_native_appnext = "b5bc854c0a713b";


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
    public static final String mPlacementId_rewardvideo_uniplay = "b5bc6b205c6ade";
    public static final String mPlacementId_rewardvideo_oneway = "b5bc6b1fab3ca3";
    public static final String mPlacementId_rewardvideo_ksyun = "b5bc6b1ef044df";
    public static final String mPlacementId_rewardvideo_mobpower = "b5bc6b197615b7";
    public static final String mPlacementId_rewardvideo_yeahmobi = "b5bc8572086c1d";
    public static final String mPlacementId_rewardvideo_appnext = "b5bc85701c4dd9";

    //banner正式
    public static final String mPlacementId_banner_facebook = "b5bc85b1162a08";
    public static final String mPlacementId_banner_admob = "b5bc85b3c0dbbf";
    public static final String mPlacementId_banner_inmobi = "b5bc85b4edf451";
    public static final String mPlacementId_banner_flurry = "b5bc85b69ae74f";
    public static final String mPlacementId_banner_applovin = "b5bc85b8239d8c";
    public static final String mPlacementId_banner_mopub = "b5bc85b9c6eade";
    public static final String mPlacementId_banner_GDT = "b5bc85bb1cfd21";
    public static final String mPlacementId_banner_all = "b5bc85cba8e958";
    public static final String mPlacementId_banner_CHARTBOOST = "";
    public static final String mPlacementId_banner_TAPJOY = "";
    public static final String mPlacementId_banner_IRONSOURCE = "";
    public static final String mPlacementId_banner_UNITYAD = "";
    public static final String mPlacementId_banner_vungle = "";
    public static final String mPlacementId_banner_adcolony = "";
    public static final String mPlacementId_banner_toutiao = "b5bc85c7c0bd77";
    public static final String mPlacementId_banner_uniplay = "b5bc85c901d864";
    public static final String mPlacementId_banner_mobpower = "b5bc85ca8142c6";
    public static final String mPlacementId_banner_yeahmobi = "b5bc85cdfdac36";
    public static final String mPlacementId_banner_appnext = "b5bc85ccd2b8c6";

    //interstital正式
    public static final String mPlacementId_interstitial_facebook = "b5bc85d951a506";
    public static final String mPlacementId_interstitial_admob = "b5bc85dab66e99";
    public static final String mPlacementId_interstitial_inmobi = "b5bc85dc08e0ab";
    public static final String mPlacementId_interstitial_flurry = "b5bc85dd039bbf";
    public static final String mPlacementId_interstitial_applovin = "b5bc85ddfa843a";
    public static final String mPlacementId_interstitial_mintegral = "b5bc85e0c5cf73";
    public static final String mPlacementId_interstitial_video_mintegral = "b5bc85e222ac09";
    public static final String mPlacementId_interstitial_mopub = "b5bc85e389d679";
    public static final String mPlacementId_interstitial_GDT = "b5bc85e4e9041b";
    public static final String mPlacementId_interstitial_all = "b5bc85d6572e1b";
    public static final String mPlacementId_interstitial_CHARTBOOST = "b5bc85e5f34d7c";
    public static final String mPlacementId_interstitial_TAPJOY = "b5bc85e6f94937";
    public static final String mPlacementId_interstitial_IRONSOURCE = "b5bc85e8bca267";
    public static final String mPlacementId_interstitial_vungle = "b5bc85e9b1f70c";
    public static final String mPlacementId_interstitial_adcolony = "b5bc85eac49c74";
    public static final String mPlacementId_interstitial_toutiao = "b5bc85ebd371f7";
    public static final String mPlacementId_interstitial_video_toutiao = "b5bc85eccade1c";
    public static final String mPlacementId_interstitial_uniplay = "b5bc85edb73c0e";
    public static final String mPlacementId_interstitial_oneway = "b5bc85eec3fa84";
    public static final String mPlacementId_interstitial_mobpower = "b5bc85f01e8140";
    public static final String mPlacementId_interstitial_yeahmobi = "b5bc85f2416e86";
    public static final String mPlacementId_interstitial_appnext = "b5bc85f1451d44";


//    //native测试
//    public static final String appid = "a5b7e203ca55fd";
//    public static final String appKey = "64c685c78eb04ced8a26af6b7d28aab8";
//    public static final String mPlacementId_native_all = "b5b7e20809cc35";
//    public static final String mPlacementId_native_facebook = "b5b7e2099d6771";
//    public static final String mPlacementId_native_admob = "b5b7e20a722b78";
//    public static final String mPlacementId_native_inmobi = "b5b7e20b4e3cd5";
//    public static final String mPlacementId_native_flurry = "b5b7e20c14ef25";
//    public static final String mPlacementId_native_applovin = "b5b7e20d675d37";
//    public static final String mPlacementId_native_mintegral = "b5b7e21121e8fd";
//    public static final String mPlacementId_native_GDT = "b5b7e2138438ae";
//    public static final String mPlacementId_native_mopub = "b5b7e212e46759";
//    public static final String mPlacementId_native_mobpower = "b5bc480058037a";
//    public static final String mPlacementId_native_yeahmobi = "b5bc7f66f22e47";
//    public static final String mPlacementId_native_appnext = "b5bc6d38fb3278";
//
//
//    //rv测试
//    public static final String mPlacementId_rewardvideo_all = "b5b7e21676eb2a";
//    public static final String mPlacementId_rewardvideo_facebook = "b5b7e217fcb7f4";
//    public static final String mPlacementId_rewardvideo_admob = "b5b7e219a4e2ad";
//    public static final String mPlacementId_rewardvideo_inmobi = "b5b7e21a8b4f74";
//    public static final String mPlacementId_rewardvideo_flurry = "b5b7e21b6232e5";
//    public static final String mPlacementId_rewardvideo_applovin = "b5b7e22f32fb5a";
//    public static final String mPlacementId_rewardvideo_mintegral = "b5b7e21d9c2bd1";
//    public static final String mPlacementId_rewardvideo_mopub = "b5b7e221317a45";
//    public static final String mPlacementId_rewardvideo_GDT = "b5b7fb6132dc9e";
//    public static final String mPlacementId_rewardvideo_CHARTBOOST = "b5b7e2227cf832";
//    public static final String mPlacementId_rewardvideo_TAPJOY = "b5b7e223912b03";
//    public static final String mPlacementId_rewardvideo_IRONSOURCE = "b5b7e224b74a27";
//    public static final String mPlacementId_rewardvideo_UNITYAD = "b5b7e2258e99cb";
//    public static final String mPlacementId_rewardvideo_vungle = "b5b7e226ed53b5";
//    public static final String mPlacementId_rewardvideo_adcolony = "b5b7e2291a08ac";
//    public static final String mPlacementId_rewardvideo_toutiao = "b5b7e22c924197";
//    public static final String mPlacementId_rewardvideo_uniplay = "b5bc4814d14c66";
//    public static final String mPlacementId_rewardvideo_oneway = "b5bc481579fa11";
//    public static final String mPlacementId_rewardvideo_ksyun = "b5bc48165cf3c7";
//    public static final String mPlacementId_rewardvideo_mobpower = "b5bc48171b6e07";
//    public static final String mPlacementId_rewardvideo_yeahmobi = "b5bc7f68127f2c";
//    public static final String mPlacementId_rewardvideo_appnext = "b5bc6d39f556e0";
//
//    //banner测试
//    public static final String mPlacementId_banner_facebook = "b5bc48337d2ca4";
//    public static final String mPlacementId_banner_admob = "b5bc48354a83d3";
//    public static final String mPlacementId_banner_inmobi = "b5bc48363ee007";
//    public static final String mPlacementId_banner_flurry = "b5bc48370b2a7d";
//    public static final String mPlacementId_banner_applovin = "b5bc4837ca3cdd";
//    public static final String mPlacementId_banner_mopub = "b5bc48391396a6";
//    public static final String mPlacementId_banner_GDT = "b5bc483bc61a8e";
//    public static final String mPlacementId_banner_all = "b5bc48410893b7";
//    public static final String mPlacementId_banner_CHARTBOOST = "";
//    public static final String mPlacementId_banner_TAPJOY = "";
//    public static final String mPlacementId_banner_IRONSOURCE = "";
//    public static final String mPlacementId_banner_UNITYAD = "";
//    public static final String mPlacementId_banner_vungle = "";
//    public static final String mPlacementId_banner_adcolony = "";
//    public static final String mPlacementId_banner_toutiao = "b5bc483cdcb1e4";
//    public static final String mPlacementId_banner_uniplay = "b5bc483ea49e47";
//    public static final String mPlacementId_banner_mobpower = "b5bc484018e13c";
//    public static final String mPlacementId_banner_yeahmobi = "b5bc7f694ddcc9";
//    public static final String mPlacementId_banner_appnext = "b5bc6d3ac8ca11";
//
//    //interstital测试
//    public static final String mPlacementId_interstitial_facebook = "b5bc69ba60a2fb";
//    public static final String mPlacementId_interstitial_admob = "b5bc69bbac3184";
//    public static final String mPlacementId_interstitial_inmobi = "b5bc69bc7d8a79";
//    public static final String mPlacementId_interstitial_flurry = "b5bc69be56a1f3";
//    public static final String mPlacementId_interstitial_applovin = "b5bc69bf26ed9d";
//    public static final String mPlacementId_interstitial_mintegral = "b5bc69c0cd8067";
//    public static final String mPlacementId_interstitial_video_mintegral = "b5bc69c1dc9da4";
//    public static final String mPlacementId_interstitial_mopub = "b5bc69c86ee45b";
//    public static final String mPlacementId_interstitial_GDT = "b5bc69cacd5320";
//    public static final String mPlacementId_interstitial_all = "b5bc69b69b15d2";
//    public static final String mPlacementId_interstitial_CHARTBOOST = "b5bc69cd534d21";
//    public static final String mPlacementId_interstitial_TAPJOY = "b5bc69ce250f18";
//    public static final String mPlacementId_interstitial_IRONSOURCE = "b5bc69cf325860";
//    public static final String mPlacementId_interstitial_vungle = "b5bc69d15f14a5";
//    public static final String mPlacementId_interstitial_adcolony = "b5bc69d2d02860";
//    public static final String mPlacementId_interstitial_toutiao = "b5bc69d4de75c8";
//    public static final String mPlacementId_interstitial_video_toutiao = "b5bc69d5e68423";
//    public static final String mPlacementId_interstitial_uniplay = "b5bc69d74aa48a";
//    public static final String mPlacementId_interstitial_oneway = "b5bc69d887d0dd";
//    public static final String mPlacementId_interstitial_mobpower = "b5bc69d9680c64";
//    public static final String mPlacementId_interstitial_yeahmobi = "b5bc7f6a7c6e85";
//    public static final String mPlacementId_interstitial_appnext = "b5bc6d3c598b80";

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
