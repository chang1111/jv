package example.com.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017-12-29.
 */

public class ListViewAdapter extends BaseAdapter {

    private List<Student> list = new ArrayList<Student>();

    public ListViewAdapter() {

    }

    public List<Student> getList() {
        return list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView text_name = view.findViewById(R.id.text_name);
        TextView text_number = view.findViewById(R.id.text_number);
        TextView text_department = view.findViewById(R.id.text_department);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        Student student = list.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        text_name.setText(student.getName());
        text_number.setText(student.getNumber());
        text_department.setText(student.getDepartment());

        return view;
    }

    public void initList() {
        delAll();
        list.add(new Student("aaa 0", "00-00", "bbb 0"));
        list.add(new Student("aaa 1", "11-11", "bbb 1"));
        list.add(new Student("aaa 2", "22-22", "bbb 2"));
        list.add(new Student("aaa 3", "33-33", "bbb 3"));
        list.add(new Student("aaa 4", "44-44", "bbb 4"));

    }

    public void addItem(String name, String number, String department) {
        Student student = new Student(name, number, department);

        list.add(student);
    }
    public void delItem(int index) {
        list.remove(index);
    }
    public void delAll() {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            list.remove(0);
        }
    }
    public Student search(int key, String keyword) {
        Student student = null;
        switch (key) {
            case 0:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().equals(keyword)) {
                        student =  list.get(i);
                        break;
                    }
                }
                break;
            case 1:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getNumber().equals(keyword)) {
                        student =  list.get(i);
                        break;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getDepartment().equals(keyword)) {
                        student =  list.get(i);
                        break;
                    }
                }
                break;
        }
        return student;
    }

    public void sortList() {
        Collections.sort(list);
    }
    public void reverseList() {
        Collections.sort(list);
        Collections.reverse(list);
    }

}
