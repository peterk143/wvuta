package org.mockup.wvuta;

import android.app.Activity;
import android.os.Bundle;

import android.view.*;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class BusWebStatus extends Activity implements OnClickListener{
	private String busStatusUrl = "http://www.busride.org/MyBus/BusFrame.html";
	private WebView webview;
	private int xOffset = 0;
	private int yOffset = 0;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.busweb);
		
		Button tableButton = (Button) findViewById(R.id.BusTableButton);
		Button mapButton = (Button) findViewById(R.id.BusMapButton);
		
		tableButton.setOnClickListener(this);
		mapButton.setOnClickListener(this);
		
		webview = (WebView) findViewById(R.id.busWebView);
		openBrowser();
	}

	private void openBrowser() {
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setBuiltInZoomControls(true);
		webview.loadUrl(busStatusUrl);
		//webview.scrollTo(xOffset, yOffset);
	}

	public void onClick(View v) {
		switch (v.getId()){
		case R.id.BusTableButton:
			xOffset = 0;
			yOffset = 0;
			break;
		case R.id.BusMapButton:
			xOffset = 1000;
			yOffset = 125;
			break;
		}
		webview.scrollTo(xOffset, yOffset);
	}
}