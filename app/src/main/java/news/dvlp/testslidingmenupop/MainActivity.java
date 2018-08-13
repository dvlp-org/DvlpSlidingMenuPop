package news.dvlp.testslidingmenupop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import news.dvlp.testslidingmenupop.zviews.SlidingMeuPop;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private SlidingMeuPop slidingMeuPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.btn);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//显示侧边栏
                slidingMeuPop = new SlidingMeuPop(MainActivity.this);
                slidingMeuPop.showPop();
            }
        });
    }
}
