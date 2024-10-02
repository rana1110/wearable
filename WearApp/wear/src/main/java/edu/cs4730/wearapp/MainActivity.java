package edu.cs4730.wearapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import edu.cs4730.wearapp.databinding.ActivityMainBinding;
import java.util.Random;

/*
  * simple app that shows random number.
  *
  * Note there is a round, notround, and layout directory.  in support.wear it will now select the
  * "correct" one.  It square uses notround, round uses round and layout appears unused in the wear.
  *
  * remember for emulators, first turn debugging on in the emulator and then
  * adb -d forward tcp:5601 tcp:5601   and then the real phone can connect to an emulated device.
  *
  * bluetooth debugging: https://developer.android.com/training/wearables/apps/debugging.html
  *
  * remember these gpt bluetooth:
  * adb forward tcp:4444 localabstract:/adb-hub
    adb connect 127.0.0.1:4444
 */
public class MainActivity extends Activity {

    private ActivityMainBinding binding;

    private TextView mTextView;
    Random myRandom = new Random();
    ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        mTextView = binding.text;
        mTextView.setText("   " + myRandom.nextInt(10) + " ");
        //get the imagebutton (checkmark) and set up the listener for a random number.
        ib = binding.myButton;
        ib.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTextView.setText("   " + myRandom.nextInt(10) + " ");

            }
        });
    }
}
