package fx.leyu.nougat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

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
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged s = " + s.toString());
                if (s.length() > 5) {
                    hideSoftInput();
                } else if (s.length() < 4) {
                    showSoftInput();
                }
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "showSoftInput = " + editText.requestFocus());
                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                Log.e(TAG, "showSoftInput = " + manager.showSoftInput(editText, 0));
            }
        }, 200);

    }

    private void hideSoftInput() {
        final InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        // not work
        //manager.hideSoftInputFromInputMethod(editText.getWindowToken(), 0);

        manager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        Log.d(TAG, "hideSoftInput");
    }

    private void showSoftInput() {
        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //manager.toggleSoftInput(0, InputMethodManager.RESULT_SHOWN);
        Log.d(TAG, "showSoftInput");
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
