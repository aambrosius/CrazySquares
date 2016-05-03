package edu.missouriwestern.aambrosius.retrobejewled;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Ambrosius on 3/3/2016.
 */
public class HardLevel extends MainActivity {

    Button preview;
    ImageButton clear;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    Button button16;
    Button button17;
    Button button18;
    Button button19;
    Button button20;
    Button button21;
    Button button22;
    Button button23;
    Button button24;
    Button button25;

    ImageButton restartbutton;

    TextView correctCount;

    Database db = new Database(this);
    SQLiteDatabase sqlConn;

    int tmp = randomColor();
    int boolButton1 = 0, boolButton2 = 0, boolButton3 = 0, boolButton4 = 0, boolButton5 = 0, boolButton6 = 0,
            boolButton7 = 0, boolButton8 = 0, boolButton9 = 0, boolButton10 = 0, boolButton11 = 0, boolButton12 = 0,
            boolButton13 = 0, boolButton14 = 0, boolButton15 = 0, boolButton16 = 0, boolButton17 = 0, boolButton18 = 0,
            boolButton19 = 0, boolButton20 = 0, boolButton21 = 0, boolButton22 = 0, boolButton23 = 0, boolButton24 = 0,
            boolButton25 = 0, boolTotal = 0, colorButton1 = 0, colorButton2 = 0, colorButton3 = 0, colorButton4 = 0,
            colorButton5 = 0, colorButton6 = 0, colorButton7 = 0, colorButton8 = 0, colorButton9 = 0, colorButton10 = 0,
            colorButton11 = 0, colorButton12 = 0, colorButton13 = 0, colorButton14 = 0, colorButton15 = 0, colorButton16 = 0,
            colorButton17 = 0, colorButton18 = 0, colorButton19 = 0, colorButton20 = 0, colorButton21 = 0, colorButton22 = 0,
            colorButton23 = 0, colorButton24 = 0, colorButton25 = 0, count = 0;

    String finalCount = "";
    String name = "";


    //@Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();
        name = i.getExtras().getString("Initial");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);

        final AlertDialog.Builder newGameDialog = new AlertDialog.Builder(this);
        final AlertDialog.Builder gameOverDialog = new AlertDialog.Builder(this);

        sqlConn = db.getWritableDatabase();

        preview = (Button) findViewById(R.id.btnPreview);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);
        button5 = (Button) findViewById(R.id.btn5);
        button6 = (Button) findViewById(R.id.btn6);
        button7 = (Button) findViewById(R.id.btn7);
        button8 = (Button) findViewById(R.id.btn8);
        button9 = (Button) findViewById(R.id.btn9);
        button10 = (Button) findViewById(R.id.btn10);
        button11 = (Button) findViewById(R.id.btn11);
        button12 = (Button) findViewById(R.id.btn12);
        button13 = (Button) findViewById(R.id.btn13);
        button14 = (Button) findViewById(R.id.btn14);
        button15 = (Button) findViewById(R.id.btn15);
        button16 = (Button) findViewById(R.id.btn16);
        button17 = (Button) findViewById(R.id.btn17);
        button18 = (Button) findViewById(R.id.btn18);
        button19 = (Button) findViewById(R.id.btn19);
        button20 = (Button) findViewById(R.id.btn20);
        button21 = (Button) findViewById(R.id.btn21);
        button22 = (Button) findViewById(R.id.btn22);
        button23 = (Button) findViewById(R.id.btn23);
        button24 = (Button) findViewById(R.id.btn24);
        button25 = (Button) findViewById(R.id.btn25);
        correctCount = (TextView) findViewById(R.id.gameCount);
        restartbutton = (ImageButton) findViewById(R.id.restartBtn);

        preview.setBackgroundColor(tmp);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton1 < 1) {
                    button1.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton1 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton1 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton1 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton1 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton1 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton1 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton1 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton1 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton1 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton1 = 50;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton1 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton2 < 1) {
                    button2.setBackgroundColor(tmp);

                    if (tmp == Color.GREEN) {
                        colorButton2 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton2 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton2 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton2 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton2 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton2 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton2 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton2 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton2 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton2 = 51;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton2 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton3 < 1) {
                    button3.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton3 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton3 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton3 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton3 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton3 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton3 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton3 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton3 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton3 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton3 = 52;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton3 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton4 < 1) {
                    button4.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton4 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton4 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton4 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton4 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton4 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton4 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton4 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton4 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton4 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton4 = 53;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton4 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton5 < 1) {
                    button5.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton5 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton5 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton5 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton5 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton5 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton5 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton5 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton5 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton5 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton5 = 54;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton5 = 1;
                }

                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() > 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton6 < 1) {
                    button6.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton6 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton6 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton6 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton6 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton6 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton6 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton6 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton6 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton6 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton6 = 55;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton6 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton7 < 1) {
                    button7.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton7 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton7 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton7 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton7 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton7 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton7 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton7 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton7 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton7 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton7 = 56;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton7 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton8 < 1) {
                    button8.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton8 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton8 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton8 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton8 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton8 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton8 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton8 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton8 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton8 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton8 = 57;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton8 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton9 < 1) {
                    button9.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton9 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton9 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton9 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton9 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton9 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton9 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton9 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton9 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton9 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton9 = 58;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton9 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton10 < 1) {
                    button10.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton10 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton10 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton10 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton10 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton10 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton10 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton10 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton10 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton10 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton10 = 59;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton10 = 1;
                }
                checkForMatch();

                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton11 < 1) {
                    button11.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton11 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton11 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton11 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton11 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton11 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton11 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton11 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton11 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton11 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton11 = 60;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton11 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton12 < 1) {
                    button12.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton12 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton12 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton12 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton12 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton12 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton12 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton12 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton12 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton12 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton12 = 61;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton12 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton13 < 1) {
                    button13.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton13 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton13 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton13 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton13 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton13 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton13 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton13 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton13 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton13 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton13 = 62;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton13 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton14 < 1) {
                    button14.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton14 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton14 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton14 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton14 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton14 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton14 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton14 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton14 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton14 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton14 = 63;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton14 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton15 < 1) {
                    button15.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton15 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton15 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton15 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton15 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton15 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton15 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton15 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton15 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton15 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton15 = 64;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton15 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton16 < 1) {
                    button16.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton16 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton16 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton16 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton16 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton16 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton16 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton16 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton16 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton16 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton16 = 65;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton16 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }

            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton17 < 1) {
                    button17.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton17 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton17 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton17 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton17 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton17 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton17 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton17 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton17 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton17 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton17 = 66;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton17 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }

            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton18 < 1) {
                    button18.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton18 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton18 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton18 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton18 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton18 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton18 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton18 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton18 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton18 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton18 = 67;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton18 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }

            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton19 < 1) {
                    button19.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton19 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton19 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton19 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton19 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton19 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton19 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton19 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton19 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton19 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton19 = 68;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton19 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }

            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton20 < 1) {
                    button20.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton20 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton20 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton20 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton20 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton20 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton20 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton20 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton20 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton20 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton20 = 69;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton20 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }

            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton21 < 1) {
                    button21.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton21 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton21 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton21 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton21 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton21 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton21 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton21 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton21 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton21 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton21 = 70;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton21 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }

            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton22 < 1) {
                    button22.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton22 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton22 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton22 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton22 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton22 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton22 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton22 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton22 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton22 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton22 = 71;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton22 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }

            }
        });
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton23 < 1) {
                    button23.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton23 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton23 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton23 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton23 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton23 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton23 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton23 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton23 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton23 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton23 = 72;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton23 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }

            }
        });
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton24 < 1) {
                    button24.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton24 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton24 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton24 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton24 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton24 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton24 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton24 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton24 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton24 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton24 = 73;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton24 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }

            }
        });
        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boolButton25 < 1) {
                    button25.setBackgroundColor(tmp);
                    if (tmp == Color.GREEN) {
                        colorButton25 = 1;
                    }
                    if (tmp == Color.BLUE) {
                        colorButton25 = 2;
                    }
                    if (tmp == Color.RED) {
                        colorButton25 = 3;
                    }
                    if (tmp == Color.YELLOW) {
                        colorButton25 = 4;
                    }
                    if (tmp == Color.MAGENTA) {
                        colorButton25 = 5;
                    }
                    if (tmp == Color.rgb(255,153,0)) {
                        colorButton25 = 6;
                    }
                    if (tmp == Color.rgb(66,28,82)) {
                        colorButton25 = 7;
                    }
                    if (tmp == Color.CYAN) {
                        colorButton25 = 8;
                    }
                    if (tmp == Color.TRANSPARENT) {
                        colorButton25 = 9;
                    }
                    if (tmp == Color.BLACK) {
                        colorButton25 = 74;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton25 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16 + boolButton17 + boolButton18
                        + boolButton19 + boolButton20 + boolButton21 + boolButton22 + boolButton23 + boolButton24
                        + boolButton25;

                if (boolTotal > 24) {
                    gameOverDialog.show();
                    if (db.getHardHighScores().getCount() >= 0) {
                        db.addHardHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateHard(sqlConn);
                    }
                }

            }
        });

        restartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGameDialog.show();
            }
        });

        gameOverDialog.setTitle("Game Over").setMessage("Good Game! Would you like to restart?");
        gameOverDialog.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                sqlConn = db.getWritableDatabase();

                button1.setBackgroundColor(Color.WHITE);
                button2.setBackgroundColor(Color.WHITE);
                button3.setBackgroundColor(Color.WHITE);
                button4.setBackgroundColor(Color.WHITE);
                button5.setBackgroundColor(Color.WHITE);
                button6.setBackgroundColor(Color.WHITE);
                button7.setBackgroundColor(Color.WHITE);
                button8.setBackgroundColor(Color.WHITE);
                button9.setBackgroundColor(Color.WHITE);
                button10.setBackgroundColor(Color.WHITE);
                button11.setBackgroundColor(Color.WHITE);
                button12.setBackgroundColor(Color.WHITE);
                button13.setBackgroundColor(Color.WHITE);
                button14.setBackgroundColor(Color.WHITE);
                button15.setBackgroundColor(Color.WHITE);
                button16.setBackgroundColor(Color.WHITE);
                button17.setBackgroundColor(Color.WHITE);
                button18.setBackgroundColor(Color.WHITE);
                button19.setBackgroundColor(Color.WHITE);
                button20.setBackgroundColor(Color.WHITE);
                button21.setBackgroundColor(Color.WHITE);
                button22.setBackgroundColor(Color.WHITE);
                button23.setBackgroundColor(Color.WHITE);
                button24.setBackgroundColor(Color.WHITE);
                button25.setBackgroundColor(Color.WHITE);
                boolButton1 = 0;
                boolButton2 = 0;
                boolButton3 = 0;
                boolButton4 = 0;
                boolButton5 = 0;
                boolButton6 = 0;
                boolButton7 = 0;
                boolButton8 = 0;
                boolButton9 = 0;
                boolButton10 = 0;
                boolButton11 = 0;
                boolButton12 = 0;
                boolButton13 = 0;
                boolButton14 = 0;
                boolButton15 = 0;
                boolButton16 = 0;
                boolButton17 = 0;
                boolButton18 = 0;
                boolButton19 = 0;
                boolButton20 = 0;
                boolButton21 = 0;
                boolButton22 = 0;
                boolButton23 = 0;
                boolButton24 = 0;
                boolButton25 = 0;
                colorButton1 = 0;
                colorButton2 = 0;
                colorButton3 = 0;
                colorButton4 = 0;
                colorButton5 = 0;
                colorButton6 = 0;
                colorButton7 = 0;
                colorButton8 = 0;
                colorButton9 = 0;
                colorButton10 = 0;
                colorButton11 = 0;
                colorButton12 = 0;
                colorButton13 = 0;
                colorButton14 = 0;
                colorButton15 = 0;
                colorButton16 = 0;
                colorButton17 = 0;
                colorButton18 = 0;
                colorButton19 = 0;
                colorButton20 = 0;
                colorButton21 = 0;
                colorButton22 = 0;
                colorButton23 = 0;
                colorButton24 = 0;
                colorButton25 = 0;
                count = 0;
                correctCount.setText("SCORE: 0");
            }
        })
                .setNegativeButton("High Scores", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Cursor res = db.getHardHighScores();
                        StringBuffer buffer = new StringBuffer();

                        while (res.moveToNext()) {
                            buffer.append("Score:" + res.getString(0) + "\t");
                            buffer.append("Initials: " + res.getString(1) + "\n");
                        }
                        showMessage("High Scores", buffer.toString());
                    }
                });

        newGameDialog.setTitle("Restart").setMessage("Would you like to restart?");
        newGameDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                button1.setBackgroundColor(Color.WHITE);
                button2.setBackgroundColor(Color.WHITE);
                button3.setBackgroundColor(Color.WHITE);
                button4.setBackgroundColor(Color.WHITE);
                button5.setBackgroundColor(Color.WHITE);
                button6.setBackgroundColor(Color.WHITE);
                button7.setBackgroundColor(Color.WHITE);
                button8.setBackgroundColor(Color.WHITE);
                button9.setBackgroundColor(Color.WHITE);
                button10.setBackgroundColor(Color.WHITE);
                button11.setBackgroundColor(Color.WHITE);
                button12.setBackgroundColor(Color.WHITE);
                button13.setBackgroundColor(Color.WHITE);
                button14.setBackgroundColor(Color.WHITE);
                button15.setBackgroundColor(Color.WHITE);
                button16.setBackgroundColor(Color.WHITE);
                button17.setBackgroundColor(Color.WHITE);
                button18.setBackgroundColor(Color.WHITE);
                button19.setBackgroundColor(Color.WHITE);
                button20.setBackgroundColor(Color.WHITE);
                button21.setBackgroundColor(Color.WHITE);
                button22.setBackgroundColor(Color.WHITE);
                button23.setBackgroundColor(Color.WHITE);
                button24.setBackgroundColor(Color.WHITE);
                button25.setBackgroundColor(Color.WHITE);
                boolButton1 = 0;
                boolButton2 = 0;
                boolButton3 = 0;
                boolButton4 = 0;
                boolButton5 = 0;
                boolButton6 = 0;
                boolButton7 = 0;
                boolButton8 = 0;
                boolButton9 = 0;
                boolButton10 = 0;
                boolButton11 = 0;
                boolButton12 = 0;
                boolButton13 = 0;
                boolButton14 = 0;
                boolButton15 = 0;
                boolButton16 = 0;
                boolButton17 = 0;
                boolButton18 = 0;
                boolButton19 = 0;
                boolButton20 = 0;
                boolButton21 = 0;
                boolButton22 = 0;
                boolButton23 = 0;
                boolButton24 = 0;
                boolButton25 = 0;
                colorButton1 = 0;
                colorButton2 = 0;
                colorButton3 = 0;
                colorButton4 = 0;
                colorButton5 = 0;
                colorButton6 = 0;
                colorButton7 = 0;
                colorButton8 = 0;
                colorButton9 = 0;
                colorButton10 = 0;
                colorButton11 = 0;
                colorButton12 = 0;
                colorButton13 = 0;
                colorButton14 = 0;
                colorButton15 = 0;
                colorButton16 = 0;
                colorButton17 = 0;
                colorButton18 = 0;
                colorButton19 = 0;
                colorButton20 = 0;
                colorButton21 = 0;
                colorButton22 = 0;
                colorButton23 = 0;
                colorButton24 = 0;
                colorButton25 = 0;
                count = 0;
                correctCount.setText("SCORE: 0");
            }
        })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                });
    }

    public void checkForMatch(){

        if (colorButton1 == colorButton2 && colorButton1 == colorButton3 && colorButton1 == colorButton4
                && colorButton1 == colorButton5 && colorButton1 !=0 && colorButton2 != 0 && colorButton3 != 0
                && colorButton4 != 0 && colorButton5 != 0){
            button1.setBackgroundColor(Color.WHITE);
            button2.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            button4.setBackgroundColor(Color.WHITE);
            button5.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton2 = 0;
            boolButton3 = 0;
            boolButton4 = 0;
            boolButton5 = 0;
            colorButton1 = 0;
            colorButton2 = 0;
            colorButton3 = 0;
            colorButton4 = 0;
            colorButton5 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton6 == colorButton7 && colorButton6 == colorButton8 && colorButton6 == colorButton9
                && colorButton6 == colorButton10 && colorButton6 !=0 && colorButton7 != 0 && colorButton8 != 0
                && colorButton9 != 0 && colorButton10 != 0){
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            boolButton6 = 0;
            boolButton7 = 0;
            boolButton8 = 0;
            boolButton9 = 0;
            boolButton10 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            colorButton8 = 0;
            colorButton9 = 0;
            colorButton10 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton11 == colorButton12 && colorButton11 == colorButton13 && colorButton11 == colorButton14
                && colorButton11 == colorButton15 && colorButton11 !=0 && colorButton12 != 0 && colorButton13 != 0
                && colorButton14 != 0 && colorButton15 != 0){
            button11.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button13.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            boolButton11 = 0;
            boolButton12 = 0;
            boolButton13 = 0;
            boolButton14 = 0;
            boolButton15 = 0;
            colorButton11 = 0;
            colorButton12 = 0;
            colorButton13 = 0;
            colorButton14 = 0;
            colorButton15 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton16 == colorButton17 && colorButton16 == colorButton18 && colorButton16 == colorButton19
                && colorButton16 == colorButton20 && colorButton16 !=0 && colorButton17 != 0 && colorButton18 != 0
                && colorButton19 != 0 && colorButton20 != 0){
            button16.setBackgroundColor(Color.WHITE);
            button17.setBackgroundColor(Color.WHITE);
            button18.setBackgroundColor(Color.WHITE);
            button19.setBackgroundColor(Color.WHITE);
            button20.setBackgroundColor(Color.WHITE);
            boolButton16 = 0;
            boolButton17 = 0;
            boolButton18 = 0;
            boolButton19 = 0;
            boolButton20 = 0;
            colorButton16 = 0;
            colorButton17 = 0;
            colorButton18 = 0;
            colorButton19 = 0;
            colorButton20 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton21 == colorButton22 && colorButton21 == colorButton23 && colorButton21 == colorButton24
                && colorButton21 == colorButton25 && colorButton21 !=0 && colorButton22 != 0 && colorButton23 != 0
                && colorButton24 != 0 && colorButton25 != 0){
            button21.setBackgroundColor(Color.WHITE);
            button22.setBackgroundColor(Color.WHITE);
            button23.setBackgroundColor(Color.WHITE);
            button24.setBackgroundColor(Color.WHITE);
            button25.setBackgroundColor(Color.WHITE);
            boolButton21 = 0;
            boolButton22 = 0;
            boolButton23 = 0;
            boolButton24 = 0;
            boolButton25 = 0;
            colorButton21 = 0;
            colorButton22 = 0;
            colorButton23 = 0;
            colorButton24 = 0;
            colorButton25 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton1 == colorButton2 && colorButton1 == colorButton3 && colorButton1 != 0 && colorButton2 != 0 && colorButton3 != 0) {
            button1.setBackgroundColor(Color.WHITE);
            button2.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton2 = 0;
            boolButton3 = 0;
            colorButton1 = 0;
            colorButton2 = 0;
            colorButton3 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton2 == colorButton3 && colorButton2 == colorButton4 && colorButton2 != 0 && colorButton3 != 0 && colorButton4 != 0) {
            button2.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            button4.setBackgroundColor(Color.WHITE);
            boolButton2 = 0;
            boolButton3 = 0;
            boolButton4 = 0;
            colorButton2 = 0;
            colorButton3 = 0;
            colorButton4 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton3 == colorButton4 && colorButton3 == colorButton5 && colorButton3 != 0 && colorButton4 != 0 && colorButton5 != 0) {
            button3.setBackgroundColor(Color.WHITE);
            button4.setBackgroundColor(Color.WHITE);
            button5.setBackgroundColor(Color.WHITE);
            boolButton3 = 0;
            boolButton4 = 0;
            boolButton5 = 0;
            colorButton3 = 0;
            colorButton4 = 0;
            colorButton5 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton6 == colorButton7 && colorButton6 == colorButton8 && colorButton6 != 0 && colorButton7 != 0 && colorButton8 != 0) {
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            boolButton6 = 0;
            boolButton7 = 0;
            boolButton8 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            colorButton8 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton7 == colorButton8 && colorButton7 == colorButton9 && colorButton7 != 0 && colorButton8 != 0 && colorButton9 != 0) {
            button7.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            boolButton7 = 0;
            boolButton8 = 0;
            boolButton9 = 0;
            colorButton7 = 0;
            colorButton8 = 0;
            colorButton9 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton8 == colorButton9 && colorButton8 == colorButton10 && colorButton8 != 0 && colorButton9 != 0 && colorButton10 != 0) {
            button8.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            boolButton8 = 0;
            boolButton9 = 0;
            boolButton10 = 0;
            colorButton8 = 0;
            colorButton9 = 0;
            colorButton10 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton11 == colorButton12 && colorButton11 == colorButton13 && colorButton11 != 0 && colorButton12 != 0 && colorButton13 != 0) {
            button11.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button13.setBackgroundColor(Color.WHITE);
            boolButton11 = 0;
            boolButton12 = 0;
            boolButton13 = 0;
            colorButton11 = 0;
            colorButton12 = 0;
            colorButton13 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton12 == colorButton13 && colorButton12 == colorButton14 && colorButton12 != 0 && colorButton13 != 0 && colorButton14 != 0) {
            button12.setBackgroundColor(Color.WHITE);
            button13.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            boolButton12 = 0;
            boolButton13 = 0;
            boolButton14 = 0;
            colorButton12 = 0;
            colorButton13 = 0;
            colorButton14 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton13 == colorButton14 && colorButton13 == colorButton15 && colorButton13 != 0 && colorButton14 != 0 && colorButton15 != 0) {
            button13.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            boolButton13 = 0;
            boolButton14 = 0;
            boolButton15 = 0;
            colorButton13 = 0;
            colorButton14 = 0;
            colorButton15 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton16 == colorButton17 && colorButton16 == colorButton18 && colorButton16 != 0 && colorButton17 != 0 && colorButton18 != 0) {
            button16.setBackgroundColor(Color.WHITE);
            button17.setBackgroundColor(Color.WHITE);
            button18.setBackgroundColor(Color.WHITE);
            boolButton16 = 0;
            boolButton17 = 0;
            boolButton18 = 0;
            colorButton16 = 0;
            colorButton17 = 0;
            colorButton18 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton17 == colorButton18 && colorButton17 == colorButton19 && colorButton17 != 0 && colorButton18 != 0 && colorButton19 != 0) {
            button17.setBackgroundColor(Color.WHITE);
            button18.setBackgroundColor(Color.WHITE);
            button19.setBackgroundColor(Color.WHITE);
            boolButton17 = 0;
            boolButton18 = 0;
            boolButton19 = 0;
            colorButton17 = 0;
            colorButton18 = 0;
            colorButton19 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton18 == colorButton19 && colorButton18 == colorButton20 && colorButton18 != 0 && colorButton19 != 0 && colorButton20 != 0) {
            button18.setBackgroundColor(Color.WHITE);
            button19.setBackgroundColor(Color.WHITE);
            button20.setBackgroundColor(Color.WHITE);
            boolButton18 = 0;
            boolButton19 = 0;
            boolButton20 = 0;
            colorButton18 = 0;
            colorButton19 = 0;
            colorButton20 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton21 == colorButton22 && colorButton21 == colorButton23 && colorButton21 != 0 && colorButton22 != 0 && colorButton23 != 0) {
            button21.setBackgroundColor(Color.WHITE);
            button22.setBackgroundColor(Color.WHITE);
            button23.setBackgroundColor(Color.WHITE);
            boolButton21 = 0;
            boolButton22 = 0;
            boolButton23 = 0;
            colorButton21 = 0;
            colorButton22 = 0;
            colorButton23 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton22 == colorButton23 && colorButton22 == colorButton24 && colorButton22 != 0 && colorButton23 != 0 && colorButton24 != 0) {
            button22.setBackgroundColor(Color.WHITE);
            button23.setBackgroundColor(Color.WHITE);
            button24.setBackgroundColor(Color.WHITE);
            boolButton22 = 0;
            boolButton23 = 0;
            boolButton24 = 0;
            colorButton22 = 0;
            colorButton23= 0;
            colorButton24 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton23 == colorButton24 && colorButton23 == colorButton25 && colorButton23 != 0 && colorButton24 != 0 && colorButton25 != 0) {
            button23.setBackgroundColor(Color.WHITE);
            button24.setBackgroundColor(Color.WHITE);
            button25.setBackgroundColor(Color.WHITE);
            boolButton23 = 0;
            boolButton24 = 0;
            boolButton25 = 0;
            colorButton23 = 0;
            colorButton24 = 0;
            colorButton25 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton1 == colorButton6 && colorButton1 == colorButton11 && colorButton1 != 0 && colorButton6 != 0 && colorButton11 != 0) {
            button1.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton6 = 0;
            boolButton11 = 0;
            colorButton1 = 0;
            colorButton6 = 0;
            colorButton11 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton6 == colorButton11 && colorButton6 == colorButton16 && colorButton6 != 0 && colorButton11 != 0 && colorButton16 != 0) {
            button6.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            boolButton6 = 0;
            boolButton11 = 0;
            boolButton16 = 0;
            colorButton6 = 0;
            colorButton11 = 0;
            colorButton16 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton11 == colorButton16 && colorButton11 == colorButton21 && colorButton11 != 0 && colorButton16 != 0 && colorButton21 != 0) {
            button11.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            button21.setBackgroundColor(Color.WHITE);
            boolButton11 = 0;
            boolButton16 = 0;
            boolButton21 = 0;
            colorButton11 = 0;
            colorButton16 = 0;
            colorButton21 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton2 == colorButton7 && colorButton2 == colorButton12 && colorButton2 != 0 && colorButton7 != 0 && colorButton12 != 0) {
            button2.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            boolButton2 = 0;
            boolButton7 = 0;
            boolButton12 = 0;
            colorButton2 = 0;
            colorButton7 = 0;
            colorButton12 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton7 == colorButton12 && colorButton7 == colorButton17 && colorButton7 != 0 && colorButton12 != 0 && colorButton17 != 0) {
            button7.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button17.setBackgroundColor(Color.WHITE);
            boolButton7 = 0;
            boolButton12 = 0;
            boolButton17 = 0;
            colorButton7 = 0;
            colorButton12 = 0;
            colorButton17 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton12 == colorButton17 && colorButton12 == colorButton22 && colorButton12 != 0 && colorButton17 != 0 && colorButton22 != 0) {
            button12.setBackgroundColor(Color.WHITE);
            button17.setBackgroundColor(Color.WHITE);
            button22.setBackgroundColor(Color.WHITE);
            boolButton12 = 0;
            boolButton17 = 0;
            boolButton22 = 0;
            colorButton12 = 0;
            colorButton17 = 0;
            colorButton22 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton3 == colorButton8 && colorButton3 == colorButton13 && colorButton3 != 0 && colorButton8 != 0 && colorButton13 != 0) {
            button3.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button13.setBackgroundColor(Color.WHITE);
            boolButton3 = 0;
            boolButton8 = 0;
            boolButton13 = 0;
            colorButton3 = 0;
            colorButton8 = 0;
            colorButton13 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton8 == colorButton13 && colorButton8 == colorButton18 && colorButton8 != 0 && colorButton13 != 0 && colorButton18 != 0) {
            button8.setBackgroundColor(Color.WHITE);
            button13.setBackgroundColor(Color.WHITE);
            button18.setBackgroundColor(Color.WHITE);
            boolButton8 = 0;
            boolButton13 = 0;
            boolButton18 = 0;
            colorButton8 = 0;
            colorButton13 = 0;
            colorButton18 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton13 == colorButton18 && colorButton13 == colorButton23 && colorButton13 != 0 && colorButton18 != 0 && colorButton23 != 0) {
            button13.setBackgroundColor(Color.WHITE);
            button18.setBackgroundColor(Color.WHITE);
            button23.setBackgroundColor(Color.WHITE);
            boolButton13 = 0;
            boolButton18 = 0;
            boolButton23 = 0;
            colorButton13 = 0;
            colorButton18 = 0;
            colorButton23 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton4 == colorButton9 && colorButton4 == colorButton14 && colorButton4 != 0 && colorButton9 != 0 && colorButton14 != 0) {
            button4.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            boolButton4 = 0;
            boolButton9 = 0;
            boolButton14 = 0;
            colorButton4 = 0;
            colorButton9 = 0;
            colorButton14 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton9 == colorButton14 && colorButton9 == colorButton19 && colorButton9 != 0 && colorButton14 != 0 && colorButton19 != 0) {
            button9.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            button19.setBackgroundColor(Color.WHITE);
            boolButton9 = 0;
            boolButton14 = 0;
            boolButton19 = 0;
            colorButton9 = 0;
            colorButton14 = 0;
            colorButton19 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton14 == colorButton19 && colorButton14 == colorButton24 && colorButton14 != 0 && colorButton19 != 0 && colorButton24 != 0) {
            button14.setBackgroundColor(Color.WHITE);
            button19.setBackgroundColor(Color.WHITE);
            button24.setBackgroundColor(Color.WHITE);
            boolButton14 = 0;
            boolButton19 = 0;
            boolButton24 = 0;
            colorButton14 = 0;
            colorButton19 = 0;
            colorButton24 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton5 == colorButton10 && colorButton5 == colorButton15 && colorButton5 != 0 && colorButton10 != 0 && colorButton15 != 0) {
            button5.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            boolButton5 = 0;
            boolButton10 = 0;
            boolButton15 = 0;
            colorButton5 = 0;
            colorButton10 = 0;
            colorButton15 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton10 == colorButton15 && colorButton10 == colorButton20 && colorButton10 != 0 && colorButton15 != 0 && colorButton20 != 0) {
            button10.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            button20.setBackgroundColor(Color.WHITE);
            boolButton10 = 0;
            boolButton15 = 0;
            boolButton20 = 0;
            colorButton10 = 0;
            colorButton15 = 0;
            colorButton20 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton15 == colorButton20 && colorButton15 == colorButton25 && colorButton15 != 0 && colorButton20 != 0 && colorButton25 != 0) {
            button15.setBackgroundColor(Color.WHITE);
            button20.setBackgroundColor(Color.WHITE);
            button25.setBackgroundColor(Color.WHITE);
            boolButton15 = 0;
            boolButton20 = 0;
            boolButton25 = 0;
            colorButton15 = 0;
            colorButton20 = 0;
            colorButton25 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }

    }

    public static int randomColor() {
        int x, color;

        x = (int) (Math.random() * 100);
        if (x <= 11) {
            color = Color.BLUE;
        } else if (x <= 22) {
            color = Color.RED;
        } else if (x <= 33) {
            color = Color.GREEN;
        } else if (x <= 44) {
            color = Color.MAGENTA;
        } else if (x <= 55) {
            color = Color.YELLOW;
        } else if (x <= 66) {
            color = Color.rgb(255,153,0);
        } else if (x <= 77) {
            color = Color.CYAN;
        } else if (x <= 89) {
            color = Color.rgb(66,28,82);
        } else {
            color = Color.BLACK;
        }
        return color;
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
}
