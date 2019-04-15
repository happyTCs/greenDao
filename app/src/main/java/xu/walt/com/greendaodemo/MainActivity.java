package xu.walt.com.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import xu.walt.com.greendaodemo.entity.User;
import xu.walt.com.greendaodemo.utils.DateBaseManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                long id = 2;
                int age = 22;
                id++;
                age++;
                User user = new User();
                user.setId(id);
                user.setName("李小"+id);
                user.setAge(age);
                user.setHeight(180+"");
                user.setHandSome("good");
                DateBaseManager.getInstance(getApplicationContext()).insert(user);
                String s = DateBaseManager.getInstance(getApplicationContext()).loadAll();
                if (s != null) {
                    textView.setText(s);
                }
                break;
            case R.id.button2:
                long id2 = 9;
                int age2 = 29;
                id2++;
                age2++;
                User user2 = new User();
                user2.setId(id2);
                user2.setName("李小"+id2);
                user2.setAge(age2);
                user2.setHeight(182+"");
                user2.setHandSome("good");
                DateBaseManager.getInstance(getApplicationContext()).insert(user2);


                String s2 = DateBaseManager.getInstance(getApplicationContext()).loadAll();
                if (s2!= null) {
                    textView.setText(s2);
                }
                break;
            default:

                break;
        }
    }
}
