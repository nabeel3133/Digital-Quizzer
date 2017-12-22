package com.seecs.quizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Instructor_HomePage extends AppCompatActivity {

    private static String title;
    private static String description;
    private static int total_questions;
    private String TAG = "SOMETHING";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor__home_page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.logout:
                Toast.makeText(Instructor_HomePage.this, "Logged out successfully", Toast.LENGTH_LONG).show();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
        }
        return true;
    }

    public void createQuiz(View view)
    {
        Log.d(TAG, "In creating the quiz");
        Intent i=new Intent(getApplicationContext(),AddQuestion.class);
        Log.d(TAG, "Got context of Question class activity");
        Log.d(TAG, "Shown toast");
        EditText edit =  (EditText) findViewById(R.id.title);
        title = edit.getText().toString();
        Log.d(TAG, "Quiz Title: "+title);

        EditText edit1 =  (EditText) findViewById(R.id.description);
        description = edit.getText().toString();
        Log.d(TAG, "Quiz Description: "+description);

        EditText edit2 =  (EditText) findViewById(R.id.total_questions);
        Log.d(TAG, "Getting the Total Questions: "+total_questions);
        total_questions = Integer.parseInt(edit2.getText().toString());
        Log.d(TAG, "Total Questions: "+total_questions);

        //Create the bundle
        Bundle bundle = new Bundle();
        //Add your data to bundle
        bundle.putString("Quiz Title", title);
        bundle.putString("Quiz Description", description);
        bundle.putInt("Total Questions", total_questions);
        //Add the bundle to the intent
        i.putExtras(bundle);
        startActivity(i);
        Toast.makeText(Instructor_HomePage.this, "Quiz Created successfully", Toast.LENGTH_LONG).show();

    }
}
