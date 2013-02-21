package kr.pe.kiwook.test.testgcmreceiverapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;


public class GCMIntentService extends GCMBaseIntentService {

	@Override
	protected void onError(Context arg0, String arg1) {
		Log.d("Ryukw82","GCMTEST onError");
	}

	@Override
	protected void onMessage(Context arg0, Intent arg1) {
		Log.d("Ryukw82","GCMTEST onMessage");
	}

	@Override
	protected void onRegistered(Context arg0, String arg1) {
		Log.d("Ryukw82","GCMTEST onRegistered");
		
	}

	@Override
	protected void onUnregistered(Context arg0, String arg1) {
		Log.d("Ryukw82","GCMTEST onUnregistered");
	}

}
