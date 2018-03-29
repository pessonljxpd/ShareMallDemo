package com.sharemall.sharemall.base;

import java.io.File;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.sharemall.sharemall.R;
import com.sharemall.sharemall.utils.ConstantUtil;

/**
 * Activityҳ����ת
 */
public class ActivityIntentFactory extends IntentFactory {
    private FragmentActivity activity;

    public ActivityIntentFactory(FragmentActivity activity) {
        super(activity);
        this.activity = activity;
    }

    private FragmentTransaction initFragmentTransaction() {
        return activity.getSupportFragmentManager().beginTransaction();
    }

    @Override
    public void addFragment(BaseFragment fragment) {
        FragmentTransaction transaction = initFragmentTransaction();
        transaction.add(R.id.simple_fragment, fragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void replaceFragment(BaseFragment newFragment) {
        replaceFragment(R.id.simple_fragment, newFragment, true);
    }

    @Override
    public void replaceFragment(BaseFragment newFragment, boolean addToBackStack) {
        replaceFragment(R.id.simple_fragment, newFragment, addToBackStack);
    }

    @Override
    public void replaceFragment(int contentID, BaseFragment newFragment,
            boolean addToBackStack) {
        FragmentTransaction transaction = initFragmentTransaction();
        // transaction.setCustomAnimations(R.anim.push_left_in,
        // R.anim.push_left_out, R.anim.push_right_in,
        // R.anim.push_right_out);
        transaction.replace(contentID, newFragment);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void goToCropImage(String path, Uri requestUri, int size) {
        File file = new File(path);
        if (file.exists()) {
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(Uri.fromFile(file), "image/*");
            // �������crop=true�������ڿ�����Intent��������ʾ��VIEW�ɲü�
            intent.putExtra("crop", "true");
            // aspectX aspectY �ǿ�ߵı���
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            // outputX outputY �ǲü�ͼƬ���
            intent.putExtra("outputX", size);
            intent.putExtra("outputY", size);
            intent.putExtra("return-data", false);
            intent.putExtra("outputFormat",
                    Bitmap.CompressFormat.JPEG.toString());
            intent.putExtra(MediaStore.EXTRA_OUTPUT, requestUri);
            activity.startActivityForResult(intent, ConstantUtil.CROP_PIC);
        }
    }

    @Override
    public void goToOthersForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra(BaseActivity.PARAM_INTENT, bundle);
        activity.startActivityForResult(intent, requestCode);
    }

    @Override
    public void backForResult(Class<?> cls, Bundle bundle, int resultCode) {
        Intent intent = new Intent();
        if (cls != null) {
            intent.setClass(activity, cls);
        }
        intent.putExtra(BaseActivity.PARAM_INTENT, bundle);
        activity.setResult(resultCode, intent);
        activity.finish();
    }
}
