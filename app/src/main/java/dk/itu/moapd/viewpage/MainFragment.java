package dk.itu.moapd.viewpage;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import java.util.Random;

public class MainFragment extends Fragment {

    private int mColor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        if (savedInstanceState == null) {
            Random random = new Random();
            mColor = Color.argb(255, random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256));
        } else
            mColor = savedInstanceState.getInt("COLOR");

        ScrollView scrollView = view.findViewById(R.id.scroll_view);
        scrollView.setBackgroundColor(mColor);

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COLOR", mColor);
    }

}
