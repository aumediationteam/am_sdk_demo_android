package com.test.ad.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.automed.api.AdError;
import com.automed.nativead.api.AMNative;
import com.automed.nativead.api.AMNativeAdView;
import com.automed.nativead.api.AMNativeNetworkListener;
import com.automed.nativead.api.NativeAd;
import com.automed.network.gdt.GDTAMConst;
import com.qq.e.ads.nativ.ADSize;

import java.util.HashMap;
import java.util.Map;

public class NativeAdActivity extends Activity {

    String unitIds[] = new String[]{
            DemoApplicaion.mPlacementId_native_all
            , DemoApplicaion.mPlacementId_native_facebook
            , DemoApplicaion.mPlacementId_native_admob
            , DemoApplicaion.mPlacementId_native_inmobi
            , DemoApplicaion.mPlacementId_native_flurry
            , DemoApplicaion.mPlacementId_native_applovin
            , DemoApplicaion.mPlacementId_native_mintegral
            , DemoApplicaion.mPlacementId_native_mopub
            , DemoApplicaion.mPlacementId_native_GDT
            , DemoApplicaion.mPlacementId_native_mobpower
            , DemoApplicaion.mPlacementId_native_yeahmobi
            , DemoApplicaion.mPlacementId_native_appnext

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
            "mobpower",
            "yeahmobi",
            "appnext"
    };

    AMNative amNatives[] = new AMNative[unitIds.length];
    AMNativeAdView amNativeAdView;
    NativeAd mNativeAd;

    RadioGroup mRadioGroup;

    int mCurrentSelectIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_native);

        mRadioGroup = (RadioGroup) findViewById(R.id.placement_select_group);

        for (int i = 0; i < unitIds.length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setPadding(20, 20, 20, 20);                 // 设置文字距离按钮四周的距离
            radioButton.setText(unitGroupName[i]);
            radioButton.setId(i + 1000);
            mRadioGroup.addView(radioButton);
        }

        mRadioGroup.check(0);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mCurrentSelectIndex = i - 1000;
            }
        });

        final AMRender amRender = new AMRender(this);

        Map<String, Object> localMap = null;
        for (int i = 0; i < unitIds.length; i++) {
            amNatives[i] = new AMNative(this, unitIds[i], new AMNativeNetworkListener() {
                @Override
                public void onNativeAdLoaded(NativeAd nativeAd) {
                    if (nativeAd != null) {
                        mNativeAd = nativeAd;
                        mNativeAd.renderAdView(amNativeAdView, amRender);
                        amNativeAdView.setVisibility(View.VISIBLE);
                        mNativeAd.prepare(amNativeAdView);
                    }
                }

                @Override
                public void onNativeAdLoadFail(AdError adError) {
                    Toast.makeText(NativeAdActivity.this, "load fail...：" + adError.getDesc(), Toast.LENGTH_LONG).show();

                }
            });

            //如果是广点通的 需要配置额外配置
            if (i == GDTAMConst.getGDTType()) {
                localMap = new HashMap<>();
                localMap.put(GDTAMConst.ADTYPE, "3");
                localMap.put(GDTAMConst.AD_WIDTH, ADSize.FULL_WIDTH);//
                localMap.put(GDTAMConst.AD_HEIGHT, ADSize.FULL_WIDTH);//
                amNatives[i].setLocalExtra(localMap);
            }

            if (amNativeAdView == null) {
                amNativeAdView = new AMNativeAdView(this);
            }
        }


        findViewById(R.id.loadAd_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> maps = new HashMap<>();
                maps.put("age", "22");
                maps.put("sex", "lady");
                amNatives[mCurrentSelectIndex].makeAdRequest(maps);
            }
        });

        findViewById(R.id.loadcache_ad_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NativeAd nativeAd = amNatives[mCurrentSelectIndex].showAds();
                if (nativeAd != null) {
                    mNativeAd = nativeAd;
                    mNativeAd.renderAdView(amNativeAdView, amRender);
                    amNativeAdView.setVisibility(View.VISIBLE);
                    mNativeAd.prepare(amNativeAdView);
                } else {
                    Toast.makeText(NativeAdActivity.this, "this placement no cache!", Toast.LENGTH_LONG).show();

                }

            }
        });

        amNativeAdView.setVisibility(View.GONE);
        ((FrameLayout) findViewById(R.id.ad_container)).addView(amNativeAdView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mNativeAd != null) {
            mNativeAd.destory();
        }
    }
}
