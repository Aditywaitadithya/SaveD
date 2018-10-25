package com.example.adithyaiyer.saved;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class customerAdapter extends RecyclerView.Adapter<customerAdapter.CustomViewHolder>{

    private List<customer> customersIn;
    private Context context;


    public class CustomViewHolder extends RecyclerView.ViewHolder {


        public TextView username;
        public Button email;
        public TextView Bg;
        public TextView phoneNo;
      //  private FusedLocationProviderClient mFusedLocationClient;

        public CustomViewHolder(View view) {
            super(view);
            // context=view.getContext();
            username = (TextView)view.findViewById(R.id.viewName);
            email = (Button) view.findViewById(R.id.viewEmail);
            Bg = (TextView) view.findViewById(R.id.viewBg);
            phoneNo = (TextView) view.findViewById(R.id.viewNumber);


        }




    }



    @NonNull
    @Override
    public customerAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customeritemview, parent, false);
        return new CustomViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final customerAdapter.CustomViewHolder holder, int position) {
        holder.username.setText(customersIn.get(position).getUsername().toString());
        holder.email.setText(customersIn.get(position).getEmail_id().toString());
        holder.Bg.setText(customersIn.get(position).getBlood_group().toString());
        holder.phoneNo.setText(customersIn.get(position).getPhoneNumber().toString());

        holder.phoneNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", holder.phoneNo.getText().toString(), null));
                context.startActivity(intent);
            }
        });
        holder.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",holder.email.getText().toString(), null));
                context.startActivity(emailIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return customersIn.size();
    }

    public customerAdapter(List<customer> cust,Context context ){
        this.customersIn=cust;
        this.context=context;
    }

}
