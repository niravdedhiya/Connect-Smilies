package com.example.nirav.connectsmilies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ultra2Activity extends AppCompatActivity {


    int ap=0;
    boolean gameonn=true;
    boolean w=true;
    // 2 means unplayed
    int[] gamestate={2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};

    //winning positions
    int[][] winningpositions={{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15},{0,4,8,12},{1,5,9,13},{2,6,10,14},{3,7,11,15},
            {0,5,10,15},{3,6,9,12}};
    public void dropin(View view) {

        if(gameonn){

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
                for (int[] winningPosition : winningpositions) {
                    if (gamestate[winningPosition[0]] == gamestate[winningPosition[1]] && gamestate[winningPosition[1]] == gamestate[winningPosition[2]]
                            && gamestate[winningPosition[2]] == gamestate[winningPosition[3]] && gamestate[winningPosition[0]] != 2) {
                        gameonn = false;
                        w = false;
                        String wincolor = "Yellow";
                        if (gamestate[winningPosition[0]] == 0) {
                            wincolor = "Red";
                        }
                        TextView winner = (TextView) findViewById(R.id.winner);
                        winner.setText(wincolor + " has won!!");
                        //someone has won
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
                    gamestate[8]!=2&&
                    gamestate[9] !=2&&
                    gamestate[10]!=2&&
                    gamestate[11]!=2&&
                    gamestate[12]!=2&&
                    gamestate[13]!=2&&
                    gamestate[14]!=2&&
                    gamestate[15]!=2){
                TextView winner = (TextView) findViewById(R.id.winner);
                winner.setText("Game is draw!");
                LinearLayout layout = (LinearLayout) findViewById(R.id.playagainlayout);
                layout.setVisibility(View.VISIBLE);
            }
        }


    }
    public void playAgain (View view){
        gameonn = true;
        LinearLayout layout = (LinearLayout) findViewById(R.id.playagainlayout);
        layout.setVisibility(View.INVISIBLE);
        ap = 0;
        for (int i = 0; i < gamestate.length; i++) {
            gamestate[i] = 2;
        }
        GridLayout gridLayout = (GridLayout) findViewById(R.id.ultragridLayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    public void menu(View view) {

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void mode(View view) {

        Intent i = new Intent(getApplicationContext(), optionActivity.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultra2);
    }
}
