package g.star.iota.milk.ui.widget.today;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class TodayInHistoryWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        context.startService(new Intent(context, TodayInHistoryService.class));
    }

    @Override
    public void onEnabled(Context context) {
        context.startService(new Intent(context, TodayInHistoryService.class));
    }

    @Override
    public void onDisabled(Context context) {
        context.stopService(new Intent(context, TodayInHistoryService.class));
    }

    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        context.startService(new Intent(context, TodayInHistoryService.class));
    }
}
