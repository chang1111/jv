package example.com.multitypelistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class ActorAdapter extends ArrayAdapter {

    public static final int VIEW_TYPE_ACTOR = 0;
    public static final int VIEW_TYPE_TITLE = 1;
    public static final int VIEW_TYPE_MOVIE = 2;
    public static final int VIEW_TYPE_DRAMA = 3;
    public static final int VIEW_TYPE_COMMENT = 4;

    private Context context;
    private ModelActor actor;

    public ActorAdapter(@NonNull Context context) {
        super(context, -1);
        this.context = context;

    }

    public ModelActor getActor() {
        return actor;
    }

    public void setActor(ModelActor actor) {
        this.actor = actor;
        // 앱 실행 중 데이터 변경 시 화면 새로 고침
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        // title 이 추가되면서 갯수가 변경되는 문제가 발생
        // 따라서 title의 갯수를 빼주어야 된다
        int count = 0;

        // actor
        if (actor == null) {
            return 0;
        }
        else {
            count = count + 1;
        }

        // movie가 있는 경우
        if (actor.getMovies().size() > 0) {
            // 1 : title 갯수
            count = count + (1 + actor.getMovies().size());
        }

        // drama
        if (actor.getDramas().size() > 0) {
            // 1 : title 갯수
            count = count + (1 + actor.getDramas().size());
        }

        // comment
        if (actor.getComments().size() > 0) {
            // 1 : title 갯수
            count = count + (1 + actor.getComments().size());
        }

        return count;
    }

    @Override
    public int getViewTypeCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {
        int VIEW_TYPE = -1;
        if(position == 0) {
            return VIEW_TYPE_ACTOR;
        }

        position = position - 1;  // actor 때문에

        if (actor.getMovies().size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_TITLE;
            }

            position = position - 1; // movie의 타이틀 때문에 -1

            if (position < actor.getMovies().size()) {
                return VIEW_TYPE_MOVIE;
            }
        }

        position = position - actor.getMovies().size();

        if (actor.getDramas().size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_TITLE;
            }

            position = position - 1; // drama의 타이틀 때문에 -1

            if (position < actor.getDramas().size()) {
                return VIEW_TYPE_DRAMA;
            }
        }

        position = position - actor.getDramas().size();

        if (actor.getComments().size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_TITLE;
            }

            position = position - 1; // comment의 타이틀 때문에

            if (position < actor.getComments().size()) {
                return VIEW_TYPE_COMMENT;
            }

            position = position - actor.getComments().size();
        }

        return VIEW_TYPE;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        if (position == 0) {
            return actor;
        }

        position = position - 1;

        if ( actor.getMovies().size() > 0) {
            if (position == 0) {
                return "Movie..."; // Movie의 타이틀
            }

            position = position - 1;

            if (actor.getMovies().size() < 0) {
                return actor.getMovies().get(position);
            }
        }

        position = position - actor.getMovies().size();

        if ( actor.getDramas().size() > 0) {
            if (position == 0) {
                return "Drama..."; // Drama의 타이틀
            }

            position = position - 1;

            if (actor.getDramas().size() < 0) {
                return actor.getDramas().get(position);
            }
        }

        position = position - actor.getDramas().size();

        if ( actor.getComments().size() > 0) {
            if (position == 0) {
                return "Comment..."; // Comment의 타이틀
            }

            position = position - 1;

            if (actor.getComments().size() < 0) {
                return actor.getComments().get(position);
            }
        }

        position = position - actor.getComments().size();

        return null;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

}
