package lc.szy.bestci.utils

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * 不定义LONG的Toast是因为short就够了
 */
fun Context.toast(message: String) {
    val toast = Toast.makeText(this, null, Toast.LENGTH_SHORT)
    toast.setText(message)
    toast.show()
}

fun Context.toastLong(message: String) {
    val toast = Toast.makeText(this, null, Toast.LENGTH_LONG)
    toast.setText(message)
    toast.show()
}

fun Fragment.toast(message: String) {
    val toast = Toast.makeText(this.context, null, Toast.LENGTH_SHORT)
    toast.setText(message)
    toast.show()
}

val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )