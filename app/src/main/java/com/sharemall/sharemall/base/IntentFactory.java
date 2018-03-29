package com.sharemall.sharemall.base;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.sharemall.sharemall.utils.Tools;

public class IntentFactory implements IntentListener {
    private Context context;

    public IntentFactory(Context context) {
        this.context = context;
    }

    @Override
    public void goToView(String path) {
        if (Tools.isEmpty(path)) {
            return;
        }
        File file = new File(path);
        if (file.exists()) {
            Uri uri = Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "image/*");
            context.startActivity(intent);
        }
    }

    @Override
    public void goToView(String path, Class<?> cls) {
        if (Tools.isEmpty(path)) {
            return;
        }
        File file = new File(path);
        if (file.exists()) {
            Intent intent = new Intent(context, cls);
            intent.putExtra("imagePath", path);
            context.startActivity(intent);
        }
    }

    @Override
    public void goToOthers(Class<?> cls) {
        goToOthers(cls, null);
    }

    @Override
    public void goToOthersF(Class<?> cls) {
        goToOthers(cls);
        ((Activity) context).finish();
    }

    @Override
    public void goToOthers(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        intent.putExtra(BaseActivity.PARAM_INTENT, bundle);
        context.startActivity(intent);
    }

    @Override
    public void goToOthersF(Class<?> cls, Bundle bundle) {
        goToOthers(cls, bundle);
        ((Activity) context).finish();
    }

    @Override
    public void upToHome(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(BaseActivity.PARAM_INTENT, bundle);
        context.startActivity(intent);
        ((Activity) context).finish();
    }

    @Override
    public void upToHome(Class<?> cls) {
        upToHome(cls, null);
    }

    @Override
    public void homeAction() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// ע��
        intent.addCategory(Intent.CATEGORY_HOME);
        context.startActivity(intent);
    }

    @Override
    public void goToWeb(String url) {
        Uri uri = Uri.parse(url);
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(it);
    }

    @Override
    public void goToCall(String telePhoneNum) {
        if (Tools.isEmpty(telePhoneNum)) {
            return;
        }
        try {
            Uri uri = Uri.parse("tel:" + telePhoneNum);
            if (uri != null) {
                // Intent intent = new Intent(Intent.ACTION_CALL, uri);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                context.startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "���豸�޷��ṩ�绰����", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void installApp(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    @Override
    public void addFragment(BaseFragment fragment) {

    }

    @Override
    public void replaceFragment(BaseFragment newFragment) {

    }

    @Override
    public void replaceFragment(BaseFragment newFragment, boolean addToBackStack) {

    }

    @Override
    public void replaceFragment(int contentID, BaseFragment newFragment,
            boolean addToBackStack) {

    }

    @Override
    public void goToCropImage(String path, Uri requestUri, int size) {

    }

    @Override
    public void goToOthersForResult(Class<?> cls, Bundle bundle, int requestCode) {

    }

    @Override
    public void backForResult(Class<?> cls, Bundle bundle, int resultCode) {

    }

}
