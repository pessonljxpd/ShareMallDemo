package com.sharemall.sharemall.base.net;

import android.os.AsyncTask;
import android.widget.Toast;

import com.sharemall.sharemall.R;
import com.sharemall.sharemall.base.BaseActivity;
import com.sharemall.sharemall.beans.JasonResult;
import com.sharemall.sharemall.itf.OnPostSuccessListener;
import com.sharemall.sharemall.utils.BaseParams;
import com.sharemall.sharemall.utils.Tools;
import com.sharemall.sharemall.utils.UriUtil;

/**
 * @author Shelly
 */
public class BaseAsyncTask extends AsyncTask<Object, Integer, JasonResult> {
    private BaseActivity activity;
    private OnPostSuccessListener listener;
    private int action;

    public BaseAsyncTask(BaseActivity activity, OnPostSuccessListener listener,
            int action) {
        this.activity = activity;
        this.listener = listener;
        this.action = action;
    }

    @Override
    protected JasonResult doInBackground(Object... params) {
        return new DataUtil()
                .postJasonResult(UriUtil.getUriBase(), BaseParams.getInstance().getBaseParams(action, activity),
                        params[0]);
    }

    @Override
    protected void onPostExecute(JasonResult result) {
        if (isCancelled()) {
            return;
        }
        activity.mProgressBar.dismiss();
        if (result != null) {
            if (result.code == 0) {
                listener.onPostSuccess(action, result.data);
            } else {
                Toast.makeText(activity, Tools.trim(result.message), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(activity, R.string.something_wrong, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPreExecute() {
        activity.mProgressBar.show();
    }

}
