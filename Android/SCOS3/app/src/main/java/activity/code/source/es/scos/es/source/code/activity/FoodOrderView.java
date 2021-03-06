package activity.code.source.es.scos.es.source.code.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import activity.code.source.es.scos.R;
import activity.code.source.es.scos.es.source.code.adapter.FragmentAdapter;
import activity.code.source.es.scos.es.source.code.fragment.FragmentFoodOrderViewList;
import activity.code.source.es.scos.es.source.code.fragment.FragmentFoodViewList;
import activity.code.source.es.scos.es.source.code.model.Food;
import activity.code.source.es.scos.es.source.code.model.User;

public class FoodOrderView extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{

    private TextView item1,item2;
    private ViewPager mPageVp;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;

    private FragmentFoodViewList foodViewList;
    private User user;
    private int selectPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_order_view);


        getParams();
        findById();
        init();
    }

    // 接受其他控制器传入的参数
    private void getParams(){
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("loginUser");
        this.user = user;
        int selectPosition = intent.getIntExtra("selectPosition",0);
        this.selectPosition = selectPosition;
    }

    private void findById(){
        item1 = (TextView) findViewById(R.id.tv_foot_OrderView_tab_item1);
        item1.setOnClickListener(this);
        item2 = (TextView) findViewById(R.id.tv_foot_OrderView_tab_item2);
        item2.setOnClickListener(this);

        mPageVp = (ViewPager) findViewById(R.id.id_food_orderview_vp);

    }

    private void init(){

        List<Food> foodList = new ArrayList<Food>();
        for (int i = 0; i < 100; i++) {
            Food food = new Food();
            food.setName("西红柿蛋汤"+i);
            food.setPrice("20.01"+i);
            foodList.add(food);
        }

        for (int i = 0; i < 2; i++) {
            boolean isSelected = i == 0 ? false : true;
            FragmentFoodOrderViewList foodViewList = new FragmentFoodOrderViewList(foodList,this,isSelected,user);
            mFragmentList.add(foodViewList);
        }


        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(),mFragmentList);
        mPageVp.setAdapter(mFragmentAdapter);
        mPageVp.setCurrentItem(selectPosition);
        mPageVp.setOnPageChangeListener(this);

        if (selectPosition == 0) {
            item1.setTextColor(getResources().getColor(R.color.selectedItemColor));
        } else {
            item2.setTextColor(getResources().getColor(R.color.selectedItemColor));
        }
    }

    // 获取食品列表
    private List<Food> getFoodList(int i) {
        List<Food> foodList = new ArrayList<Food>();
        Food food = new Food();
        food.setName("西红柿蛋汤"+i);
        food.setPrice("20.01"+i);
        foodList.add(food);
        return foodList;
    }

    @Override
    public void onClick(View v) {
        System.out.println("调用了这个方法");
        switch (v.getId()) {
            case R.id.tv_foot_OrderView_tab_item1:
                mPageVp.setCurrentItem(0);
                break;
            case R.id.tv_foot_OrderView_tab_item2:
                mPageVp.setCurrentItem(1);
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
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void resetOtherTextView() {
        item1.setTextColor(getResources().getColor(R.color.nomalItemColor));
        item2.setTextColor(getResources().getColor(R.color.nomalItemColor));
    }

}
