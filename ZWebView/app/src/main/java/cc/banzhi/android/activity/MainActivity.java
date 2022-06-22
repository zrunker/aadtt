package cc.banzhi.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * WebView实例：
 * 规则1：访问百度页面，要把登录令牌app_token加上
 * 规则2：访问拨号页面，能够实现拨号，同时隐藏页面需要隐藏的内容
 * create by 邹峰立
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView baiduTv = (TextView) findViewById(R.id.tv_baidu);
        baiduTv.setOnClickListener(this);
        TextView telTv = (TextView) findViewById(R.id.tv_tel);
        telTv.setOnClickListener(this);
    }

    // 点击事件监听
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_baidu:
                // 访问百度
                Intent intent_baidu = new Intent(this, WebViewActivity.class);
                intent_baidu.putExtra("weburl", "http://www.baidu.com");
                intent_baidu.putExtra("isTel", false);
                startActivity(intent_baidu);
                break;
            case R.id.tv_tel:
                // 访问本地文件
                Intent intent_tel = new Intent(this, WebViewActivity.class);
                intent_tel.putExtra("weburl", "file:///android_asset/tel.html");
                intent_tel.putExtra("isTel", true);
                startActivity(intent_tel);
                break;
        }
    }
}
