package activity.code.source.es.scos.es.source.code.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import activity.code.source.es.scos.R;
import activity.code.source.es.scos.es.source.code.activity.FoodDetailed;
import activity.code.source.es.scos.es.source.code.adapter.FragmentFoodViewAdapter;
import activity.code.source.es.scos.es.source.code.model.Food;

public class FragmentFoodViewList extends Fragment implements AdapterView.OnItemClickListener{

    private List<Food> foodList;
    private ListView listView;
    private Context mContext;

     public FragmentFoodViewList(List<Food> foodList,Context context) {
         super();
         this.foodList = foodList;
         this.mContext = context;
     }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View foodView = inflater.inflate(R.layout.fragment_foo_view_list, container,false);
        listView = (ListView) foodView.findViewById(R.id.lv_frgment_foodView);

        return foodView;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        FragmentFoodViewAdapter fragmentFoodViewAdapter = new FragmentFoodViewAdapter(mContext, (ArrayList<Food>) foodList);
        listView.setAdapter(fragmentFoodViewAdapter);
        listView.setOnItemClickListener(this);

    }

    //listview的条目点击时会调用该方法 parent:代表listviw  view:点击的条目上的那个view对象   position:条目的位置  id： 条目的id
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("foodList", (Serializable) foodList);
        intent.putExtra("position",position);
        intent.putExtra("foodList", (Serializable) foodList);
//        intent.putExtras(bundle);
        intent.setClass(mContext, FoodDetailed.class);
        startActivity(intent);
    }


}
