package com.sharemall.sharemall.base;

import java.io.File;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class BaseActivity extends FragmentActivity implements IntentListener {
    /**
     * �������ݱ�ʾ
     */
    public static final String PARAM_INTENT = "intentData";
    /**
     * ���ݲ���
     */
    private Bundle intentData;

    /**
     * ģ̬�Ի���
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
     * ��ʼ��ҳ�洫�ݹ���������
     *
     * @param bundle ����
     */
    protected void initIntentData(Bundle bundle) {

    }


    /**
     * ����EditText���룬����ܳ���length�ĳ���
     *
     * @param et     EditText�ؼ�
     * @param length ���Ƴ���
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
     * �������뷨
     */
    public void hideInputMethodManager() {
        // �������뷨
        InputMethodManager imm = (InputMethodManager) getApplicationContext()
                .getSystemService(INPUT_METHOD_SERVICE);
        // ��ʾ�����������뷨
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * �������������fragment
     *
     * @param fragment
     */
    @Override
    public void addFragment(BaseFragment fragment) {
        intentFactory.addFragment(fragment);
    }

    /**
     * �滻���������fragment
     *
     * @param newFragment
     */
    @Override
    public void replaceFragment(BaseFragment newFragment) {
        intentFactory.replaceFragment(newFragment);
    }

    /**
     * fragment�滻
     *
     * @param newFragment    ��Ƭ
     * @param addToBackStack �Ƿ񱣴��ջ��Ϣ
     */
    @Override
    public void replaceFragment(BaseFragment newFragment, boolean addToBackStack) {
        intentFactory.replaceFragment(newFragment, addToBackStack);
    }

    /**
     * fragment�滻
     *
     * @param contentID      ����ID
     * @param newFragment    ��Ƭ
     * @param addToBackStack �Ƿ񱣴��ջ��Ϣ
     */
    @Override
    public void replaceFragment(int contentID, BaseFragment newFragment, boolean addToBackStack) {
        intentFactory.replaceFragment(contentID, newFragment, addToBackStack);
    }

    /**
     * ȥ�ü�ͼƬ
     *
     * @param path       ͼƬ��ַ
     * @param requestUri �ü��ص���ַ
     * @param size       �ü���С
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
     * ͨ����ַ�鿴ͼƬ
     *
     * @param path ͼƬ��ַ
     */
    @Override
    public void goToView(String path, Class<?> cls) {
        intentFactory.goToView(path, cls);
    }

    /**
     * ������ҳ����ת
     *
     * @param cls ��ת��ҳ��
     */
    @Override
    public void goToOthers(Class<?> cls) {
        intentFactory.goToOthers(cls);
    }

    /**
     * ҳ����ת���رյ�ǰҳ��
     *
     * @param cls ��ת��ҳ��
     */
    @Override
    public void goToOthersF(Class<?> cls) {
        intentFactory.goToOthersF(cls);
    }

    /**
     * ��������ҳ����ת
     *
     * @param cls    ��ת��ҳ��
     * @param bundle ����
     */
    @Override
    public void goToOthers(Class<?> cls, Bundle bundle) {
        intentFactory.goToOthers(cls, bundle);
    }

    /**
     * ��������ҳ����ת���رյ�ǰҳ��
     *
     * @param cls    ��ת��ҳ��
     * @param bundle ����
     */
    @Override
    public void goToOthersF(Class<?> cls, Bundle bundle) {
        intentFactory.goToOthersF(cls, bundle);
    }

    /**
     * ���ص���ҳ����ת
     *
     * @param cls         ��ת��ҳ��
     * @param bundle      ����
     * @param requestCode ������
     */
    @Override
    public void goToOthersForResult(Class<?> cls, Bundle bundle, int requestCode) {
        intentFactory.goToOthersForResult(cls, bundle, requestCode);
    }

    /**
     * ���ûص�
     *
     * @param cls        �ص���ҳ��
     * @param bundle     ����
     * @param resultCode ������
     */
    @Override
    public void backForResult(Class<?> cls, Bundle bundle, int resultCode) {
        intentFactory.backForResult(cls, bundle, resultCode);
    }

    /**
     * ��ĳһҳ�涥��
     *
     * @param bundle ����
     */
    @Override
    public void upToHome(Class<?> cls, Bundle bundle) {
        intentFactory.upToHome(cls, bundle);
    }

    /**
     * ��ĳһҳ�涥��
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
     * ��ת����ҳ
     *
     * @param url ��ҳ��ַ
     */
    @Override
    public void goToWeb(String url) {
        intentFactory.goToWeb(url);
    }

    /**
     * ��绰
     *
     * @param telePhoneNum �绰����
     */
    @Override
    public void goToCall(String telePhoneNum) {
        intentFactory.goToCall(telePhoneNum);
    }

    /**
     * ��װӦ��
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
     * ҳ��ص�����
     *
     * @param requestCode ������
     * @param resultCode  ������
     * @param data        ����
     */
    protected void onActivityResult(int requestCode, int resultCode, Bundle data) {

    }

    public void onClick(View v) {
    }

}
