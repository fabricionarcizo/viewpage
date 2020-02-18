package dk.itu.moapd.viewpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final static int NUM_PAGES = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a ViewPage and a PagerAdapter.
        ViewPager viewPage = findViewById(R.id.view_page);
        PagerAdapter pagerAdapter = new SlidePagerAdapter(
                getSupportFragmentManager());
        viewPage.setAdapter(pagerAdapter);
    }

    private static class SlidePagerAdapter
            extends FragmentStatePagerAdapter {

        SlidePagerAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return new MainFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}
