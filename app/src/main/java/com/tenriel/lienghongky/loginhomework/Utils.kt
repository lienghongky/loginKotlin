import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class PreferenceHelper {
    var context:Context
    constructor(context: Context){
        this.context = context
    }


    fun defaultPrefs(): SharedPreferences
            = PreferenceManager.getDefaultSharedPreferences(context)

    fun customPrefs(name: String): SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }
}