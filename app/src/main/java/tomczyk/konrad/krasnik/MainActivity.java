package tomczyk.konrad.krasnik;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    public ViewHolder layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public Toolbar getToolbar() {
        return layout.toolbar;
    }

    public static class ViewHolder {
        public Toolbar toolbar;

        public ViewHolder(Activity a) {
            toolbar = (Toolbar) a.findViewById(R.id.toolbar);
        }
    }
}
