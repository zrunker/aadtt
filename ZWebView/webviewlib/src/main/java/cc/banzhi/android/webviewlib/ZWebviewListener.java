package cc.banzhi.android.webviewlib;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/**
 * @program: ZWebView
 * @description:
 * @author: zoufengli01
 * @create: 2022/6/22 16:37
 **/
public class ZWebviewListener implements ZWebView.OnZWebviewListener {
    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {

    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {

    }

    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {

    }

    @Override
    public void onReceivedError(WebView view) {

    }

    @Override
    public boolean shouldOverrideUrlLoad(String url) {
        return false;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {

    }

    @Override
    public void onPageFinished(WebView view, String url) {

    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        return false;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {

    }

    @Override
    public void onReceivedTitle(View view, String title) {

    }

    @Override
    public void onLoadResource(WebView view, String url) {

    }

    @Override
    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {

    }
}
