package activity.code.source.es.scos.es.source.code.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import activity.code.source.es.scos.R;
import activity.code.source.es.scos.es.source.code.adapter.FragmentAdapter;
import activity.code.source.es.scos.es.source.code.fragment.FragmentFoodDetailView;
import activity.code.source.es.scos.es.source.code.fragment.FragmentFoodOrderViewList;
import activity.code.source.es.scos.es.source.code.model.Food;

public class FoodDetailed extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager mPageVp;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;

    private int currentPosition;    // 当前选中位置
    private List<Food> foodList;    // 所以食物列表

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detailed);

        Intent intent = getIntent();
        List<Food> foodList = (List<Food>) intent.getSerializableExtra("foodList");
        int position = intent.getIntExtra("position",0);
        this.currentPosition = position;
        this.foodList = foodList;
        System.out.println("foodlist:"+foodList+"position="+position);

        mPageVp = (ViewPager) findViewById(R.id.id_food_Detaildview_vp);

        init();
    }

    private void init() {
//        List<Food> foodList = new ArrayList<Food>();
//        for (int i = 0; i < 100; i++) {
//            Food food = new Food();
//            food.setName("西红柿蛋汤"+i);
//            food.setPrice("20.01"+i);
//            foodList.add(food);
//        }

        for (int i = 0; i < foodList.size(); i++) {
            Food food = foodList.get(i);
            FragmentFoodDetailView foodViewList = new FragmentFoodDetailView(this,food);
            mFragmentList.add(foodViewList);
        }


        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(),mFragmentList);
        mPageVp.setAdapter(mFragmentAdapter);
        mPageVp.setCurrentItem(this.currentPosition);
        mPageVp.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
