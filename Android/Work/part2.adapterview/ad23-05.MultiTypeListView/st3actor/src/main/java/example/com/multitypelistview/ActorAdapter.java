package example.com.multitypelistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ActorAdapter extends ArrayAdapter {

    public static final int VIEW_TYPE_ACTOR = 0;
    public static final int VIEW_TYPE_TITLE = 1;
    public static final int VIEW_TYPE_MOVIE = 2;
    public static final int VIEW_TYPE_DRAMA = 3;
    public static final int VIEW_TYPE_COMMENT = 4;

    private Context context;
    private LayoutInflater inflater;
    private ModelActor actor;

    public ActorAdapter(@NonNull Context context, ModelActor actor) {
        super(context, -1);
        this.context = context;
        this.actor = actor;
        inflater = LayoutInflater.from(context);
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
        if (position == 0) {
            ViewActor view = null;
            if (convertView != null && convertView instanceof ViewActor) {
                view = (ViewActor)convertView;
            }
            else {
                // inflate
                view = new ViewActor(parent.getContext());
            }

            // 데이터 입력 & 화면 새로 고침
            view.setActor(actor);

            return view;
        }

        position = position - 1;

        if (actor.getMovies().size() > 0) {
            if (position == 0) {
                TextView view = null;
                if (convertView != null && convertView instanceof TextView) {
                    view = (TextView)convertView;
                }
                else {
                    view = (TextView)inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                }

                // 데이터 설정 및 새로고침
                view.setText("Movies...");
                return view;
            }

            // position의 0점 조정
            position = position - 1;

            if (position < actor.getMovies().size()) {
                ViewMovie view = null;
                if (convertView != null && convertView instanceof  ViewMovie) {
                    view = (ViewMovie)convertView;
                }
                else {
                    view = new ViewMovie(parent.getContext());
                }

                // 데이터 설정
                ModelMovie movie = actor.getMovies().get(position);
                view.setMovie(movie);

                return view;
            }

            // position의 0점 저정
            position = position - actor.getMovies().size();
        }

        if (actor.getDramas().size() > 0) {
            //title 처리
            if (position == 0) {
                TextView view;
                if (convertView != null && convertView instanceof TextView) {
                    view = (TextView)convertView;
                }
                else {
                    view = (TextView)inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                }

                // 데이터 설정
                view.setText("Dramas...");

                return view;
            }

            // positon의 0점 조정
            position = position - 1;

            // row 데이터 처리
            if (position < actor.getDramas().size()) {
                ViewDrama view = null;
                if (convertView != null && convertView instanceof ViewDrama) {
                    view = (ViewDrama)convertView;
                }
                else {
                    view = new ViewDrama(parent.getContext());
                }

                // 데이터 설정
                ModelDrama drama = actor.getDramas().get(position);
                view.setDrama(drama);

                return view;
            }

            //position의 0점 조정
            position = position - actor.getDramas().size();

        }

        if (actor.getComments().size() > 0) {
            //title
            if (position == 0) {
                TextView view;
                if (convertView != null && convertView instanceof TextView) {
                    view = (TextView)convertView;
                }
                else {
                    view = (TextView)inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                }

                // 데이터 설정
                view.setText("Comments...");

                return view;
            }

            // position의 0점 조정
            position = position - 1;

            if (position < actor.getComments().size()) {
                ViewComment view;
                if (convertView != null && convertView instanceof ViewComment) {
                    view = (ViewComment)convertView;
                }
                else {
                    view = new ViewComment(parent.getContext());
                }

                //데이터 설정
                ModelComment comment = actor.getComments().get(position);
                view.setComment(comment);

                return view;

            }
            position = position - actor.getComments().size();


        }

        throw new IllegalArgumentException("Invalid position");

    }

}
