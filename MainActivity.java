package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	
	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private TextView mQuestionTextView;
	
	private TrueFalse[] mQuestionBank = new TrueFalse[] {
			new TrueFalse(R.string.question_oceans, true),
			new TrueFalse(R.string.question_mideast, false),
			new TrueFalse(R.string.question_africa, false),
			new TrueFalse(R.string.question_americas, true),
			new TrueFalse(R.string.question_asia, true),
	};
	
	private int mCurrentIndex = 0;
	
	private void updateQuestion() {
		int question = mQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);
	}
	
	private void checkAnswer(boolean userPressedTrue) {
		boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
		
		int messageResId = 0;
		
		if (userPreesedTrue == answerIsTrue) {
			messageResId = R.string.correct_toast;
		} else {
			messageResId = R.string.incorrect_toast;
		}
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mQuestionTextView = (TextView)findViewByID(R.id.question_text_view);
        
        
        mTrueButton = (Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListner(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		
        		checkAnswer(true);
        	}
        });
        
        mFalseButton = (Button)findViewById(R.id.false_button);
        mFalseButton.setOnClickListner(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		
        		checkAnswer(false);
        	
        	}
        });
        
        mNextButton = (Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListner(new View.OnClickListiner() {
        	@Override
        	public void onClick(View v) {
        		mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
        		
        	}
        });
        
        updateQuestion();
    }
  }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
