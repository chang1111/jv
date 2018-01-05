package example.com.st3checkablelistview;

import android.content.Context;
import android.graphics.Color;
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
    private int resource;
    private List<Person> list = null;

    public PersonAdapter(Context context, int resource, List<Person> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        list = data;
    }

    public List<Person> getList() {
        return list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Person getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder {
        ImageView image;
        TextView textName;
        TextView textAge;
        ImageView checkBox;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {

//        Context context = parent.getContext();

        View itemLayout = LayoutInflater.from(context).inflate(resource, parent, false);

        ViewHolder holder = (ViewHolder)itemLayout.getTag();

        // "view_person" Layout을 inflate하여 convertView 참조 획득.
        if (holder == null) {
            holder = new ViewHolder();

            holder.image = itemLayout.findViewById(R.id.image);
            holder.textName = itemLayout.findViewById(R.id.textName);
            holder.textAge = itemLayout.findViewById(R.id.textAge);
            holder.checkBox = itemLayout.findViewById(R.id.checkBox);

            itemLayout.setTag(holder);
        }

        Person person = list.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        holder.image.setImageDrawable(person.getImage());
        holder.textName.setText(person.getName());
        holder.textAge.setText(person.getAge());
        if (person.isChecked()) {
            holder.checkBox.setImageResource(android.R.drawable.checkbox_on_background);
            itemLayout.setBackgroundColor(Color.argb(127,255,0,0));
        }
        else {
            holder.checkBox.setImageResource(android.R.drawable.checkbox_off_background);
        }

        return itemLayout;
    }


}
