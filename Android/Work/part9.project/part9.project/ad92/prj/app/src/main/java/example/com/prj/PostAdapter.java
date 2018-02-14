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

import example.com.prj.model.ModelPost;

public class PostAdapter extends ArrayAdapter<ModelPost> {
    private Context context;
    private List<ModelPost> mData;
    public PostAdapter(@NonNull Context context, int resource, @NonNull List<ModelPost> objects) {
        super(context, resource, objects);

        this.context = context;
        mData = objects;
    }

    private class ViewHolder {
        TextView author;
        TextView regdate;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemLayout = LayoutInflater.from( context )
                .inflate(R.layout.custom_list_view, parent, false );

        ViewHolder holder = (ViewHolder) itemLayout.getTag();

        if( holder == null ) {
            holder = new ViewHolder();

            holder.author = itemLayout.findViewById(R.id.author      );
            holder.regdate = itemLayout.findViewById(R.id.regdate    );

            itemLayout.setTag( holder );
        }

        int commentNum = getItem(position).getCommentNum();
        if (commentNum > 0) {
            holder.author.setText( getItem(position).getAuthor() + " [" + commentNum + "]" );
        }
        else {
            holder.author.setText( getItem(position).getAuthor() );
        }
        Date date = getItem(position).getRegdate();
        SimpleDateFormat tf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        holder.regdate.setText( tf.format(date) );

        return itemLayout;
    }
}
