package itenabler.com.lesson3fragmentexercise;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kentan on 10/7/2017.
 */
public class MyFBFragment extends Fragment {

    String myfb_frag_string = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getArguments();
        if (b != null && b.containsKey(MainActivity.FB_BUNDLE)) {
            myfb_frag_string = b.getString(MainActivity.FB_BUNDLE);
        }



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_fbfragment, container, false);

        TextView tv = (TextView) rootView.findViewById(R.id.text_view_fb);

        if (myfb_frag_string != null) {
            tv.setText(myfb_frag_string);
        }



        return rootView;
    }
}
