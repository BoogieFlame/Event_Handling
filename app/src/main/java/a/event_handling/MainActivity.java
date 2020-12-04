package a.event_handling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout myLayout;

    TextView textView1_lb1;
    Button button_click_lb1;

    TextView textView2_lb2;
    TextView textView2_lb22;

    TextView textView3_lb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLayout = (ConstraintLayout) findViewById((R.id.cL));
        textView1_lb1 = (TextView) findViewById(R.id.tv1_lb1);
        button_click_lb1 = (Button) findViewById(R.id.button_lb1);
        button_click_lb1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                textView1_lb1.setText("Button clicked");
            }
        });

        button_click_lb1.setOnLongClickListener(new Button.OnLongClickListener() {
            public boolean onLongClick(View view) {
                textView1_lb1.setText("Long button click");
                return false;
            }
        });

        textView2_lb2 = (TextView) findViewById(R.id.tv2_lb2);
        textView2_lb22 = (TextView) findViewById(R.id.tv2_lb2_2);
        myLayout.setOnTouchListener(new ConstraintLayout.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent m) {
                handleTouch(m);
                return true;
            }
        });

        textView3_lb3 = (TextView) findViewById(R.id.tv3_lv2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        hide();
        switch(id){
            case R.id.lb1 :
                textView1_lb1.setVisibility(View.VISIBLE);
                button_click_lb1.setVisibility(View.VISIBLE);
                return true;
            case R.id.lb2:
                textView2_lb2.setVisibility(View.VISIBLE);
                textView2_lb22.setVisibility(View.VISIBLE);
                return true;
            case R.id.lb3:
                textView3_lb3.setVisibility(View.VISIBLE);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void handleTouch(MotionEvent m) {
        TextView textView1 = findViewById(R.id.tv2_lb2);
        TextView textView2 = findViewById(R.id.tv2_lb2_2);

        int pointerCount = m.getPointerCount();

        for (int i = 0; i < pointerCount; i++)
        {
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
            int id = m.getPointerId(i);
            int action = m.getActionMasked();
            int actionIndex = m.getActionIndex();
            String actionString;


            switch (action)
            {
                case MotionEvent.ACTION_DOWN:
                    actionString = "DOWN";
                    break;
                case MotionEvent.ACTION_UP:
                    actionString = "UP";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "PNTR DOWN";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "PNTR UP";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionString = "MOVE";
                    break;
                default:
                    actionString = "";
            }

            String touchStatus = "Action: " + actionString + " Index: " +
                    actionIndex + " ID: " + id + " X: " + x + " Y: " + y;
            if (id == 0)
                textView1.setText(touchStatus);
            else
                textView2.setText(touchStatus);
        }
    }

    private void hide()
    {
        textView1_lb1.setVisibility(View.GONE);
        button_click_lb1.setVisibility(View.GONE);

        textView2_lb2.setVisibility(View.GONE);
        textView2_lb22.setVisibility(View.GONE);

        textView3_lb3.setVisibility(View.GONE);
    }
}