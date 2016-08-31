package tomczyk.konrad.krasnik.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import tomczyk.konrad.krasnik.R;
import tomczyk.konrad.krasnik.base.BaseFragment;

/**
 * Created by Konrad_Tomczyk on 31.08.2016.
 */
public class LoginFragment extends BaseFragment implements LoginFragmentPresenter.loginInterface {

    public ViewHolder layout;

    public static class ViewHolder {

        public ViewHolder(View root) {

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        layout = new ViewHolder(root);

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
