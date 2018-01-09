package example.com.st3checkablelistview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018-01-09.
 */

public class ViewPerson extends RelativeLayout {

    private ImageView image;
    private TextView textName;
    private TextView textAge;
    private ImageView checkBox;

    public ViewPerson(Context context) {
        super(context);

        init(context, null, 0);
    }

    public ViewPerson(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0);
    }

    public ViewPerson(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        // 1. Layout 관련 필수 설정
        // LinearLayout인 경우는 orientation을 반드시 설정

        // 2. inflation
        View rowView = LayoutInflater.from(context).inflate(R.layout.view_person, this, true);

        image = rowView.findViewById(R.id.image);
        textName = rowView.findViewById(R.id.textName);
        textAge = rowView.findViewById(R.id.textAge);
        checkBox = rowView.findViewById(R.id.checkBox);


        // inflation

        // attrs 관련 설정. attrs로 정의한 속성값 가져와서 찾은 위젯에 값으로 설정.

        // 리스너 설정
        checkBox.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                // 현재 에서 checkbox를 클릭했을 때
                // 클릭된 row 화면의 새로고침
                redrawRowView();
            }
        });
    }

    private void redrawRowView() {
        if (person.isChecked()) {
            this.setBackgroundColor(Color.TRANSPARENT);
            this.checkBox.setImageResource(android.R.drawable.checkbox_off_background);
            person.setChecked(false);
        }
        else {
            this.setBackgroundColor(Color.MAGENTA);
            this.checkBox.setImageResource(android.R.drawable.checkbox_on_background);
            person.setChecked(true);
        }

    }

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;

        //위젯 설정
        image.setImageDrawable(person.getImage());
        textName.setText(person.getName());
        textAge.setText(person.getAge()+"");
    }

}
