package com.test.ad.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.util.Log;

import com.automed.api.AdError;
import com.automed.banner.api.AMBannerListener;
import com.automed.banner.api.AMBannerView;

import java.util.HashMap;

public class BannerAdActivity extends Activity {


    String unitIds[] = new String[]{
            DemoApplicaion.mPlacementId_banner_all
            , DemoApplicaion.mPlacementId_banner_admob
            , DemoApplicaion.mPlacementId_banner_GDT
            , DemoApplicaion.mPlacementId_banner_toutiao
            , DemoApplicaion.mPlacementId_banner_uniplay
            , DemoApplicaion.mPlacementId_banner_facebook
            , DemoApplicaion.mPlacementId_banner_inmobi
            , DemoApplicaion.mPlacementId_banner_flurry
            , DemoApplicaion.mPlacementId_banner_applovin
            , DemoApplicaion.mPlacementId_banner_mopub
            , DemoApplicaion.mPlacementId_banner_mobpower
            , DemoApplicaion.mPlacementId_banner_yeahmobi
            , DemoApplicaion.mPlacementId_banner_appnext};

    String unitGroupName[] = new String[]{
            "All",
            "Admob",
            "GDT",
            "Toutiao",
            "Uniplay",
            "Facebook",
            "Inmobi",
            "Flurry",
            "Applovin",
            "Mopub",
            "Mobpower",
            "yeahmobi",
            "appnext"
    };

    AMBannerView mBannerView;

    int mCurrentSelectIndex;
    boolean hasAddBannerView = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_banner);

        Spinner spinner = (Spinner) findViewById(R.id.banner_spinner);
        final FrameLayout frameLayout = findViewById(R.id.adview_container);
        mBannerView = new AMBannerView(this);
        mBannerView.setBannerAdListener(new AMBannerListener() {
            @Override
            public void onBannerLoaded() {
                Log.i("BannerAdActivity", "onBannerLoaded");
                Toast.makeText(BannerAdActivity.this,
                        "onBannerLoaded",
                        Toast.LENGTH_SHORT).show();
                if (!hasAddBannerView) {
                    frameLayout.addView(mBannerView);
                    hasAddBannerView = true;
                }
            }

            @Override
            public void onBannerFailed(AdError adError) {
                Log.i("BannerAdActivity", "onBannerFailed：" + adError.printStackTrace());
                Toast.makeText(BannerAdActivity.this,
                        "onBannerFailed",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBannerClicked() {
                Log.i("BannerAdActivity", "onBannerClicked");
                Toast.makeText(BannerAdActivity.this,
                        "onBannerClicked",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBannerShow() {
                Log.i("BannerAdActivity", "onBannerShow");
                Toast.makeText(BannerAdActivity.this,
                        "onBannerShow",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBannerClose() {
                Log.i("BannerAdActivity", "onBannerClose");
                Toast.makeText(BannerAdActivity.this,
                        "onBannerClose",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // 声明一个ArrayAdapter用于存放简单数据
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                BannerAdActivity.this, android.R.layout.simple_spinner_dropdown_item,
                unitGroupName);
        // 把定义好的Adapter设定到spinner中
        spinner.setAdapter(adapter);
        // 为第一个Spinner设定选中事件
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // 在选中之后触发
                Toast.makeText(BannerAdActivity.this,
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


        findViewById(R.id.loadAd_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> maps = new HashMap<>();
                mBannerView.setUnitId(unitIds[mCurrentSelectIndex]);
                mBannerView.loadAd();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
