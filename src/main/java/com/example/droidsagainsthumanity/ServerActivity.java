package com.example.droidsagainsthumanity;

import java.io.IOException;
import java.net.ServerSocket;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

public class ServerActivity extends Activity {
	
	private ServerSocket server;
	Handler updateHandler;
	Thread serverThread = null;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_server);
		// Show the Up button in the action bar.
		setupActionBar();
		TextView status = (TextView)findViewById(R.id.serverstatus);
		status.append("Trying to start server (port will be OS assigned)...\n");
		try {
			server = new ServerSocket(0);
			status.append("Server initiated!\n");
			status.append("Port number is: " + server.getLocalPort() + "\n");
			server.accept();
			status.append("Server is accepting requests. Tell your piss-ant friends to join!\n");
		} catch (IOException e) {
			status.append("Well fuck...something went wrong.\n");
			e.printStackTrace();
		}

	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.server, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
