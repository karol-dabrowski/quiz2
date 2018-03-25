package pl.karoldabrowski.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void quitGame(View view) {
        finishAndRemoveTask();
    }

    public void starNewGame(View view) {
        setContentView(R.layout.activity_main_game);
    }

    public void submitGame(View view) {
        int points = 0;

        EditText firstQuestionAnswerField = (EditText) findViewById(R.id.first_answer);
        if (firstQuestionAnswerField.getText().toString().toLowerCase().equals("cat")) {
            points++;
        }

        RadioGroup secondQuestionAnswerGroup = (RadioGroup) findViewById(R.id.question_2_group);
        int selectedRadioButtonId = secondQuestionAnswerGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonId);
            if (selectedRadioButton.getText().toString().equals("France")) {
                points++;
            }
        }

        CheckBox question3answer1 = (CheckBox) findViewById(R.id.question_3_checkbox_1);
        CheckBox question3answer2 = (CheckBox) findViewById(R.id.question_3_checkbox_2);
        CheckBox question3answer3 = (CheckBox) findViewById(R.id.question_3_checkbox_3);
        CheckBox question3answer4 = (CheckBox) findViewById(R.id.question_3_checkbox_4);

        if (question3answer1.isChecked() && !question3answer2.isChecked()
                && !question3answer3.isChecked() && question3answer4.isChecked()) {
            points++;
        }

        RadioGroup fourthQuestionAnswerGroup = (RadioGroup) findViewById(R.id.question_4_group);
        selectedRadioButtonId = fourthQuestionAnswerGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonId);
            if (selectedRadioButton.getText().toString().equals("Apple")) {
                points++;
            }
        }

        setContentView(R.layout.activity_main);
        CharSequence toastText;

        if(points <= 2) {
            toastText = "Your score is " + points + ". Try again!";
        } else {
            toastText = "Your score is " + points + ". Great job!";
        }

        Toast toast = Toast.makeText(this, toastText, Toast.LENGTH_LONG);
        toast.show();
    }
}
