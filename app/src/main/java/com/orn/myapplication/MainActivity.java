package com.orn.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    FootballBoardView footballBoardView;
    Button btnAddPlayer2, btnAddPlayer3, btnAddFootball;
    private boolean isBallAdded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        footballBoardView = findViewById(R.id.footballBoardView);
        btnAddPlayer2 = findViewById(R.id.btnAddPlayer2);
        btnAddPlayer3 = findViewById(R.id.btnAddPlayer3);
        btnAddFootball = findViewById(R.id.btnAddFootball);

        btnAddPlayer2.setOnClickListener(v -> addPlayer(R.drawable.player1));
        btnAddPlayer3.setOnClickListener(v -> addPlayer(R.drawable.player4));
//        btnAddFootball.setOnClickListener(v -> addPlayer(R.drawable.football_ball));
        btnAddFootball.setOnClickListener(v -> addFootball());
    }

    private void addPlayer(int drawableRes) {
        int x = (int) (Math.random() * footballBoardView.getWidth());
        int y = (int) (Math.random() * footballBoardView.getHeight());
        footballBoardView.addPlayer("Player", x, y, drawableRes);
    }
    private void addFootball() {
        if (!isBallAdded) { // Check if ball is already added
            int x = footballBoardView.getWidth() / 2; // Center of the field
            int y = footballBoardView.getHeight() / 2;
            footballBoardView.addPlayer("", x, y, R.drawable.football_ball);
            isBallAdded = true; // Mark that the ball has been added
        }
    }
}
