package itenabler.com.lesson3fragmentexercise;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyHomeFragment.OnImageClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button btn = (Button) findViewById(R.id.button);
//        if (btn != null) {
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(this, "Button Press!", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }

//        MyFragment myfrag = new MyFragment();  // Create object - instantiation


//        getFragmentManager().beginTransaction()
//                .add(R.id.myContainer, myfrag)
//                .commit();
//

    } // End Of OnCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Fragment frag = null;

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_hp) {
            frag = new MyHomeFragment();
        } else if (id == R.id.action_news) {
//            frag = new MyNewsFragment();
        } else if (id == R.id.action_fb) {
//            frag = new MyFBFragment();
        }

        getFragmentManager().beginTransaction()
                .replace(R.id.myContainer, frag)
                .commit();


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onButtonPress(String str1) {
//        Button btn = (Button) findViewById(R.id.button2);
//        final String str2 = str1;
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), str2 + " is Pressed!", Toast.LENGTH_SHORT).show();
//            }
//        });
        Toast.makeText(this, str1, Toast.LENGTH_SHORT).show();

    }
}
