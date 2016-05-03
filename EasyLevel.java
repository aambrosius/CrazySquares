package edu.missouriwestern.aambrosius.retrobejewled;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.List;

/**
 * Created by Ambrosius on 3/2/2016.
 */
public class EasyLevel extends MainActivity {
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

    ImageButton restartButton;

    TextView correctCount;

    Database db = new Database(this);
    SQLiteDatabase sqlConn;

    int tmp = randomColor();
    int boolButton1 = 0, boolButton2 = 0, boolButton3 = 0, boolButton4 = 0, boolButton5 = 0, boolButton6 = 0,
            boolButton7 = 0, boolButton8 = 0, boolButton9 = 0, boolButton10 = 0, boolButton11 = 0, boolButton12 = 0,
            boolButton13 = 0, boolButton14 = 0, boolButton15 = 0, boolButton16 = 0, boolTotal = 0, colorButton1 = 0,
            colorButton2 = 0, colorButton3 = 0, colorButton4 = 0, colorButton5 = 0, colorButton6 = 0, colorButton7 = 0,
            colorButton8 = 0, colorButton9 = 0, colorButton10 = 0, colorButton11 = 0, colorButton12 = 0, colorButton13 = 0,
            colorButton14 = 0, colorButton15 = 0, colorButton16 = 0, count = 0;

    String name;


    //@Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();
        name = i.getExtras().getString("Initial");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);

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
        correctCount = (TextView) findViewById(R.id.gameCount);
        restartButton = (ImageButton) findViewById(R.id.restartBtn);

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
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton2 = 55;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton2 = 1;
                }

                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton3 = 60;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton3 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton4 = 65;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton4 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton5 = 70;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton5 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton6 = 80;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton6 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton7 = 80;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton7 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton8 = 90;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton8 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton9 = 95;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton9 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton10 = 100;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton10 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton11 = 105;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton11 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton12 = 110;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton12 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton13 = 115;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton13 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton14 = 120;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton14 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton15 = 125;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton15 = 1;
                }
                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
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
                    if (tmp == Color.BLACK) {
                        colorButton16 = 130;
                    }
                    tmp = randomColor();
                    preview.setBackgroundColor(tmp);
                    boolButton16 = 1;
                }

                checkForMatch();
                boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                        + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                        + boolButton13 + boolButton14 + boolButton15 + boolButton16;

                if (boolTotal > 15) {
                    gameOverDialog.show();
                    if (db.getEasyHighScores().getCount() >= 0) {
                        db.addEasyHighScore(new HighScores(count, name));
                    } else {
                        db.onCreateEasy(sqlConn);
                    }
                }
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
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
                count = 0;
                correctCount.setText("SCORE: 0");
            }
        })
                .

                        setNegativeButton("High Scores", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Cursor res = db.getEasyHighScores();
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

    public void checkForMatch() {

        if (colorButton1 == colorButton2 && colorButton1 == colorButton3 && colorButton1 == colorButton4
                && colorButton1 == colorButton6 && colorButton1 == colorButton10 && colorButton1 != 0 && colorButton2 != 0
                && colorButton3 != 0 && colorButton4 != 0 && colorButton6 != 0 && colorButton10 != 0) {
            button1.setBackgroundColor(Color.WHITE);
            button2.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            button4.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton2 = 0;
            boolButton3 = 0;
            boolButton4 = 0;
            boolButton6 = 0;
            boolButton10 = 0;
            colorButton1 = 0;
            colorButton2 = 0;
            colorButton3 = 0;
            colorButton4 = 0;
            colorButton6 = 0;
            colorButton10 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton1 == colorButton2 && colorButton1 == colorButton3 && colorButton1 == colorButton4
                && colorButton1 == colorButton7 && colorButton1 == colorButton11 && colorButton1 != 0 && colorButton2 != 0
                && colorButton3 != 0 && colorButton4 != 0 && colorButton7 != 0 && colorButton11 != 0) {
            button1.setBackgroundColor(Color.WHITE);
            button2.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            button4.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton2 = 0;
            boolButton3 = 0;
            boolButton4 = 0;
            boolButton7 = 0;
            boolButton11 = 0;
            colorButton1 = 0;
            colorButton2 = 0;
            colorButton3 = 0;
            colorButton4 = 0;
            colorButton7 = 0;
            colorButton11 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton5 == colorButton6 && colorButton5 == colorButton7 && colorButton5 == colorButton8
                && colorButton5 == colorButton10 && colorButton5 == colorButton14 && colorButton5 != 0 && colorButton6 != 0
                && colorButton7 != 0 && colorButton8 != 0 && colorButton10 != 0 && colorButton14 != 0) {
            button5.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            boolButton5 = 0;
            boolButton6 = 0;
            boolButton7 = 0;
            boolButton8 = 0;
            boolButton10 = 0;
            boolButton14 = 0;
            colorButton5 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            colorButton8 = 0;
            colorButton10 = 0;
            colorButton14 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton5 == colorButton6 && colorButton5 == colorButton7 && colorButton5 == colorButton8
                && colorButton5 == colorButton11 && colorButton5 == colorButton15 && colorButton5 != 0 && colorButton6 != 0
                && colorButton7 != 0 && colorButton8 != 0 && colorButton11 != 0 && colorButton15 != 0) {
            button5.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            boolButton5 = 0;
            boolButton6 = 0;
            boolButton7 = 0;
            boolButton8 = 0;
            boolButton11 = 0;
            boolButton15 = 0;
            colorButton5 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            colorButton8 = 0;
            colorButton11 = 0;
            colorButton15 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton9 == colorButton10 && colorButton9 == colorButton11 && colorButton9 == colorButton12
                && colorButton9 == colorButton6 && colorButton9 == colorButton2 && colorButton9 != 0 && colorButton10 != 0
                && colorButton11 != 0 && colorButton12 != 0 && colorButton6 != 0 && colorButton2 != 0) {
            button9.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button2.setBackgroundColor(Color.WHITE);
            boolButton9 = 0;
            boolButton10 = 0;
            boolButton11 = 0;
            boolButton12 = 0;
            boolButton6 = 0;
            boolButton2 = 0;
            colorButton9 = 0;
            colorButton10 = 0;
            colorButton11 = 0;
            colorButton12 = 0;
            colorButton6 = 0;
            colorButton2 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton9 == colorButton10 && colorButton9 == colorButton11 && colorButton9 == colorButton12
                && colorButton9 == colorButton7 && colorButton9 == colorButton3 && colorButton9 != 0 && colorButton10 != 0
                && colorButton11 != 0 && colorButton12 != 0 && colorButton7 != 0 && colorButton3 != 0) {
            button9.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            boolButton9 = 0;
            boolButton10 = 0;
            boolButton11 = 0;
            boolButton12 = 0;
            boolButton7 = 0;
            boolButton3 = 0;
            colorButton9 = 0;
            colorButton10 = 0;
            colorButton11 = 0;
            colorButton12 = 0;
            colorButton7 = 0;
            colorButton3 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton13 == colorButton14 && colorButton13 == colorButton15 && colorButton13 == colorButton16
                && colorButton13 == colorButton10 && colorButton13 == colorButton6 && colorButton13 != 0 && colorButton14 != 0
                && colorButton15 != 0 && colorButton16 != 0 && colorButton6 != 0 && colorButton10 != 0) {
            button13.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            boolButton13 = 0;
            boolButton14 = 0;
            boolButton15 = 0;
            boolButton16 = 0;
            boolButton10 = 0;
            boolButton6 = 0;
            colorButton13 = 0;
            colorButton14 = 0;
            colorButton15 = 0;
            colorButton16 = 0;
            colorButton10 = 0;
            colorButton6 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton13 == colorButton14 && colorButton13 == colorButton15 && colorButton13 == colorButton16
                && colorButton13 == colorButton11 && colorButton13 == colorButton7 && colorButton13 != 0 && colorButton14 != 0
                && colorButton15 != 0 && colorButton16 != 0 && colorButton7 != 0 && colorButton7 != 0) {
            button13.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            boolButton13 = 0;
            boolButton14 = 0;
            boolButton15 = 0;
            boolButton16 = 0;
            boolButton11 = 0;
            boolButton7 = 0;
            colorButton13 = 0;
            colorButton14 = 0;
            colorButton15 = 0;
            colorButton16 = 0;
            colorButton11 = 0;
            colorButton7 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton1 == colorButton5 && colorButton1 == colorButton9 && colorButton1 == colorButton13
                && colorButton1 == colorButton6 && colorButton1 == colorButton7 && colorButton1 != 0 && colorButton5 != 0
                && colorButton9 != 0 && colorButton13 != 0 && colorButton6 != 0 && colorButton7 != 0) {
            button1.setBackgroundColor(Color.WHITE);
            button5.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            button13.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton5 = 0;
            boolButton9 = 0;
            boolButton13 = 0;
            boolButton6 = 0;
            boolButton7 = 0;
            colorButton1 = 0;
            colorButton5 = 0;
            colorButton9 = 0;
            colorButton13 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton1 == colorButton5 && colorButton1 == colorButton9 && colorButton1 == colorButton13
                && colorButton1 == colorButton10 && colorButton1 == colorButton11 && colorButton1 != 0 && colorButton5 != 0
                && colorButton9 != 0 && colorButton13 != 0 && colorButton10 != 0 && colorButton11 != 0) {
            button1.setBackgroundColor(Color.WHITE);
            button5.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            button13.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton5 = 0;
            boolButton9 = 0;
            boolButton13 = 0;
            boolButton10 = 0;
            boolButton11 = 0;
            colorButton1 = 0;
            colorButton5 = 0;
            colorButton9 = 0;
            colorButton13 = 0;
            colorButton10 = 0;
            colorButton11 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton2 == colorButton6 && colorButton2 == colorButton10 && colorButton2 == colorButton14
                && colorButton2 == colorButton7 && colorButton2 == colorButton8 && colorButton2 != 0 && colorButton6 != 0
                && colorButton10 != 0 && colorButton14 != 0 && colorButton7 != 0 && colorButton8 != 0) {
            button2.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            boolButton2 = 0;
            boolButton6 = 0;
            boolButton10 = 0;
            boolButton14 = 0;
            boolButton7 = 0;
            boolButton8 = 0;
            colorButton2 = 0;
            colorButton6 = 0;
            colorButton10 = 0;
            colorButton14 = 0;
            colorButton7 = 0;
            colorButton8 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton2 == colorButton6 && colorButton2 == colorButton10 && colorButton2 == colorButton14
                && colorButton2 == colorButton11 && colorButton2 == colorButton12 && colorButton2 != 0 && colorButton6 != 0
                && colorButton10 != 0 && colorButton14 != 0 && colorButton11 != 0 && colorButton12 != 0) {
            button2.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            boolButton2 = 0;
            boolButton6 = 0;
            boolButton10 = 0;
            boolButton14 = 0;
            boolButton11 = 0;
            boolButton12 = 0;
            colorButton2 = 0;
            colorButton6 = 0;
            colorButton10 = 0;
            colorButton14 = 0;
            colorButton11 = 0;
            colorButton12 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton3 == colorButton7 && colorButton3 == colorButton11 && colorButton3 == colorButton15
                && colorButton3 == colorButton6 && colorButton3 == colorButton5 && colorButton3 != 0 && colorButton7 != 0
                && colorButton11 != 0 && colorButton15 != 0 && colorButton6 != 0 && colorButton5 != 0) {
            button3.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button5.setBackgroundColor(Color.WHITE);
            boolButton3 = 0;
            boolButton7 = 0;
            boolButton11 = 0;
            boolButton15 = 0;
            boolButton6 = 0;
            boolButton5 = 0;
            colorButton3 = 0;
            colorButton7 = 0;
            colorButton11 = 0;
            colorButton15 = 0;
            colorButton6 = 0;
            colorButton5 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton3 == colorButton7 && colorButton3 == colorButton11 && colorButton3 == colorButton15
                && colorButton3 == colorButton10 && colorButton3 == colorButton9 && colorButton3 != 0 && colorButton7 != 0
                && colorButton11 != 0 && colorButton15 != 0 && colorButton6 != 0 && colorButton5 != 0) {
            button3.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            boolButton3 = 0;
            boolButton7 = 0;
            boolButton11 = 0;
            boolButton15 = 0;
            boolButton10 = 0;
            boolButton9 = 0;
            colorButton3 = 0;
            colorButton7 = 0;
            colorButton11 = 0;
            colorButton15 = 0;
            colorButton10 = 0;
            colorButton9 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton4 == colorButton8 && colorButton4 == colorButton12 && colorButton4 == colorButton16
                && colorButton4 == colorButton7 && colorButton4 == colorButton6 && colorButton4 != 0 && colorButton8 != 0
                && colorButton12 != 0 && colorButton16 != 0 && colorButton7 != 0 && colorButton6 != 0) {
            button4.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            boolButton4 = 0;
            boolButton8 = 0;
            boolButton12 = 0;
            boolButton16 = 0;
            boolButton7 = 0;
            boolButton6 = 0;
            colorButton4 = 0;
            colorButton8 = 0;
            colorButton12 = 0;
            colorButton16 = 0;
            colorButton7 = 0;
            colorButton6 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton4 == colorButton8 && colorButton4 == colorButton12 && colorButton4 == colorButton16
                && colorButton4 == colorButton11 && colorButton4 == colorButton10 && colorButton4 != 0 && colorButton8 != 0
                && colorButton12 != 0 && colorButton16 != 0 && colorButton11 != 0 && colorButton10 != 0) {
            button4.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            boolButton4 = 0;
            boolButton8 = 0;
            boolButton12 = 0;
            boolButton16 = 0;
            boolButton11 = 0;
            boolButton10 = 0;
            colorButton4 = 0;
            colorButton8 = 0;
            colorButton12 = 0;
            colorButton16 = 0;
            colorButton11 = 0;
            colorButton10 = 0;
            count = count + 4;
            correctCount.setText("SCORE: " + count);
        }


        if (colorButton1 == colorButton2 && colorButton1 == colorButton3 && colorButton1 == colorButton4
                && colorButton1 != 0 && colorButton2 != 0 && colorButton3 != 0 && colorButton4 != 0) {
            button1.setBackgroundColor(Color.WHITE);
            button2.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            button4.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton2 = 0;
            boolButton3 = 0;
            boolButton4 = 0;
            colorButton1 = 0;
            colorButton2 = 0;
            colorButton3 = 0;
            colorButton4 = 0;
            count = count + 2;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton5 == colorButton6 && colorButton5 == colorButton7 && colorButton5 == colorButton8
                && colorButton5 != 0 && colorButton6 != 0 && colorButton7 != 0 && colorButton8 != 0) {
            button5.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            boolButton5 = 0;
            boolButton6 = 0;
            boolButton7 = 0;
            boolButton8 = 0;
            colorButton5 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            colorButton8 = 0;
            count = count + 2;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton9 == colorButton10 && colorButton9 == colorButton11 && colorButton9 == colorButton12
                && colorButton9 != 0 && colorButton10 != 0 && colorButton11 != 0 && colorButton12 != 0) {
            button9.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            boolButton9 = 0;
            boolButton10 = 0;
            boolButton11 = 0;
            boolButton12 = 0;
            colorButton9 = 0;
            colorButton10 = 0;
            colorButton11 = 0;
            colorButton12 = 0;
            count = count + 2;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton13 == colorButton14 && colorButton13 == colorButton15 && colorButton13 == colorButton16
                && colorButton13 != 0 && colorButton14 != 0 && colorButton15 != 0 && colorButton16 != 0) {
            button13.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            boolButton13 = 0;
            boolButton14 = 0;
            boolButton15 = 0;
            boolButton16 = 0;
            colorButton13 = 0;
            colorButton14 = 0;
            colorButton15 = 0;
            colorButton16 = 0;
            count = count + 2;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton1 == colorButton5 && colorButton1 == colorButton9 && colorButton1 == colorButton13
                && colorButton1 != 0 && colorButton5 != 0 && colorButton9 != 0 && colorButton13 != 0) {
            button1.setBackgroundColor(Color.WHITE);
            button5.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            button13.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton5 = 0;
            boolButton9 = 0;
            boolButton13 = 0;
            colorButton1 = 0;
            colorButton5 = 0;
            colorButton9 = 0;
            colorButton13 = 0;
            count = count + 2;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton2 == colorButton6 && colorButton2 == colorButton10 && colorButton2 == colorButton14
                && colorButton2 != 0 && colorButton6 != 0 && colorButton10 != 0 && colorButton14 != 0) {
            button2.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            boolButton2 = 0;
            boolButton6 = 0;
            boolButton10 = 0;
            boolButton14 = 0;
            colorButton2 = 0;
            colorButton6 = 0;
            colorButton10 = 0;
            colorButton14 = 0;
            count = count + 2;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton3 == colorButton7 && colorButton3 == colorButton11 && colorButton3 == colorButton15
                && colorButton3 != 0 && colorButton7 != 0 && colorButton11 != 0 && colorButton15 != 0) {
            button3.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            boolButton3 = 0;
            boolButton7 = 0;
            boolButton11 = 0;
            boolButton15 = 0;
            colorButton3 = 0;
            colorButton7 = 0;
            colorButton11 = 0;
            colorButton15 = 0;
            count = count + 2;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton4 == colorButton8 && colorButton4 == colorButton12 && colorButton4 == colorButton16
                && colorButton4 != 0 && colorButton8 != 0 && colorButton12 != 0 && colorButton16 != 0) {
            button4.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            boolButton4 = 0;
            boolButton8 = 0;
            boolButton12 = 0;
            boolButton16 = 0;
            colorButton4 = 0;
            colorButton8 = 0;
            colorButton12 = 0;
            colorButton16 = 0;
            count = count + 2;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton1 == colorButton2 && colorButton1 == colorButton3 && colorButton1 == colorButton6
                && colorButton1 == colorButton10 && colorButton1 != 0 && colorButton2 != 0
                && colorButton3 != 0 && colorButton6 != 0 && colorButton10 != 0) {
            button1.setBackgroundColor(Color.WHITE);
            button2.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton2 = 0;
            boolButton3 = 0;
            boolButton6 = 0;
            boolButton10 = 0;
            colorButton1 = 0;
            colorButton2 = 0;
            colorButton3 = 0;
            colorButton6 = 0;
            colorButton10 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton2 == colorButton3 && colorButton2 == colorButton4 && colorButton2 == colorButton7
                && colorButton2 == colorButton11 && colorButton2 != 0 && colorButton3 != 0
                && colorButton4 != 0 && colorButton7 != 0 && colorButton11 != 0) {
            button2.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            button4.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            boolButton2 = 0;
            boolButton3 = 0;
            boolButton4 = 0;
            boolButton7 = 0;
            boolButton11 = 0;
            colorButton2 = 0;
            colorButton3 = 0;
            colorButton4 = 0;
            colorButton7 = 0;
            colorButton11 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton5 == colorButton6 && colorButton5 == colorButton7 && colorButton5 == colorButton10
                && colorButton5 == colorButton14 && colorButton5 != 0 && colorButton6 != 0
                && colorButton7 != 0 && colorButton10 != 0 && colorButton14 != 0) {
            button5.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            boolButton5 = 0;
            boolButton6 = 0;
            boolButton7 = 0;
            boolButton10 = 0;
            boolButton14 = 0;
            colorButton5 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            colorButton10 = 0;
            colorButton14 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton6 == colorButton7 && colorButton6 == colorButton8 && colorButton6 == colorButton11
                && colorButton6 == colorButton15 && colorButton6 != 0 && colorButton7 != 0
                && colorButton8 != 0 && colorButton11 != 0 && colorButton15 != 0) {
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            boolButton6 = 0;
            boolButton7 = 0;
            boolButton8 = 0;
            boolButton11 = 0;
            boolButton15 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            colorButton8 = 0;
            colorButton11 = 0;
            colorButton15 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton9 == colorButton10 && colorButton9 == colorButton11 && colorButton9 == colorButton6
                && colorButton9 == colorButton2 && colorButton9 != 0 && colorButton10 != 0
                && colorButton11 != 0 && colorButton6 != 0 && colorButton2 != 0) {
            button9.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button2.setBackgroundColor(Color.WHITE);
            boolButton9 = 0;
            boolButton10 = 0;
            boolButton11 = 0;
            boolButton6 = 0;
            boolButton2 = 0;
            colorButton9 = 0;
            colorButton10 = 0;
            colorButton11 = 0;
            colorButton6 = 0;
            colorButton2 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton10 == colorButton11 && colorButton10 == colorButton12 && colorButton10 == colorButton7
                && colorButton10 == colorButton3 && colorButton10 != 0 && colorButton11 != 0
                && colorButton12 != 0 && colorButton7 != 0 && colorButton3 != 0) {
            button10.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            boolButton10 = 0;
            boolButton11 = 0;
            boolButton12 = 0;
            boolButton7 = 0;
            boolButton3 = 0;
            colorButton10 = 0;
            colorButton11 = 0;
            colorButton12 = 0;
            colorButton7 = 0;
            colorButton3 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton13 == colorButton14 && colorButton13 == colorButton15 && colorButton13 == colorButton10
                && colorButton13 == colorButton6 && colorButton13 != 0 && colorButton14 != 0
                && colorButton15 != 0 && colorButton10 != 0 && colorButton6 != 0) {
            button13.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            boolButton13 = 0;
            boolButton14 = 0;
            boolButton15 = 0;
            boolButton10 = 0;
            boolButton6 = 0;
            colorButton13 = 0;
            colorButton14 = 0;
            colorButton15 = 0;
            colorButton10 = 0;
            colorButton6 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton14 == colorButton15 && colorButton14 == colorButton16 && colorButton14 == colorButton11
                && colorButton14 == colorButton7 && colorButton14 != 0 && colorButton15 != 0
                && colorButton16 != 0 && colorButton11 != 0 && colorButton7 != 0) {
            button14.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            boolButton14 = 0;
            boolButton15 = 0;
            boolButton16 = 0;
            boolButton11 = 0;
            boolButton7 = 0;
            colorButton14 = 0;
            colorButton15 = 0;
            colorButton16 = 0;
            colorButton11 = 0;
            colorButton7 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton1 == colorButton5 && colorButton1 == colorButton9 && colorButton1 == colorButton6
                && colorButton1 == colorButton7 && colorButton1 != 0 && colorButton5 != 0
                && colorButton9 != 0 && colorButton6 != 0 && colorButton7 != 0) {
            button1.setBackgroundColor(Color.WHITE);
            button5.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton5 = 0;
            boolButton9 = 0;
            boolButton6 = 0;
            boolButton7 = 0;
            colorButton1 = 0;
            colorButton5 = 0;
            colorButton9 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton5 == colorButton9 && colorButton5 == colorButton13 && colorButton5 == colorButton10
                && colorButton5 == colorButton11 && colorButton5 != 0 && colorButton9 != 0
                && colorButton13 != 0 && colorButton10 != 0 && colorButton11 != 0) {
            button5.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            button13.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            boolButton5 = 0;
            boolButton9 = 0;
            boolButton13 = 0;
            boolButton10 = 0;
            boolButton11 = 0;
            colorButton5 = 0;
            colorButton9 = 0;
            colorButton13 = 0;
            colorButton10 = 0;
            colorButton11 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton2 == colorButton6 && colorButton2 == colorButton10 && colorButton2 == colorButton7
                && colorButton2 == colorButton8 && colorButton2 != 0 && colorButton6 != 0
                && colorButton10 != 0 && colorButton7 != 0 && colorButton8 != 0) {
            button2.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            boolButton2 = 0;
            boolButton6 = 0;
            boolButton10 = 0;
            boolButton7 = 0;
            boolButton8 = 0;
            colorButton2 = 0;
            colorButton6 = 0;
            colorButton10 = 0;
            colorButton7 = 0;
            colorButton8 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton6 == colorButton10 && colorButton6 == colorButton14 && colorButton6 == colorButton11
                && colorButton6 == colorButton12 && colorButton6 != 0 && colorButton10 != 0
                && colorButton14 != 0 && colorButton11 != 0 && colorButton12 != 0) {
            button6.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            boolButton6 = 0;
            boolButton10 = 0;
            boolButton14 = 0;
            boolButton11 = 0;
            boolButton12 = 0;
            colorButton6 = 0;
            colorButton10 = 0;
            colorButton14 = 0;
            colorButton11 = 0;
            colorButton12 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton3 == colorButton7 && colorButton3 == colorButton11 && colorButton3 == colorButton6
                && colorButton3 == colorButton5 && colorButton3 != 0 && colorButton7 != 0
                && colorButton11 != 0 && colorButton6 != 0 && colorButton5 != 0) {
            button3.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button5.setBackgroundColor(Color.WHITE);
            boolButton3 = 0;
            boolButton7 = 0;
            boolButton11 = 0;
            boolButton6 = 0;
            boolButton5 = 0;
            colorButton3 = 0;
            colorButton7 = 0;
            colorButton11 = 0;
            colorButton6 = 0;
            colorButton5 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton7 == colorButton11 && colorButton7 == colorButton15 && colorButton7 == colorButton10
                && colorButton7 == colorButton9 && colorButton7 != 0 && colorButton11 != 0
                && colorButton15 != 0 && colorButton10 != 0 && colorButton9 != 0) {
            button7.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            boolButton7 = 0;
            boolButton11 = 0;
            boolButton15 = 0;
            boolButton10 = 0;
            boolButton9 = 0;
            colorButton7 = 0;
            colorButton11 = 0;
            colorButton15 = 0;
            colorButton10 = 0;
            colorButton9 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton4 == colorButton8 && colorButton4 == colorButton12 && colorButton4 == colorButton7
                && colorButton4 == colorButton6 && colorButton4 != 0 && colorButton8 != 0
                && colorButton12 != 0 && colorButton7 != 0 && colorButton6 != 0) {
            button4.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            boolButton4 = 0;
            boolButton8 = 0;
            boolButton12 = 0;
            boolButton7 = 0;
            boolButton6 = 0;
            colorButton4 = 0;
            colorButton8 = 0;
            colorButton12 = 0;
            colorButton7 = 0;
            colorButton6 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton8 == colorButton12 && colorButton8 == colorButton16 && colorButton8 == colorButton11
                && colorButton8 == colorButton10 && colorButton8 != 0 && colorButton12 != 0
                && colorButton16 != 0 && colorButton11 != 0 && colorButton10 != 0) {
            button8.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            boolButton8 = 0;
            boolButton12 = 0;
            boolButton16 = 0;
            boolButton11 = 0;
            boolButton10 = 0;
            colorButton8 = 0;
            colorButton12 = 0;
            colorButton16 = 0;
            colorButton11 = 0;
            colorButton10 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton5 == colorButton6 && colorButton5 == colorButton7 && colorButton5 == colorButton2
                && colorButton5 == colorButton10 && colorButton5 != 0 && colorButton6 != 0
                && colorButton7 != 0 && colorButton2 != 0 && colorButton10 != 0) {
            button5.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button2.setBackgroundColor(Color.WHITE);
            boolButton5 = 0;
            boolButton6 = 0;
            boolButton7 = 0;
            boolButton10 = 0;
            boolButton2 = 0;
            colorButton5 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            colorButton10 = 0;
            colorButton2 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton6 == colorButton7 && colorButton6 == colorButton8 && colorButton6 == colorButton3
                && colorButton6 == colorButton11 && colorButton6 != 0 && colorButton7 != 0
                && colorButton8 != 0 && colorButton3 != 0 && colorButton11 != 0) {
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            boolButton6 = 0;
            boolButton7 = 0;
            boolButton8 = 0;
            boolButton3 = 0;
            boolButton11 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            colorButton8 = 0;
            colorButton3 = 0;
            colorButton11 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton9 == colorButton10 && colorButton9 == colorButton11 && colorButton9 == colorButton6
                && colorButton9 == colorButton14 && colorButton9 != 0 && colorButton10 != 0
                && colorButton11 != 0 && colorButton6 != 0 && colorButton14 != 0) {
            button9.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            boolButton9 = 0;
            boolButton10 = 0;
            boolButton11 = 0;
            boolButton6 = 0;
            boolButton14 = 0;
            colorButton9 = 0;
            colorButton10 = 0;
            colorButton11 = 0;
            colorButton6 = 0;
            colorButton14 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton10 == colorButton11 && colorButton10 == colorButton12 && colorButton10 == colorButton7
                && colorButton10 == colorButton15 && colorButton10 != 0 && colorButton11 != 0
                && colorButton12 != 0 && colorButton7 != 0 && colorButton15 != 0) {
            button10.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            boolButton10 = 0;
            boolButton11 = 0;
            boolButton12 = 0;
            boolButton7 = 0;
            boolButton15 = 0;
            colorButton10 = 0;
            colorButton11 = 0;
            colorButton12 = 0;
            colorButton7 = 0;
            colorButton15 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton1 == colorButton2 && colorButton1 == colorButton3 && colorButton1 == colorButton7 && colorButton1 == colorButton11
                && colorButton1 != 0 && colorButton2 != 0 && colorButton3 != 0 && colorButton7 != 0 && colorButton11 != 0) {
            button1.setBackgroundColor(Color.WHITE);
            button2.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton2 = 0;
            boolButton3 = 0;
            boolButton7 = 0;
            boolButton11 = 0;
            colorButton1 = 0;
            colorButton2 = 0;
            colorButton3 = 0;
            colorButton7 = 0;
            colorButton11 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton2 == colorButton3 && colorButton2 == colorButton4 && colorButton2 == colorButton8 && colorButton2 == colorButton12
                && colorButton2 != 0 && colorButton3 != 0 && colorButton4 != 0 && colorButton8 != 0 && colorButton12 != 0) {
            button2.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            button4.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            boolButton2 = 0;
            boolButton3 = 0;
            boolButton4 = 0;
            boolButton8 = 0;
            boolButton12 = 0;
            colorButton2 = 0;
            colorButton3 = 0;
            colorButton4 = 0;
            colorButton8 = 0;
            colorButton12 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton5 == colorButton6 && colorButton5 == colorButton7 && colorButton5 == colorButton11 && colorButton5 == colorButton15
                && colorButton5 != 0 && colorButton6 != 0 && colorButton7 != 0 && colorButton11 != 0 && colorButton15 != 0) {
            button5.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            boolButton5 = 0;
            boolButton6 = 0;
            boolButton7 = 0;
            boolButton11 = 0;
            boolButton15 = 0;
            colorButton5 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            colorButton11 = 0;
            colorButton15 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton6 == colorButton7 && colorButton6 == colorButton8 && colorButton6 == colorButton12 && colorButton6 == colorButton16
                && colorButton6 != 0 && colorButton7 != 0 && colorButton8 != 0 && colorButton12 != 0 && colorButton16 != 0) {
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            boolButton6 = 0;
            boolButton7 = 0;
            boolButton8 = 0;
            boolButton12 = 0;
            boolButton16 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            colorButton8 = 0;
            colorButton12 = 0;
            colorButton16 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton1 == colorButton5 && colorButton1 == colorButton9 && colorButton1 == colorButton2 && colorButton1 == colorButton3
                && colorButton1 != 0 && colorButton5 != 0 && colorButton9 != 0 && colorButton2 != 0 && colorButton3 != 0) {
            button1.setBackgroundColor(Color.WHITE);
            button5.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            button2.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton5 = 0;
            boolButton9 = 0;
            boolButton2 = 0;
            boolButton3 = 0;
            colorButton1 = 0;
            colorButton5 = 0;
            colorButton9 = 0;
            colorButton2 = 0;
            colorButton3 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton2 == colorButton6 && colorButton2 == colorButton10 && colorButton2 == colorButton3 && colorButton2 == colorButton4
                && colorButton2 != 0 && colorButton6 != 0 && colorButton10 != 0 && colorButton3 != 0 && colorButton4 != 0) {
            button2.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            button4.setBackgroundColor(Color.WHITE);
            boolButton2 = 0;
            boolButton6 = 0;
            boolButton10 = 0;
            boolButton3 = 0;
            boolButton4 = 0;
            colorButton2 = 0;
            colorButton6 = 0;
            colorButton10 = 0;
            colorButton3 = 0;
            colorButton4 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton5 == colorButton9 && colorButton5 == colorButton13 && colorButton5 == colorButton6 && colorButton5 == colorButton7
                && colorButton5 != 0 && colorButton6 != 0 && colorButton7 != 0 && colorButton9 != 0 && colorButton13 != 0) {
            button5.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            button13.setBackgroundColor(Color.WHITE);
            boolButton5 = 0;
            boolButton6 = 0;
            boolButton7 = 0;
            boolButton9 = 0;
            boolButton13 = 0;
            colorButton5 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            colorButton9 = 0;
            colorButton13 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton6 == colorButton10 && colorButton6 == colorButton14 && colorButton6 == colorButton7 && colorButton6 == colorButton8
                && colorButton6 != 0 && colorButton7 != 0 && colorButton8 != 0 && colorButton10 != 0 && colorButton14 != 0) {
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            boolButton6 = 0;
            boolButton7 = 0;
            boolButton8 = 0;
            boolButton10 = 0;
            boolButton14 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
            colorButton8 = 0;
            colorButton10 = 0;
            colorButton14 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton1 == colorButton5 && colorButton1 == colorButton9 && colorButton1 == colorButton10 && colorButton1 == colorButton11
                && colorButton1 != 0 && colorButton5 != 0 && colorButton9 != 0 && colorButton10 != 0 && colorButton11 != 0) {
            button1.setBackgroundColor(Color.WHITE);
            button5.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton5 = 0;
            boolButton9 = 0;
            boolButton10 = 0;
            boolButton11 = 0;
            colorButton1 = 0;
            colorButton5 = 0;
            colorButton9 = 0;
            colorButton10 = 0;
            colorButton11 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton2 == colorButton6 && colorButton2 == colorButton10 && colorButton2 == colorButton11 && colorButton2 == colorButton12
                && colorButton2 != 0 && colorButton6 != 0 && colorButton10 != 0 && colorButton11 != 0 && colorButton12 != 0) {
            button2.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            boolButton2 = 0;
            boolButton6 = 0;
            boolButton10 = 0;
            boolButton11 = 0;
            boolButton12 = 0;
            colorButton2 = 0;
            colorButton6 = 0;
            colorButton10 = 0;
            colorButton11 = 0;
            colorButton12 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton5 == colorButton9 && colorButton5 == colorButton13 && colorButton5 == colorButton14 && colorButton5 == colorButton15
                && colorButton5 != 0 && colorButton9 != 0 && colorButton13 != 0 && colorButton14 != 0 && colorButton15 != 0) {
            button5.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            button13.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            boolButton5 = 0;
            boolButton9 = 0;
            boolButton13 = 0;
            boolButton14 = 0;
            boolButton15 = 0;
            colorButton5 = 0;
            colorButton9 = 0;
            colorButton13 = 0;
            colorButton14 = 0;
            colorButton15 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton6 == colorButton10 && colorButton6 == colorButton14 && colorButton6 == colorButton15 && colorButton6 == colorButton16
                && colorButton6 != 0 && colorButton10 != 0 && colorButton14 != 0 && colorButton15 != 0 && colorButton16 != 0) {
            button6.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            boolButton6 = 0;
            boolButton10 = 0;
            boolButton14 = 0;
            boolButton15 = 0;
            boolButton16 = 0;
            colorButton6 = 0;
            colorButton10 = 0;
            colorButton14 = 0;
            colorButton15 = 0;
            colorButton16 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton4 == colorButton8 && colorButton4 == colorButton12 && colorButton4 == colorButton11 && colorButton4 == colorButton10
                && colorButton4 != 0 && colorButton8 != 0 && colorButton12 != 0 && colorButton11 != 0 && colorButton10 != 0) {
            button4.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            boolButton4 = 0;
            boolButton8 = 0;
            boolButton12 = 0;
            boolButton11 = 0;
            boolButton10 = 0;
            colorButton4 = 0;
            colorButton8 = 0;
            colorButton12 = 0;
            colorButton11 = 0;
            colorButton10 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton3 == colorButton7 && colorButton3 == colorButton11 && colorButton3 == colorButton10 && colorButton3 == colorButton9
                && colorButton3 != 0 && colorButton7 != 0 && colorButton11 != 0 && colorButton10 != 0 && colorButton9 != 0) {
            button3.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            boolButton3 = 0;
            boolButton7 = 0;
            boolButton11 = 0;
            boolButton10 = 0;
            boolButton9 = 0;
            colorButton3 = 0;
            colorButton7 = 0;
            colorButton11 = 0;
            colorButton10 = 0;
            colorButton9 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton8 == colorButton12 && colorButton8 == colorButton16 && colorButton8 == colorButton15 && colorButton8 == colorButton14
                && colorButton8 != 0 && colorButton12 != 0 && colorButton16 != 0 && colorButton15 != 0 && colorButton14 != 0) {
            button8.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            boolButton8 = 0;
            boolButton12 = 0;
            boolButton16 = 0;
            boolButton15 = 0;
            boolButton14 = 0;
            colorButton8 = 0;
            colorButton12 = 0;
            colorButton16 = 0;
            colorButton15 = 0;
            colorButton14 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

        if (colorButton7 == colorButton11 && colorButton7 == colorButton15 && colorButton7 == colorButton14 && colorButton7 == colorButton13
                && colorButton7 != 0 && colorButton11 != 0 && colorButton15 != 0 && colorButton14 != 0 && colorButton13 != 0) {
            button7.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            button13.setBackgroundColor(Color.WHITE);
            boolButton7 = 0;
            boolButton11 = 0;
            boolButton15 = 0;
            boolButton14 = 0;
            boolButton13 = 0;
            colorButton7 = 0;
            colorButton11 = 0;
            colorButton15 = 0;
            colorButton14 = 0;
            colorButton13 = 0;
            count = count + 3;
            correctCount.setText("SCORE: " + count);
        }

/////////////////////////////////////////

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
        if (colorButton5 == colorButton6 && colorButton5 == colorButton7 && colorButton5 != 0 && colorButton6 != 0 && colorButton7 != 0) {
            button5.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            boolButton5 = 0;
            boolButton6 = 0;
            boolButton7 = 0;
            colorButton5 = 0;
            colorButton6 = 0;
            colorButton7 = 0;
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
        if (colorButton9 == colorButton10 && colorButton9 == colorButton11 && colorButton9 != 0 && colorButton10 != 0 && colorButton11 != 0) {
            button9.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            boolButton9 = 0;
            boolButton10 = 0;
            boolButton11 = 0;
            colorButton9 = 0;
            colorButton10 = 0;
            colorButton11 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton10 == colorButton11 && colorButton10 == colorButton12 && colorButton10 != 0 && colorButton11 != 0 && colorButton12 != 0) {
            button10.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            boolButton10 = 0;
            boolButton11 = 0;
            boolButton12 = 0;
            colorButton10 = 0;
            colorButton11 = 0;
            colorButton12 = 0;
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
        if (colorButton14 == colorButton15 && colorButton14 == colorButton16 && colorButton14 != 0 && colorButton15 != 0 && colorButton16 != 0) {
            button14.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            boolButton14 = 0;
            boolButton15 = 0;
            boolButton16 = 0;
            colorButton14 = 0;
            colorButton15 = 0;
            colorButton16 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton1 == colorButton5 && colorButton1 == colorButton9 && colorButton1 != 0 && colorButton5 != 0 && colorButton9 != 0) {
            button1.setBackgroundColor(Color.WHITE);
            button5.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            boolButton1 = 0;
            boolButton5 = 0;
            boolButton9 = 0;
            colorButton1 = 0;
            colorButton5 = 0;
            colorButton9 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton5 == colorButton9 && colorButton5 == colorButton13 && colorButton5 != 0 && colorButton9 != 0 && colorButton16 != 13) {
            button5.setBackgroundColor(Color.WHITE);
            button9.setBackgroundColor(Color.WHITE);
            button13.setBackgroundColor(Color.WHITE);
            boolButton5 = 0;
            boolButton9 = 0;
            boolButton13 = 0;
            colorButton5 = 0;
            colorButton9 = 0;
            colorButton13 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton2 == colorButton6 && colorButton2 == colorButton10 && colorButton2 != 0 && colorButton6 != 0 && colorButton10 != 0) {
            button2.setBackgroundColor(Color.WHITE);
            button6.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            boolButton2 = 0;
            boolButton6 = 0;
            boolButton10 = 0;
            colorButton2 = 0;
            colorButton6 = 0;
            colorButton10 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton6 == colorButton10 && colorButton6 == colorButton14 && colorButton6 != 0 && colorButton10 != 0 && colorButton14 != 0) {
            button6.setBackgroundColor(Color.WHITE);
            button10.setBackgroundColor(Color.WHITE);
            button14.setBackgroundColor(Color.WHITE);
            boolButton6 = 0;
            boolButton10 = 0;
            boolButton14 = 0;
            colorButton6 = 0;
            colorButton10 = 0;
            colorButton14 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton3 == colorButton7 && colorButton3 == colorButton11 && colorButton3 != 0 && colorButton7 != 0 && colorButton11 != 0) {
            button3.setBackgroundColor(Color.WHITE);
            button7.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            boolButton3 = 0;
            boolButton7 = 0;
            boolButton11 = 0;
            colorButton3 = 0;
            colorButton7 = 0;
            colorButton11 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton7 == colorButton11 && colorButton7 == colorButton15 && colorButton7 != 0 && colorButton11 != 0 && colorButton15 != 0) {
            button7.setBackgroundColor(Color.WHITE);
            button11.setBackgroundColor(Color.WHITE);
            button15.setBackgroundColor(Color.WHITE);
            boolButton7 = 0;
            boolButton11 = 0;
            boolButton15 = 0;
            colorButton7 = 0;
            colorButton11 = 0;
            colorButton15 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton4 == colorButton8 && colorButton4 == colorButton12 && colorButton4 != 0 && colorButton8 != 0 && colorButton12 != 0) {
            button4.setBackgroundColor(Color.WHITE);
            button8.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            boolButton4 = 0;
            boolButton8 = 0;
            boolButton12 = 0;
            colorButton4 = 0;
            colorButton8 = 0;
            colorButton12 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
        if (colorButton8 == colorButton12 && colorButton8 == colorButton16 && colorButton8 != 0 && colorButton12 != 0 && colorButton16 != 0) {
            button8.setBackgroundColor(Color.WHITE);
            button12.setBackgroundColor(Color.WHITE);
            button16.setBackgroundColor(Color.WHITE);
            boolButton8 = 0;
            boolButton12 = 0;
            boolButton16 = 0;
            colorButton8 = 0;
            colorButton12 = 0;
            colorButton16 = 0;
            count++;
            correctCount.setText("SCORE: " + count);
        }
    }

    public void showGameOver() {
        final AlertDialog.Builder gameOverDialog = new AlertDialog.Builder(this);

        boolTotal = boolButton1 + boolButton2 + boolButton3 + boolButton4 + boolButton5 + boolButton6
                + boolButton7 + boolButton8 + boolButton9 + boolButton10 + boolButton11 + boolButton12
                + boolButton13 + boolButton14 + boolButton15 + boolButton16;

        if (boolTotal > 15) {
            gameOverDialog.show();
            if (db.getEasyHighScores().getCount() >= 0) {
                db.addEasyHighScore(new HighScores(count, name));
            } else {
                db.onCreateEasy(sqlConn);
            }
        }
    }

    public static int randomColor() {
        int x, color;

        x = (int) (Math.random() * 100);
        if (x <= 19) {
            color = Color.BLUE;
        } else if (x <= 38) {
            color = -65536;
        } else if (x <= 57) {
            color = Color.GREEN;
        } else if (x <= 74) {
            color = Color.MAGENTA;
        } else if (x <= 95) {
            color = Color.YELLOW;
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
