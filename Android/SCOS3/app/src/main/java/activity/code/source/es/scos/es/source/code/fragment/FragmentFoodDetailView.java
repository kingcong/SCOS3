package activity.code.source.es.scos.es.source.code.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import activity.code.source.es.scos.R;
import activity.code.source.es.scos.es.source.code.model.Food;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class FragmentFoodDetailView extends Fragment {


    private Context mContext;
    private Food food;

    private ImageView iconImageView;
    private TextView nameTextView;
    private TextView priceTextView;
    private EditText editText;
    private Button exitSelectedButton;


    public FragmentFoodDetailView(Context context,Food food) {
//        super();
        this.mContext = context;
        this.food = food;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View foodDetailView = inflater.inflate(R.layout.fragment_food_detail_view, container, false);
        iconImageView = (ImageView) foodDetailView.findViewById(R.id.ig_fooddetail_icon);
        nameTextView = (TextView) foodDetailView.findViewById(R.id.tv_food_detailview_foodname);
        priceTextView = (TextView) foodDetailView.findViewById(R.id.tv_food_detailview_foodprice);
        editText = (EditText) foodDetailView.findViewById(R.id.et_food_detailview_fooddeclare);
        exitSelectedButton = (Button) foodDetailView.findViewById(R.id.bt_food_detailview_foodbtn);

        return foodDetailView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
    }

    private void initData(){
        nameTextView.setText(this.food.getName());
        priceTextView.setText(this.food.getPrice());

        if (food.isSelected()) {    // 已经点菜
            exitSelectedButton.setText("退点");
        } else {    // 没有点菜
            exitSelectedButton.setText("点菜");
        }
    }
}
