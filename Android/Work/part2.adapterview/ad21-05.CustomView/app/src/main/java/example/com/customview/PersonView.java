package example.com.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017-12-22.
 */

public class PersonView extends RelativeLayout {

    private ImageView photo = null;
    private TextView name = null;
    private TextView age = null;
    private ImageView check = null;
    private ImageView select = null;

    public PersonView(Context context) {
        super(context);

        init(context, null, 0);
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0);
    }

    public PersonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // RelativeLayout 관련 속성 설정

        // inflation 하기
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_person, this, true);

        name = this.findViewById(R.id.text_name);
        age = this.findViewById(R.id.text_age);
        photo = this.findViewById(R.id.image_photo);
        check = this.findViewById(R.id.image_check);
        select = this.findViewById(R.id.image_select);

        // CustomView 속성 가져오기
        if(attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.PersonView, defStyleAttr, 0);
            String name = ta.getString(R.styleable.PersonView_name);
            int age = ta.getInt(R.styleable.PersonView_age, -1);
            Drawable photo = ta.getDrawable(R.styleable.PersonView_photo);
            ta.recycle();

            // 자식에 값 설정
            this.name.setText(name);
            this.age.setText(age+"");
            this.photo.setImageDrawable(photo);

        }




    }
}
