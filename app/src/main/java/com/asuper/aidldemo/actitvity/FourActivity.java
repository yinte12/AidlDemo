package com.asuper.aidldemo.actitvity;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.asuper.aidldemo.R;
import com.asuper.aidldemo.base.BaseActivity;
import com.asuper.aidldemo.view.BubbleLayout;
import com.asuper.aidldemo.view.LoopNewsView;
import com.asuper.aidldemo.view.LoopView;
import com.asuper.aidldemo.view.MarqueeTextView;
import com.asuper.aidldemo.view.VerticalProgressBar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author super
 * @date 2018-12-07
 */
public class FourActivity extends BaseActivity {
    private static final int MY_PERMISSIONS_REQUEST_CALL_CAMERA = 2;

    private LoopNewsView mLnvView;
    private MarqueeTextView mTvView;
    private Button mBtn;
    private ImageView imageView;
    private boolean isTune = true;

    String[] permissions = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    @Override
    protected int getContentView() {
        return R.layout.activity_four_layout;
    }

    @Override
    protected void initView() {
        super.initView();
        mLnvView = (LoopNewsView) this.findViewById(R.id.lnv_view);
        List<String> list = new ArrayList<String>();
        list.add("1111111111111111111111111811111111111111113111111111311111111");
        list.add("1111111111111111111111111811111111111111113111111111311111111");
        list.add("111111111111111111111111181111111111111111311111111311111111");
        list.add("111111111181111111111111111311111111111111111181111111111111111311111111");
        list.add("111111");
        list.add("111111111161111111");
        list.add("111111111171111111");
        list.add("111111111181111111111111111311111111111111111181111111111111111311111111");
        list.add("111111111191111111111111111311111111");
        list.add("111111111211111111111111111311111111");
        list.add("111111111311111111111111111311111111");
        mLnvView.addData(list);

        imageView = (ImageView) this.findViewById(R.id.iv_image);
        mTvView = (MarqueeTextView) this.findViewById(R.id.tv_view);
        mTvView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        mTvView.setSingleLine(true);
        mTvView.setFocusable(true);
        mTvView.setText("111111111111111111111111111111111112222211111111111111111111111111111111111");
//        mTvView.startScroll();

        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTune) {
                    mTvView.setFocusableInTouchMode(false);
                    mTvView.setFocusable(false);
                    imageView.setImageDrawable(getResources().getDrawable(R.mipmap.kk_refresh0));
                    isTune = false;
                } else {
                    mTvView.setFocusable(true);
                    mTvView.setFocusableInTouchMode(true);
                    imageView.setImageDrawable(getResources().getDrawable(R.mipmap.bang_start_tip));
                    isTune = true;
                }
                Intent intent = new Intent(FourActivity.this, OpenGLAcitivity.class);
                startActivity(intent);
            }
        });
        LoopView lv = (LoopView) this.findViewById(R.id.lv_layout);
        lv.addData(list);

        //进程优先级
        int process = ActivityManager.RunningAppProcessInfo.IMPORTANCE_BACKGROUND;
        hasPermissions(101, () -> {}, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        hasPermissions(101, () -> {}, Manifest.permission.READ_EXTERNAL_STORAGE);

        VerticalProgressBar vpb = (VerticalProgressBar) findViewById(R.id.vpb_view);
        vpb.setMaxCount(100);
        vpb.setCurrentCount(90);

        BubbleLayout mBubble = (BubbleLayout) findViewById(R.id.bubble);
        mBubble.setData("1111111");
        mBubble.setAlpha(0.7f);
    }
}
