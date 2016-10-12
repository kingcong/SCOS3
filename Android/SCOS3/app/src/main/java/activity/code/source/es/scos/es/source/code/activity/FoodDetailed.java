package activity.code.source.es.scos.es.source.code.activity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detailed);

        mPageVp = (ViewPager) findViewById(R.id.id_food_Detaildview_vp);

        init();
    }

    private void init() {
        List<Food> foodList = new ArrayList<Food>();
        for (int i = 0; i < 100; i++) {
            Food food = new Food();
            food.setName("西红柿蛋汤"+i);
            food.setPrice("20.01"+i);
            foodList.add(food);
        }

        for (int i = 0; i < 2; i++) {
            FragmentFoodDetailView foodViewList = new FragmentFoodDetailView(this);
            mFragmentList.add(foodViewList);
        }


        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(),mFragmentList);
        mPageVp.setAdapter(mFragmentAdapter);
        mPageVp.setCurrentItem(0);
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