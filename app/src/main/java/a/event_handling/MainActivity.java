package a.event_handling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView1_lb1;
    Button button_click_lb1;

    TextView textView2_lb2;
    TextView textView2_lb22;

    TextView textView3_lb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1_lb1 = (TextView) findViewById(R.id.tv1_lb1);
        button_click_lb1 = (Button) findViewById(R.id.button_lb1);

        textView2_lb2 = (TextView) findViewById(R.id.tv2_lb2);
        textView2_lb22 = (TextView) findViewById(R.id.tv2_lb2_2);

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

    private void hide()
    {
        textView1_lb1.setVisibility(View.GONE);
        button_click_lb1.setVisibility(View.GONE);

        textView2_lb2.setVisibility(View.GONE);
        textView2_lb22.setVisibility(View.GONE);

        textView3_lb3.setVisibility(View.GONE);
    }
}