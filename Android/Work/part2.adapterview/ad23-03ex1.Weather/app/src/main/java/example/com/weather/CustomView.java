package example.com.weather;

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
    private TextView text;

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

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public TextView getText() {
        return text;
    }

    public void setText(TextView text) {
        this.text = text;
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, 0);
        Drawable image = a.getDrawable(R.styleable.CustomView_image);
        String text = a.getString(R.styleable.CustomView_text);
        a.recycle();

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_custom, this, true);

        this.image = (ImageView) this.getChildAt(0);
        this.image.setImageDrawable(image);
        this.text = (TextView) this.getChildAt(1);
        this.text.setText(text);
    }
}

