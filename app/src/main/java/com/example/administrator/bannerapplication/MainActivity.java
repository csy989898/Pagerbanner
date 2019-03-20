package com.example.administrator.bannerapplication;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.bannerapplication.activity.LoopActivity;
import com.example.administrator.bannerapplication.activity.NetWorkActivity;
import com.example.administrator.bannerapplication.activity.glide.GlideTransActivity;
import com.example.administrator.bannerapplication.activity.glide.GlideZoomActivity;
import com.example.administrator.bannerapplication.activity.glide.GlidenormalActivity;
import com.example.administrator.bannerapplication.tab.TabActivity;
import com.example.viewpagerlib.view.ArcImageView;
import com.example.viewpagerlib.view.ColorTextView;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "zsr";
    private static final int[] RES = {R.mipmap.ca,R.mipmap.cb,R.mipmap.cc,
            R.mipmap.cd };
    private ColorTextView mColorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArcImageView arcImageView = (ArcImageView) findViewById(R.id.arcimage);
        GlideApp.with(this)
                .load(R.mipmap.cd)
                .into(arcImageView);
        mColorTextView = (ColorTextView) findViewById(R.id.colortext);

    }



    public void glide(View view) {
        startActivity(new Intent(this, GlidenormalActivity.class));
    }

    public void glide_tran(View view) {
        startActivity(new Intent(this, GlideTransActivity.class));
    }

    public void glide_scale(View view) {
        startActivity(new Intent(this, GlideZoomActivity.class));
    }


    public void loop_max(View view) {
        startActivity(new Intent(this, LoopActivity.class));
    }

    public void fragment(View view) {
        startActivity(new Intent(this,TabActivity.class));
    }

    public void leftchange(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mColorTextView,"progress",0,1);
        animator.setDuration(2000).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mColorTextView.setprogress(value,ColorTextView.DEC_LEFT);
            }
        });


    }

    public void rightchange(View view) {

        ObjectAnimator animator = ObjectAnimator.ofFloat(mColorTextView,"progress",0,1);
        animator.setDuration(2000).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mColorTextView.setprogress(value,ColorTextView.DEC_RIGHT);
            }
        });
    }

    public void test(View view) {
        startActivity(new Intent(this, NetWorkActivity.class));
    }
}
