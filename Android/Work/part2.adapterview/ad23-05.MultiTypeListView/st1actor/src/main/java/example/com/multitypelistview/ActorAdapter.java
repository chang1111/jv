package example.com.multitypelistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ActorAdapter extends ArrayAdapter<ModelActor> {

    private Context context;
    private ModelActor actor;
    private List<ModelActor> list;

    public ActorAdapter(@NonNull Context context, int resource, @NonNull List<ModelActor> objects) {
        super(context, resource, objects);
        this.context = context;
        list = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

//        return getViewHolder(position, convertView, parent);
        return getViewClass(position, convertView, parent);
    }
    @NonNull
    private View getViewClass(int position, View convertView, ViewGroup parent) {
        // ListView의 row는 ViewPerson 이다
        ViewActor rowView = (ViewActor) convertView;

        if (rowView == null) {
            rowView = new ViewActor(parent.getContext());
            rowView.setTag("exist");
        }
        else {
            // 작업 없음
        }

        // ViewPerson에 데이터 설정

        ModelActor actor = list.get(position);
        rowView.setPerson(actor);

        return rowView;
    }
}
