package activity.code.source.es.scos.es.source.code.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by kingcong on 2016/10/11.
 */

public class Food implements Serializable{

    private int icon;    // 菜的图片
    private String name;    // 菜名
    private String price;   // 菜的价格
    private boolean isSelected; // 是否点菜


    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}
