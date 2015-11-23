package com.group.buy.base;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyTool {

	private static RequestQueue mRequestQueue;
	public static RequestQueue getRequestQueue(Context context) {
		if(mRequestQueue == null) {
			synchronized (RequestQueue.class) {
				if(mRequestQueue == null) {
					mRequestQueue = Volley.newRequestQueue(context);
				}
			}
		}
		return mRequestQueue;
	}
}
