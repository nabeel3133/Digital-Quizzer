package com.seecs.quizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import com.seecs.quizer.model.User;

import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {
    static RestTemplate restTemplate = new RestTemplate();
    private static String username;
    private static String password;
    private static String type;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String TAG = "SOMETHING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButtonListener();
    }

    private void setButtonListener() {
        Button button = (Button)findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ToggleButton toggleButton = (ToggleButton)findViewById(R.id.MainToggle);
                String toggleText = toggleButton.getText().toString();
                Log.d(TAG, "Start");
                EditText user_name    = (EditText)findViewById(R.id.username);
                Log.d(TAG, "Got Username");
                EditText pass_word    = (EditText)findViewById(R.id.password);
                Log.d(TAG, "Got Password");
                username = user_name.getText().toString();
                password = pass_word.getText().toString();
                radioGroup = (RadioGroup) findViewById(R.id.radio);
                Log.d(TAG, "Got Radio Group");

                //get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                //find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);
                Log.d(TAG, "Got Radio Button");

                type = radioButton.getText().toString();
                Log.d(TAG, "Username: "+username);
                Log.d(TAG, "Password: "+password);
                Log.d(TAG, "Type: "+type);


                if(type.equals("Student"))
                {
                    Log.d(TAG, "The type is: "+type);
                    if(toggleText.equals("Sign In"))
                    {
                        Intent i=new Intent(getApplicationContext(),Student_HomePage.class);
                        Log.d(TAG, "Got context of new activity");
                        startActivity(i);
                        Log.d(TAG, "Activity started");
                        Toast.makeText(MainActivity.this, "Logged in successfully as a "+type, Toast.LENGTH_LONG).show();
                        Log.d(TAG, "Shown toast");
                    }
                    if(toggleText.equals("Sign Up"))
                    {
                        Toast.makeText(MainActivity.this, "Signed up successfully as a "+type, Toast.LENGTH_LONG).show();
                    }
//                    if(SignIn(username,password,type))
//                    {
//                        Log.d(TAG, "Got Signed in as "+type);
//                        Toast.makeText(MainActivity.this, "Logged in successfully as a Student", Toast.LENGTH_LONG).show();
//                    }
                }
                else if(type.equals("Instructor"))
                {
                    if(toggleText.equals("Sign In"))
                    {
                        if(SignIn(username,password,type))
                        {
                            Log.d(TAG, "The type is: "+type);
                            Intent i=new Intent(getApplicationContext(),Instructor_HomePage.class);
                            Log.d(TAG, "Got context of new activity");
                            startActivity(i);
                            Log.d(TAG, "Activity started");
                            Toast.makeText(MainActivity.this, "Logged in successfully as an "+type, Toast.LENGTH_LONG).show();
                            Log.d(TAG, "Shown toast");
                        }
                    }
                    else if(toggleText.equals("Sign Up"))
                    {
                        Toast.makeText(MainActivity.this, "Signed up successfully as an "+type, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }


    //Sign Up function
    public static String SignUp(String user, String pass, String type)
    {
        User theUser = new User();
        theUser.setUsername(user);
        theUser.setPassword(pass);
        theUser.setType(type);
        String signed_up_message = restTemplate.postForObject("http://localhost:8080/users/signup", theUser, String.class);
        return signed_up_message+" as "+type+"!";
    }


    //Sign In function
    public boolean SignIn(String user, String pass, String type) {
        String theTAG = "SOMETHING";
            Log.d(theTAG, "Sign in function called");
            User theUser = new User();
            theUser.setUsername(user);
            theUser.setPassword(pass);
            theUser.setType(type);
            Log.d(theTAG, "Before sending post request... Username: " + theUser.getUsername() + " Password: " + theUser.getPassword() + " Type: " + theUser.getType());
            boolean signed_in_check = restTemplate.postForObject("http://192.168.43.31:8080/users/signin", theUser, boolean.class);
            Log.d(theTAG, "After returning from URL call");
            return signed_in_check;
        }







//        public boolean SignIn(String user, String pass, String type) {
//            String theTAG = "SOMETHING";
//            Log.d(theTAG, "Sign in function called");
//            User theUser = new User();
//            theUser.setUsername(user);
//            theUser.setPassword(pass);
//            theUser.setType(type);
//            Log.d(theTAG, "Before sending post request... Username: " + theUser.getUsername() + " Password: " + theUser.getPassword() + " Type: " + theUser.getType());
//            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//            boolean signed_in_check = restTemplate.postForObject("http://192.168.43.31:8080/users/signin", theUser, boolean.class);
//            Log.d(theTAG, "After returning from URL call");
//            return signed_in_check;
//        }

}
