package com.thecoderok.game2048;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    MainActivity mContext;

    /** Instantiate the interface and set the context */
    WebAppInterface(MainActivity c) {
        mContext = c;
    }

    @JavascriptInterface
    public void showInterstitial() {
        mContext.runOnUiThread(new Runnable() {
            public void run() {
                mContext.showAd();
            }
        });
    }
}
