package com.test.ad.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
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
            AMApplication.PLACEMENTID_NATIVE_ALL
            , AMApplication.PLACEMENTID_NATIVE_FACEBOOK
            , AMApplication.PLACEMENTID_NATIVE_ADMOB
            , AMApplication.PLACEMENTID_NATIVE_INMOBI
            , AMApplication.PLACEMENTID_NATIVE_FLURRY
            , AMApplication.PLACEMENTID_NATIVE_APPLOVIN
            , AMApplication.PLACEMENTID_NATIVE_MINTEGRAL
            , AMApplication.PLACEMENTID_NATIVE_MOPUB
            , AMApplication.PLACEMENTID_NATIVE_GDT

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
            "GDT"
    };

    AMNative amNatives[] = new AMNative[unitIds.length];
    AMNativeAdView amNativeAdView;
    NativeAd mNativeAd;

    int mCurrentSelectIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_native);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // 声明一个ArrayAdapter用于存放简单数据
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                NativeAdActivity.this, android.R.layout.simple_spinner_dropdown_item,
                unitGroupName);
        // 把定义好的Adapter设定到spinner中
        spinner.setAdapter(adapter);
        // 为第一个Spinner设定选中事件
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // 在选中之后触发
                Toast.makeText(NativeAdActivity.this,
                        parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
                mCurrentSelectIndex = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // 这个一直没有触发，我也不知道什么时候被触发。
                //在官方的文档上说明，为back的时候触发，但是无效，可能需要特定的场景
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
