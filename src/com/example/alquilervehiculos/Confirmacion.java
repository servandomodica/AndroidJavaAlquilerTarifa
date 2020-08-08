package com.example.alquilervehiculos;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;


public class Confirmacion extends Activity {
	TextView tv1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirmacion);
		tv1=(TextView)findViewById(R.id.textView1);
		Bundle datos=getIntent().getExtras();
		String paga=datos.getString("precioPagar");
		tv1.setText("Paga: $"+paga);
		
	}

	public void retornar (View v) {
		finish();
	}

}
