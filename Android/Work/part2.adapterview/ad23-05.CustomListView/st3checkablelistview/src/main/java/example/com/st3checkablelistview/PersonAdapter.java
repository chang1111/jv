package example.com.st3checkablelistview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017-12-29.
 */

public class PersonAdapter extends ArrayAdapter<Person> {

    private Context context;
    private List<Person> data = null;

    public PersonAdapter(Context context, int resource, List<Person> data) {
        super(context, resource, data);
        this.context = context;
        this.data = data;
    }

//    private class ViewHolder {
//        ImageView image;
//        TextView textName;
//        TextView textAge;
//        ImageView checkBox;
//    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

//        return getViewHolder(position, convertView, parent);
        return getViewClass(position, convertView, parent);
    }
    @NonNull
    private View getViewClass(int position, View convertView, ViewGroup parent) {
        // ListView의 row는 ViewPerson 이다
        ViewPerson rowView = (ViewPerson) convertView;

        if (rowView == null) {
            rowView = new ViewPerson(parent.getContext());
            rowView.setTag("exist");
        }
        else {
            // 작업 없음
        }

        // ViewPerson에 데이터 설정

        Person p = data.get(position);
        rowView.setPerson(p);

        return rowView;
    }
//    @NonNull
//    private View getViewHolder(int position, View convertView, ViewGroup parent) {
//        View rowView = convertView;
//
//
//        ViewHolder holder;
//
//        if (rowView == null) {
//            rowView = LayoutInflater.from(context).inflate(resource, parent, false);
//
//            holder = new ViewHolder();
//
//            holder.image = rowView.findViewById(R.id.image);
//            holder.textName = rowView.findViewById(R.id.textName);
//            holder.textAge = rowView.findViewById(R.id.textAge);
//            holder.checkBox = rowView.findViewById(R.id.checkBox);
//
//            rowView.setTag(holder);
//        }
//        else {
//            holder = (ViewHolder)rowView.getTag();
//        }
//
//        Person person = data.get(position);
//
//        holder.image.setImageDrawable(person.getImage());
//        holder.textName.setText(person.getName());
//        holder.textAge.setText(person.getAge()+"");
//        if (person.isChecked()) {
//            holder.checkBox.setImageResource(android.R.drawable.checkbox_on_background);
//            rowView.setBackgroundColor(Color.MAGENTA);
//        }
//        else {
//            holder.checkBox.setImageResource(android.R.drawable.checkbox_off_background);
//            rowView.setBackgroundColor(Color.TRANSPARENT);
//        }

//        final View finalItemLayout = itemLayout;
//        holder.checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Person p = data.get(position);
//
//                if (p.isChecked()) {
//                    finalItemLayout.setBackgroundColor(Color.MAGENTA);
//                    p.setChecked(false);
//                }
//                else {
//                    finalItemLayout.setBackgroundColor(Color.TRANSPARENT);
//                    p.setChecked(true);
//                }
//            }
//        });

//        return rowView;
//    }


}
