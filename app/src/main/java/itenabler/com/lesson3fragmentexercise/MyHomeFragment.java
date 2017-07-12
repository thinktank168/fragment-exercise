package itenabler.com.lesson3fragmentexercise;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by kentan on 9/7/2017.
 */
public class MyHomeFragment extends Fragment {
    Animation animRotate;
    ImageView iv;

    OnButtonClickListener mCallback;

    public interface OnButtonClickListener {

        public void buttonpressed(String string);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnButtonClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        animRotate = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
    }

    @Override
    public void onResume() {
        super.onResume();
        iv.startAnimation(animRotate);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_homefragment, container, false);

        Button btn = (Button) rootView.findViewById(R.id.button);
        iv = (ImageView) rootView.findViewById(R.id.imageView2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.startAnimation(animRotate);
                Toast.makeText(getActivity(), "Fragment Button Press!", Toast.LENGTH_SHORT).show();
                mCallback.buttonpressed("Fragment String passsed!");
            }
        });


        return rootView;
    }
}
