package com.codegodfather.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.codegodfather.interactivestory.R;
import com.codegodfather.interactivestory.model.Page;
import com.codegodfather.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {




    public static final String TAG = StoryActivity.class.getSimpleName();
    private Story story;
    private String name;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = (ImageView) findViewById(R.id.storyImageView);
        storyTextView = (TextView)findViewById(R.id.storyTextView);
        choice1Button = (Button)findViewById(R.id.choice1Button);
        choice2Button = (Button)findViewById(R.id.choice2Button);

        Intent intent = getIntent();
        name = intent.getStringExtra(getString(R.string.key_name));
        if(name == null || name.isEmpty())
        {
            name = "User";
        }
        Log.d(TAG,name);
        //Setting the complete story
        story = new Story();
        //loading first page of story
        loadPage(0);
    }

    private void loadPage(int pageNumber) {
        Page page = story.getPage(pageNumber);

        Drawable image = ContextCompat.getDrawable(this,page.getImageId());

        storyImageView.setImageDrawable(image);

        String pageText = getString(page.getTextId());
        //add the name if the placeholder is included
        String.format(pageText, name);

        storyTextView.setText(pageText);

        choice1Button.setText(page.getChoice1().getTextId());
        choice2Button.setText(page.getChoice2().getTextId());

    }
}
