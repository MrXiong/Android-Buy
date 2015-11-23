package com.group.buy.adapter;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.group.buy.R;
import com.group.buy.base.MyApplication;
import com.group.buy.entity.Store;
import com.group.buy.utils.AdapterUtils;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder>{
	
	private OnItemClickListener mOnItemClickListener;
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


		public ViewHolder(View itemView) {
			super(itemView);
		}
		TextView tvStoreName;
		
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
					mOnItemClickListener.onItemClick(holder.itemView, position);
				}
			});
		}
		holder.tvStoreName.setText(mStoreList.get(position).getStoreName());
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
		View view = mLayoutInflater.inflate(R.layout.view_item_store, parent, false);
		ViewHolder holder = new ViewHolder(view);
		holder.tvStoreName = (TextView) view.findViewById(R.id.tv_storeName);
		return holder;
	}
	//onItem»Øµ÷
	public interface OnItemClickListener{
		void onItemClick(View view ,int position);
	}
	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.mOnItemClickListener = onItemClickListener;
	}
}
