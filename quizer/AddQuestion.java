package com.seecs.quizer;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.seecs.quizer.model.MCQ;


public class AddQuestion extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String TAG = "SOMETHING";
    private static String title;
    private static String description;
    private static int total_questions;
    private static String questionType;

    private int quest_count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        TextView t = (TextView)findViewById(R.id.quizTitle);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.questiontype);
        //Get the bundle
        Bundle bundle = getIntent().getExtras();

        //Extract the data…
        title = bundle.getString("Quiz Title");
        t.setText(title);
        TextView number = (TextView)findViewById(R.id.questionNumber);

        number.setText("Question "+quest_count+":");
        description = bundle.getString("Quiz Description");
        total_questions = bundle.getInt("Total Questions");

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    ConstraintLayout mcqLayout = (ConstraintLayout) findViewById(R.id.MCQLayout);
                    ConstraintLayout truefalseLayout = (ConstraintLayout) findViewById(R.id.TrueFalseLayout);
                    ConstraintLayout numericLayout = (ConstraintLayout) findViewById(R.id.NumericLayout);
                    RadioButton rb = (RadioButton) findViewById(checkedId);
                    questionType = rb.getText().toString();
                    if (questionType.equals("MCQ")) {
                        mcqLayout.setVisibility(View.VISIBLE);
                        truefalseLayout.setVisibility(View.GONE);
                        numericLayout.setVisibility(View.GONE);
                    } else if (questionType.equals("True/False")) {
                        truefalseLayout.setVisibility(View.VISIBLE);
                        mcqLayout.setVisibility(View.GONE);
                        numericLayout.setVisibility(View.GONE);
                    } else if (questionType.equals("Numeric")) {
                        numericLayout.setVisibility(View.VISIBLE);
                        truefalseLayout.setVisibility(View.GONE);
                        mcqLayout.setVisibility(View.GONE);
                    }
                }
            });

    }

    //Add Question is called when Next or Finish Button is clicked
    public void addQuestion(View view)
    {
        Log.d(TAG, "Getting Question Number "+quest_count);
        if(quest_count == total_questions-1)
        {
            Button MCQButton = (Button) findViewById(R.id.nextMCQ);
            Button NumericButton = (Button) findViewById(R.id.nextNumeric);
            Button TrueFalseButton = (Button) findViewById(R.id.nextTrueFalse);
            MCQButton.setText("Finish");
            NumericButton.setText("Finish");
            TrueFalseButton.setText("Finish");
        }
        else if(quest_count == total_questions)
        {
            Button MCQButton = (Button) findViewById(R.id.nextMCQ);
            Button NumericButton = (Button) findViewById(R.id.nextNumeric);
            Button TrueFalseButton = (Button) findViewById(R.id.nextTrueFalse);
            MCQButton.setText("Finish");
            NumericButton.setText("Finish");
            TrueFalseButton.setText("Finish");
            Toast.makeText(AddQuestion.this, "All the questions are added in the quiz", Toast.LENGTH_LONG).show();
            Intent i=new Intent(getApplicationContext(),Instructor_HomePage.class);
            startActivity(i);
        }

        quest_count++;
        TextView number = (TextView)findViewById(R.id.questionNumber);
        number.setText("Question "+quest_count+":");

        radioGroup = (RadioGroup) findViewById(R.id.questiontype);
        int id = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(id);
        radioButton.setChecked(false);

        if(questionType.equals("MCQ")) {
            EditText option1 = (EditText) findViewById(R.id.Option1);
            option1.setText("");
            EditText option2 = (EditText) findViewById(R.id.Option2);
            option2.setText("");
            EditText option3 = (EditText) findViewById(R.id.Option3);
            option3.setText("");
            EditText option4 = (EditText) findViewById(R.id.Option4);
            option4.setText("");
            radioGroup = (RadioGroup) findViewById(R.id.mcqRadioGroup);
            id = radioGroup.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(id);
            radioButton.setChecked(false);
        }

        else if(questionType.equals("True/False")) {
            radioGroup = (RadioGroup) findViewById(R.id.truefalseRadioGroup);
            id = radioGroup.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(id);
            radioButton.setChecked(false);
        }

        else if(questionType.equals("Numeric"))
        {
            EditText numeric_answer = (EditText) findViewById(R.id.numericAnswer);
            numeric_answer.setText("");
        }

        EditText editText = (EditText) findViewById(R.id.marks);
        editText.setText("");

        editText = (EditText) findViewById(R.id.question);
        editText.setText("");

        //get selected radio button from radioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();

        //find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);
        questionType = radioButton.getText().toString();

        Toast.makeText(AddQuestion.this, "Question added successfully", Toast.LENGTH_LONG).show();
        ConstraintLayout mcqLayout = (ConstraintLayout) findViewById(R.id.MCQLayout);
        ConstraintLayout truefalseLayout = (ConstraintLayout) findViewById(R.id.TrueFalseLayout);
        ConstraintLayout numericLayout = (ConstraintLayout) findViewById(R.id.NumericLayout);
        mcqLayout.setVisibility(View.GONE);
        truefalseLayout.setVisibility(View.GONE);
        numericLayout.setVisibility(View.GONE);
    }


}
