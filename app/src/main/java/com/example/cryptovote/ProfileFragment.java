package com.example.cryptovote;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.time.Period;

public class ProfileFragment extends Fragment{
    Button logout;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        logout = view.findViewById(R.id.logOut);
        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent logout_act = new Intent(getActivity(), log_in.class);
                startActivity(logout_act);
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();


        TextView name = view.findViewById(R.id.userName);
        TextView aadhaar = view.findViewById(R.id.aadhaarNumber);
        TextView email = view.findViewById(R.id.email);
        TextView dob = view.findViewById(R.id.dobProfile);
        TextView age = view.findViewById(R.id.age);
        TextView registered = view.findViewById(R.id.Registered);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                voterReg userProfile = snapshot.getValue(voterReg.class);
                if(userProfile != null){
                    name.setText(userProfile.getFname()+" "+userProfile.getLname());
                    aadhaar.setText(userProfile.getAdhaar());
                    email.setText(userProfile.getEmail());
                    dob.setText(userProfile.getDob());
                    int UID = userProfile.getUserID();
                    Blockchain blockchain = new Blockchain();
                    try {
                        registered.setText((blockchain.CheckRegistered(UID) ? "Yes" : "No"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    String temp = userProfile.getDob();
                    String year[] = temp.split("/",0);

                    int dd = Integer.parseInt(year[0]);
                    int m = Integer.parseInt(year[1]);
                    int y = Integer.parseInt(year[2]);

                    LocalDate dob = LocalDate.of(y,m,dd);
                    LocalDate currentDate = LocalDate.now();

                    Period p = Period.between(dob,currentDate);
                    String a = Integer.toString(p.getYears());

                    age.setText(a);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Something Wrong", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
