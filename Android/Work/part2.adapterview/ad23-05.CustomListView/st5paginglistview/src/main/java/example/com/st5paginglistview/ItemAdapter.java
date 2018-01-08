package example.com.st5paginglistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018-01-08.
 */

public class ItemAdapter extends ArrayAdapter<ModelItem>  {

    private Context context;
    private int resource;

    public ItemAdapter(Context context, int resource, List<ModelItem> data) {
        super(context, resource, data);

        this.context = context;
        this.resource = resource;
    }

    private class ViewHolder {
        ImageView image;
        TextView name;
        TextView price;
        TextView desciption;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemLayout = LayoutInflater.from(context).inflate(resource, parent, false);

        ViewHolder holder = (ViewHolder)itemLayout.getTag();

        if (holder == null) {

            holder = new ViewHolder();

            holder.image = itemLayout.findViewById(R.id.image);
            holder.name = itemLayout.findViewById(R.id.name);
            holder.price = itemLayout.findViewById(R.id.price);
            holder.desciption = itemLayout.findViewById(R.id.description);

            itemLayout.setTag(holder);
        }

        holder.image.setImageDrawable(getItem(position).getImage());
        holder.name.setText(getItem(position).getName());
        holder.price.setText(getItem(position).getPrice());
        holder.desciption.setText(getItem(position).getDescription());

        return itemLayout;
    }
}
