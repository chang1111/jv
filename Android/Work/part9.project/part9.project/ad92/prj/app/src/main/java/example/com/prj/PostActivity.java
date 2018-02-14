package example.com.prj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import example.com.prj.http.HttpPost;
import example.com.prj.model.ModelComments;
import example.com.prj.model.ModelPost;

public class PostActivity extends AppCompatActivity {

    ModelPost post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Intent intent = getIntent();
        int postno = intent.getIntExtra("postno", 1);

        new GetPostTask(PostActivity.this).execute(postno);


    }

    public void setActivity() {


        TextView post_author = findViewById(R.id.post_author);
        TextView post_regdate = findViewById(R.id.post_regdata);
        ImageView image = findViewById(R.id.image);
        TextView post_content = findViewById(R.id.content);
        TextView good = findViewById(R.id.good);
        TextView bad = findViewById(R.id.bad);
        TextView comment = findViewById(R.id.comments);
        ListView commentList = findViewById(R.id.commentList);

        String author = post.getAuthor();
        Date date = post.getRegdate();
        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String regdate = tf.format(date);
        String content = post.getContent();
        content = Html.fromHtml(content).toString();
        Integer countgood = post.getCountgood();
        Integer countbad = post.getCountbad();
        Integer commentNum = post.getCommentNum();

        post_author.setText(author);
        post_regdate.setText(regdate);
        if (post.getImage() != null) {
            byte[] imageBytes = post.getImage().getImageBytes();
            Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            image.setImageBitmap(decodedImage);
        }
        post_content.setText(content);
        good.setText("Good" + countgood);
        bad.setText("Bad" + countbad);
        if (commentNum > 0) {
            List<ModelComments> commentData = post.getComment();
            comment.setVisibility(View.VISIBLE);
            commentList.setVisibility(View.VISIBLE);
            comment.setText("댓글 [" + commentNum + "]");
            CommentAdapter adapter = new CommentAdapter(PostActivity.this, R.layout.comment_view, commentData);
            commentList.setAdapter(adapter);
        }

    }

    private class GetPostTask extends SiteAsyncTask< Integer, Integer, ModelPost> {

        public GetPostTask(Context context) {
            super(context);
        }

        @Override
        protected ModelPost doInBackground(Integer... integer) {
            ModelPost result = new HttpPost().getPostOne(integer[0]);
            return result;
        }

        @Override
        protected void onPostExecute(ModelPost data) {
            super.onPostExecute(data);

            post = data;

            setActivity();
        }

    }
}
