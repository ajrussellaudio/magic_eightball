package com.example.user.eightball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Alan fuckin' Russell on 30/08/2016.
 */
public class MainActivity extends AppCompatActivity {

    EditText mQuestionEditText;
    Button mShakeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionEditText = (EditText)findViewById(R.id.question_text);
        mShakeButton = (Button)findViewById(R.id.shake_button);

        mShakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = mQuestionEditText.getText().toString();
                Log.d("EightBall", "Shake button clicked");
                Log.d("EightBall", "The question asked was '" + question + "'");

                String answer = eightBallText();

                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer", answer);
                startActivity(intent);
            }
        });
    }

    private String eightBallText() {
        String[] answers = new String[] {
                "It is certain",
                "It is decidedly so",
                "Without a doubt",
                "Yes, definitely",
                "You may rely on it",
                "As I see it, yes",
                "Most likely",
                "Outlook good",
                "Yes",
                "Signs point to yes",
                "Reply hazy try again",
                "Ask again later",
                "Better not tell you now",
                "Cannot predict now",
                "Concentrate and ask again",
                "Don't count on it",
                "My reply is no",
                "My sources say no",
                "Outlook not so good",
                "Very doubtful"
        };
        int randomIndex = (int) (Math.random() * answers.length);
        return answers[randomIndex];
    }



}
