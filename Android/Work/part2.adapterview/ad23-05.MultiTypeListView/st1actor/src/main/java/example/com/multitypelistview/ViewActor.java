package example.com.multitypelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018-01-09.
 */

public class ViewActor extends RelativeLayout {

    private ImageView actorImage;
    private TextView actorName;
    private TextView actorAge;

    public ViewActor(Context context) {
        super(context);

        init(context, null, 0);
    }

    public ViewActor(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0);
    }

    public ViewActor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        View rowView = LayoutInflater.from(context).inflate(R.layout.view_actor, this, true);

        actorImage = this.findViewById(R.id.actorImage);
        actorName = this.findViewById(R.id.actorName);
        actorAge = this.findViewById(R.id.actorAge);

    }

    private ModelActor actor;

    public ModelActor getActor() {
        return actor;
    }

    public void setPerson(ModelActor actor) {
        this.actor = actor;

        //위젯 설정
        actorImage.setImageDrawable(actor.getActorImage());
        actorName.setText(actor.getActorName());
        actorAge.setText(actor.getActorAge()+"");
    }

}
