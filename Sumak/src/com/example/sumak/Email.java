package com.example.sumak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {

	EditText personEmail, intro, personName, stupidThings, hatefulAction,
			outro;
	String emailAdd, beginning, name, stupidAction, hatefulAct, out;
	Button sendEmail;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initialize();
		sendEmail.setOnClickListener(this);

	}

	private void initialize() {

		personEmail = (EditText) findViewById(R.id.etEmails);
		intro = (EditText) findViewById(R.id.etIntro);
		personName = (EditText) findViewById(R.id.etName);
		stupidThings = (EditText) findViewById(R.id.etThing);
		hatefulAction = (EditText) findViewById(R.id.etAction);
		sendEmail = (Button) findViewById(R.id.bSendEmail);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		mail();
		String emailadress[] = { emailAdd };
		String message = "Well hello" + name + " I just wanted to say "
				+ beginning + " Not only that but I hate when you "
				+ stupidAction
				+ " , that just really makes me crazy. I just want to make "
				+ hatefulAct + ". Welp, thats " + out + " ...." + " P.S. ...";

		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailadress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "gizo");
		emailIntent.setType("text/plain");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(emailIntent);

	}

	private void mail() {
		// TODO Auto-generated method stub
		emailAdd = personEmail.getText().toString();
		beginning = intro.getText().toString();
		name = personName.getText().toString();
		stupidAction = stupidThings.getText().toString();
		hatefulAct = hatefulAction.getText().toString();
		out = outro.getText().toString();

	}

	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}

}
