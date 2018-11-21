package com.zecollokaris.cryptocurrency;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Tab2 extends Fragment {
    Button mRegisterBtn;
    EditText username, email, password;
    FirebaseAuth auth;
    DatabaseReference reference;
    private void register(String username, String email,String password){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(getActivity(),new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                 if(task.isSuccessful()){
                     Log.d("SUCCESS","SUCCESS");
                 }
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
          View view=inflater.inflate(R.layout.fragment_tab2, container, false);
          mRegisterBtn=(Button) view.findViewById(R.id.registerBtn);
          username = view.findViewById(R.id.username);
          email = view.findViewById(R.id.email);
          password = view.findViewById(R.id.password);
          auth = FirebaseAuth.getInstance();
          mRegisterBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  register();
              }
          });
          return view;
    }

}
