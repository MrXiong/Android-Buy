package com.group.buy.adapter;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.group.buy.R;
import com.group.buy.base.MyApplication;
import com.group.buy.entity.Store;
import com.group.buy.utils.AdapterUtils;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder>{
	
	private OnItemClickListener mOnItemClickListener;
	private OnLongItemClickListener mOnLongItemClickListener;
	private List<Store> mStoreList;
	private Context mContext;
	private LayoutInflater mLayoutInflater;
	
	public StoreAdapter(){
		mContext = MyApplication.getContext();
		mLayoutInflater = LayoutInflater.from(mContext);
		
	}
	public void setStoreList(List<Store> storeList){
		this.mStoreList = AdapterUtils.getList(storeList);
	}
	
	
	static class ViewHolder extends RecyclerView.ViewHolder{

		private TextView tvStoreName;
		public ViewHolder(View parent) {
			super(parent);
			tvStoreName = (TextView) parent.findViewById(R.id.tv_storeName);
		}
		
	}
	@Override
	public int getItemCount() {
		return mStoreList.size();
	}

	@Override
	public void onBindViewHolder(final ViewHolder holder, final int position) {
		if(mOnItemClickListener != null) {
			holder.itemView.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					mOnItemClickListener.onItemClick(v, position);
				}
			});
			holder.itemView.setOnLongClickListener(new OnLongClickListener() {
				public boolean onLongClick(View v) {
					mOnLongItemClickListener.onLongItemClick(v, position);
					return false;
				}
			});
		}
		holder.tvStoreName.setText(mStoreList.get(position).getStoreName());
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
		View view = mLayoutInflater.inflate(R.layout.view_item_store, parent, false);
		return new ViewHolder(view);
	}
	
	//other
	//item点击事件
	public interface OnItemClickListener{
		void onItemClick(View view ,int position);
	}
	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.mOnItemClickListener = onItemClickListener;
	}
	//长按删除回调
	public interface OnLongItemClickListener{
		void onLongItemClick(View view ,int position);
	}
	public void setOnLongItemClickListener(OnLongItemClickListener onLongItemClickListener) {
		this.mOnLongItemClickListener = onLongItemClickListener;
	}
	//添加item
	public void addItem(int position, Store store){
		mStoreList.add(position, store);
		//插入Item的时候刷新单个Item
		notifyItemInserted(position);
	}
	//删除单个item
	public void deleteItem(int position){
		mStoreList.remove(position);
		  // 移除Item的时候刷新单个Item
		notifyItemRemoved(position);
	}
	
	//刷新数据
	/**
     * 下拉刷新 ，更新数据的方法
     * @param newsBeans
     */
    public void refreshAllData(List<Store> storeList) {
    	mStoreList.clear();
        if (mStoreList.isEmpty()) {
        	mStoreList.addAll(storeList);
        }
        // 更新RecyclerView视图
        notifyDataSetChanged();
    }
}
