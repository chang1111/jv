package example.com.st2personview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017-12-26.
 */

public class PersonView extends RelativeLayout {

    private ImageView imagePhoto;
    private TextView textName;
    private TextView textAge;
    private ImageView imageCheck;
    private PersonData person;

    // 인터페이스 정의
    public interface OnImageClickListener {
        void onImageClick(PersonView view, PersonData person);
    }

    // 인터페이스 선언
    OnImageClickListener imageClickListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        this.imageClickListener = listener;
    }

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

        // 디자인 xml파일 inflation 하기. xml을 자바 인스턴스로 바꾸기
        LayoutInflater.from(context).inflate(R.layout.view_person, this, true);

        // 위젯 선언
        // 위젯 찾기
        imagePhoto = findViewById(R.id.image_photo);
        textName = findViewById(R.id.text_name);
        textAge = findViewById(R.id.text_age);
        imageCheck = findViewById(R.id.image_check);

        // 커스텀뷰 디자인에서 attrs로 정의한 속성값 가져오기
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.PersonView, defStyleAttr, 0);
            String name = ta.getString(R.styleable.PersonView_my_name);
            textName.setText(name);
            int age = ta.getInt(R.styleable.PersonView_my_age, -1);
            textAge.setText(age+"");

            // app:my_photo 에서 설정한 속성 값
            Drawable photo = ta.getDrawable(R.styleable.PersonView_my_photo);
            imagePhoto.setImageDrawable(photo);

            // 재사용. 반드시 호출
            ta.recycle();

            person = new PersonData();
            person.setName(name);
            person.setAge(age);
            person.setPhoto(photo);

        }

        // 위젯에 값 설정
        imagePhoto.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageClickListener != null) {

                    // 컨테이너 위젯으로 이벤트 발생
                    // 부모로 이벤트 발생시킴
                    imageClickListener.onImageClick(PersonView.this, person);
                }
            }
        });
    }

}
