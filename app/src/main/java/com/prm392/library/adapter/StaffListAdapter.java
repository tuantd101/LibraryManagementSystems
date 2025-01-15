package com.prm392.library.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prm392.library.R;
import com.prm392.library.StaffDetailActivity;
import com.prm392.library.bean.StaffShow;

import java.util.ArrayList;
import java.util.List;

public class StaffListAdapter extends RecyclerView.Adapter<StaffListAdapter.StaffViewHolder>{

    private List<StaffShow> staffShowList = new ArrayList<>();
    private Context context;

    public StaffListAdapter(List<StaffShow> staffShowList, Context context) {
        this.staffShowList = staffShowList;
        this.context = context;
    }

    @NonNull
    @Override
    public StaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.staff_list_item, parent, false);
        return new StaffViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffListAdapter.StaffViewHolder holder, int position) {
        StaffShow staffShow = staffShowList.get(position);
        holder.id.setText(""+staffShow.getId());
        holder.name.setText(staffShow.getName());
        holder.role.setText(""+staffShow.getRole());
    }

    @Override
    public int getItemCount() {
        return staffShowList.size();
    }

    public class StaffViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView id, name, role;

        public StaffViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tv_staff_id);
            name = itemView.findViewById(R.id.tv_staff_name);
            role = itemView.findViewById(R.id.tv_staff_role);
            name.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, StaffDetailActivity.class);
            intent.putExtra("ID", id.getText());
            context.startActivity(intent);
        }
    }
}
