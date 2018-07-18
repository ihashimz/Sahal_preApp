package sahalpreapp.sahal_preapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;


public class Frag1 extends Fragment {

    private FirebaseAuth mAuth;
// ...


    EditText password , email ;
    TextView mylabel;
    Button signup;




    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

        email =  view.findViewById(R.id.email_text);
        password = view.findViewById(R.id.pass_text);



        mylabel = view.findViewById(R.id.myLabel);

        signup = view.findViewById(R.id.btn_do);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final  String emailTxt,passTxt ;
                emailTxt = email.getText().toString().trim();
                passTxt = password.getText().toString().trim();


                mAuth.createUserWithEmailAndPassword(emailTxt, passTxt)
                        .addOnCompleteListener((Activity) v.getContext(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("test", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(view.getContext(), "Authentication True.",                                            Toast.LENGTH_SHORT).show();


                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("test", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(view.getContext(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    password.setText("");
                                    mylabel.setText("failed LogIn");
                                }

                                // ...
                            }
                        });
            }
        });


    }

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.frag_seller, container, false);
    }
}



