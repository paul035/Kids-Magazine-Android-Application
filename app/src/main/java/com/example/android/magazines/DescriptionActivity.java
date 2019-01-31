package com.example.android.magazines;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import static com.example.android.magazines.Constants.Megher_Kole_Rod_Heseche;

public class DescriptionActivity extends AppCompatActivity {

    private static final String TAG = "DescriptionActivity";
    private Context mContext;
    private Bundle extras;
    private WebView webView;
    private WebView webView1;
    private Button show;
    private String url1;

    public String Jodi_Tor_Dak_Shune = "Jodi_Tor_Dak_Shune_Rabindranath_Tagore";
    public String Amaro_Porano_Jaha_Chay = "Amaro_Porano_Jaha_Chay_Rabindranath_Tagore";
    public String Gramchara_oi_ranga_matir_poth = "Gramchara_oi_ranga_matir_poth_Rabindranath_Tagore";
    public String Megher_Kole_Rod_Hesech = "Megher_Kole_Rod_Hesech_Rabindranath_Tagore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        mContext = DescriptionActivity.this;

        show = (Button) findViewById(R.id.show);
        webView = (WebView) findViewById(R.id.simpleWebView);
        webView1 = (WebView) findViewById(R.id.translatedsimpleWebView);

        extras = getIntent().getExtras();
        if(!extras.equals(null)){

            final String data = extras.getString("titles");

            Log.d(TAG, "coming data " + data );

            String url = "file:///android_asset/"+data+".html";
            webView.loadUrl(url);


            show.setOnClickListener(new View.OnClickListener() {
                boolean visible;
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick(View view) {

                    if (data.equals(Jodi_Tor_Dak_Shune)) {
                        url1 = "file:///android_asset/Jodi_Tor_Dak_Shune_Rabindranath_Tagore_Translated.html";
                    }
                    else if(data.equals(Amaro_Porano_Jaha_Chay)){
                        url1 = "file:///android_asset/Amaro_Porano_Jaha_Chay_Rabindranath_Tagore_Translated.html";
                    }
                    else if(data.equals(Gramchara_oi_ranga_matir_poth)){
                        url1 = "file:///android_asset/Gramchara_oi_ranga_matir_poth_Rabindranath_Tagore_Translated.html";
                    }
                    else  if(data.equals(Megher_Kole_Rod_Heseche)){
                        url1 = "file:///android_asset/Megher_Kole_Rod_Heseche_Rabindranath_Tagore_Translated.html";
                    }
                        webView1.loadUrl(url1);
                        ViewGroup viewGroup = findViewById(R.id.storyDescription);
                        TransitionManager.beginDelayedTransition(viewGroup);
                        visible = !visible;
                        webView1.setVisibility(visible ? View.VISIBLE : View.GONE);

                        WebSettings webSettings1 = webView1.getSettings();
                        webSettings1.setBuiltInZoomControls(true);
                        webSettings1.setDisplayZoomControls(false);
                        webSettings1.setJavaScriptEnabled(true);
                    }
            });

            WebSettings webSettings = webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setJavaScriptEnabled(true);
        }
    }
}
