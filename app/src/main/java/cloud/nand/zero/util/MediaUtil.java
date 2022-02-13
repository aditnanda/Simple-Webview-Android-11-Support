package cloud.nand.zero.util;

import android.content.ContentResolver;
import android.content.Context;

/**
 * Media Utilities
 *
 * @author mcharima5@gmail.com, @redevelopment by aditnanda@nand.cloud
 * @since 2020
 */
public class MediaUtil {

    public static ContentResolver getContentResolver(Context context) {
        return context.getApplicationContext().getContentResolver();
    }
}
