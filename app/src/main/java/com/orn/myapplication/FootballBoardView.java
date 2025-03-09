package com.orn.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class FootballBoardView extends View {
    private Bitmap fieldBitmap;
    private List<Player> players;
    private Player selectedPlayer;


    public FootballBoardView(Context context) {
        super(context);
        init();
    }

    public FootballBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FootballBoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        players = new ArrayList<>();
        fieldBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.field);
    }

    public void addPlayer(String name, int x, int y, int drawableRes) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), drawableRes);
        Bitmap playerBitmap = getBitmapFromDrawable(drawable);
        players.add(new Player(name, x, y, playerBitmap));
        invalidate();
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int canvasWidth = getWidth();
        int canvasHeight = getHeight();
        Bitmap scaledField = Bitmap.createScaledBitmap(fieldBitmap, canvasWidth, canvasHeight, true);
        canvas.drawBitmap(scaledField, 0, 0, null);

        for (Player player : players) {
            canvas.drawBitmap(player.getBitmap(), player.getX(), player.getY(), null);
            canvas.drawText(player.getName(), player.getX() + (player.getBitmap().getWidth() / 2),
                    player.getY() + player.getBitmap().getHeight() + 40, player.getTextPaint());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                for (Player player : players) {
                    if (player.isTouched(event.getX(), event.getY())) {
                        selectedPlayer = player;
                        break;
                    } else if (player.isNameTouched(event.getX(), event.getY())) {
                        showEditNameDialog(player);
                        return true;
                    }
                }
                break;

            case MotionEvent.ACTION_MOVE:
                if (selectedPlayer != null) {
                    selectedPlayer.setPosition((int) event.getX(), (int) event.getY());
                    invalidate();
                }
                break;

            case MotionEvent.ACTION_UP:
                selectedPlayer = null;
                break;
        }
        return true;
    }

    private void showEditNameDialog(Player player) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Edit Player Name");

        final EditText input = new EditText(getContext());
        input.setText(player.getName());
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            player.setName(input.getText().toString());
            invalidate();
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}
