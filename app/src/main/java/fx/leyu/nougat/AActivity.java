package fx.leyu.nougat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AActivity extends Activity {
    private final int requestCode = 1;

    private TextView textView;


    public static Intent getIntentOfTheActivity(Context context) {
        Intent result = new Intent();
        result.setClass(context, AActivity.class);
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        textView = (TextView) findViewById(R.id.text_view);
    }


    public void onClick(View view) {
        Intent intent = BActivity.getIntentOfTheActivity(this);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        textView.setText(data.getStringExtra("string"));
    }
}
