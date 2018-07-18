package sahalpreapp.sahal_preapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Frag2 extends Fragment {
    EditText email ;
    EditText password ;
    Button btn ;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email = view.findViewById(R.id.email_text);
        password = view.findViewById(R.id.pass_text);

        btn = view.findViewById(R.id.btn_sign) ;


    }

    @Nullable
    @Override
public View onCreateView (LayoutInflater inflater , @Nullable ViewGroup container , @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_signup__coustmer_,container,false);
    }

    public void doSign(View view) {

    }
}
