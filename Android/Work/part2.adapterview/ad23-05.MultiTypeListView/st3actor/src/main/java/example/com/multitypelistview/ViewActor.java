package example.com.multitypelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewActor extends RelativeLayout{

    private ImageView actorImage = null;
    private TextView actorName = null;
    private TextView actorAge = null;
    private TextView actorDesc = null;
    private ModelActor actor;

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
        // inflate
        View rowview = LayoutInflater.from(context)
                .inflate(R.layout.view_actor,this,true);

        actorImage = rowview.findViewById(R.id.actorImage);
        actorName = rowview.findViewById(R.id.actorName);
        actorAge = rowview.findViewById(R.id.actorAge);
        actorDesc = rowview.findViewById(R.id.actorDesc);
    }

    public ModelActor getActor() {
        return actor;
    }

    public void setActor(ModelActor actor) {
        this.actor = actor;

        actorImage.setImageDrawable(actor.getActorImage());
        actorName.setText         (actor.getActorName());
        actorAge.setText         (actor.getActorAge() + "");
        actorDesc.setText         (actor.getActorDesc());
    }
}
