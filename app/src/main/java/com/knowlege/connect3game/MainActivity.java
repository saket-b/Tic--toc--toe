package com.knowlege.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  Button Newgame;

        //     0 red.1-yellow
        int activeplayer = 0;

        boolean gamestart = true;

        int[] visit = {2, 2, 2, 2, 2, 2, 2, 2, 2};

        int[][] winnergerid = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

        public void dropimg (View view){

        ImageView counter = (ImageView) view;

        int countertag = Integer.parseInt(counter.getTag().toString());

        if (visit[countertag] == 2 && gamestart == true) {

            visit[countertag] = activeplayer;

            counter.setTranslationY(-1500);

            if (activeplayer == 1) {

                counter.setImageResource(R.drawable.x);

                activeplayer = 0;
            } else {
                counter.setImageResource(R.drawable.o);

                activeplayer = 1;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for (int[] winnerpos : winnergerid) {

                if (visit[winnerpos[0]] == visit[winnerpos[1]] && visit[winnerpos[1]] == visit[winnerpos[2]] && visit[winnerpos[0]] != 2) {

                    gamestart = false;

                    String s = "";

                    if (activeplayer == 1)

                        s = "O";

                    else s = "X";

                    //Toast.makeText(this, s + " has winner", Toast.LENGTH_SHORT).show();



                    TextView winner = (TextView) findViewById(R.id.winner);

                    winner.setText(s + "  has won!");

                    winner.setVisibility(View.VISIBLE);


                }

            }
        }
    }









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Newgame=(Button)findViewById(R.id.button2);
        Newgame.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {


                                           TextView winner = (TextView) findViewById(R.id.winner);

                                           winner.setVisibility(View.INVISIBLE);


                                          androidx.gridlayout.widget.GridLayout  gridlayout = findViewById(R.id.gridtable);


                                           for (int i = 0; i < gridlayout.getChildCount(); i++) {

                                               ImageView counter = (ImageView) gridlayout.getChildAt(i);

                                               counter.setImageDrawable(null);
                                           }

                                           for (int i = 0; i < visit.length; i++)
                                               visit[i] = 2;

                                           gamestart = true;

                                           activeplayer = 0;
                                       }
                                   }
        );
    }
}