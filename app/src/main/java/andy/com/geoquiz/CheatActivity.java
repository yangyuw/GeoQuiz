package andy.com.geoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    public static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.bignerdranch.android.geoquiz.answer_is_true";

    private boolean mAnswerIsTrue;
    private static final String KEY_INDEX = "index";
    private TextView mAnswerTextView;
    private Button mShowAnswer;
    private int mWhetherCheat = 0;

    ////旋转以后保存变量值不变
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, mWhetherCheat);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
        if (savedInstanceState != null){
            mWhetherCheat = savedInstanceState.getInt(KEY_INDEX);
            mAnswerTextView.setText("" + mAnswerIsTrue);
            setAnswerShownResult(true);
        }
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnswerTextView.setText("" + mAnswerIsTrue);
                mWhetherCheat = 1;
                setAnswerShownResult(true);

            }
        });

    }
    ////创建一个私有方法，用来创建intent，附加extra并设置结果值。然后在Show Answer按钮的监听器代码中调用该方法
    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown); //(key, value)
        setResult(RESULT_OK, data);
    }

}
