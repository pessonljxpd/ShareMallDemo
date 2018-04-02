package com.sharemall.sharemall.base;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.gyf.barlibrary.ImmersionBar;
import com.sharemall.sharemall.R;

import java.io.File;


/**
 * Fragment基类
 *
 * @author Shelly
 */
public class BaseFragment extends Fragment implements OnClickListener, IntentListener {

    private static final boolean DEBUG = false;

    /**
     * 模态
     */
    public MyProgressBar mProgressBar;

    private IntentListener intentFactory;
    private BaseActivity mActivity;

    protected ImmersionBar mImmersionBar;

    @Override
    public void onAttach(Activity activity) {
        if (DEBUG) { System.out.println("fragment开始onAttach"); }
        super.onAttach(activity);
        mActivity = (BaseActivity) activity;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (DEBUG) { System.out.println("fragment开始onCreate"); }
        super.onCreate(savedInstanceState);
        intentFactory = new FragmentIntentFactory(this);
        mProgressBar = new MyProgressBar(getActivity());
    }

    /**
     * 限制EditText输入，最长不能超过length的长度
     *
     * @param et     EditText控件
     * @param length 限制长度
     */
    public void limitEditTextLength(final EditText et, final int length) {
        if (mActivity != null) { mActivity.limitEditTextLength(et, length); }
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle bundle = null;
        if (data != null) {
            bundle = data.getBundleExtra(BaseActivity.PARAM_INTENT);
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

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        if (DEBUG) { System.out.println("fragment开始onActivityCreated"); }
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (view != null) {
            View titleBar = view.findViewById(setTitleBar());
            if (titleBar != null) {
                ImmersionBar.setTitleBar(mActivity, titleBar);
            }
            View statusBarView = view.findViewById(setStatusBarView());
            if (statusBarView != null) {
                ImmersionBar.setStatusBarView(mActivity, statusBarView);
            }
        }
    }

    public int setStatusBarView() {
        return 0;
    }

    public int setTitleBar() {
        return 0;
    }

    @Override
    public void onStart() {
        if (DEBUG) { System.out.println("fragment开始onStart"); }
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        if (DEBUG) { System.out.println("fragment开始onDestroyView"); }
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        if (DEBUG) { System.out.println("fragment开始onDestroy"); }
        super.onDestroy();
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
    }

    @Override
    public void onClick(View v) {
    }

}
