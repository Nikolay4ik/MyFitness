package com.example.myfitness.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.myfitness.Data.Timetable;
import com.example.myfitness.R;
import com.example.myfitness.Utils.JsonUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterTimeTable extends RecyclerView.Adapter<AdapterTimeTable.TableVive> {
    private List<Timetable> timetables =new ArrayList<>();
    private OnTableClickListner tableClickListner;
private Context context;

    public AdapterTimeTable(Context context) {
        this.context = context;
    }

    public void setTableClickListner(OnTableClickListner tableClickListner) {
        this.tableClickListner = tableClickListner;
    }

    public interface OnTableClickListner {
        void OnTableClick(int postion);
    }

    public List<Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(List<Timetable> timetables) {
        this.timetables.clear();
        this.timetables.addAll(timetables);
        notifyDataSetChanged();
    }

    public void addTimeTable(List<Timetable> timetables) {
        this.timetables.addAll(timetables);

    }


    @NonNull
    @Override
    public TableVive onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.timetable, viewGroup, false);

        return new TableVive(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableVive tableVive, int i) {
        Timetable timetable = timetables.get(i);
        tableVive.textView_name.setText(timetable.getName());
       String description= timetable.getDescription();
       if (description.trim().isEmpty()){
           tableVive.textView_description.setVisibility(View.GONE);
       }
        tableVive.textView_description.setText(timetable.getDescription());
        tableVive.textView_place.setText(timetable.getPlace());
        tableVive.textView_teacher.setText(timetable.getTeacher());
        tableVive.textView_startTime.setText(timetable.getStartTime());
        tableVive.textView_endTime.setText(timetable.getEndTime());
        String dayWeek;
        int numberWeek= timetable.getWeekDay();
        if (numberWeek>=1&& numberWeek<=7){
            numberWeek--;
        }else {
            numberWeek=0;
        }
        dayWeek= context.getResources().getStringArray(R.array.days_of_week)[numberWeek];
        tableVive.textView_weekDay.setText(dayWeek);

     //  tableVive.textView_weekDay.setText(timetable.getWeekDay());

    }

    @Override
    public int getItemCount() {
        return timetables.size();
    }


    class TableVive extends RecyclerView.ViewHolder {
        private CardView cardViewTime;
        private TextView textView_name;
        private TextView textView_description;
        private TextView textView_place;
        private TextView textView_teacher;
        private TextView textView_startTime;
        private TextView textView_endTime;
        private TextView textView_weekDay;
        public TableVive(@NonNull View itemView) {
            super(itemView);
            this.cardViewTime = itemView.findViewById(R.id.cardViewTable);
            this.textView_name = itemView.findViewById(R.id.textView_name);
            this.textView_description = itemView.findViewById(R.id.textView_description);
            this.textView_place = itemView.findViewById(R.id.textView_place);
            this.textView_teacher = itemView.findViewById(R.id.textView_teacher);
            this.textView_startTime = itemView.findViewById(R.id.textView_startTime);
            this.textView_endTime = itemView.findViewById(R.id.textView_endTime);
            this.textView_weekDay = itemView.findViewById(R.id.textView_DayWeek);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (tableClickListner != null) {
                        tableClickListner.OnTableClick(getAdapterPosition());
                    }

                }
            });

        }
    }




}
