package com.example.nirav.connectsmilies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class simpleActivity extends AppCompatActivity {

    //0=red 1=yellow
    int ap=0;
    boolean gameonn = true;
    boolean w = true;
    //2 means unplayed box
    int [] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view) {

        if (gameonn)
        {
            ImageView counter = (ImageView) view;
            int tappedcounter = Integer.parseInt(counter.getTag().toString());

            if (gamestate[tappedcounter] == 2 && gameonn) {
                gamestate[tappedcounter] = ap;
                counter.setTranslationY(-1000f);
                if (ap == 0) {

                    counter.setImageResource(R.drawable.redd);
                    ap = 1;
                } else {
                    counter.setImageResource(R.drawable.yellow);
                    ap = 0;
                }
                counter.animate().translationYBy(1000f).rotation(360).setDuration(500);
                //winning logic
                for (int[] wins : win) {
                    if (gamestate[wins[0]] == gamestate[wins[1]] && gamestate[wins[1]] == gamestate[wins[2]]
                            && gamestate[wins[0]] != 2) {
                        gameonn = false;
                        w = false;
                        String wincolor = "Yellow";
                        if (gamestate[wins[0]] == 0) {
                            wincolor = "Red";
                        }
                        TextView winner = (TextView) findViewById(R.id.winner);
                        winner.setText(wincolor+" has won!!");
                        LinearLayout layout = (LinearLayout) findViewById(R.id.playagainlayout);
                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }
            if (w&&gamestate[0]!=2&&
                    gamestate[1]!=2&&
                    gamestate[2]!=2&&
                    gamestate[3]!=2&&
                    gamestate[4]!=2&&
                    gamestate[5]!=2&&
                    gamestate[6]!=2&&
                    gamestate[7]!=2&&
                    gamestate[8]!=2){
                TextView winner = (TextView) findViewById(R.id.winner);
                winner.setText("Game is draw!");
                LinearLayout layout = (LinearLayout) findViewById(R.id.playagainlayout);
                layout.setVisibility(View.VISIBLE);
            }
        }


    }

    public void playAgain(View view){
        gameonn=true;
        LinearLayout layout = (LinearLayout) findViewById(R.id.playagainlayout);
        layout.setVisibility(View.INVISIBLE);
        ap=0;
        for(int i=0 ;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        GridLayout gridLayout=(GridLayout) findViewById(R.id.gridLayout);
        for(int i=0; i<gridLayout.getChildCount();i++){
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    public void menu(View view) {

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
    }
}
