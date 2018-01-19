package example.com.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentThree extends Fragment {

    String[] imageTitle = {"Dream 01", "Dream 02", "Dream 03"};
    int[] imageDrawable = {R.drawable.nougat, R.drawable.icon03, R.drawable.mov01};
    public FragmentThree() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    public void update (int index) {
        TextView title = getView().findViewById(R.id.title);
        ImageView image = getView().findViewById(R.id.image);

        title.setText(imageTitle[index]);
        image.setImageResource(imageDrawable[index]);
    }
}
