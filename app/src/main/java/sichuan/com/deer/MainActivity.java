package sichuan.com.deer;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import java.io.File;


public class MainActivity extends ActionBarActivity {


//    private ViewPager viewPager;//页卡内容
//    private ImageView imageView;// 动画图片
//    private TextView textView1,textView2,textView3;
//    private List<View> views;// Tab页面列表
//    private int offset = 0;// 动画图片偏移量
//    private int currIndex = 0;// 当前页卡编号
//    private int bmpW;// 动画图片宽度
//    private View view1,view2,view3;//各个页卡

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click();

    }

    private void click() {
        Button topBtn = (Button) this.findViewById(R.id.btn);
        final ScrollView scrollView = (ScrollView) this.findViewById(R.id.scrollView);
        topBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.scrollTo(0, 0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createSDCardDir() {
        if (Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            // 创建一个文件夹对象，赋值为外部存储器的目录
            File sdcardDir = Environment.getExternalStorageDirectory();
            // 得到一个路径，内容是sdcard的文件夹路径和名字
            String path = sdcardDir.getPath() + "/zhidu";
            File path1 = new File(path);
            if (!path1.exists()) {
                // 若不存在，创建目录，可以在应用启动的时候创建
                path1.mkdirs();
                System.out.println("paht ok,path:" + path);
            }
        } else {
            System.out.println("false");
            return;
        }

    }
}
