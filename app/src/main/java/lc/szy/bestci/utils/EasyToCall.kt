package lc.szy.bestci.utils

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import es.dmoral.toasty.Toasty
import lc.szy.bestci.App
import java.util.*

sealed class ToastType {
    object Error : ToastType()
    object Success : ToastType()
    object Info : ToastType()
    object Warning : ToastType()
    object Normal : ToastType()
}

/**
 * 不定义LONG的Toast是因为short就够了
 */
fun Context.toast(message: String, toastType: ToastType = ToastType.Normal) {
    when (toastType) {
        ToastType.Error -> Toasty.error(this, message, Toast.LENGTH_SHORT).show()
        ToastType.Success -> Toasty.success(this, message, Toast.LENGTH_SHORT).show()
        ToastType.Info -> Toasty.info(this, message, Toast.LENGTH_SHORT).show()
        ToastType.Warning -> Toasty.warning(this, message, Toast.LENGTH_SHORT).show()
        ToastType.Normal -> Toasty.normal(this, message, Toast.LENGTH_SHORT).show()
    }
}

fun Context.toastLong(message: String, toastType: ToastType = ToastType.Normal) {
    when (toastType) {
        ToastType.Error -> Toasty.error(this, message, Toast.LENGTH_LONG).show()
        ToastType.Success -> Toasty.success(this, message, Toast.LENGTH_LONG).show()
        ToastType.Info -> Toasty.info(this, message, Toast.LENGTH_LONG).show()
        ToastType.Warning -> Toasty.warning(this, message, Toast.LENGTH_LONG).show()
        ToastType.Normal -> Toasty.normal(this, message, Toast.LENGTH_LONG).show()
    }
}

fun Fragment.toast(message: String, toastType: ToastType = ToastType.Normal) {
    context?.run {
        when (toastType) {
            ToastType.Error -> Toasty.error(this, message, Toast.LENGTH_SHORT).show()
            ToastType.Success -> Toasty.success(this, message, Toast.LENGTH_SHORT).show()
            ToastType.Info -> Toasty.info(this, message, Toast.LENGTH_SHORT).show()
            ToastType.Warning -> Toasty.warning(this, message, Toast.LENGTH_SHORT).show()
            ToastType.Normal -> Toasty.normal(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}

fun loadImage(imageView: ImageView, url: String, defaultDrawable: Int) {
    Glide.with(App.application).load(url)
        .placeholder(defaultDrawable)
        .into(imageView)
}

fun getCalendar(year: Int, month: Int, date: Int, hour: Int, minute: Int, second: Int) =
    Calendar.getInstance().apply {
        set(Calendar.YEAR, year)
        //10表示11月，需要-1
        set(Calendar.MONTH, month - 1)
        set(Calendar.DATE, date)
        set(Calendar.HOUR_OF_DAY, hour)
        set(Calendar.MINUTE, minute)
        set(Calendar.SECOND, second)
    }

val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )