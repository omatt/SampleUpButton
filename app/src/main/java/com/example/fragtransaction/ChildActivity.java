package com.example.fragtransaction;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by User on 2/6/2015.
 */
public class ChildActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_child, new ChildFragment1())
                    .commit();
        }
    }

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Placeholder fragment for Child Fragment 1.
     */
    public static class ChildFragment1 extends Fragment implements View.OnClickListener {

        private static String TAG = "ChildFragment1";

        private Button mBtnNextFragment;

        public ChildFragment1() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_child_1, container, false);

            mBtnNextFragment = (Button) rootView.findViewById(R.id.btn_next_fragment);

            mBtnNextFragment.setOnClickListener(this);

            return rootView;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_next_fragment:
                    Log.e(TAG, "Next Fragment Clicked");
                    getFragmentManager().beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.container_child, new ChildFragment2(), "Child Fragment 2")
                            .commit();
                    break;
            }
        }

        /**
         * Placeholder fragment for Child Fragment 2.
         */
        public static class ChildFragment2 extends Fragment implements View.OnClickListener {

            private static String TAG = "ChildFragment2";

            private Button mBtnNextFragment;

            public ChildFragment2() {
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                View rootView = inflater.inflate(R.layout.fragment_child_2, container, false);

                mBtnNextFragment = (Button) rootView.findViewById(R.id.btn_next_fragment);

                mBtnNextFragment.setOnClickListener(this);

                return rootView;
            }

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_next_fragment:
                        Log.e(TAG, "New Fragment Clicked");
                        getFragmentManager().beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.container_child, new ChildFragment3(), "Child Fragment 2")
                                .commit();
                        break;
                }
            }
        }

        /**
         * Placeholder fragment for Child Fragment 3.
         */
        public static class ChildFragment3 extends Fragment {

            private static String TAG = "ChildFragment3";

            private Button mBtnNextFragment;

            public ChildFragment3() {
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                View rootView = inflater.inflate(R.layout.fragment_child_3, container, false);

                mBtnNextFragment = (Button) rootView.findViewById(R.id.btn_next_fragment);
                mBtnNextFragment.setEnabled(false);

                return rootView;
            }
        }
    }
}
