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

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        mContext.runOnUiThread(new Runnable() {
            public void run() {
                mContext.showAd();
            }
        });
    }
}
