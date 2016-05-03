package edu.missouriwestern.aambrosius.retrobejewled;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button easyButton;
    Button mediumButton;
    Button hardButton;
    Button crazyButton;

    ImageButton infoButton;
    ImageButton highScoreButton;

    EditText initial;

    public String name = "";

    Database db = new Database(this);
    SQLiteDatabase sqlConn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initial = (EditText) findViewById(R.id.nameText);

        easyButton = (Button) findViewById(R.id.easyBtn);
        mediumButton = (Button) findViewById(R.id.medBtn);
        hardButton = (Button) findViewById(R.id.hardBtn);
        crazyButton = (Button) findViewById(R.id.crazyBtn);
        infoButton = (ImageButton) findViewById(R.id.infoBtn);
        highScoreButton = (ImageButton) findViewById(R.id.highScoreBtn);


        final AlertDialog.Builder infoDialog = new AlertDialog.Builder(this);
        final AlertDialog.Builder highScoreDialog = new AlertDialog.Builder(this);




        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = initial.getText().toString().toUpperCase();
                Intent easy = new Intent(MainActivity.this, EasyLevel.class);
                easy.putExtra("Initial", name);
                startActivity(easy);

            }
        });

        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = initial.getText().toString().toUpperCase();
                Intent medium = new Intent(MainActivity.this, MediumLevel.class);
                medium.putExtra("Initial", name);
                startActivity(medium);
            }
        });
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = initial.getText().toString().toUpperCase();
                Intent hard = new Intent(MainActivity.this, HardLevel.class);
                hard.putExtra("Initial", name);
                startActivity(hard);
            }
        });

        crazyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = initial.getText().toString().toUpperCase();
                Intent crazy = new Intent(MainActivity.this, CrazyLevel.class);
                crazy.putExtra("Initial", name);
                startActivity(crazy);
            }
        });


        infoDialog.setTitle("How to Play").setMessage("Click on tiles to try and match three colors in a row. " +
                "You score points by matching together three colored tiles. You can not get rid of black tiles. Good Luck!");
        infoDialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        highScoreDialog.setTitle("High Scores");


        String[] options = {"Easy", "Medium", "Hard", "Crazy"};


        DialogInterface.OnClickListener actionListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        sqlConn = db.getWritableDatabase();
                        Cursor res = db.getEasyHighScores();
                        StringBuffer buffer = new StringBuffer();

                        while (res.moveToNext()) {
                            buffer.append("Score:" + res.getString(0) + "\t");
                            buffer.append("Initials: " + res.getString(1) + "\n");
                        }
                        showMessage("High Scores", buffer.toString());


                        break;
                    case 1:
                        sqlConn = db.getWritableDatabase();
                        Cursor res1 = db.getMediumHighScores();
                        StringBuffer buffer1 = new StringBuffer();

                        while (res1.moveToNext()) {
                            buffer1.append("Score:" + res1.getString(0) + "\t");
                            buffer1.append("Initials: " + res1.getString(1) + "\n");
                        }
                        showMessage("High Scores", buffer1.toString());
                        break;
                    case 2:
                        sqlConn = db.getWritableDatabase();
                        Cursor res2 = db.getHardHighScores();
                        StringBuffer buffer2 = new StringBuffer();

                        while (res2.moveToNext()) {
                            buffer2.append("Score:" + res2.getString(0) + "\t");
                            buffer2.append("Initials: " + res2.getString(1) + "\n");
                        }
                        showMessage("High Scores", buffer2.toString());
                        break;
                    case 3:
                        sqlConn = db.getWritableDatabase();
                        Cursor res3 = db.getCrazyHighScores();
                        StringBuffer buffer3 = new StringBuffer();

                        while (res3.moveToNext()) {
                            buffer3.append("Score:" + res3.getString(0) + "\t");
                            buffer3.append("Initials: " + res3.getString(1) + "\n");
                        }
                        showMessage("High Scores", buffer3.toString());
                        break;
                }
            }
        };

        highScoreDialog.setItems(options, actionListener);

        highScoreDialog.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoDialog.show();
            }
        });

        initial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = initial.getText().toString();
            }
        });

        highScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highScoreDialog.create();
                highScoreDialog.show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNeutralButton("Back", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

            highScoreButton.callOnClick();

            }
        });
        builder.show();
    }
}
