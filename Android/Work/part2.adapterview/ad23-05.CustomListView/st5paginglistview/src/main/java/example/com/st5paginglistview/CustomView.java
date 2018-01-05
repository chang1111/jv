package example.com.st5paginglistview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018-01-05.
 */

public class CustomView extends LinearLayout {
    private ImageView image;
    private TextView name;
    private TextView price;
    private TextView description;


    public CustomView(Context context) {
        super(context);

        init(context, null, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet  attrs, int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, 0);
        Drawable image = a.getDrawable(R.styleable.CustomView_image);
        String name = a.getString(R.styleable.CustomView_name);
        String price = a.getString(R.styleable.CustomView_price);
        String description = a.getString(R.styleable.CustomView_description);
        a.recycle();

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_custom, this, true);

        this.image = this.findViewById(R.id.image);
        this.name = this.findViewById(R.id.name);
        this.price = this.findViewById(R.id.price);
        this.description = this.findViewById(R.id.description);

        this.image.setImageDrawable(image);
        this.name.setText(name);
        this.price.setText(price);
        this.description.setText(description);
    }
}
