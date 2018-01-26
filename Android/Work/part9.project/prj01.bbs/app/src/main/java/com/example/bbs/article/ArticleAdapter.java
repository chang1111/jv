package com.example.bbs.article;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bbs.R;
import com.example.bbs.model.ModelArticle;

import java.util.List;

/**
 * Created by Administrator on 2018-01-26.
 */

public class ArticleAdapter extends ArrayAdapter<ModelArticle> {
    private LayoutInflater mInflater;
    private List<ModelArticle> mList;

    public ArticleAdapter(@NonNull Context context, int resource, @NonNull List<ModelArticle> objects) {
        super(context, resource, objects);
        mInflater = LayoutInflater.from(context);
        mList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;

        ViewHolder holder = null;

        if (rowView == null) {
            rowView = mInflater.inflate(R.layout.list_customview_article, parent, false);

            holder = new ViewHolder();

            holder.no = rowView.findViewById(R.id.no);
            holder.title = rowView.findViewById(R.id.title);
            holder.hit = rowView.findViewById(R.id.hit);
            holder.content = rowView.findViewById(R.id.content);

            rowView.setTag(holder);
        }
        else {
            holder = (ViewHolder) rowView.getTag();
        }

        ModelArticle item = getItem(position);

        holder.no.setText(item.getArticleno() + "");
        holder.title.setText(item.getTitle());
        holder.hit.setText(item.getHit() + "");
        holder.content.setText(item.getContent());

        return rowView;
    }

    private class ViewHolder {
        TextView no;
        TextView title;
        TextView hit;
        TextView content;
    }
}
