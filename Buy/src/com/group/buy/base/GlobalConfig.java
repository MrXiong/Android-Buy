package com.group.buy.base;

public class GlobalConfig {

	private static final String URL_DEBUG = "http://gw.test1.api.witown.com/router";
	private static final String URL_ONLINE = "http://open.treebear.cn/router";//支持https
	private static final String API_VERSION = "1.0";
	private static final String APPKEY_DEBUG = "10238";
//	private static final String URL_ONLINE = "http://open.witown.com/router";//不支持https
	public static final String URL_TEST = URL_DEBUG
			+ "?method=ivy.store.recommend.search"
			+ "&v=1.0"
			+ "&appKey=10238"
			+ "&longitude=120.097396"
			+ "&pageSize=20"
			+ "&latitude=30.267004"
			+ "&startNo=1"
			+ "&cityId=hangzhou"
			+ "&sign=CD1A962BE849E1DB43348721754907EE8750A2C4";
	
	
}
