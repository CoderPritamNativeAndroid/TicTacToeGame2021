package com.example.tictactoe2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean gameActive = true;

    public void PlayerTap(View view) {
        ImageView imageView = (ImageView) view; //TypeCasting into (ImageView)
        int tapImageTag = Integer.parseInt(imageView.getTag().toString());
        if (gameState[tapImageTag] == 2) {
            gameState[tapImageTag] = activePlayer;
            imageView.setTranslationY(-1000f); //it Means, This imageView Hide, it is a CSS-Animation
            if (activePlayer == 0) {
                imageView.setImageResource(R.drawable.x);
                activePlayer = 1;
                ((TextView) findViewById(R.id.textView3)).setText("Player 2   O-Turn  --  Tap  To  Play");
            } else if (activePlayer == 1) {
                imageView.setImageResource(R.drawable.o);
                activePlayer = 0;
                ((TextView) findViewById(R.id.textView3)).setText("Player 1   X-Turn  --  Tap  To  Play");
            }
            imageView.animate().translationYBy(1000f).setDuration(50); //it Means, This imageView animation() Property, it is a CSS-Animation, 50 MiliSecond
        }
        for (int[] i : winPositions) {
            if (gameState[i[0]] == gameState[i[1]] && gameState[i[1]] == gameState[i[2]] && gameState[i[0]] != 2) {
                if (gameState[i[0]] == 0) {
                    gameActive = false;
                    ((TextView) findViewById(R.id.textView3)).setText("Player 1   X-Win  --  Congrats");
                } else if (gameState[i[1]] == 1) {
                    gameActive = false;
                    ((TextView) findViewById(R.id.textView3)).setText("Player 2   O-Win  --  Congrats");
                }
            }
        }
        if (!gameActive) {
            gameReset(view);
        }
    }

    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
    }

    public void btnResetGame(View view) {
        gameReset(view);
        Toast.makeText(MainActivity.this, "Reset Successfully\nLet's PLAY...", Toast.LENGTH_LONG).show();
        ((TextView) findViewById(R.id.textView3)).setText("Player 1   X-Turn  --  Tap  To  Play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
