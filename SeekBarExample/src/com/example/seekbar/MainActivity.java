package com.example.seekbar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends ActionBarActivity {

	// private static final OnSeekBarChangeListener OnSeekBarChangeListener =
	// null;
	private int seekBarR, seekBarG, seekBarB;
	SeekBar sbRed, sbBlue, sbGreen;
	LinearLayout myScreen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initilaze();
	}

	private void initilaze() {

		myScreen = (LinearLayout) findViewById(R.id.myScreen);
		sbRed = (SeekBar) findViewById(R.id.sbRed);
		sbBlue = (SeekBar) findViewById(R.id.sbGreen);
		sbGreen = (SeekBar) findViewById(R.id.sbBlue);

		backgroundUpdate();

		sbRed.setOnSeekBarChangeListener(OnSeekBarChangeListener);
		sbBlue.setOnSeekBarChangeListener(OnSeekBarChangeListener);
		sbGreen.setOnSeekBarChangeListener(OnSeekBarChangeListener);

	}

	private SeekBar.OnSeekBarChangeListener OnSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			backgroundUpdate();

		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub

		}

	};

	private void backgroundUpdate() {
		seekBarR = sbRed.getProgress();
		seekBarB = sbBlue.getProgress();
		seekBarG = sbGreen.getProgress();

		myScreen.setBackgroundColor(0xff000000 + seekBarR * 0x10000 + seekBarG
				* 0x100 + seekBarB);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.main, menu);
		return true;
	}
}
