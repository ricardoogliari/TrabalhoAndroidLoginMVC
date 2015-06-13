package com.example.trabalhoandroidloginmvc;

import java.net.CookieHandler;
import java.net.CookieManager;

import android.app.ActivityManager;
import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class MyVolley {
	private static RequestQueue mRequestQueue;
	private static ImageLoader mImageLoader;
	private static RetryPolicy mRetryPolicy;

	private MyVolley() {
		// no instances
	}

	static void init(Context context) {
		mRequestQueue = Volley.newRequestQueue(context);
		CookieManager cookieManager = new CookieManager();
		CookieHandler.setDefault(cookieManager);

		int memClass = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
		// Use 1/8th of the available memory for this memory cache.
		int cacheSize = 1024 * 1024 * memClass / 8;
		//mImageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache(cacheSize));

		// Default timeout
		mRetryPolicy = new DefaultRetryPolicy(20000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
	}

	public static RetryPolicy getDefaultRetryPolicy() {
		return mRetryPolicy;
	}

	public static RequestQueue getRequestQueue() {
		if (mRequestQueue != null) {
			return mRequestQueue;
		} else {
			throw new IllegalStateException("RequestQueue not initialized");
		}
	}

	/**
	 * Returns instance of ImageLoader initialized with {@see FakeImageCache}
	 * which effectively means that no memory caching is used. This is useful
	 * for images that you know that will be show only once.
	 * 
	 * @return
	 */
	public static ImageLoader getImageLoader() {
		if (mImageLoader != null) {
			return mImageLoader;
		} else {
			throw new IllegalStateException("ImageLoader not initialized");
		}
	}

}