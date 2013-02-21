package kr.pe.kiwook.test.testgcmsenderapp;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

public class MainActivity extends Activity {
	
	private final String REGISTRATION_ID = "";
	private final String API_KEY = "";
	
	Thread thread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btn = (Button)findViewById(R.id.btn);
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				threadStart();
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	 private void threadStart(){
	    	
	    	thread = new Thread(null, sending, "SEND");
	    	thread.start();
	    }

	    private Runnable sending = new Runnable() {
			
			@Override
			public void run() {
				Sender sender = new Sender(API_KEY);
				Message.Builder builder = new Message.Builder();
				
				builder.collapseKey("111");
				builder.timeToLive(10000);
				builder.addData("message", "Message");
				
				Message message = builder.build();
				
				try {
					Result result = sender.sendNoRetry(message, REGISTRATION_ID);
					Log.d("LOG",result.getMessageId());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					Log.d("LOG",e.getMessage());
				}
				
				
			}
		};
		

}
