package activity.code.source.es.scos.es.source.code.activity;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import activity.code.source.es.scos.R;
import activity.code.source.es.scos.es.source.code.adapter.FragmentFoodOrderViewAdapter;
import activity.code.source.es.scos.es.source.code.adapter.FragmentFoodViewAdapter;
import activity.code.source.es.scos.es.source.code.model.Food;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFoodOrderViewList extends Fragment implements AdapterView.OnItemClickListener{


    private List<Food> foodList;
    private ListView listView;

    private Context mContext;
    private boolean isSelectedFood;

    // 底部控件
    private TextView bottomNameTextView;
    private TextView bottomPriceTextView;
    private TextView bottomNumberTextView;
    private TextView bottomDeclareTextView;
    private Button bottomButton;

    public FragmentFoodOrderViewList(List<Food> foodList,Context context,boolean isSelectedFood) {
        // Required empty public constructor
        super();
        this.foodList = foodList;
        this.mContext = context;
        this.isSelectedFood = isSelectedFood;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View foodView = inflater.inflate(R.layout.fragment_food_order_view_list, container,false);
        listView = (ListView) foodView.findViewById(R.id.lvfood_order_view_list);

        bottomNameTextView = (TextView) foodView.findViewById(R.id.tv_fooOrderView_bootom_name);
        bottomPriceTextView = (TextView) foodView.findViewById(R.id.tv_fooOrderView_bootom_price);
        bottomNumberTextView = (TextView) foodView.findViewById(R.id.tv_fooOrderView_bootom_number);
        bottomDeclareTextView = (TextView) foodView.findViewById(R.id.tv_fooOrderView_bootom_declare);
        bottomButton = (Button) foodView.findViewById(R.id.bt_foodOrderView_bottom_button);

        return foodView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        FragmentFoodOrderViewAdapter fragmentFoodViewAdapter = new FragmentFoodOrderViewAdapter(mContext, (ArrayList<Food>) foodList);
        listView.setAdapter(fragmentFoodViewAdapter);
        listView.setOnItemClickListener(this);

        if (this.isSelectedFood){   // 已经选菜
             bottomButton.setText("结账");
        } else {    // 没有选菜
            bottomButton.setText("提交订单");
        }
    }

    //listview的条目点击时会调用该方法 parent:代表listviw  view:点击的条目上的那个view对象   position:条目的位置  id： 条目的id
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

}
