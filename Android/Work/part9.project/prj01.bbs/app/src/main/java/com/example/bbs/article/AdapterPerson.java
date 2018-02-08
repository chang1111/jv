package com.example.bbs.article;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bbs.R;
import com.example.bbs.model.ModelPerson;

import java.util.List;

public class AdapterPerson extends ArrayAdapter<ModelPerson> {

    private Context           context = null;
    private List<ModelPerson> lists   = null;

    public AdapterPerson(@NonNull Context context, int resource, @NonNull List<ModelPerson> objects) {
        super(context, resource, objects);

        this.context = context;
        this.lists   = objects;
    }

    private class ViewHolder {
        ImageView imagePhoto ;
        TextView  textName   ;
        TextView  textAge    ;
        CheckBox  imageCheck ;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // return getViewInflation(position, convertView, parent);
        return getViewClass(position, convertView, parent);
    }

    @NonNull
    private View getViewClass(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // ListView의 row는 ViewPerson 이다.
        ViewPerson rowView = (ViewPerson) convertView;

        if( rowView == null ){
            rowView = new ViewPerson( parent.getContext() );
        }
        else { /* 작업 없음. */ }

        // 데이터 ViewPerson 에 데이터 설정
        ModelPerson p = lists.get( position );
        rowView.setPerson( p );

        return rowView;
    }

    @NonNull
    private View getViewInflation(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView ;

        ViewHolder holder = null;

        if( rowView == null ) {

            rowView = LayoutInflater.from( this.context)
                                    .inflate( R.layout.listview_customview_person, parent, false );

            holder = new ViewHolder();

            holder.imagePhoto = rowView.findViewById(R.id.image_photo );  //
            holder.textName   = rowView.findViewById(R.id.text_name   );  //
            holder.textAge    = rowView.findViewById(R.id.text_age    );  //
            holder.imageCheck = rowView.findViewById(R.id.image_check );  //

            rowView.setTag( holder );
        }
        else {
            holder = (ViewHolder) rowView.getTag();
        }

        ModelPerson p = lists.get( position );
        holder.imagePhoto.setImageDrawable( p.getImagePhoto()  );
        holder.textName  .setText         ( p.getTextName()    );
        holder.textAge   .setText         ( p.getTextAge()     );
        holder.imageCheck.setChecked      ( p.getImageCheck()  );

        // ListView를 위아래로 스크롤 할 때. 화면 새로고침을 위해서..
        redrawRowView(p, rowView);

        final View finalRowView = rowView;
        holder.imageCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelPerson person = lists.get( position );

                // chechk 상태를 반전하여 lists 에 저장.
                // p.getImageCheck()   -->  ! p.getImageCheck()
                //   false             -->     true
                //   true              -->     false
                person.setImageCheck( ! person.getImageCheck()  );

                // 현재 listview의 row에서 checkbox를 클릭 했을 때
                // 클릭된 row 화면의 새로고침..
                redrawRowView(person, finalRowView);
            }
        });

        return rowView;
    }

    private void redrawRowView(ModelPerson person, View view) {
        if( person.getImageCheck() ) {
            view.setBackgroundColor(Color.MAGENTA);
        }
        else {
            view.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
