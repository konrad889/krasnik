package tomczyk.konrad.krasnik.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import tomczyk.konrad.krasnik.R;
import tomczyk.konrad.krasnik.base.BaseFragment;

/**
 * Created by Konrad_Tomczyk on 31.08.2016.
 */
public class LoginFragment extends BaseFragment implements LoginFragmentPresenter.loginInterface {

    public ViewHolder layout;

    public static class ViewHolder {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
