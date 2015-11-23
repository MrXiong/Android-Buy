package com.group.buy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.group.buy.adapter.StoreAdapter;
import com.group.buy.adapter.StoreAdapter.OnItemClickListener;
import com.group.buy.base.GlobalConfig;
import com.group.buy.base.MyApplication;
import com.group.buy.base.VolleyTool;
import com.group.buy.entity.CommonResponse;
import com.group.buy.entity.Store;
import com.group.buy.request.GsonRequest;
import com.group.buy.utils.LogUtils;
import com.group.buy.utils.ToastUtils;

public class MainActivity extends Activity {
	protected static final String TAG = MainActivity.class.getSimpleName();
	private Context mContext;
	private SwipeRefreshLayout mSwipeRefresh;
	private RecyclerView mRvStore;
	private RequestQueue mRequestQueue;
	private LinearLayoutManager mLinearLayoutManager;
	private List<Store> mStoreList;
	private StoreAdapter mStoreAdapter;
	private GsonRequest<CommonResponse> mGsonRequest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		mContext = MyApplication.getContext();
		mRequestQueue = VolleyTool.getRequestQueue(mContext);
		mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
		mRvStore = (RecyclerView) findViewById(R.id.rv_store);
		mLinearLayoutManager = new LinearLayoutManager(mContext);
		mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		mRvStore.setLayoutManager(mLinearLayoutManager);
		mStoreAdapter = new StoreAdapter();
		initData();
		initListener();
	}

	private void initListener() {
		mStoreAdapter.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(View view, int position) {
				ToastUtils.show(mContext, mStoreList.get(position).getStoreName());
			}
		});
		
	}

	private void initData() {
		mGsonRequest = new GsonRequest<CommonResponse>(GlobalConfig.URL_TEST, CommonResponse.class, new Response.Listener<CommonResponse>() {

			public void onResponse(CommonResponse response) {
				Store storeList[] = response.getResult().getStoreList();
				mStoreList = Arrays.asList(storeList);
				mStoreAdapter.setStoreList(mStoreList);
				mRvStore.setAdapter(mStoreAdapter);
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				
			}
		});
		mRequestQueue.add(mGsonRequest);
		
		
	}

}
