package com.feet.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.viewpagerdemo.pojo.FirstModel
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

object CommonUtils {



    private var progressBarDialog: Dialog? = null

//    fun showwLoader(context: Context?, message: String) {
//        if (progressBarDialog == null && context != null) {
//            val view = LayoutInflater.from(context).inflate(R.layout.custom_loader, null)
//            progressBarDialog = Dialog(context)
//            progressBarDialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
//            progressBarDialog?.setContentView(view)
//            progressBarDialog?.setCancelable(false)
//            progressBarDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            view.bringToFront()
////            view.loadingMessage.text = message
//            progressBarDialog?.setCancelable(false)
//            progressBarDialog?.show()
//        }
//    }

    fun hideLoader() {
        if (progressBarDialog != null) {
            progressBarDialog?.dismiss()
            progressBarDialog = null
        }
    }

    fun parseError(response: Response<FirstModel>?): String? {

        return when (response?.code()) {
            401 -> "Unauthorized"
            403 -> "Forbidden"
            405 -> "Method not allowed"
            400, 404, 422 -> {
                if (response.errorBody() != null) {
                    try {
                        val error: FirstModel = Gson().fromJson(
                            response.errorBody()?.string(),
                            FirstModel::class.java
                        )
                        return  "Not Found"
                    } catch (e: Exception) {
                        return "Not Found"
                    }
                } else {
                    return "Something went wrong"
                }
            }
            429 -> "Too Many Requests"
            500 -> "Internal Server Error"
            503 -> "Service Unavailable"
            else -> "Something went wrong"
        }
    }

    fun isLink(text: String): Boolean {
        return text.contains("http")
    }

    fun isValidEmail(email: String): Boolean {
        return (!email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches())
    }

    fun showMessage(view: View?, msg: String) {
        if (view != null)
            Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show()
    }

//    fun savePrefs(context: Context?, key: String, value: String?) {
//        if (context != null && value != null) {
//            val prefs = context.getSharedPreferences(PrefConstants.PREF_NAME, Context.MODE_PRIVATE)
//            val editor = prefs.edit()
//            editor.putString(key, value)
//            editor.apply()
//        }
//    }

//    fun getPrefValue(context: Context?, key: String): String {
//        val prefs = context?.getSharedPreferences(PrefConstants.PREF_NAME, Context.MODE_PRIVATE)
//        return prefs?.getString(key, "").toString()
//    }


    fun utc_to_local(time: String): String {
        var resultDate = ""
        val df = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH)
        df.timeZone = TimeZone.getTimeZone("UTC")
        val date = df.parse(time)
        df.timeZone = TimeZone.getDefault()
        val af = SimpleDateFormat("EE, HH:mm", Locale.ENGLISH)
        resultDate = af.format(date)
        Log.e("actual date", resultDate)
        return resultDate
    }

    fun hideKeyboard(view: View, activity: Activity) {
        val imm =
            activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

//    fun showDialogUnAuthorized(
//        context: Activity,
//        isLogin: Boolean,
//        view: View
//    ) {
//        val dialog = Dialog(context)
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setCancelable(false)
//        dialog.setContentView(R.layout.dialog_aunthorised)
//        val btn_login = dialog.findViewById(R.id.btn_login) as TextView
//        btn_login.setOnClickListener {
//            if (isLogin) {
//                navController = Navigation.findNavController(context, R.id.main_nav_fragment)
////               val navOptions =  NavOptions.Builder().setPopUpTo(R.id.loginFragment, true).build();
//                Navigation.findNavController(context, R.id.main_nav_fragment)
//                    .popBackStack(R.id.nav_graph, true)
//
//                context.let {
//                    navController.navigate(R.id.loginFragment)
//                }
//
//                dialog.dismiss()
//
//            } else {
//                context.finish()
//                dialog.dismiss()
//
//            }
//        }
//
//        dialog.show()
//
//    }

  /*  fun imageLoader(activity: Activity): CircularProgressDrawable {
        val circularProgressDrawable = CircularProgressDrawable(activity)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        return circularProgressDrawable
    }*/
}