package cloud.nand.zero.activity;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Abstract base activity
 *
 * @author mcharima5@gmail.com, @redevelopment by aditnanda@nand.cloud
 * @since 2018
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Context getContext() {
        return this;
    }

    protected Activity getActivity() {
        return this;
    }

}
