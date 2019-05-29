package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextAge;
    private Button buttonSave;
    private TextView textViewResult;
    private SharedPreferences sharedPreferences;


    private static final String PREFERENCES_FILE = "preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        buttonSave = findViewById(R.id.buttonSave);
        textViewResult = findViewById(R.id.textViewResult);
        sharedPreferences = getSharedPreferences(PREFERENCES_FILE, MODE_PRIVATE);

        String result = sharedPreferences.getString("name", "name") + "\n" +
                sharedPreferences.getInt("age", 0);

        textViewResult.setText(result);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                int age = Integer.valueOf(editTextAge.getText().toString());

                String result = name + "\n" + age;
                textViewResult.setText(result);
                sharedPreferences
                        .edit()
                        .putString("name", name)
                        .putInt("age", age)
                        .apply();
            }
        });
    }
}


