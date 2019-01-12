package com.londonappbrewery.quizzler;

        import android.app.Activity;
        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here
    Button True;
    Button False;
    Toast toast;
    TextView quesionText;
    int Index;
    int Question;
    TextView Score;
    ProgressBar progressBar;
    int score;
    // TODO: Declare member variables here:


    // TODO: Uncomment to create question bank

    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, false),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, true),
            new TrueFalse(R.string.question_7, false),
            new TrueFalse(R.string.question_8, true),
            new TrueFalse(R.string.question_9, false),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, true),
            new TrueFalse(R.string.question_12, true),
            new TrueFalse(R.string.question_13,false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null)
        {
            score = savedInstanceState.getInt("score");
            Index = savedInstanceState.getInt("Index");
        }
        else
        {
            score = 0;
            Index = 0;
        }

        True = findViewById(R.id.true_button);
        False = findViewById(R.id.false_button);
        quesionText = findViewById(R.id.question_text_view);
        Score = findViewById(R.id.score);
        Score.setText("score  "+score+"/"+ mQuestionBank.length);
        progressBar = findViewById(R.id.progress_bar);
        final int PROGRESSBAR_INCREMENTED_BY = (int) Math.ceil(100/mQuestionBank.length);
        Question = mQuestionBank[Index].getQuestionId();
        quesionText.setText(Question);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.true_button:
                        CheckAnswer(true);
                        UpdateQuestion();
                        break;
                    case R.id.false_button:
                        CheckAnswer(false);
                        UpdateQuestion();
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
    final int PROGRESSBAR_INCREMENTED_BY = (int) Math.ceil(100/mQuestionBank.length);
    private void UpdateQuestion()
    {
        Index=(Index+1)% mQuestionBank.length;

        if(Index == 0)
        {

            AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder(this);
            alertDialogbuilder.setTitle("Game Over");
            alertDialogbuilder.setCancelable(false);
            alertDialogbuilder.setMessage("You Scored "+score+" points!");
            alertDialogbuilder.setPositiveButton("Close App", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
               finish();
                }
            });
            AlertDialog alertDialog = alertDialogbuilder.create();
            alertDialog.show();

        }
        Question = mQuestionBank[Index].getQuestionId();
        quesionText.setText(Question);
        Score.setText("score  "+score+"/"+ mQuestionBank.length);
        progressBar.incrementProgressBy(PROGRESSBAR_INCREMENTED_BY);
    }
    private void CheckAnswer(boolean Ans)
    {
        boolean mans = mQuestionBank[Index].isAnswer();
        if(mans == Ans)
        {

            toast = Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT);
            toast.show();
            score++;

        }
        else
        {
            toast = Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("score",score);
        outState.putInt("Index",Index);
    }

}
