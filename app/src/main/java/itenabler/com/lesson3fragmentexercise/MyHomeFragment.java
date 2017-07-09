package itenabler.com.lesson3fragmentexercise;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by kentan on 9/7/2017.
 */
public class MyHomeFragment extends Fragment {

    OnImageClickListener mCallback;

    public interface OnImageClickListener {
        void onButtonPress(String str1);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnImageClickListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_homefragment, container, false);

        Button btn = (Button) rootView.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Fragment Button Press!", Toast.LENGTH_SHORT).show();
                mCallback.onButtonPress("From Home Fragment!");
            }
        });

        return rootView;
    }
}
