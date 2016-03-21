package andy.com.geoquiz;

/**
 * Created by andy on 2016/3/20.
 */
public class TrueFalse {
    private int mQuestion;

    private boolean mTrueQuestion;

    public int getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public boolean ismTrueQuestion() {
        return mTrueQuestion;
    }

    public void setmTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }

    public TrueFalse(int mQuestion, boolean mTrueQuestion) {
        this.mQuestion=mQuestion;
        this.mTrueQuestion=mTrueQuestion;
    }
}
