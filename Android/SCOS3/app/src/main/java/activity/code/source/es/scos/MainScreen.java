package activity.code.source.es.scos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import activity.code.source.es.scos.es.source.code.model.User;

public class MainScreen extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        initListview();
    }

    private void initListview() {

        Intent intent = getIntent();
        String fromEntry = intent.getStringExtra("activity.code.source.es.scos.MainScreen");

        User loginUser = (User)intent.getSerializableExtra("user");

        String[] titles;
        int[] imags;


        if (!"FromEntry".equals(fromEntry)) {    // 判断是否相等
            titles = new String[] {"登录",
                    "注册","系统帮助"};
            imags = new int[] {R.drawable.paybank,R.drawable.paymentrecord,R.drawable.setting};
        } else {
            titles = new String[] {"点菜","查看订单","登录",
                    "注册","系统帮助"};
            imags = new int[] {R.drawable.aboutus,R.drawable.comquestion,R.drawable.paybank,R.drawable.paymentrecord,R.drawable.setting};
        }

        //
        if ("LoginSuccess".equals(fromEntry)) { // 登录成功
            titles = new String[] {"点菜","查看订单","登录",
                    "注册","系统帮助"};
            imags = new int[] {R.drawable.aboutus,R.drawable.comquestion,R.drawable.paybank,R.drawable.paymentrecord,R.drawable.setting};

            user = loginUser;
        } else if ("RegisterSuccess".equals(fromEntry)) {   // 注册成功
            Toast.makeText(this,"欢迎您成为 SCOS 新用户",Toast.LENGTH_SHORT).show();
            titles = new String[] {"点菜","查看订单","登录",
                    "注册","系统帮助"};
            imags = new int[] {R.drawable.aboutus,R.drawable.comquestion,R.drawable.paybank,R.drawable.paymentrecord,R.drawable.setting};

            user = loginUser;
        } else {
            user = null;
        }

        GridView gridView = (GridView) findViewById(R.id.gv_maingridview);

        List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < imags.length; i++) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("image",imags[i]);
            map.put("title",titles[i]);
            listItems.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,listItems,R.layout.main_items,new String[]{"title","image"},new int[]{R.id.tv_itemstextview,R.id.iv_itemsicon});
        gridView.setAdapter(adapter);
    }
}
