package com.example.android.udacityquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgDays;
    RadioGroup rgLogos;
    RadioGroup rgSports;

    CheckBox chHome;
    CheckBox chClassroom;
    CheckBox chStadium;
    CheckBox chLibrary;

    EditText etGreeting;

    TextView q1;
    TextView q2;
    TextView q3;
    TextView q4;
    TextView q5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgDays = findViewById(R.id.radio_group_days);
        rgLogos = findViewById(R.id.radio_group_logos);
        rgSports = findViewById(R.id.radio_group_sports);

        chHome = findViewById(R.id.home);
        chClassroom = findViewById(R.id.classroom);
        chStadium = findViewById(R.id.stadium);
        chLibrary = findViewById(R.id.library);

        etGreeting = findViewById(R.id.question_two_edit_text);

        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        q5 = findViewById(R.id.q5);
    }

    public void submitQuiz(View view){
        int score = calculateScore();

        if(etGreeting.getText().toString().trim().equalsIgnoreCase("Hello World!")){
            score ++;
        }else{
            q2.setText(R.string.q2Answer);
        }
        displayScore("Your score is : " + score + "/5");
    }

    private int calculateScore (){

        int userScore = 0;

        switch(rgDays.getCheckedRadioButtonId()){
            case R.id.wednesday:
                userScore += 0;
                q1.setText(R.string.q1Answer);
                break;
            case R.id.monday:
                userScore ++;
                q1.setText(null);
                break;
            case R.id.thursday:
                userScore += 0;
                q1.setText(R.string.q1Answer);
                break;
            case R.id.sunday:
                userScore += 0;
                q1.setText(R.string.q1Answer);
                break;
        }

        switch(rgLogos.getCheckedRadioButtonId()){
            case R.id.pidgeot:
                userScore += 0;
                q4.setText(R.string.q4Answer);
                break;
            case R.id.toyota:
                userScore += 0;
                q4.setText(R.string.q4Answer);
                break;
            case R.id.audi:
                userScore ++;
                q4.setText(null);
                break;
            case R.id.mazda:
                userScore += 0;
                q4.setText(R.string.q4Answer);
                break;
        }

        switch(rgSports.getCheckedRadioButtonId()){
            case R.id.basketball:
                userScore += 0;
                q5.setText(R.string.q5Answer);
                break;
            case R.id.football:
                userScore ++;
                q5.setText(null);
                break;
            case R.id.baseball:
                userScore += 0;
                q5.setText(R.string.q5Answer);
                break;
            case R.id.hockey:
                userScore += 0;
                q5.setText(R.string.q5Answer);
                break;
        }

        if(!chHome.isChecked() && chClassroom.isChecked() && !chStadium.isChecked() && chLibrary.isChecked()){
            userScore++;
        }else{
            q3.setText(R.string.q3Answer);
        }
        return userScore;
    }

    public void displayScore(String message){
        TextView userScore = findViewById(R.id.score_text_view);
        userScore.setText(message);
    }

    public void resetQuiz(View view){
        chHome.setChecked(false);
        chClassroom.setChecked(false);
        chStadium.setChecked(false);
        chLibrary.setChecked(false);

        rgDays.clearCheck();
        rgLogos.clearCheck();
        rgSports.clearCheck();

        etGreeting.setText(null);
        etGreeting.isFocusableInTouchMode();
        displayScore(null);

        q1.setText(null);
        q2.setText(null);
        q3.setText(null);
        q4.setText(null);
        q5.setText(null);
    }
}

