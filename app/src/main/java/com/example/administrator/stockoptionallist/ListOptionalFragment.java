package com.example.administrator.stockoptionallist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base_v2_0.BaseQuickAdapter;
import com.chad.library.adapter.base_v2_0.BaseViewHolder;
import com.example.administrator.stockoptionallist.locktable.CHScrollView;

import java.util.ArrayList;
import java.util.List;

import me.jessyan.autosize.utils.LogUtils;

/**
 * Created by Administrator on 2018/12/14.
 * <p>
 * 自选列表
 */

public class ListOptionalFragment extends Fragment implements BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemLongClickListener {

    private StockOptionalAdapter mStockOptionalAdapter;

    //装入所有的HScrollView
    protected List<CHScrollView> mHScrollViews = new ArrayList<>();

    private View rootView;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list_optional, container, false);
        initView();
        return rootView;
    }

    private void initView() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rlv_optional_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mStockOptionalAdapter = new StockOptionalAdapter(this));
        mStockOptionalAdapter.setOnItemClickListener(this);
        mStockOptionalAdapter.setOnItemLongClickListener(this);
        //添加头滑动事件
        CHScrollView sortScrollTitle = (CHScrollView) rootView.findViewById(R.id.sort_scroll_title);
        sortScrollTitle.setListOptionalFragment(this);
        mHScrollViews.add(sortScrollTitle);
    }


    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        for (CHScrollView scrollView : mHScrollViews) {
            int scrollX = scrollView.getScrollX();
            scrollView.scrollTo(l, t);
        }
    }


    @Override
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        LogUtils.d("click item:" + i);
    }

    @Override
    public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        return true;
    }

    class StockOptionalAdapter extends BaseQuickAdapter<StockModel, BaseViewHolder> {
        private ListOptionalFragment listOptionalFragment;

        StockOptionalAdapter(ListOptionalFragment listOptionalFragment) {
            super(R.layout.item_stock_optional_list, getList());
            this.listOptionalFragment = listOptionalFragment;
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, StockModel stockModel) {
            baseViewHolder.itemView.setBackgroundResource(R.drawable.recycler_bg);
            baseViewHolder.setText(R.id.tv_stock_name,stockModel.getName())
                    .setText(R.id.tv_stock_code,stockModel.getCode());
            addHViews((CHScrollView) baseViewHolder.getView(R.id.item_scroll_view));
        }

        void addHViews(final CHScrollView hScrollView) {
            hScrollView.setListOptionalFragment(listOptionalFragment);
            if (!mHScrollViews.isEmpty()) {
                int size = mHScrollViews.size();
                CHScrollView scrollView = mHScrollViews.get(size - 1);
                final int scrollX = scrollView.getScrollX();
                //第一次满屏后，向下滑动，有一条数据在开始时未加入
                if (scrollX != 0) {
                    recyclerView.post(new Runnable() {
                        @Override
                        public void run() {
                            //当listView刷新完成之后，把该条移动到最终位置
                            hScrollView.scrollTo(scrollX, 0);
                        }
                    });
                }
            }
            mHScrollViews.add(hScrollView);
        }

        void setDatas(List<StockModel> stockModels) {
            this.mData = stockModels;
        }
    }

    private List<StockModel> getList() {
        List<StockModel> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new StockModel(String.valueOf(600546 + i), "股票key" + i));
        }
        return list;
    }
}
