package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here
        Button True;
        Button False;
        Toast toast;

    // TODO: Declare member variables here:


    // TODO: Uncomment to create question bank
//    private TrueFalse[] mQuestionBank = new TrueFalse[] {
//            new TrueFalse(R.string.question_1, true),
//            new TrueFalse(R.string.question_2, true),
//            new TrueFalse(R.string.question_3, true),
//            new TrueFalse(R.string.question_4, false),
//            new TrueFalse(R.string.question_5, true),
//            new TrueFalse(R.string.question_6, true),
//            new TrueFalse(R.string.question_7, false),
//            new TrueFalse(R.string.question_8, true),
//            new TrueFalse(R.string.question_9, false),
//            new TrueFalse(R.string.question_10, true),
//            new TrueFalse(R.string.question_11, true),
//            new TrueFalse(R.string.question_12, true),
//            new TrueFalse(R.string.question_13,false)
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        True = findViewById(R.id.true_button);
        False = findViewById(R.id.false_button);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.true_button:
                        toast = Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.false_button:
                        toast = Toast.makeText(getApplicationContext(),"False",Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    default:
                        toast = Toast.makeText(getApplicationContext(),"Something went wrong!",Toast.LENGTH_SHORT);
                        toast.show();
                            break;
                }

            }
        };

        True.setOnClickListener(listener);
        False.setOnClickListener(listener);
    }
}
