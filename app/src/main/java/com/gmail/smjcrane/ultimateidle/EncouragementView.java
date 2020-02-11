package com.gmail.smjcrane.ultimateidle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class EncouragementView extends View {

    private static int[] encouragingColors = {
            R.color.encourageRed,
            R.color.encourageGreen,
            R.color.encourageOrange,
            R.color.encouragePink
    };

    private Context context;
    private String text;
    private Random random;
    private TextPaint paint;

    public EncouragementView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        random = new Random();
        paint = new TextPaint();
        paint.setTypeface(context.getResources().getFont(R.font.comicsans));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        text = Words.encouragement[random.nextInt(Words.encouragement.length)];
        Log.i("ENCOURAGE", "msg: " + text);
        paint.setColor(context.getColor(encouragingColors[random.nextInt(encouragingColors.length)]));
        paint.setTextSize(random.nextFloat()*75 + 50);

        canvas.save();
        int xpos = random.nextInt(200);
        StaticLayout.Builder builder = StaticLayout.Builder.obtain(text, 0, text.length(), paint, getWidth() - xpos)
                .setAlignment(Layout.Alignment.ALIGN_CENTER);
        StaticLayout myStaticLayout = builder.build();
        canvas.translate(
                xpos,
                random.nextInt(getHeight() - myStaticLayout.getHeight())
        );
        myStaticLayout.draw(canvas);
        canvas.restore();

        postInvalidateDelayed(500);
    }
}
