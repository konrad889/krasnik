package tomczyk.konrad.krasnik.base;

import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import tomczyk.konrad.krasnik.MainActivity;

/**
 * Created by Konrad_Tomczyk on 31.08.2016.
 */
public class BaseFragment extends Fragment {

    public static Toolbar toolbar;

    public BaseFragment() {

    }

    public Toolbar initializeToolbarForView(int resourceMenuId, Toolbar.OnMenuItemClickListener onMenuItemClickListener, Integer titleResId) {

        try {
            if (toolbar == null) toolbar = ((MainActivity) getActivity()).getToolbar();
            toolbar.getMenu().clear();
            toolbar.inflateMenu(resourceMenuId);
            toolbar.setOnMenuItemClickListener(onMenuItemClickListener);
            if (titleResId != null) toolbar.setTitle(titleResId);
        } catch (Exception e) {
            System.err.println("Toolbar got here from other module/activity, and it was unable to set card module toolbar" + Log.getStackTraceString(e));
        }
        return toolbar;
    }
}
