package com.example.droidsagainsthumanity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity implements OnClickListener{

	private Button btnServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        
        // Buttonize the buttons
        btnServer = (Button) findViewById(R.id.btnServer);
        btnServer.setOnClickListener(this);
        Button btnClient = (Button) findViewById(R.id.btnClient);
        btnClient.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, m);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == btnServer){
			Intent i = new Intent(this, ServerActivity.class);
			startActivity(i);
		}
		
	}
    
}
