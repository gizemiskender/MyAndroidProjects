package com.example.customlistview;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	
	ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv = (ListView) findViewById(R.id.listView1);
		
		ArrayList<Model> insan = new ArrayList<Model>();
		insan.add( new Model ("ahmet", getResources().getDrawable(R.drawable.ic_launcher)));
		insan.add( new Model ("ayse", getResources().getDrawable(R.drawable.ic_launcher)));
		insan.add( new Model ("arda", getResources().getDrawable(R.drawable.ic_launcher)));
		
	
		CustomAdapter adapter = new CustomAdapter(MainActivity.this, insan);
		
		lv.setAdapter(adapter);
	}

	
}
