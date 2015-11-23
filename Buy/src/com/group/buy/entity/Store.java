package com.group.buy.entity;

import java.text.DecimalFormat;
import java.util.List;

import android.text.TextUtils;

public class Store {
	private String storeId;
	private String storeLogoUrl;
	private String storeName;
	private String storeTypeName;
	private String subStoreTypeName;
	private String maxPrice;
	private String minPrice;
	private String address;
	private int distance;
	private String grouponNum;
	private String longitude;
	private String latitude;
	private int totalSaleNum;
	private String storeNote;
	private String minDiscount;
	private List<String> originTypeNames;
	private String minDiscountOrigin;
	private boolean isAd;

	
	public String getMinDiscount() {
		return minDiscount;
	}

	public void setMinDiscount(String minDiscount) {
		this.minDiscount = minDiscount;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreLogoUrl() {
		return storeLogoUrl;
	}

	public void setStoreLogoUrl(String storeLogoUrl) {
		this.storeLogoUrl = storeLogoUrl;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreTypeName() {
		return storeTypeName;
	}

	public void setStoreTypeName(String storeTypeName) {
		this.storeTypeName = storeTypeName;
	}

	public String getSubStoreTypeName() {
		return subStoreTypeName;
	}

	public void setSubStoreTypeName(String subStoreTypeName) {
		this.subStoreTypeName = subStoreTypeName;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDistance() {
		return distance;
	}
	
	public String getDistanceLabel() {
		if(distance >= 1000) {
			return "" + DecimalPoint((double) distance / 1000)  + "km";
		} else if(distance >= 100000) {
			return ">100km";
		} else {
			return "" + distance + "m";
		}
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getGrouponNum() {
		return grouponNum;
	}

	public void setGrouponNum(String grouponNum) {
		this.grouponNum = grouponNum;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public int getTotalSaleNum() {
		return totalSaleNum;
	}

	public void setTotalSaleNum(int totalSaleNum) {
		this.totalSaleNum = totalSaleNum;
	}

	public String getStoreNote() {
		return storeNote;
	}

	public void setStoreNote(String storeNote) {
		this.storeNote = storeNote;
	}
	

	public List<String> getOriginTypeNames() {
		return originTypeNames;
	}

	public void setOriginTypeNames(List<String> originTypeNames) {
		this.originTypeNames = originTypeNames;
	}
	

	public String getMinDiscountOrigin() {
		return minDiscountOrigin;
	}

	public void setMinDiscountOrigin(String minDiscountOrigin) {
		this.minDiscountOrigin = minDiscountOrigin;
	}

	public boolean isAd() {
		return isAd;
	}

	public void setAd(boolean isAd) {
		this.isAd = isAd;
	}

	@Override
	public boolean equals(Object o) {
		Store store = (Store) o;
		if (store != null && this.storeId.equals(store.getStoreId())) {
			return true;
		}
		return false;
	}
	
	private String DecimalPoint(double decimalValue) {
		DecimalFormat df = new DecimalFormat("#.#");
		return df.format(decimalValue);
	}
	
	public boolean isUnknownLocation() {
		float fLatitude = 0;
		float flongitude = 0;
		try {
			if (!TextUtils.isEmpty(longitude)) {
				flongitude = Float.valueOf(longitude);
			}
			if (!TextUtils.isEmpty(latitude)) {
				fLatitude = Float.valueOf(latitude);
			}
		} catch (Exception e) {
		}
		return fLatitude == 0 || flongitude == 0;
	}

}
