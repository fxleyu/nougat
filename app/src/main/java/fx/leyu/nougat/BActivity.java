package fx.leyu.nougat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class BActivity extends Activity {
    private static final String TAG = "BActivity";
    private static final int requestCode = 1;

    private TextView textView;

    public static Intent getIntentOfTheActivity(Context context) {
        Intent result = new Intent();
        result.setClass(context, BActivity.class);
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        textView = (TextView) findViewById(R.id.text_view);
    }

    public void onClick(View view) {
        Intent intent = CActivity.getIntentOfTheActivity(this);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (data == null) {
            Log.d(TAG, "onActivityResult the data is null");
            return;
        } else {
            Log.d(TAG, "data = " + data);
        }

        textView.setText(data.getStringExtra("string"));
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}
