package example.com.chatting;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import example.com.chatting.model.ModelData;
import example.com.chatting.model.ModelReceive;
import example.com.chatting.model.ModelSend;

/**
 * Created by Administrator on 2018-01-12.
 */

public class ChattingAdapter extends ArrayAdapter {

    public static final int VIEW_TYPE_SEND    = 0;
    public static final int VIEW_TYPE_RECEIVE = 1;
    public static final int VIEW_TYPE_DATA    = 2;


    private Context context;
    private LayoutInflater inflater;
    private List<Object> object;

    public ChattingAdapter(@NonNull Context context, List<Object> object) {
        super(context, -1);
        this.context = context;
        this.object = object;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return object.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (object.get(position) instanceof ModelSend) {
            view = inflater.inflate(R.layout.view_send, parent, false);
            TextView sMessage = view.findViewById(R.id.sMessage);
            sMessage.setText(((ModelSend) object.get(position)).getsMessage());

        } else if (object.get(position) instanceof ModelReceive) {
            view = inflater.inflate(R.layout.view_receive, parent, false);
            TextView rMessage = view.findViewById(R.id.rMessage);
            rMessage.setText(((ModelReceive) object.get(position)).getrMessage());
        } else if (object.get(position) instanceof ModelData) {
            view = inflater.inflate(R.layout.view_data, parent, false);
            TextView data = view.findViewById(R.id.data);
            data.setText(((ModelData) object.get(position)).getData());
        }

        return view;
    }

    @Override
    public int getItemViewType(int position) {
        if (object.get(position) instanceof ModelSend) {
            return VIEW_TYPE_SEND;
        }
        else if (object.get(position) instanceof ModelReceive) {
            return VIEW_TYPE_RECEIVE;
        }
        else if (object.get(position) instanceof ModelData)
            return VIEW_TYPE_DATA;
        return -1;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }
}
