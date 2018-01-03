package example.com.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017-12-29.
 */

public class StudentAdapter extends ArrayAdapter<Student> {

    private Context context;
    private int resource;
    private List<Student> list = null;

    public StudentAdapter(Context context, int resource, List<Student> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        list = data;
    }

    public List<Student> getList() {
        return list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Student getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder {
        TextView text_name;
        TextView text_number;
        TextView text_department;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {

//        Context context = parent.getContext();

        View itemLayout = LayoutInflater.from(context).inflate(R.layout.listview_item, parent, false);

        ViewHolder holder = (ViewHolder)itemLayout.getTag();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (holder == null) {
            holder = new ViewHolder();

            holder.text_name = itemLayout.findViewById(R.id.text_name);
            holder.text_number = itemLayout.findViewById(R.id.text_number);
            holder.text_department = itemLayout.findViewById(R.id.text_department);

            itemLayout.setTag(holder);
        }

        Student student = list.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        holder.text_name.setText(student.getName());
        holder.text_number.setText(student.getNumber());
        holder.text_department.setText(student.getDepartment());

        return itemLayout;
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

    public void sortList(boolean desc, int criteria) {
        switch (criteria) {
            case 0:
                Student.NameCompare name = new Student.NameCompare(desc);
                Collections.sort(list, name);
                break;
            case 1:
                Student.NumberCompare number = new Student.NumberCompare(desc);
                Collections.sort(list, number);
                break;
            case 2:
                Student.DepartmentCompare department = new Student.DepartmentCompare(desc);
                Collections.sort(list, department);
                break;

        }

    }

}
