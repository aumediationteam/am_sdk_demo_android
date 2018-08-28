package com.test.ad.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.automed.api.AMSDK;

public class MainActivity extends Activity {

    String[] itemFunction = new String[]{"GDPR Setting", "AM NativeAd Demo", "AM RewardedVideo Demo"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.item_grid_view);
        gridView.setAdapter(new GridAdapter());
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        AMSDK.showGdprAuth(MainActivity.this);
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, NativeAdActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, RewardVideoAdActivity.class));
                        break;
                }
            }
        });

    }

    class GridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return itemFunction.length;
        }

        @Override
        public Object getItem(int position) {
            return itemFunction[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView button = new TextView(MainActivity.this);
            button.setText(itemFunction[position]);
            int height = getResources().getDisplayMetrics().widthPixels / 2;
            button.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, height));
            button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            button.setTextColor(0xff000000);
            button.setGravity(Gravity.CENTER);
            button.setBackgroundColor(0xffededed);
            return button;
        }
    }
}
