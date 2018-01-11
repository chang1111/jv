package example.com.multitypelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ViewComment extends RelativeLayout{

    private TextView comment = null;
    private TextView writer = null;

    public ViewComment(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ViewComment(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ViewComment(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // inflate
        View rowview = LayoutInflater.from(context)
                .inflate(R.layout.view_comment,this,true);

        comment = rowview.findViewById(R.id.comment);
        writer = rowview.findViewById(R.id.writer);

    }

    ModelComment modelComment;

    public ModelComment getComment() {
        return modelComment;
    }

    public void setComment(ModelComment comment) {
        this.modelComment = comment;

        this.comment.setText(modelComment.getComment());
        writer.setText(modelComment.getWriter());
    }
}
