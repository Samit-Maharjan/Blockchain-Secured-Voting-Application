package com.example.cryptovote;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class register extends AppCompatActivity implements View.OnClickListener{
    EditText fname, lname, cpass, email, password, adhaar, date;
    private DatePickerDialog datePickerDialog;
    private FirebaseAuth mAuth;
    private int count = 1;
    int maxId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_register);

        initDatePicker();

        fname =  findViewById(R.id.FirstName);
        lname = findViewById(R.id.LastName);
        cpass = findViewById(R.id.ConfirmPass);
        password = findViewById(R.id.Pass);
        email = findViewById(R.id.Email);
        adhaar  = findViewById(R.id.Aadhaar);
        date = findViewById(R.id.DOB);



        findViewById(R.id.register).setOnClickListener(this);
        date.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                registerUser();
                break;
            case R.id.DOB:
                openDatePicker(v);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void registerUser(){
        String FirstName = fname.getText().toString().trim();
        String LastName = lname.getText().toString().trim();
        String emaill = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String Confpass = cpass.getText().toString().trim();
        String adh = adhaar.getText().toString().trim();
        String d = date.getText().toString();

        String year[] = d.split("/",0);

        int dd = Integer.parseInt(year[0]);
        int m = Integer.parseInt(year[1]);
        int y = Integer.parseInt(year[2]);

        LocalDate dob = LocalDate.of(y,m,dd);
        LocalDate currentDate = LocalDate.now();

        Period p = Period.between(dob,currentDate);
        if(p.getYears() < 18){
            Toast.makeText(this, "You are not eligible to vote", Toast.LENGTH_SHORT).show();
            date.setError("You are not eligible to vote");
            return;
        }

        if(FirstName.isEmpty()){
            fname.setError("Please provide first name");
            fname.requestFocus();
            return;
        }
        if(!FirstName.matches("^[a-zA-Z]{0,20}$")){
            fname.setError("Please provide valid first name");
            fname.requestFocus();
            return;
        }
        if(LastName.isEmpty()){
            lname.setError("Please provide last name");
            lname.requestFocus();
            return;
        }
        if(!LastName.matches("^[a-zA-Z]{0,20}$")){
            lname.setError("Please provide valid last name");
            lname.requestFocus();
            return;
        }
        if(!adh.matches("^[2-9]{1}[0-9]{11}$")){
            adhaar.setError("Please enter valid aadhaar number");
            adhaar.requestFocus();
            return;
        }
        if(emaill.isEmpty()){
            email.setError("Please provide Email");
            email.requestFocus();
            return;
        }
        if(pass.isEmpty()){
            password.setError("Please provide Password");
            password.requestFocus();
            return;
        }
        if(Confpass.isEmpty()){
            cpass.setError("Please provide Confirm Password");
            cpass.requestFocus();
            return;
        }
        if(adh.isEmpty()){
            adhaar.setError("Please provide aadhaar number");
            adhaar.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emaill).matches()){
            email.setError("Please provide valid email");
            email.requestFocus();
            return;
        }
        if(!Confpass.equals(pass)) {
            cpass.setError("Passwords does not Match");
            cpass.requestFocus();
            return;
        }
        if(!pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")) {
            password.setError("Password should contain at least one special and uppercase character");
            password.requestFocus();
            return;
        }

        Blockchain blockchain = new Blockchain();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users");

        reference.orderByChild("adhaar").equalTo(adh).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    adhaar.setError("Aadhaar number already registered");
                    adhaar.requestFocus();
                    return;
                }
                else{
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                maxId = (int) snapshot.getChildrenCount();

                                try {
                                    blockchain.AddVoter(maxId);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    mAuth.createUserWithEmailAndPassword(emaill, pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        voterReg vot = new voterReg(FirstName, LastName, emaill, adh, d, maxId);
                                        FirebaseDatabase.getInstance().getReference("Users")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(vot).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(register.this, "Successfully Registered. Please verify your email", Toast.LENGTH_LONG).show();
                                                    Intent register_act = new Intent(getApplicationContext(), log_in.class);
                                                    startActivity(register_act);
                                                } else {
                                                    Toast.makeText(register.this, "Error", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    } else {
                                        Toast.makeText(register.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }

                                }
                            });
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String dat = makeDateString(day, month, year);
                date.setText(dat);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);

    }

    private String makeDateString(int day, int month, int year) {
        return day + "/" + month + "/" + year;
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }
}
