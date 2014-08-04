package com.example.customlistview;

import android.graphics.drawable.Drawable;

public class Model {

	String isim;
	Drawable resim;

	public Model(String isim, Drawable resim){
		this.isim = isim;
		this.resim = resim;
	}
	
	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public Drawable getResim() {
		return resim;
	}

	public void setResim(Drawable resim) {
		this.resim = resim;
	}

}
