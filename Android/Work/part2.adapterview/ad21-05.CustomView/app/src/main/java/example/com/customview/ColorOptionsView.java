package example.com.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017-12-22.
 */

public class ColorOptionsView extends LinearLayout {

    private TextView title = null;
    private View value = null;
    private ImageView image = null;

    public ColorOptionsView(Context context) {
        super(context);

        init(context, null, 0);
    }

    public ColorOptionsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0);
    }

    public ColorOptionsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        // CustomView 속성 가져오기
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ColorOptionsView, defStyleAttr, 0);
        String titleText = a.getString(R.styleable.ColorOptionsView_titleText);
        @SuppressLint("ResourceAsColor")
        int valueColor = a.getColor(R.styleable.ColorOptionsView_valueColor, android.R.color.holo_blue_light);
        a.recycle(); // 재사용

        // LinearLayout 관련 속성 설정
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);

        // inflation 하기
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_color_options, this, true);

        // 첫번째 자식에 값 설정
        title = (TextView) this.getChildAt(0);
        title.setText(titleText);

        // 두번째 자식에 값 설정
        value = this.getChildAt(1);
        value.setBackgroundColor(valueColor);

        // 세번째 자식에 값 설정
        image = (ImageView) this.getChildAt(2);
    }

    public void setValueColor(int color) {
        value.setBackgroundColor(color);
    }

    public void setImage(int resourceID) {
        image.setImageResource(resourceID);
//        image.setImageDrawable(resourceID);
    }

    public void setImageVisible(boolean visible) {
        value.setVisibility(visible?VISIBLE:GONE);
    }

    public String getText() {
        return title.getText().toString();
    }
}
