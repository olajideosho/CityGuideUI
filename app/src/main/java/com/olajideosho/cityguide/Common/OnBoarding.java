package com.olajideosho.cityguide.Common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.olajideosho.cityguide.HelperClasses.SliderAdapter;
import com.olajideosho.cityguide.R;
import com.olajideosho.cityguide.User.UserDashboard;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    TextView[] dots;
    Button letsGetStarted;
    Button skipButton;
    Button nextButton;

    SliderAdapter sliderAdapter;
    Animation animation;
    Boolean fromThree = false;

    int currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        letsGetStarted = findViewById(R.id.get_started_btn);
        skipButton = findViewById(R.id.skip_btn);
        nextButton = findViewById(R.id.next_btn);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);

        viewPager.setOnPageChangeListener(changeListener);
        skipButton.setOnClickListener(buttonListener);
        nextButton.setOnClickListener(buttonListener);
    }

    private void skip(){
        startActivity(new Intent(this, UserDashboard.class));
        finish();
    }

    private void next(){
        viewPager.setCurrentItem(currentPos + 1);
    }

    private void addDots(int position){
        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for(int i=0; i< dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if(dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.skip_btn:
                    skip();
                    break;
                case R.id.next_btn:
                    next();
                    break;
            }
        }
    };

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPos = position;

            if(position == 2){
                if(fromThree){
                    animation = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.bottom_reverse_anim);
                    letsGetStarted.setAnimation(animation);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            letsGetStarted.setVisibility(View.INVISIBLE);
                        }
                    }, 1500);
                    fromThree = false;
                }

            }
            else if(position != 3){
                letsGetStarted.setVisibility(View.INVISIBLE);
            }
            else{
                fromThree = true;
                animation = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.bottom_anim);
                letsGetStarted.setAnimation(animation);
                letsGetStarted.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
