package com.hy.ioms.utils.net;

import android.util.Log;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/4/5.
 */

public class RxException<T extends Throwable> implements Consumer<T> {

    private static final String TAG = "RxException";

    private static final String SOCKETTIMEOUTEXCEPTION = "网络连接超时，请检查您的网络状态，稍后重试";
    private static final String CONNECTEXCEPTION = "网络连接异常，请检查您的网络状态";
    private static final String UNKNOWNHOSTEXCEPTION = "网络异常，请检查您的网络状态";

    private Consumer<? super Throwable> onError;
    public RxException(Consumer<? super Throwable> onError) {
        this.onError=onError;
    }

    /**
     * Consume the given value.
     *
     * @param t the value
     * @throws Exception on error
     */
    @Override
    public void accept(T t) throws Exception {
        if (t instanceof SocketTimeoutException) {
            Log.e(TAG, "onError: SocketTimeoutException----" + SOCKETTIMEOUTEXCEPTION);
            onError.accept(new Throwable(SOCKETTIMEOUTEXCEPTION));
        } else if (t instanceof ConnectException) {
            Log.e(TAG, "onError: ConnectException-----" + CONNECTEXCEPTION);
            onError.accept(new Throwable(CONNECTEXCEPTION));
        } else if (t instanceof UnknownHostException) {
            Log.e(TAG, "onError: UnknownHostException-----" + UNKNOWNHOSTEXCEPTION);
            onError.accept(new Throwable(UNKNOWNHOSTEXCEPTION));
        } else {
            Log.e(TAG, "onError:----" + t.getMessage());
            onError.accept(t);
        }
    }
}