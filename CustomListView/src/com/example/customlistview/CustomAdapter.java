package com.example.customlistview;

import java.util.ArrayList;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {

	ArrayList<Model> insan;
	Context context;
	

	public CustomAdapter(Context context, ArrayList<Model> insan) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.insan = insan;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		// dizinin laç elemanlı oldugunu döndürür
		return insan.size();

	}

	@Override
	public Model getItem(int position) {
		// TODO Auto-genernameated method stub
		return insan.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView( final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// burası view dondurur her bır satırda tekrar edılecek elemanı dondurur
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		
		View view = inflater.inflate(R.layout.listvie_item, null, false);
		
		TextView tv = (TextView) view.findViewById(R.id.textView1);
		ImageView im = (ImageView) view.findViewById(R.id.imageView1);
		
		tv.setText(getItem(position).getIsim());
		
		view.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg1) {
				
				// TODO Auto-generated method stub
				Toast.makeText(context, insan.get(position).getIsim(), Toast.LENGTH_LONG).show();
			}
		});

		return view;
	}
}


