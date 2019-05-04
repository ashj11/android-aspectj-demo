package com.ashj.aspectjdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ashj.aspectjhooks.Trace;

public class MainActivity extends AppCompatActivity {

	Button button;
	TextView textView;
	int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView = findViewById(R.id.textView);

		button = findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				textView.setText(String.valueOf(incrementAndGetCount()));
			}
		});
	}

	@Trace
	public int incrementAndGetCount(){
		return ++count;
	}
}
