package com.codegodfather.interactivestory.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codegodfather.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText nameField;
    private Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameField = (EditText) findViewById(R.id.nameEditText);
        startButton = (Button) findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameField.getText().toString();
                Toast.makeText(MainActivity.this,"Welcome "+name,Toast.LENGTH_LONG).show();
                startStory(name);
            }
        });
    }

    private void startStory(String name) {
        Intent intent = new Intent(getApplicationContext(),StoryActivity.class);
        //We keep all values in string.xml as it is a resource file.
        //this helps us to edit the value at one place but have effect on the entire project.
        Resources resources = getResources();
        String key = resources.getString(R.string.key_name);
        intent.putExtra(key,name);
        startActivity(intent);

    }
}


