package activity.code.source.es.scos.es.source.code.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import activity.code.source.es.scos.R;
import activity.code.source.es.scos.es.source.code.adapter.FragmentFoodViewAdapter;
import activity.code.source.es.scos.es.source.code.model.Food;

public class FragmentFoodViewList extends Fragment {

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
    }

}
