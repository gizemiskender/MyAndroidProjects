package com.example.sumak;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class MyBringBack extends View{

	Typeface font;
	
	Bitmap gBall;
	float change;
	
	
	public MyBringBack(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		gBall = BitmapFactory.decodeResource(getResources(), R.drawable.love);
		change = 0;
		font = Typeface.createFromAsset(context.getAssets(), "G-Unit.ttf");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		
		Paint textPaint = new Paint();
		textPaint.setARGB(50, 245, 10, 50);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(50);
		textPaint.setTypeface(font);
		
		canvas.drawText("mybringtext", (canvas.getWidth()/2), 200, textPaint);
		canvas.drawBitmap(gBall, (canvas.getWidth()/2), change, null);
		
		if(change < canvas.getHeight()){
			change += 10;
		}else{
			change = 0;
		}
		
		Rect middleRect = new Rect();
		middleRect.set(0, 400, canvas.getWidth(), 550);
		Paint ourBlue = new Paint();
		ourBlue.setColor(Color.WHITE);
		canvas.drawRect(middleRect, ourBlue);
		invalidate();
	}

}
