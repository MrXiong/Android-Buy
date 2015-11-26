package com.group.buy.entity;

public class Result {
	
	public Result(){
		
	}
	public Result(int a){
		
	}
	public Result(String a){
		
	}
	public Result(String a,int b){
		
	}

	private int totalSize;
	private Store[] storeList;

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public Store[] getStoreList() {
		return storeList;
	}

	public void setStoreList(Store[] storeList) {
		this.storeList = storeList;
	}

}
