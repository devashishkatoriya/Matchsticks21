package dev.matchsticks21;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int sticks=21,comp,user,round=1,clear=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submit (View v)
    {

        TextView t1 = (TextView)findViewById(R.id.textView2);
        TextView t2 = (TextView)findViewById(R.id.textView4);
        TextView t3 = (TextView)findViewById(R.id.textView6);
        TextView t4 = (TextView)findViewById(R.id.textView7);
        EditText e1 = (EditText)findViewById(R.id.editText);
        try {
            user = Integer.parseInt(e1.getText().toString());
            if (sticks == 0) {
                t3.setText("Please restart the game.");
                t4.setText("");
            }
            else if (sticks == 1 && user != 1) {
                t3.setText("Hahaha... You are cheating. :P ");
                t4.setText("");
            } else {
                if (user >= 5 || user <= 0) {
                    t3.setText("Cmon, don't start cheating with me. ;) You can pick upto 4 sticks at a time only.");
                    t4.setText("");
                } else {
                    t3.setText("You pick " + user + " matchsticks.");
                    sticks = sticks - user;
                    if (sticks == 0) {
                        round++;
                        t3.setText("YOU LOSE. Once again, the computer shows its mighty playing skills!!! ");
                        t4.setText("");
                        t1.setText("" + round);
                        t2.setText("" + sticks);
                    } else {
                        t2.setText("" + sticks);
                        switch (user) {
                            case 1:
                                comp = 4;
                                break;
                            case 2:
                                comp = 3;
                                break;
                            case 3:
                                comp = 2;
                                break;
                            case 4:
                                comp = 1;
                        }
                        t4.setText("I pick " + comp + " matchsticks.");
                        sticks = sticks - comp;
                        t2.setText("" + sticks);
                        round++;
                        t1.setText("" + round);
                    }
                }
            }
        }catch (Exception e)
        {
            t3.setText(""+e);
            t4.setText("");
        }
    }

    public void about(View v)
    {
        Intent intent = new Intent("dev.matchsticks21.about");
        startActivity(intent);
    }
    public void exit(View v)
    {
        AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
        a.setMessage("Are you sure you want to close this app ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        Toast.makeText(MainActivity.this,"Thank you for using this application!",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = a.create();
        alert.setTitle("Alert!");
        alert.show();
    }
    public void clear(View v)
    {
        AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
        a.setMessage("Are you sure you want to restart the game ?")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TextView t1 = (TextView)findViewById(R.id.textView2);
                        TextView t2 = (TextView)findViewById(R.id.textView4);
                        TextView t3 = (TextView)findViewById(R.id.textView6);
                        TextView t4 = (TextView)findViewById(R.id.textView7);
                        EditText e1 = (EditText)findViewById(R.id.editText);
                        e1.setText("");
                        sticks = 21;
                        round = 1;
                        t4.setText("");
                        t3.setText("");
                        t1.setText("" + round);
                        t2.setText("" + sticks);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = a.create();
        alert.setTitle("Huh!");
        alert.show();
    }
    public void clear1(View v)
    {
        EditText e1 = (EditText)findViewById(R.id.editText);
        e1.setText("");
    }

}

