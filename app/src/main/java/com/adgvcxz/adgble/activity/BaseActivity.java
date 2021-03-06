package com.adgvcxz.adgble.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;

import com.adgvcxz.adgble.R;
import com.adgvcxz.adgble.util.ThemeUtil;
import com.adgvcxz.adgble.util.TypefaceSpan;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;


/**
 * zhaowei
 * Created by zhaowei on 2016/10/15.
 */

public class BaseActivity extends AppCompatActivity {

    ArrayList<Disposable> disposables;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, ThemeUtil.sColorMainBackground.get(ThemeUtil.theme.get()))));
        disposables = new ArrayList<>();
    }

    void setActionBarTitle(@StringRes int res) {
        if (getSupportActionBar() != null) {
            SpannableString s = new SpannableString(getString(res));
            s.setSpan(new TypefaceSpan(this, "hobostd.otf"), 0, s.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            getSupportActionBar().setTitle(s);
        }
    }

    void setActionBarTitle(String res) {
        if (getSupportActionBar() != null) {
            SpannableString s = new SpannableString(res);
            s.setSpan(new TypefaceSpan(this, "hobostd.otf"), 0, s.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            getSupportActionBar().setTitle(s);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (Disposable disposable : disposables) {
            disposable.dispose();
        }
    }
}
