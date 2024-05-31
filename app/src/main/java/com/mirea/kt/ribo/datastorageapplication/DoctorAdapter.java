package com.mirea.kt.ribo.datastorageapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {

    interface OnPersonClickListner{
        void onPersonClick(Doctor doctor, int position);
    }

    private ArrayList<Doctor> doctors;

    private OnPersonClickListner onPersonClickListner;

    public DoctorAdapter(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView nameView;
        private final TextView specializationView;

        ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.tvDoctorName);
            specializationView = view.findViewById(R.id.tvSpecialization);
        }
    }

    @NonNull
    @Override
    public DoctorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorAdapter.ViewHolder holder, int position) {
        Doctor doctor = doctors.get(position);
        holder.nameView.setText(String.format("%s %s", doctor.getFirstName(), doctor.getLastName()));
        holder.specializationView.setText(String.format("%s, Certification: %s", doctor.getSpecialization(), doctor.getCertification()));

    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }
}
