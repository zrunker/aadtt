package cc.banzhi.android.webviewlib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * 自定义WebView
 *
 * @author 邹峰立
 */
public abstract class ZWebView extends WebView {
    private boolean isPageFinished = false;
    private boolean isLoading = false;
    private final boolean isProhibitLongClickEvent;// 是否允许长按事件
    private WebSettings webSettings;
    private OnScrollChangedCallback mOnScrollChangedCallback;
//    private JsEvent jsEvent;

    public boolean isPageFinished() {
        return isPageFinished;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public ZWebView(Context context) {
        this(context, null);
    }

    public ZWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // 获取自定义属性，并设置
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.ZWebView);
        isProhibitLongClickEvent = ta.getBoolean(R.styleable.ZWebView_isProhibitLongClickEvent, false);
        ta.recycle();

        init();
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void init() {
        clearHistory();
        clearCache(true);
        clearAnimation();
        clearFormData();
        // 隐藏滚动条
        setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        // 设置WebView相关属性
        webSettings = getSettings();
        // 是否缓存表单数据
        webSettings.setSaveFormData(false);
        // 设置WebView 可以加载更多格式页面
        webSettings.setLoadWithOverviewMode(true);
        // 设置WebView使用广泛的视窗
        webSettings.setUseWideViewPort(true);
        // 允许加载Assets和resources文件
        webSettings.setAllowFileAccess(true);
        // 告诉webview启用应用程序缓存api
        webSettings.setAppCacheEnabled(true);
        // 排版适应屏幕
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        // 支持插件
        webSettings.setPluginState(WebSettings.PluginState.ON);
        // 设置是否启用了DOM storage AP搜索I
        webSettings.setDomStorageEnabled(true);
//        // 设置缓存，默认不使用缓存
//        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        // 有缓存，使用缓存
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        // 是否允许缩放
        webSettings.setSupportZoom(false);
        // 是否支持通过js打开新的窗口
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 允许加载JS
        webSettings.setJavaScriptEnabled(true);
        // 提高渲染优先级
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        // 设置编码格式
        webSettings.setDefaultTextEncodingName("utf-8");
        // 支持自动加载图片
        webSettings.setLoadsImagesAutomatically(true);
        // 设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setBuiltInZoomControls(true);
        // 隐藏原生的缩放控件
        webSettings.setDisplayZoomControls(false);
//        // 添加js
//        jsEvent = new JsEvent(getContext());
//        addJavascriptInterface(jsEvent, "jsEvent");
        // 开启数据库
        webSettings.setDatabaseEnabled(true);

        // 取消长按事件
        setOnLongClickListener(new OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                return isProhibitLongClickEvent || onZWebviewListener != null && onZWebviewListener.onLongClick(v);
            }
        });

        setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                boolean bool = shouldOverrideUrlLoad(url);
                if (!bool)
                    bool = super.shouldOverrideUrlLoading(view, url);
                return bool;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                boolean bool = false;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    String url = request.getUrl().toString();
                    bool = shouldOverrideUrlLoad(url);
                }
                if (!bool)
                    bool = super.shouldOverrideUrlLoading(view, request);
                return bool;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                onUrlReceived();
                isPageFinished = true;
                isLoading = false;
                if (onZWebviewListener != null)
                    onZWebviewListener.onReceivedError(view, request, error);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                // 兼容https
                if (error.getPrimaryError() == SslError.SSL_DATE_INVALID
                        || error.getPrimaryError() == SslError.SSL_EXPIRED
                        || error.getPrimaryError() == SslError.SSL_INVALID
                        || error.getPrimaryError() == SslError.SSL_UNTRUSTED) {
                    handler.proceed();
                } else {
                    handler.cancel();
                }
                super.onReceivedSslError(view, handler, error);
                onUrlReceived();
                isPageFinished = true;
                isLoading = false;
                if (onZWebviewListener != null)
                    onZWebviewListener.onReceivedSslError(view, handler, error);
            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                onUrlReceived();
                isPageFinished = true;
                isLoading = false;
                if (onZWebviewListener != null)
                    onZWebviewListener.onReceivedHttpError(view, request, errorResponse);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                isLoading = true;
                if (onZWebviewListener != null)
                    onZWebviewListener.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                onUrlReceived();
                isPageFinished = true;
                isLoading = false;
                if (onZWebviewListener != null)
                    onZWebviewListener.onPageFinished(view, url);
            }
        });

        setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                if (onZWebviewListener != null)
                    return onZWebviewListener.onJsAlert(view, url, message, result);
                else {
                    Toast.makeText(ZWebView.this.getContext(), message, Toast.LENGTH_SHORT).show();
                    result.confirm();
                    return true;
                }
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress < 100)
                    isLoading = true;
                else {
                    isPageFinished = true;
                    isLoading = false;
                }
                if (onZWebviewListener != null)
                    onZWebviewListener.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (onZWebviewListener != null)
                    onZWebviewListener.onReceivedTitle(view, title);
            }
        });

        // 使页面获取焦点，防止点击无响应
        requestFocus();
    }

    @Override
    public void destroy() {
        clearHistory();
        clearCache(true);
        clearAnimation();
        clearFormData();
        super.destroy();
    }

    @Override
    public WebSettings getSettings() {
        if (webSettings == null)
            webSettings = super.getSettings();
        return webSettings;
    }

    // Url加载完成（正确/错误）调用，空方法由开发者自行实现
    private void onUrlReceived() {
    }

    // 网页内url跳转监听，空方法由开发者自行实现
    private boolean shouldOverrideUrlLoad(String url) {
        return false;
    }

    public interface OnZWebviewListener {
        boolean onLongClick(View v);

        void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error);

        void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error);

        void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse);

        void onPageStarted(WebView view, String url, Bitmap favicon);

        void onPageFinished(WebView view, String url);

        boolean onJsAlert(WebView view, String url, String message, JsResult result);

        void onProgressChanged(WebView view, int newProgress);

        void onReceivedTitle(View view, String title);
    }

    private OnZWebviewListener onZWebviewListener;

    public void setOnZWebviewListener(OnZWebviewListener onZWebviewListener) {
        this.onZWebviewListener = onZWebviewListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollChangedCallback != null) {
            mOnScrollChangedCallback.onScroll(l - oldl, t - oldt);
        }
    }

    public void setOnScrollChangedCallback(OnScrollChangedCallback onScrollChangedCallback) {
        mOnScrollChangedCallback = onScrollChangedCallback;
    }

    public interface OnScrollChangedCallback {
        void onScroll(int dx, int dy);
    }
}
