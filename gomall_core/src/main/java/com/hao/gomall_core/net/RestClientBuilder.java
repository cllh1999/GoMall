package com.hao.gomall_core.net;

import android.content.Context;

import com.hao.gomall_core.net.callback.IError;
import com.hao.gomall_core.net.callback.IFailure;
import com.hao.gomall_core.net.callback.IRequest;
import com.hao.gomall_core.net.callback.ISuccess;
import com.hao.gomall_core.ui.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RestClientBuilder {
    
    private String mUrl;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mRequest;
    private ISuccess mSuccess;
    private IFailure mFailure;
    private IError mError;
    private RequestBody mBody;
    private Context mContext;
    private LoaderStyle mLoaderStyle;
    private File mFlie;
    private String mDownloadDir;
    private String mExtension;
    private String mName;

    RestClientBuilder(){

    }

    public final RestClientBuilder url(String url){
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params){
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value){
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw){
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest){
        this.mRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess){
        this.mSuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure){
        this.mFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError){
        this.mError = iError;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle style){
        this.mContext = context;
        this.mLoaderStyle = style;
        return this;
    }

    public final RestClientBuilder loader(Context context){
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }

    public final RestClientBuilder file(File file){
        this.mFlie = file;
        return this;
    }

    public final RestClientBuilder file(String filePath){
        this.mFlie = new File(filePath);
        return this;
    }

    public final RestClientBuilder file(String key, Object value){
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder name(String name) {
        this.mName = name;
        return this;
    }

    public final RestClientBuilder dir(String dir) {
        this.mDownloadDir = dir;
        return this;
    }

    public final RestClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }

    public final RestClient build(){
        return new RestClient(mUrl, PARAMS, mRequest, mSuccess, mFailure, mError, mBody, mLoaderStyle, mFlie, mDownloadDir, mExtension, mName, mContext);
    }
}
