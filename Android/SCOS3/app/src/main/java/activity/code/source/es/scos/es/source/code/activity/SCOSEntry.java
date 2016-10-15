package activity.code.source.es.scos.es.source.code.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import activity.code.source.es.scos.R;

public class SCOSEntry extends AppCompatActivity implements View.OnClickListener{

    final int RIGHT = 0;
    final int LEFT = 1;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);


        gestureDetector = new GestureDetector(this, onGestureListener);

//        Intent intent = new Intent(this, MainScreen.class);
//        startActivity(intent);

    }

    private GestureDetector.OnGestureListener onGestureListener =
            new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                    float x = e2.getX() - e1.getX();
                    float y = e2.getY() - e1.getY();

                    if (x > 0) {
                        doResult(RIGHT);
                    } else if (x < 0) {
                        doResult(LEFT);
                    }

                    return true;
                }
            };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    public void doResult(int action) {
        switch (action) {
            case RIGHT:
                System.out.println("go right");
                Intent intent = new Intent(this,LoginOrRegister.class);
                intent.putExtra("activity.code.source.es.scos.es.source.code.activity.MainScreen","FromEntry");
                startActivity(intent);
                break;
            case LEFT:
                System.out.println("go left");
                break;
        }
    }

    @Override
    public void onClick(View v) {

    }
}
