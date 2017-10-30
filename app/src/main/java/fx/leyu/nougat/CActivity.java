package fx.leyu.nougat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CActivity extends Activity {
    private static final String TAG = "CActivity";
    private EditText editText;

    public static Intent getIntentOfTheActivity(Context context) {
        Intent result = new Intent();
        result.setClass(context, CActivity.class);
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        editText = (EditText) findViewById(R.id.edit_text);
    }

    public void onClick(View view) {
        String string = editText.getText().toString();
        Intent intent = getIntent();
        intent.putExtra("string", string);
        Log.d(TAG, "intent = " + intent);

        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
