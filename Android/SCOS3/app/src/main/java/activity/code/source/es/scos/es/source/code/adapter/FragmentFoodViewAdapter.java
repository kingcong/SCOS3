package activity.code.source.es.scos.es.source.code.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import activity.code.source.es.scos.R;
import activity.code.source.es.scos.es.source.code.model.Food;

/**
 * Created by kingcong on 2016/10/11.
 */

public class FragmentFoodViewAdapter extends BaseAdapter implements View.OnClickListener{

    private ArrayList<Food> foodList;
    private Context mContext;
    private Map<Integer,Boolean> selectdMap;
    private Adapter adapter;

    public FragmentFoodViewAdapter(Context context,ArrayList<Food> foodList) {
        this.mContext = context;
        this.foodList = foodList;
        this.selectdMap = new HashMap<Integer, Boolean>();
        for (int i = 0; i < foodList.size(); i++) {
            this.selectdMap.put(i,false);
        }
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

            view = layoutInflater.inflate(R.layout.fragment_foo_view_list_item,null);
        }
        //2.获取view上的子控件对象
        TextView item_tv_name = (TextView) view.findViewById(R.id.tv_footView_listItem_name);
        TextView item_tv_price = (TextView) view.findViewById(R.id.tv_footView_listItem_price);
        Button item_btn = (Button) view.findViewById(R.id.bt_footView_listItem_food);
        item_btn.setTag(position);
        item_btn.setOnClickListener(this);

        Boolean isSelectd = selectdMap.get(position);

        if (isSelectd.booleanValue() == true) {
            item_btn.setText("退点");
            selectdMap.put(position,true);
        } else {
            item_btn.setText("点菜");
            selectdMap.put(position,false);
        }

        //3.获取postion位置条目对应的list集合中的新闻数据，Bean对象
        Food food = foodList.get(position);
        //4.将数据设置给这些子控件做显示
        item_tv_name.setText(food.getName());
        item_tv_price.setText(food.getPrice());



        return view;
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(mContext,v.getTag().toString(),Toast.LENGTH_SHORT).show();

        int position = (int) v.getTag();

        Food food = foodList.get(position);
        Button button = (Button) v;

        Boolean isSelect = selectdMap.get(position);

        if (!isSelect) {    // 没有选中
            button.setText("退点");
            selectdMap.put(position,true);
        } else {    // 取消选中
            button.setText("点菜");
            selectdMap.put(position,false);
        }
    }
}
