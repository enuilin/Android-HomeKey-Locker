package io.github.homelocker.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import io.github.homelocker.lib.OverlayDialog;


public class MainActivity extends ActionBarActivity implements CompoundButton.OnCheckedChangeListener {

    private ToggleButton mTbLock;
    private OverlayDialog mOverlayDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTbLock = (ToggleButton) findViewById(R.id.tb_lock);
        mTbLock.setOnCheckedChangeListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView == mTbLock) {
            if (isChecked) {
                if (mOverlayDialog == null) {
                    mOverlayDialog = new OverlayDialog(this);
                    mOverlayDialog.show();
                }
            } else {
                if (mOverlayDialog != null) {
                    mOverlayDialog.dismiss();
                    mOverlayDialog = null;
                }
            }
        }
    }
}
