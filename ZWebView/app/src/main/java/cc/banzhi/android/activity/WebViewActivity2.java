package cc.banzhi.android.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cc.banzhi.android.jsevent.JavaScriptMixUpEvent;
import cc.banzhi.android.utils.ClickUtil;
import cc.banzhi.android.webviewlib.ZWebView;
import cc.banzhi.android.webviewlib.ZWebviewListener;

/**
 * WebView加载网页
 * Created by 邹峰立 on 2017/3/9 0009.
 */
public class WebViewActivity2 extends AppCompatActivity implements View.OnClickListener {
    // appToken用户登录令牌
    private final static String app_token = "asdfargerasgethegasadw";

    private RelativeLayout topLayout;
    private TextView titleTv;
    private ProgressBar hProgressBar;
    private ZWebView webView;

    private String weburl;
    private boolean isTel = false;// 是否需要拨号

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview2);

        initView();

        // 获取上一个页面传递过来的网址
        weburl = getIntent().getStringExtra("weburl");
        // 是否需要拨号
        isTel = getIntent().getBooleanExtra("isTel", false);
        // 重构
        refactorUrlLoad(weburl);
    }

    // 初始化控件
    @SuppressLint("AddJavascriptInterface")
    private void initView() {
        topLayout = findViewById(R.id.layout_top);
        ImageView backImg = findViewById(R.id.img_back);
        if (backImg != null) {
            backImg.setOnClickListener(this);
        }
        titleTv = findViewById(R.id.tv_title);
        hProgressBar = findViewById(R.id.hprogressBar);

        webView = findViewById(R.id.webview);
        // 解决WebView与JavaScript混淆问题
        webView.addJavascriptInterface(new JavaScriptMixUpEvent(this), "jsObj");
        webView.setOnZWebviewListener(new ZWebviewListener() {

            @Override
            public void onReceivedError(WebView view) {
                hProgressBar.setVisibility(View.GONE);
                topLayout.setVisibility(View.VISIBLE);
//                // 当网页加载出错时，加载本地错误文件
//                webView.loadUrl("file:///android_asset/error.html");
            }

            @Override
            public boolean shouldOverrideUrlLoad(String url) {
                // 返回false，意味着请求过程中，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
                // 返回true，说明你自己想根据url，做新的跳转，比如在判断url符合条件的情况下，我想让webView加载http://sina.com/
                // 加载Url，使网页在WebView中打开
                if (!TextUtils.isEmpty(url)) {
                    if ("http://domain/quit.html".equals(url)) {
                        // 如果是退出html页面关闭当前WebView页
                        finish();
                    } else if ("file:///android_asset/login.html".equals(url)) {
                        // 如果是本地登录html页面跳转到原声页面
                        Intent intent_login = new Intent(WebViewActivity2.this, LoginActivity.class);
                        startActivity(intent_login);
                    } else {
                        // 重构加载url
                        refactorUrlLoad(url);
                    }
                }
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
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

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // newProgress 1-100
                if (newProgress >= 100) {
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

            @Override
            public void onReceivedTitle(View view, String title) {
                titleTv.setText(title);
            }
        });
    }

    // 返回键监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                // 判断WebView是否能够返回，能-返回
                webView.canGoBack();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // 点击事件监听
    @Override
    public void onClick(View v) {
        if (ClickUtil.isFastClick()) return;
        if (v.getId() == R.id.img_back) {// 返回
            finish();
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
