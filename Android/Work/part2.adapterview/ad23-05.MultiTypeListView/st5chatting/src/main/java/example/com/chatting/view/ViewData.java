package example.com.chatting.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.com.chatting.R;
import example.com.chatting.model.ModelData;

/**
 * Created by Administrator on 2018-01-11.
 */

public class ViewData extends LinearLayout {
    private TextView data;


    public ViewData(Context context) {
        super(context);

        init(context, null, 0);
    }

    public ViewData(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0);
    }

    public ViewData(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        View rowView = LayoutInflater.from(context).inflate(R.layout.view_data, this, true);

        data = rowView.findViewById(R.id.data);
    }

    ModelData modelData;

    public void setModelData(ModelData modelData) {
        this.modelData = modelData;

        data.setText(modelData.getData());
    }
}
