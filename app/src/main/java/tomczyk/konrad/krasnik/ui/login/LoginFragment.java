package tomczyk.konrad.krasnik.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import tomczyk.konrad.krasnik.R;
import tomczyk.konrad.krasnik.base.BaseFragment;
import tomczyk.konrad.krasnik.models.User;

/**
 * Created by Konrad_Tomczyk on 31.08.2016.
 */
public class LoginFragment extends BaseFragment implements LoginFragmentPresenter.loginInterface {

    private static final String TAG = "MainActivity";

    public ViewHolder layout;

    public static class ViewHolder {


        public ViewHolder(View root) {
            ;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private boolean validateForm() {
        boolean result = true;


        return result;
    }


}
