package cc.banzhi.android.jsevent;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * 解决WebView与JavaScript混淆问题
 * Created by 邹峰立 on 2017/3/21.
 */
public class JavaScriptMixUpEvent {
    private Context context;


    public JavaScriptMixUpEvent(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void clickOnAndroid(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        // 执行相应的逻辑操作
    }

}
