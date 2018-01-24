package example.com.tabpagerfragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018-01-24.
 */

public class StudentAdapter<M> extends ArrayAdapter<ModelStudent> {
    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<ModelStudent> objects) {
        super(context, resource, objects);
    }
}
