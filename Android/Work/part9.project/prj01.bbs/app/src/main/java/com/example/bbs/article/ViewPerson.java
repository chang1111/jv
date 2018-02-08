package com.example.bbs.article;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bbs.R;
import com.example.bbs.model.ModelPerson;

public class ViewPerson extends RelativeLayout {

    private ImageView imagePhoto = null;
    private TextView  textName   = null;
    private TextView  textAge    = null;
    private CheckBox  imageCheck = null;

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

        // 1. Layout 관련 필수 설정.
        //    LinearLayout 인경우는 orientation을 반드시 설정한다.

        // 2. inflation

        View rowView = LayoutInflater.from( context)
                .inflate( R.layout.listview_customview_person, this, true );


        imagePhoto = rowView.findViewById(R.id.image_photo );  //
        textName   = rowView.findViewById(R.id.text_name   );  //
        textAge    = rowView.findViewById(R.id.text_age    );  //
        imageCheck = rowView.findViewById(R.id.image_check );  //

        // 3. attrs 관련 설정.
        //    attrs로 정의한 속성값 가져와서 찾은 위젯에 값으로 설정.

        // 4. 리스너 설정.
        imageCheck.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                // chechk 상태를 반전하여 lists 에 저장.
                // p.getImageCheck()   -->  ! p.getImageCheck()
                //   false             -->     true
                //   true              -->     false
                person.setImageCheck( ! person.getImageCheck()  );

                // 현재 row에서 checkbox를 클릭 했을 때
                // 클릭된 row 화면의 새로고침..
                redrawRowView();
            }
        });
    }

    private void redrawRowView() {
        if( person.getImageCheck() ) {
            this.setBackgroundColor(Color.MAGENTA);
        }
        else {
            this.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private ModelPerson person;

    public ModelPerson getPerson() {
        return person;
    }

    public void setPerson(ModelPerson person) {
        this.person = person;

        // 위젯 설정.
        imagePhoto.setImageDrawable( person.getImagePhoto() );
        textName  .setText( person.getTextName()            );
        textAge   .setText( person.getTextAge()             );
        imageCheck.setChecked( person.getImageCheck()       );
        redrawRowView();

    }
}
