package activity.code.source.es.scos.es.source.code.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import activity.code.source.es.scos.R;
import activity.code.source.es.scos.es.source.code.model.Food;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFoodDetailView extends Fragment {


    private Context mContext;
    private Food food;

    public FragmentFoodDetailView(Context context,Food food) {
        super();
        this.mContext = context;
        this.food = food;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_detail_view, container, false);
    }

}
