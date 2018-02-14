package example.com.prj;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import example.com.prj.model.ModelComments;

public class CommentAdapter extends ArrayAdapter<ModelComments> {
    private Context context;
    private List<ModelComments> mData;

    public CommentAdapter(@NonNull Context context, int resource, @NonNull List<ModelComments> objects) {
        super(context, resource, objects);

        this.context = context;
        mData = objects;
    }
    private class ViewHolder {
        TextView memo;
        TextView comment_regdate;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemLayout = LayoutInflater.from( context )
                .inflate(R.layout.comment_view, parent, false );

        ViewHolder holder = (ViewHolder) itemLayout.getTag();

        if( holder == null ) {
            holder = new ViewHolder();

            holder.memo = itemLayout.findViewById(R.id.memo);
            holder.comment_regdate = itemLayout.findViewById(R.id.comment_regdate    );

            itemLayout.setTag( holder );
        }

        holder.memo.setText( getItem(position).getMemo() );
        Date date = getItem(position).getRegdate();
        SimpleDateFormat tf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        holder.comment_regdate.setText( tf.format(date) );

        return itemLayout;
    }
}
