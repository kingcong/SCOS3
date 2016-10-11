package activity.code.source.es.scos.es.source.code.activity;

import android.content.DialogInterface;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import activity.code.source.es.scos.R;

public class FoodView extends FragmentActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{

    private TextView item1,item2,item3,item4;
    private ViewPager mPageVp;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;

    private FragmentFoodViewList foodViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_view);

        findById();
        init();
    }

    private void findById(){
        item1 = (TextView) findViewById(R.id.tv_footView_tab_item1);
        item1.setOnClickListener(this);
        item2 = (TextView) findViewById(R.id.tv_footView_tab_item2);
        item2.setOnClickListener(this);
        item3 = (TextView) findViewById(R.id.tv_footView_tab_item3);
        item3.setOnClickListener(this);
        item4 = (TextView) findViewById(R.id.tv_footView_tab_item4);
        item4.setOnClickListener(this);

        mPageVp = (ViewPager) findViewById(R.id.id_foodview_vp);
    }

    private void init(){
        foodViewList = new FragmentFoodViewList();
        for (int i = 0; i < 4; i++) {
            FragmentFoodViewList foodViewList1 = new FragmentFoodViewList();
            mFragmentList.add(foodViewList1);
        }

        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(),mFragmentList);
        mPageVp.setAdapter(mFragmentAdapter);
        mPageVp.setCurrentItem(0);
        mPageVp.setOnPageChangeListener(this);

        item1.setTextColor(getResources().getColor(R.color.selectedItemColor));
    }

    @Override
    public void onClick(View v) {
        System.out.println("调用了这个方法");
        switch (v.getId()) {
            case R.id.tv_footView_tab_item1:
                mPageVp.setCurrentItem(0);
                break;
            case R.id.tv_footView_tab_item2:
                mPageVp.setCurrentItem(1);
                break;
            case R.id.tv_footView_tab_item3:
                mPageVp.setCurrentItem(2);
                break;
            case R.id.tv_footView_tab_item4:
                mPageVp.setCurrentItem(3);
                break;
        }
    }


    // 监听ViewPager的滑动
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        resetOtherTextView();
        switch (position) {
            case 0:
                item1.setTextColor(getResources().getColor(R.color.selectedItemColor));
                break;
            case 1:
                item2.setTextColor(getResources().getColor(R.color.selectedItemColor));
                break;
            case 2:
                item3.setTextColor(getResources().getColor(R.color.selectedItemColor));
                break;
            case 3:
                item4.setTextColor(getResources().getColor(R.color.selectedItemColor));
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void resetOtherTextView() {
        item1.setTextColor(getResources().getColor(R.color.nomalItemColor));
        item2.setTextColor(getResources().getColor(R.color.nomalItemColor));
        item3.setTextColor(getResources().getColor(R.color.nomalItemColor));
        item4.setTextColor(getResources().getColor(R.color.nomalItemColor));
    }
}
