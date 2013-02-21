package kr.pe.kiwook.test.testgcmreceiverapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.android.gcm.GCMRegistrar;

public class MainActivity extends Activity {

    private final String SENDER_ID = "";
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);
		final String regId = GCMRegistrar.getRegistrationId(this);
		
		Log.d("Ryukw82","regid "+regId);
		if (regId.equals("")) {
		  GCMRegistrar.register(this, SENDER_ID);
		  
		} else {
		  Log.v("Ryukw82", "Already registered");
		}
		
		Button btn = (Button)findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Log.d("Ryukw82", GCMRegistrar.getRegistrationId(MainActivity.this));
			
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
