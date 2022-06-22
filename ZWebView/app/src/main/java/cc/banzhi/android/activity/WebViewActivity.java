package cc.banzhi.android.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cc.banzhi.android.jsevent.JavaScriptMixUpEvent;
import cc.banzhi.android.utils.ClickUtil;

/**
 * WebView加载网页
 * Created by 邹峰立 on 2017/3/9 0009.
 */
public class WebViewActivity extends AppCompatActivity implements View.OnClickListener {
    // appToken用户登录令牌
    private final static String app_token = "asdfargerasgethegasadw";

    private RelativeLayout topLayout;
    private TextView titleTv;
    private ProgressBar hProgressBar;
    private WebView webView;

    private String weburl;
    private boolean isTel = false;// 是否需要拨号

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        initView();

        // 获取上一个页面传递过来的网址
        weburl = getIntent().getStringExtra("weburl");
        // 是否需要拨号
        isTel = getIntent().getBooleanExtra("isTel", false);
        // 重构
        refactorUrlLoad(weburl);
    }

    // 初始化控件
    private void initView() {
        // 初始化控件
        topLayout = (RelativeLayout) findViewById(R.id.layout_top);
        ImageView backImg = (ImageView) findViewById(R.id.img_back);
        if (backImg != null)
            backImg.setOnClickListener(this);
        titleTv = (TextView) findViewById(R.id.tv_title);
        hProgressBar = (ProgressBar) findViewById(R.id.hprogressBar);
        webView = (WebView) findViewById(R.id.webview);
        // 设置WebView属性
        initWebView();
    }

    // 初始化WebView
    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void initWebView() {
        // 使页面获取焦点，防止点击无响应
        webView.requestFocus();

        // WebView默认是通过浏览器打开url，使用url在WebView中打开
        webView.setWebViewClient(new WebViewClient() {
            // 旧版本
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // 返回false，意味着请求过程中，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
                // 返回true，说明你自己想根据url，做新的跳转，比如在判断url符合条件的情况下，我想让webView加载http://sina.com/
                // 加载Url，使网页在WebView中打开
                if (!TextUtils.isEmpty(url)) {
                    if ("http://domain/quit.html".equals(url)) {
                        // 如果是退出html页面关闭当前WebView页
                        finish();
                    } else if ("file:///android_asset/login.html".equals(url)) {
                        // 如果是本地登录html页面跳转到原声页面
                        Intent intent_login = new Intent(WebViewActivity.this, LoginActivity.class);
                        startActivity(intent_login);
                    } else {
                        // 重构加载url
                        refactorUrlLoad(url);
                    }
                }
                return true;
            }

            // 新版本
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                // 返回false，意味着请求过程中，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
//                // 返回true，说明你自己想根据url，做新的跳转，比如在判断url符合条件的情况下，我想让webView加载http://baidu.com/
//                // 加载Url，使网页在WebView中打开
//                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP) {
//                    webView.loadUrl(request.getUrl().toString());
//                }
//                return true;
//            }

            // WebViewClient帮助WebView去处理页面控制和请求通知
            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }

            // 错误代码处理，一般是加载本地Html页面，或者使用TextView显示错误
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                hProgressBar.setVisibility(View.GONE);
                topLayout.setVisibility(View.VISIBLE);
                // 当网页加载出错时，加载本地错误文件
//                webView.loadUrl("file:///android_asset/error.html");
            }

            // 页面开始加载
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            // 页面加载结束
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // 编写javaScript方法-执行修改样式
                String javascript = "javascript:function hide() {" +
                        "document.getElementById('hideElem').style.display='none';" +
                        "}";
                // 网页添加方法
                view.loadUrl(javascript);
                // 执行方法
                view.loadUrl("javascript:hide();");


                if (isTel) {
                    // 编写javaScript方法-执行网页js
                    String script = "javascript:function addMethod() {" +
                            "document.getElementById('telElem').setAttribute('href','javascript:;');" +
                         // "document.getElementById('customerTel').href='javascript:;';" +
                            "document.getElementById('telElem').onclick = function() {alert(getTel());}" +
                            "}";
                    view.loadUrl(script);
                    view.loadUrl("javascript:addMethod();");
                }


                // 支持4.4以上的版本
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                    view.evaluateJavascript("javascript:getTel()", new ValueCallback<String>() {
//                        @Override
//                        public void onReceiveValue(String value) {
//                            Log.d("JsonResult", value);
//                        }
//                    });
//                }
            }
        });

        // 监听网页加载进度
        webView.setWebChromeClient(new WebChromeClient() {

            // 网页Title信息
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                titleTv.setText(title);
            }

            // 监听网页alert方法
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                result.confirm();
                if (isTel) {// 执行拨号
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + message));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                return true;
            }

            // 显示网页加载进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // newProgress 1-100
                if (newProgress == 100) {
                    // 记载完毕
                    hProgressBar.setVisibility(View.GONE);
                    topLayout.setVisibility(View.VISIBLE);
                } else {
                    // 正在加载
                    hProgressBar.setProgress(newProgress);
                    hProgressBar.setVisibility(View.VISIBLE);
                    topLayout.setVisibility(View.GONE);
                }
            }
        });

        // 下载文件
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                // url下载文件地址
                // 处理下载文件逻辑
            }
        });

        // 设置WebView相关属性
        WebSettings webSettings = webView.getSettings();
        // 是否缓存表单数据
        webSettings.setSaveFormData(false);
        // 设置WebView 可以加载更多格式页面
        webSettings.setLoadWithOverviewMode(true);
        // 设置WebView使用广泛的视窗
        webSettings.setUseWideViewPort(true);
        // 支持2.2以上所有版本
        webSettings.setPluginState(WebSettings.PluginState.ON);
        // 允许加载Assets和resources文件
        webSettings.setAllowFileAccess(true);
        // 告诉webview启用应用程序缓存api
        webSettings.setAppCacheEnabled(true);
        // 排版适应屏幕
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        // 支持插件
        webSettings.setPluginState(WebSettings.PluginState.ON);
        // 设置是否启用了DOM storage AP搜索I
        webSettings.setDomStorageEnabled(true);
        // 设置缓存，默认不使用缓存
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);// 有缓存，使用缓存
        // 是否允许缩放
        webSettings.setSupportZoom(false);
        // 是否支持通过js打开新的窗口
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 允许加载JS
        webSettings.setJavaScriptEnabled(true);

        // 解决WebView与JavaScript混淆问题
//        webView.addJavascriptInterface(new Object() {
//
//            @JavascriptInterface
//            public void clickOnAndroid(String result) {
//                Toast.makeText(WebViewActivity.this, result, Toast.LENGTH_LONG).show();
//                // 执行相应的逻辑操作
//            }
//        }, "jsObj");
        webView.addJavascriptInterface(new JavaScriptMixUpEvent(this), "jsObj");
        // 隐藏滚动条
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
    }

    // 返回键监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack())
                // 判断WebView是否能够返回，能-返回
                webView.canGoBack();
            else
                finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // 点击事件监听
    @Override
    public void onClick(View v) {
        // 防止连续点击
        if (ClickUtil.isFastClick())
            return;
        switch (v.getId()) {
            case R.id.img_back:// 返回
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.destroy();
    }

    /**
     * 重构Url
     */
    private void refactorUrlLoad(String url) {
        webView.loadUrl(weburl);

//        // 将跳转url添加app_token-URL重构
//        if (!url.contains("app_token=")) {
//            if (url.contains("?") && url.contains("=")) {
//                weburl = url + "&app_token=" + app_token;
//                webView.loadUrl(weburl);
//            } else {
//                weburl = url + "?app_token=" + app_token;
//                webView.loadUrl(weburl);
//            }
//        } else {
//            // 跳转登录
//            Intent intent_login = new Intent(this, LoginActivity.class);
//            startActivity(intent_login);
//            finish();
//        }
    }

}
