package com.example.administrator.stockoptionallist.locktable;

/**
 * Created by Administrator on 2018/12/18.
 */

import android.content.Context;
import android.util.AttributeSet;

import com.example.administrator.stockoptionallist.ListOptionalFragment;


/**
 * 滑动代码
 */
public class CHScrollView extends HorizontalScrollViewEx {
    ListOptionalFragment listOptionalFragment;

    public CHScrollView(Context context) {
        this(context, null);
    }

    public CHScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CHScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setListOptionalFragment(ListOptionalFragment listOptionalFragment) {
        this.listOptionalFragment = listOptionalFragment;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        //当当前的CHSCrollView被触摸时，滑动其它
        if (listOptionalFragment != null) {
            listOptionalFragment.onScrollChanged(l, t, oldl, oldt);
        } else {
            super.onScrollChanged(l, t, oldl, oldt);
        }
    }

}