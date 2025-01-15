package com.prm392.library.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prm392.library.R;
import com.prm392.library.bean.LogShow;


import java.util.List;

public class LogListAdapter extends RecyclerView.Adapter<LogListAdapter.LogsViewHolder> {
    private List<LogShow> logShows;
    private Context context;
    public LogListAdapter(List<LogShow> logShows, Context context){
        this.logShows = logShows;
        this.context = context;
    }
    public class LogsViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvNumber, tvAction, tvUser, tvTime;
        public LogsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNumber = itemView.findViewById(R.id.tvNumber);
            tvAction = itemView.findViewById(R.id.tvAction);
            tvUser = itemView.findViewById(R.id.tvUser);
            tvTime = itemView.findViewById(R.id.tvTime);
        }

        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(context, LogShow.class);
////            intent.putExtra("actionId", actionId);
//            context.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public LogListAdapter.LogsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.log_item, parent, false);
        return new LogsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogListAdapter.LogsViewHolder holder, int position) {
        LogShow logShow = logShows.get(position);
        holder.tvNumber.setText("" + logShow.getNumber());
        holder.tvAction.setText(logShow.getAction_name());
        holder.tvUser.setText("" + logShow.getCreated_by());
        holder.tvTime.setText("" + logShow.getCreated_at());
    }

    @Override
    public int getItemCount() {
        return logShows.size();
    }
}
