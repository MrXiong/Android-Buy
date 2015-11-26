package com.group.buy.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.group.buy.R;

public class HeaderFooterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
	//our items
	List<String> items = new ArrayList<String>();
	//headers
	List<View> headers = new ArrayList<>();
	//footers
    List<View> footers = new ArrayList<>();
	
	public static final int TYPE_HEADER = 111;
    public static final int TYPE_FOOTER = 222;
    public static final int TYPE_ITEM = 333;
    
    public HeaderFooterAdapter(){
    	for (int i = 0; i < 20; i++) {
    		items.add("第"+i+"行");
		}
    }

	@Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
		if(type == TYPE_ITEM) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.generic_layout, viewGroup, false);
            return new GenericViewHolder(view);
        }else{
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
			//保证它充满控件
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return new HeaderFooterViewHolder(frameLayout);
        }
	}
	
	@Override
    public void onBindViewHolder(final RecyclerView.ViewHolder vh, int position) {
        if(position < headers.size()){
            View v = headers.get(position);
			//添加我们的视图到一个标题视图和显示它
            prepareHeaderFooter((HeaderFooterViewHolder) vh, v);
        }else if(position >= headers.size() + items.size()){
            View v = footers.get(position-items.size()-headers.size());
			//添加我们的视图到一个脚注视图并显示它
            prepareHeaderFooter((HeaderFooterViewHolder) vh, v);
        }else {
			//通用的默认情况下
            prepareGeneric((GenericViewHolder) vh, position-headers.size());
            
        }
    }
	
	@Override
    public int getItemCount() {
        return headers.size() + items.size() + footers.size();
    }

    private void prepareHeaderFooter(HeaderFooterViewHolder vh, View view){
		//清空我们的FrameLayout更换我们的页眉/页脚
        vh.base.removeAllViews();
        vh.base.addView(view);
    }
	
	private void prepareGeneric(GenericViewHolder vh, int position){
		//做我们需要做的任何其他类型的事
		vh.tvGeneric.setText(items.get(position));
	}
	
	@Override
    public int getItemViewType(int position) {
		//筛选类型
        if(position < headers.size()){
            return TYPE_HEADER;
        }else if(position >= headers.size() + items.size()){
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }
	
	public void addHeader(View header){
        if(!headers.contains(header)){
            headers.add(header);
			//animate
            notifyItemInserted(headers.size()-1);
        }
    }
	
    public void removeHeader(View header){
        if(headers.contains(header)){
			//animate
            notifyItemRemoved(headers.indexOf(header));
            headers.remove(header);
        }
    }
	
    public void addFooter(View footer){
        if(!footers.contains(footer)){
            footers.add(footer);
			//animate
            notifyItemInserted(headers.size()+items.size()+footers.size()-1);
        }
    }
	
    public void removeFooter(View footer){
        if(footers.contains(footer)) {
			//animate
            notifyItemRemoved(headers.size()+items.size()+footers.indexOf(footer));
            footers.remove(footer);
        }
    }
	
	//我们的页眉/页脚recyclerview.viewholder是FrameLayout
	public static class HeaderFooterViewHolder extends RecyclerView.ViewHolder{
        FrameLayout base;
        public HeaderFooterViewHolder(View itemView) {
            super(itemView);
            this.base = (FrameLayout) itemView;
        }
    }
	public static class GenericViewHolder extends RecyclerView.ViewHolder{
		private TextView tvGeneric;
		public GenericViewHolder(View itemView) {
			super(itemView);
			
			tvGeneric = (TextView) itemView.findViewById(R.id.tv_generic);
		}
	}
}