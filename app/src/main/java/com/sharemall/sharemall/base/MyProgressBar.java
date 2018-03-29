package com.sharemall.sharemall.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sharemall.sharemall.R;
import com.sharemall.sharemall.utils.Tools;


/**
 * ģ̬�Ի���
 *
 * @author wanghl-a
 */
public class MyProgressBar extends Dialog {
    private Activity context;
    private TextView tv_content;
    private ImageView iv_result;
    private ProgressBar progressBar1;
    private View view;

    /**
     * �������
     *
     * @param context ������
     */
    public MyProgressBar(Context context) {
        super(context, R.style.dialog_no_animation);
        this.context = (Activity) context;
        view = LayoutInflater.from(context)
                .inflate(R.layout.progress_bar, null);
        tv_content = (TextView) view.findViewById(R.id.tv_content);
        progressBar1 = (ProgressBar) view.findViewById(R.id.progressBar1);
        iv_result = (ImageView) view.findViewById(R.id.iv_result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(view);
        setCanceledOnTouchOutside(false);
    }

    @Override
    public void show() {
        progressBar1.setVisibility(View.VISIBLE);
        iv_result.setVisibility(View.GONE);
        tv_content.setText(R.string.dialog_loading_data);
        super.show();
    }

    public void show(int resID) {
        if (tv_content != null) {
            tv_content.setText(resID);
        }
        show();
    }

    public void show(String msg) {
        if (tv_content != null) {
            tv_content.setText(Tools.trim(msg));
        }
        show();
    }

    public void successDismiss(String msg) {
        tv_content.setText(Tools.trim(msg));
        showResult(R.drawable.icon_ok);
    }

    public void errorDismiss(String msg) {
        tv_content.setText(Tools.trim(msg));
        showResult(R.drawable.icon_error);
    }

    private void showResult(int resID) {
        progressBar1.setVisibility(View.GONE);
        iv_result.setVisibility(View.VISIBLE);
        iv_result.setImageResource(resID);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, 1000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        context.finish();
    }

}
