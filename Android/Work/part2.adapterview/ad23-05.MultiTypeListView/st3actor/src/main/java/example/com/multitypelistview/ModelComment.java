package example.com.multitypelistview;

public class ModelComment {

    private String comment = ""  ;
    private String writer = ""  ;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "ModelComment{" +
                "comment='" + comment + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

    public ModelComment() {
    }

    public ModelComment(String comment, String writer) {
        this.comment = comment;
        this.writer = writer;
    }
}
