package ch.schmitz_dynamics.cat_n_run.cat_n_run;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.browser = (WebView)findViewById(R.id.webView);
        this.browser.setWebViewClient(new CustomWebViewClient());
        WebSettings webSetting = this.browser.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSetting.setDisplayZoomControls(true);

        browser.getSettings().setLoadWithOverviewMode(true);
        browser.getSettings().setUseWideViewPort(true);
        this.browser.loadUrl("http://google.de");
    }

    private class CustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
