package com.example.android_book_app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	EditText etname, etlastname;
	Button save;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		save = (Button) findViewById(R.id.bSave);
		etname = (EditText) findViewById(R.id.etName);
		etlastname = (EditText) findViewById(R.id.etLastname);

		save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				String nameText = etname.getText().toString();
				String lastnameText = etlastname.getText().toString();
				String mesaj = "Merhaba" + nameText + " " + lastnameText + "!";
				Toast.makeText(MainActivity.this, mesaj, Toast.LENGTH_LONG)
						.show();
			}
		});
	}

}
