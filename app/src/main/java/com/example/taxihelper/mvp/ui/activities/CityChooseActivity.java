package com.example.taxihelper.mvp.ui.activities;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.example.taxihelper.R;
import com.example.taxihelper.constant.Constant;
import com.example.taxihelper.mvp.contract.GetCitiesInfoContract;
import com.example.taxihelper.mvp.entity.CitiesInfo;
import com.example.taxihelper.mvp.presenter.GetCitiesInfoPresenterImpl;
import com.example.taxihelper.mvp.ui.activities.base.BaseActivity;
import com.example.taxihelper.mvp.ui.adapters.CityChooseContentAdapter;
import com.example.taxihelper.mvp.ui.adapters.CityChooseHeaderAdapter;
import com.example.taxihelper.utils.image.DialogProgressUtils;
import com.example.taxihelper.utils.others.AccessTokenUtils;
import com.example.taxihelper.utils.others.EasyRecyViewInitUtils;
import com.example.taxihelper.utils.others.ToastUtil;
import com.example.taxihelper.utils.system.DensityUtil;
import com.example.taxihelper.widget.DividerDecoration;
import com.example.taxihelper.widget.StickyHeaderDecoration;
import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * Created by 张兴锐 on 2017/8/11.
 */

public class CityChooseActivity extends BaseActivity implements GetCitiesInfoContract.View {
    @InjectView(R.id.current_city)
    TextView currentCityTv;
    @InjectView(R.id.citys)
    EasyRecyclerView citysRecycler;
    private CityChooseContentAdapter adapter;

    
    @Inject
    GetCitiesInfoPresenterImpl mPresenter;
    @Override
    public void initInjector() {
        mActivityComponent.inject(this);
        mPresenter.injectView(this);
    }

    @Override
    public void initViews() {
        //取得当前城市
        String currentCity = getIntent().getStringExtra(Constant.CURRENT_CITY);
        String type = getIntent().getStringExtra(Constant.TYPE);
        Integer serviceId = getIntent().getIntExtra(Constant.SERVICE_ID,-1);
        if (currentCity == null){
            return;
        }
        currentCityTv.append(currentCity);
        //初始化citysRecycler
        EasyRecyViewInitUtils.initEasyRecyclerView(citysRecycler);
        citysRecycler.setLayoutManager(new LinearLayoutManager(this));
        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, DensityUtil.dip2px(this, 0.5f), DensityUtil.dip2px(this, 8f), DensityUtil.dip2px(this, 8f));
        itemDecoration.setDrawLastItem(false);
        //设置adapter
        adapter = new CityChooseContentAdapter(this);
//        citysRecycler.addItemDecoration(itemDecoration);
        citysRecycler.setAdapter(adapter);
        
        //加入header
        StickyHeaderDecoration header = new StickyHeaderDecoration(new CityChooseHeaderAdapter(this,adapter));
        header.setIncludeHeader(true);
        citysRecycler.addItemDecoration(header);
        
        mPresenter.getCitiesInfo(AccessTokenUtils.getAccessToken(),type,serviceId);
        
    }
    
    

    @Override
    public int getLayout() {
        return R.layout.activity_city_choose;
    }


    @Override
    public void showProgress() {
        DialogProgressUtils.ShowDialogProgress(this);
    }

    @Override
    public void hideProgress() {
        DialogProgressUtils.hideDialogProgress();
    }

    @Override
    public void showMsg(String msg) {
        ToastUtil.shortToast(msg);
    }

    @Override
    public void getDatas(List<CitiesInfo> list) {
        adapter.addAll(list);
    }
}
