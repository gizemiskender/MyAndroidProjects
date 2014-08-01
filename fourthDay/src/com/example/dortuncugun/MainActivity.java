package com.example.dortuncugun;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	Button gonder;
	TextView isim;
	TextView yas;
	EditText etIsim;
	EditText etYas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gonder = (Button) findViewById(R.id.buttonverileriAl);
		isim = (TextView) findViewById(R.id.textViewisim);
		yas = (TextView) findViewById(R.id.textViewYasınız);
		etIsim = (EditText) findViewById(R.id.editTextIsminiz);
		etYas = (EditText) findViewById(R.id.editTextYasınız);
		
		
		gonder.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			isim.setText(etIsim.getText());
			yas.setText(etYas.getText());
				 
				
			}
		});
	}
	
	
}
