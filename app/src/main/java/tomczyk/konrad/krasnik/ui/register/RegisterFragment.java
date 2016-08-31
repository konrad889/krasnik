package tomczyk.konrad.krasnik.ui.register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tomczyk.konrad.krasnik.R;
import tomczyk.konrad.krasnik.base.BaseFragment;

/**
 * Created by Konrad_Tomczyk on 31.08.2016.
 */
public class RegisterFragment extends BaseFragment implements RegisterFragmentPresenter.registerInterface {

    public ViewHolder layout;

    public static class ViewHolder {

        public ViewHolder(View root) {

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register, container, false);
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
