package com.sharemall.sharemall.base;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.io.File;

/**
 * @author Shelly
 */
public class BaseActivity extends FragmentActivity implements IntentListener {
    /**
     * 参数传递标示
     */
    public static final String PARAM_INTENT = "intentData";
    /**
     * 传递参数
     */
    private Bundle intentData;

    /**
     * 模态对话框
     */
    public MyProgressBar mProgressBar;

    public boolean isHasFragment = false;
    private IntentListener intentFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mProgressBar = new MyProgressBar(this);
        if (savedInstanceState == null) {
            intentData = getIntent().getExtras();
        } else {
            intentData = savedInstanceState.getBundle(PARAM_INTENT);
        }
        Bundle bundle = intentData != null
                && intentData.getBundle(PARAM_INTENT) != null ? intentData
                .getBundle(PARAM_INTENT) : intentData;
        initIntentData(bundle != null ? bundle : new Bundle());
        super.onCreate(savedInstanceState);
        intentFactory = new ActivityIntentFactory(this);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBundle(PARAM_INTENT, intentData);
        super.onSaveInstanceState(outState);
    }

    /**
     * 初始化页面传递过来的数据
     *
     * @param bundle 数据
     */
    protected void initIntentData(Bundle bundle) {

    }


    /**
     * 限制EditText输入，最长不能超过length的长度
     *
     * @param et     EditText控件
     * @param length 限制长度
     */
    public void limitEditTextLength(EditText et, int length) {
        et.addTextChangedListener(new MyTextWatcher(et, length));
    }

    private class MyTextWatcher implements TextWatcher {
        private EditText et;
        private int length;

        public MyTextWatcher(EditText et, int length) {
            this.et = et;
            this.length = length;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            String mText = et.getText().toString();
            int len = mText.length();
            if (len > length) {
                mText = mText.substring(0, length);
                et.setText(mText);
            }
        }
    }

    /**
     * 隐藏输入法
     */
    public void hideInputMethodManager() {
        // 隐藏输入法
        InputMethodManager imm = (InputMethodManager) getApplicationContext()
                .getSystemService(INPUT_METHOD_SERVICE);
        // 显示或者隐藏输入法
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 往容器里面添加fragment
     *
     * @param fragment
     */
    @Override
    public void addFragment(BaseFragment fragment) {
        intentFactory.addFragment(fragment);
    }

    /**
     * 替换容器里面的fragment
     *
     * @param newFragment
     */
    @Override
    public void replaceFragment(BaseFragment newFragment) {
        intentFactory.replaceFragment(newFragment);
    }

    /**
     * fragment替换
     *
     * @param newFragment    碎片
     * @param addToBackStack 是否保存堆栈信息
     */
    @Override
    public void replaceFragment(BaseFragment newFragment, boolean addToBackStack) {
        intentFactory.replaceFragment(newFragment, addToBackStack);
    }

    /**
     * fragment替换
     *
     * @param contentID      容器ID
     * @param newFragment    碎片
     * @param addToBackStack 是否保存堆栈信息
     */
    @Override
    public void replaceFragment(int contentID, BaseFragment newFragment,
            boolean addToBackStack) {
        intentFactory.replaceFragment(contentID, newFragment, addToBackStack);
    }

    /**
     * 去裁剪图片
     *
     * @param path       图片地址
     * @param requestUri 裁剪回调地址
     * @param size       裁剪大小
     */
    @Override
    public void goToCropImage(String path, Uri requestUri, int size) {
        intentFactory.goToCropImage(path, requestUri, size);
    }

    @Override
    public void goToView(String path) {
        intentFactory.goToView(path);
    }

    /**
     * 通过地址查看图片
     *
     * @param path 图片地址
     */
    @Override
    public void goToView(String path, Class<?> cls) {
        intentFactory.goToView(path, cls);
    }

    /**
     * 单纯的页面跳转
     *
     * @param cls 跳转的页面
     */
    @Override
    public void goToOthers(Class<?> cls) {
        intentFactory.goToOthers(cls);
    }

    /**
     * 页面跳转并关闭当前页面
     *
     * @param cls 跳转的页面
     */
    @Override
    public void goToOthersF(Class<?> cls) {
        intentFactory.goToOthersF(cls);
    }

    /**
     * 带参数的页面跳转
     *
     * @param cls    跳转的页面
     * @param bundle 参数
     */
    @Override
    public void goToOthers(Class<?> cls, Bundle bundle) {
        intentFactory.goToOthers(cls, bundle);
    }

    /**
     * 带参数的页面跳转并关闭当前页面
     *
     * @param cls    跳转的页面
     * @param bundle 参数
     */
    @Override
    public void goToOthersF(Class<?> cls, Bundle bundle) {
        intentFactory.goToOthersF(cls, bundle);
    }

    /**
     * 带回调的页面跳转
     *
     * @param cls         跳转的页面
     * @param bundle      参数
     * @param requestCode 请求码
     */
    @Override
    public void goToOthersForResult(Class<?> cls, Bundle bundle, int requestCode) {
        intentFactory.goToOthersForResult(cls, bundle, requestCode);
    }

    /**
     * 设置回调
     *
     * @param cls        回调的页面
     * @param bundle     参数
     * @param resultCode 返回码
     */
    @Override
    public void backForResult(Class<?> cls, Bundle bundle, int resultCode) {
        intentFactory.backForResult(cls, bundle, resultCode);
    }

    /**
     * 让某一页面顶置
     *
     * @param bundle 参数
     */
    @Override
    public void upToHome(Class<?> cls, Bundle bundle) {
        intentFactory.upToHome(cls, bundle);
    }

    /**
     * 让某一页面顶置
     */
    @Override
    public void upToHome(Class<?> cls) {
        intentFactory.upToHome(cls);
    }

    @Override
    public void homeAction() {
        intentFactory.homeAction();
    }

    /**
     * 跳转到网页
     *
     * @param url 网页地址
     */
    @Override
    public void goToWeb(String url) {
        intentFactory.goToWeb(url);
    }

    /**
     * 打电话
     *
     * @param telePhoneNum 电话号码
     */
    @Override
    public void goToCall(String telePhoneNum) {
        intentFactory.goToCall(telePhoneNum);
    }

    /**
     * 安装应用
     *
     * @param file
     */
    @Override
    public void installApp(File file) {
        intentFactory.installApp(file);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle bundle = null;
        if (data != null) {
            bundle = data.getBundleExtra(PARAM_INTENT);
            if (bundle == null) {
                bundle = data.getExtras();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
        onActivityResult(requestCode, resultCode, bundle);
    }

    /**
     * 页面回调函数
     *
     * @param requestCode 请求码
     * @param resultCode  返回码
     * @param data        数据
     */
    protected void onActivityResult(int requestCode, int resultCode, Bundle data) {

    }

    public void onClick(View v) {
    }

}
