package com.example.alquilervehiculos;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	TextView tv1;
	RadioButton rb1, rb2, rb3, rb4;
	Spinner sp1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1 = (TextView) findViewById(R.id.textView1);
		rb1 = (RadioButton) findViewById(R.id.radio0);
		rb2 = (RadioButton) findViewById(R.id.radio1);
		rb3 = (RadioButton) findViewById(R.id.radio2);
		rb4 = (RadioButton) findViewById(R.id.radio3);
		sp1 = (Spinner) findViewById(R.id.spinner1);
		String[] dias = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, dias); //Control Shit F : ordena el indent del código
		sp1.setAdapter(adaptador1);
		sp1.setOnItemSelectedListener(new OnItemSelectedListener(){

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				tv1.setText("Precio total: $" + retornarPrecio());
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				
			}});

	}

	public void alquiler(View v) {
		tv1.setText("Precio total: $" + retornarPrecio());
	}
	
	public void confirmar (View v) {
		Intent intento1=new Intent(this, Confirmacion.class);
		intento1.putExtra("precioPagar", String.valueOf(retornarPrecio()));
		startActivity(intento1);
	}
	
	private int retornarPrecio () {
		int dias = Integer.parseInt(sp1.getSelectedItem().toString());
		int precio=0;
		if (rb1.isChecked()) {
			precio = dias * 1000;
		}
		if (rb2.isChecked()) {
			precio = dias * 2000;
		}
		if (rb3.isChecked()) {
			precio = dias * 3000;
		}
		if (rb4.isChecked()) {
			precio = dias * 4000;
		}
		return precio;
	}
	
	

}
