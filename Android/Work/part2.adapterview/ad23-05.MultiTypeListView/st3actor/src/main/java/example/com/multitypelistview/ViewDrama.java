package example.com.multitypelistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ViewDrama extends RelativeLayout {

    private ImageView dramaImage = null;
    private TextView dramaTitle = null;
    private TextView dramaInterval = null;

    public ViewDrama(@NonNull Context context) {
        super(context);
        init(context, null, 0);
    }

    public ViewDrama(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ViewDrama(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // inflate
        View rowview = LayoutInflater.from(context)
                .inflate(R.layout.view_drama,this,true);

        dramaImage = rowview.findViewById(R.id.dramaImage);
        dramaTitle = rowview.findViewById(R.id.dramaTitle);
        dramaInterval = rowview.findViewById(R.id.dramaInterval);
    }

    ModelDrama drama;

    public ModelDrama getDrama() {
        return drama;
    }

    public void setDrama(ModelDrama drama) {
        this.drama = drama;

        dramaImage.setImageDrawable(drama.getDramaImage());
        dramaTitle.setText         (drama.getDramaTitle()   );
        dramaInterval.setText         (drama.getDramaInterval());
    }
}
