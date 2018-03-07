package com.example.android.honeybeequiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

      // This app displays a quiz about the bees
     // It calculates the final result of a player
    // Finally it resets the score and allows for a new game

    public class MainActivity extends Activity {

    // Declaration of global variables for the Views

    RadioGroup firstRadioGroup;
    RadioGroup secondRadioGroup;
    RadioGroup thirdRadioGroup;
    RadioGroup fourthRadioGroup;
    RadioGroup fifthRadioGroup;
    RadioGroup sixthRadioGroup;
    RadioGroup seventhRadioGroup;
    RadioGroup eighthRadioGroup;

    RadioButton quest1A;
    RadioButton quest1B;
    RadioButton quest3B;
    RadioButton quest5A;
    RadioButton quest6A;
    RadioButton quest7B;
    RadioButton quest8B;
    RadioButton quest9B;
    RadioButton quest10C;
    CheckBox quest2A;
    CheckBox quest2B;
    CheckBox quest2C;
    CheckBox quest2D;
    CheckBox quest2E;
    CheckBox quest2F;
    EditText quest4;
    EditText playerName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       //Removes app status bar at the top to allow for more screen size to work with

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // Initializing the global variables in onCreate method to reduce the number of calls to findViewById() method

        firstRadioGroup = (RadioGroup) findViewById(R.id.radio_group_q1);
        secondRadioGroup = (RadioGroup) findViewById(R.id.radio_group_q3);
        thirdRadioGroup = (RadioGroup) findViewById(R.id.radio_group_q5);
        fourthRadioGroup = (RadioGroup) findViewById(R.id.radio_group_q6);
        fifthRadioGroup = (RadioGroup) findViewById(R.id.radio_group_q7);
        sixthRadioGroup = (RadioGroup) findViewById(R.id.radio_group_q8);
        seventhRadioGroup = (RadioGroup) findViewById(R.id.radio_group_q9);
        eighthRadioGroup = (RadioGroup) findViewById(R.id.radio_group_q10);

        quest1A = (RadioButton) findViewById(R.id.radio_button_q1_a);
        quest1B = (RadioButton) findViewById(R.id.radio_button_q1_b);
        quest2A = (CheckBox) findViewById(R.id.checked_button_q2_a);
        quest2B = (CheckBox) findViewById(R.id.checked_button_q2_b);
        quest2C = (CheckBox) findViewById(R.id.checked_button_q2_c);
        quest2D = (CheckBox) findViewById(R.id.checked_button_q2_d);
        quest2E = (CheckBox) findViewById(R.id.checked_button_q2_e);
        quest2F = (CheckBox) findViewById(R.id.checked_button_q2_f);
        quest3B = (RadioButton) findViewById(R.id.radio_button_q3_b);
        quest4 = (EditText) findViewById(R.id.edit_text_q4);
        quest5A = (RadioButton) findViewById(R.id.radio_button_q5_a);
        quest6A = (RadioButton) findViewById(R.id.radio_button_q6_a);
        quest7B = (RadioButton) findViewById(R.id.radio_button_q7_b);
        quest8B = (RadioButton) findViewById(R.id.radio_button_q8_b);
        quest9B = (RadioButton) findViewById(R.id.radio_button_q9_b);
        quest10C = (RadioButton) findViewById(R.id.radio_button_10_c);
        playerName = (EditText) findViewById(R.id.player_name);

    }

    //Use onSaveInstanceState(Bundle)

    @Override
    public void onSaveInstanceState(Bundle outState) {

        // Calling the superclass so it can save the view hierarchy state

        super.onSaveInstanceState(outState);
    }

    //Use onRestoreInstanceState (Bundle)

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        // Calling the superclass so it can save the view hierarchy state

        super.onRestoreInstanceState(savedInstanceState);
    }

    // This method is called when the Submit Button is clicked

    public void submitButton(View v) {

        // Creates a boolean and checks if the player clicked on the correct answer B for question 1
        boolean questOneB = quest1B.isChecked();

        // Creates a boolean and checks if the player clicked on the correct answer A for question 2
        boolean questTwoA = quest2A.isChecked();

        // Creates a boolean and checks if the player clicked on the wrong answer B for question 2
        boolean questTwoB = quest2B.isChecked();

        // Creates a boolean and checks if the player clicked on the wrong answer C for question 2
        boolean questTwoC = quest2C.isChecked();

        // Creates a boolean and checks if the player clicked on the wrong answer D for question 2
        boolean questTwoD = quest2D.isChecked();

        // Creates a boolean and checks if the player clicked on the correct answer E for question 2
        boolean questTwoE = quest2E.isChecked();

        // Creates a boolean and checks if the player clicked on the correct answer F for question 2
        boolean questTwoF = quest2F.isChecked();

        // Creates a boolean and checks if the player clicked on the correct answer B for question 3
        boolean questThreeB = quest3B.isChecked();

        // Creates a String and gets player's text answer for question 4
        String textQ = quest4.getText().toString().toLowerCase().replaceAll(" ", "");

        // Creates a boolean and checks if the player clicked on the correct answer A for question 5
        boolean questFiveA = quest5A.isChecked();

        // Creates a boolean and checks if the player clicked on the correct answer A for question 6
        boolean questSixA = quest6A.isChecked();

        // Creates a boolean and checks if the player clicked on the correct answer B for question 7
        boolean questSevenB = quest7B.isChecked();

        // Creates a boolean and checks if the player clicked on the correct answer B for question 8
        boolean questEightB = quest8B.isChecked();

        // Creates a boolean and checks if the player clicked on the correct answer B for question 9
        boolean questNineB = quest9B.isChecked();

        // Creates a boolean and checks if the player clicked on the correct answer C for question 10
        boolean questTenC = quest10C.isChecked();


        // Creates an integer that stores the final quiz score of the player
        int finalScore = calculateScore(questOneB, questTwoA, questTwoB, questTwoC, questTwoD, questTwoE, questTwoF, questThreeB, textQ, questFiveA, questSixA, questSevenB, questEightB, questNineB, questTenC);

        // Creates a String that gets the player's name input
        String name = playerName.getText().toString();

        // Uses a StringBuilder that allows the creation of a Toast message using strings (for score >= 5)
        StringBuilder answerSummaryHigh = new StringBuilder(getString(R.string.answer_summary_high, name, finalScore));

        // Uses a StringBuilder that allows the creation of a Toast message using strings (for score < 5)
        StringBuilder answerSummaryLow = new StringBuilder(getString(R.string.answer_summary_low, name, finalScore));

        // If player's name is empty or its length <=0, display a Toast message. Else continue with the score
        if (playerName.getText().toString().trim().length() <= 0) {
            Toast toastName = Toast.makeText(this, R.string.empty_player_name, Toast.LENGTH_LONG);
            // Positions the Toast message in the center of the screen
            toastName.setGravity(Gravity.CENTER, 0, 0);
            // Displays the Toast message
            toastName.show();

            // If player's score < 5 display Toast message for low score
        } else if (finalScore < 5) {
            Toast toastLowScore = Toast.makeText(this, answerSummaryLow.toString(), Toast.LENGTH_LONG);
            // Positions the Toast message in the center of the screen
            toastLowScore.setGravity(Gravity.CENTER, 0, 0);
            // Displays the Toast message
            toastLowScore.show();

            // If player's score >= 5 display Toast message for high score
        } else if (finalScore >= 5) {
            Toast.makeText(this, answerSummaryHigh.toString(), Toast.LENGTH_LONG);
            Toast toastHighScore = Toast.makeText(this, answerSummaryHigh.toString(), Toast.LENGTH_LONG);
            // Positions the Toast message in the center of the screen
            toastHighScore.setGravity(Gravity.CENTER, 0, 0);
            // Displays the Toast message
            toastHighScore.show();
        }
    }

      //This method calculates the final player score
     //@return total score

    public int calculateScore(boolean questOneB, boolean questTwoA, boolean questTwoB, boolean questTwoC, boolean questTwoD, boolean questTwoE, boolean questTwoF,
                              boolean questThreeB, String textQ, boolean questFiveA, boolean questSixA,
                              boolean questSevenB, boolean questEightB, boolean questNineB, boolean questTenC) {

    //Initializing the integer score as a local variable

        int score = 0;

        // Checks if correct answer B of question 1 is checked and adds 1 point to the score
        // Otherwise the score does not change

        if (questOneB) {
            score += 1;
        } else {
            score += 0;
        }

        // Checks if correct answers A, E and F of question 2 are checked and wrong answers B, C and D are not checked and adds 1 point to the score
        // Otherwise the score does not change

        if (questTwoA && questTwoE && questTwoF && !questTwoB && !questTwoC && !questTwoD) {
            score += 1;
        } else {
            score += 0;
        }

        // Checks if correct answer B of question 3 is checked and adds 1 point to the score
        // Otherwise the score does not change

        if (questThreeB) {
            score += 1;
        } else {
            score += 0;
        }

        // Checks if correct answer "drone/Drone/търтей/Търтей" of question 4 is typed in and adds 1 point to the score
        // Otherwise the score does not change

        textQ = quest4.getText().toString().toLowerCase().replaceAll(" ", "");
        if (textQ.equals("drone") || textQ.equals("търтей")) {
            score += 1;
        } else {
            score += 0;
        }

        // Checks if correct answer A of question 5 is checked and adds 1 point to the score
        // Otherwise the score does not change

        if (questFiveA) {
            score += 1;
        } else {
            score += 0;
        }

        // Checks if correct answer A of question 6 is checked and adds 1 point to the score
        // Otherwise the score does not change

        if (questSixA) {
            score += 1;
        } else {
            score += 0;
        }

        // Checks if correct answer B of question 7 is checked and adds 1 point to the score
        // Otherwise the score does not change

        if (questSevenB) {
            score += 1;
        } else {
            score += 0;
        }

        // Checks if correct answer B of question 8 is checked and adds 1 point to the score
        // Otherwise the score does not change

        if (questEightB) {
            score += 1;
        } else {
            score -= 1;
        }

        // Checks if correct answer B of question 9 is checked and adds 1 point to the score
        // Otherwise the score does not change

        if (questNineB) {
            score += 1;
        } else {
            score += 0;
        }

        // Checks if correct answer C of question 10 is checked and adds 1 point to the score
        // Otherwise the score does not change

        if (questTenC) {
            score += 1;
        } else {
            score += 0;
        }
        // Returns the final score

        return score;
    }

    //This method is called when the Reset Button is clicked

    public void resetScore(View v) {

        //Resets the questions with single correct answer (Radio Buttons)

        firstRadioGroup.clearCheck();
        secondRadioGroup.clearCheck();
        thirdRadioGroup.clearCheck();
        fourthRadioGroup.clearCheck();
        fifthRadioGroup.clearCheck();
        sixthRadioGroup.clearCheck();
        seventhRadioGroup.clearCheck();
        eighthRadioGroup.clearCheck();

        //Resets the questions with multiple correct answer (CheckBoxes)

        quest2A.setChecked(false);
        quest2B.setChecked(false);
        quest2C.setChecked(false);
        quest2D.setChecked(false);
        quest2E.setChecked(false);
        quest2F.setChecked(false);

        //Resets the text answer on question 4

        quest4.getText().clear();

        //Resets player names

        playerName.getText().clear();
    }

}

