package activity.code.source.es.scos.es.source.code.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import activity.code.source.es.scos.R;
import activity.code.source.es.scos.es.source.code.model.Food;

/**
 * Created by kingcong on 2016/10/12.
 */

public class FragmentFoodOrderViewAdapter extends BaseAdapter {
    private ArrayList<Food> foodList;
    private Context mContext;
    private Map<Integer,Boolean> selectdMap;
    private Adapter adapter;

    public FragmentFoodOrderViewAdapter(Context context,ArrayList<Food> foodList) {
        this.mContext = context;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        //1.复用converView优化listview,创建一个view作为getview的返回值用来显示一个条目
        if(convertView != null){
            view = convertView;
        }else {

            //通过context获取系统服务得到一个LayoutInflater，通过LayoutInflater将一个布局转换为view对象
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = layoutInflater.inflate(R.layout.food_orderview_listview_item,null);
        }
        //2.获取view上的子控件对象
        TextView item_tv_name = (TextView) view.findViewById(R.id.tv_fooOrderView_top_name);
        TextView item_tv_price = (TextView) view.findViewById(R.id.tv_fooOrderView_top_price);
        TextView item_tv_number = (TextView) view.findViewById(R.id.tv_fooOrderView_top_number);
        TextView item_tv_declare = (TextView) view.findViewById(R.id.tv_fooOrderView_top_declare);
        Button item_btn = (Button) view.findViewById(R.id.bt_foodOrderView_top_button);
        item_btn.setTag(position);
//        item_btn.setOnClickListener(this);


        //3.获取postion位置条目对应的list集合中的新闻数据，Bean对象
        Food food = foodList.get(position);
        //4.将数据设置给这些子控件做显示
        item_tv_name.setText(food.getName());
        item_tv_price.setText(food.getPrice());
        item_tv_number.setText("200");
        item_tv_declare.setText("这个很好吃");


        return view;
    }
}
