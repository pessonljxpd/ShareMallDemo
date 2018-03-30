package com.sharemall.sharemall.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sharemall.sharemall.R;
import com.sharemall.sharemall.utils.DensityUtil;
import com.sharemall.sharemall.view.AmountView;

/**
 * Created by Administrator on 2018/3/30 0030.
 */

public class CartExpandableListAdapter extends BaseExpandableListAdapter {

    private  Context context;
    private String[] CDs = new String[]
            { "风筝", "完美的一天", "是时候"};
    private String[][] songs = new String[][]
            {
                    { "绿光", "不是真的爱我", "爱情字典", "练习" },
                    { "Honey Honey", "心愿", "明天晴天", "隐形人" },
                    { "愚人的国度", "是时候" , "世说心语" }
            };

    public CartExpandableListAdapter(Context context){
        this.context = context;
    }


    //获取指定组位置、指定子列表项处的子列表项数据
    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        return songs[groupPosition][childPosition];
    }
    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }
    @Override
    public int getChildrenCount(int groupPosition)
    {
        return songs[groupPosition].length;
    }
    private TextView getTextView()
    {
        //用于实现条目的虚拟列表的基类. 这里的列表没有空间的定义。 例如，该类的子类可以以网格的形式、走马灯的形式显示，或者作为堆栈等等
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, 64);  //设置宽和高
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(lp);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        textView.setPadding(36, 0, 0, 0);
        textView.setTextSize(20);
        return textView;
    }
    //该方法决定每个子选项的外观
    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent)
    {

        View view   = View.inflate(getContext(), R.layout.item_cart,null);
        AmountView amountView = view.findViewById(R.id.amount_view);
        amountView.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                Toast.makeText(getContext(),songs[groupPosition][childPosition] + "::: " +amount,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    //获取指定组位置处的组数据
    @Override
    public Object getGroup(int groupPosition)
    {
        return CDs[groupPosition];
    }
    @Override
    public int getGroupCount()
    {
        return CDs.length;
    }
    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }
    //该方法决定每个组选项的外观
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent)
    {
        LinearLayout ll = new LinearLayout(getContext());
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(DensityUtil.dip2px(getContext(),10),0,0,0);

        TextView textView = getTextView();
        textView.setText(getGroup(groupPosition).toString());

        ll.addView(textView);
        return ll;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return true;
    }
    @Override
    public boolean hasStableIds()
    {
        return true;
    }

    public Context getContext() {
        return context;
    }
};

