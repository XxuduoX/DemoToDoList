package sg.edu.rp.c346.id20007998.demotodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    int layout_id;
    ArrayList<ToDoItem> alToDoList;


    public CustomAdapter(Context context, int resource, ArrayList<ToDoItem>alToDoList) {
        super(context, resource, alToDoList);

        this.context=context;
        this.layout_id=resource;
        this.alToDoList=alToDoList;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //R.Layout.row
        View rowView = inflater.inflate(layout_id,parent,false);
        //inflate the view for each row
        //line 32 and 34 will always exist and has no change to it.

        TextView tvTitle=rowView.findViewById(R.id.tvTitle);
        TextView tvDate=rowView.findViewById(R.id.tvDate);
        //Obtain UI component and do the necessary binding.

        ToDoItem currentrow=alToDoList.get(position);

        tvTitle.setText(currentrow.getTitle());
        String date=currentrow.getDate().get(Calendar.DAY_OF_MONTH)+"/"+currentrow.getDate().get(Calendar.MONTH)+"/"+currentrow.getDate().get(Calendar.YEAR)+" ("+getDay(currentrow.getDate().get(Calendar.DAY_OF_WEEK))+")";
        tvDate.setText(date);

        return rowView;
    }
    private String getDay(int day) {
        switch (day) {
            case 1: return "Monday";

            case 2: return "Tuesday";

            case 3: return "Wednesday";

            case 4: return "Thursday";

            case 5: return "Friday";

            case 6: return "Saturday";

            case 7: return "Sunday";

            default: return "";
        }
    }

}
