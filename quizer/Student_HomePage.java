package com.seecs.quizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.seecs.quizer.model.Quiz;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.seecs.quizer.MainActivity.restTemplate;

public class Student_HomePage extends AppCompatActivity {

    private static int quizId;
    String[] QuizIds = new String[] {
    };

    String[] QuizTitles= new String[]
            {
            };

    String[] QuizDescriptions = new String[]
            {
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__home_page);
        ListView listview = (ListView) findViewById(R.id.ids);
        List<Quiz> allQuizzes = showQuizzes();
        for (int i = 0; i < allQuizzes.size(); i++)
        {
            //QuizIds[i] = allQuizzes.get(i).getId().toString();
            QuizTitles[i] = allQuizzes.get(i).getTitle();
            QuizDescriptions[i] = allQuizzes.get(i).getDescription();
        }

//        final List<String> ListElementsArrayList = new ArrayList<String>(Arrays.asList(QuizIds));
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
//                (Student_HomePage.this, android.R.layout.simple_list_item_1, ListElementsArrayList);
//        listview.setAdapter(adapter);

        listview = (ListView) findViewById(R.id.titles);
        final List<String> ListElementsArrayList1 = new ArrayList<String>(Arrays.asList(QuizTitles));
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (Student_HomePage.this, android.R.layout.simple_list_item_1, ListElementsArrayList1);
        listview.setAdapter(adapter1);

        listview = (ListView) findViewById(R.id.descriptions);
        final List<String> ListElementsArrayList2 = new ArrayList<String>(Arrays.asList(QuizDescriptions));
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (Student_HomePage.this, android.R.layout.simple_list_item_1, ListElementsArrayList2);
        listview.setAdapter(adapter2);

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
                Toast.makeText(Student_HomePage.this, "Logged out successfully", Toast.LENGTH_LONG).show();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
        }
        return true;
    }

    public void attemptQuiz(View view)
    {
        EditText editText = (EditText)findViewById(R.id.enterID);
        quizId = Integer.parseInt(editText.getText().toString());
        Toast.makeText(Student_HomePage.this, "Opening Quiz "+quizId, Toast.LENGTH_LONG).show();
        Intent i=new Intent(getApplicationContext(),AttemptQuiz.class);
        startActivity(i);
    }

    //Show Quizzes Request to Server
    public static List<Quiz> showQuizzes()
    {
        String TAG = "SOMETHING";
        Log.d(TAG, "Before sending url");
        ResponseEntity<Quiz[]> allQuizzes = restTemplate.getForEntity("http://192.168.43.31:8080/quizzes/allquizzes", Quiz[].class);
        Log.d(TAG, "After returning url");
        return Arrays.asList(allQuizzes.getBody());
    }

}
