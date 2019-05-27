package br.com.lucasfrancisco.exemplointroscreen.data;

import android.content.Context;

public class SPInfo {

    private Context context;

    public SPInfo(Context context) {
        this.context = context;
    }

    public void updateIntroStatus(boolean isStatus) {
        context.getSharedPreferences("PREF", Context.MODE_PRIVATE).edit().putBoolean("status", isStatus).apply();
    }

    public boolean isIntroActivityShown() {
        return context.getSharedPreferences("PREF", Context.MODE_PRIVATE).getBoolean("status", false);
    }
}
