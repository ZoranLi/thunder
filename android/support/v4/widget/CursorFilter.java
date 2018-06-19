package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class CursorFilter extends Filter {
    CursorFilterClient mClient;

    interface CursorFilterClient {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    CursorFilter(CursorFilterClient cursorFilterClient) {
        this.mClient = cursorFilterClient;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.mClient.convertToString((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        charSequence = this.mClient.runQueryOnBackgroundThread(charSequence);
        FilterResults filterResults = new FilterResults();
        if (charSequence != null) {
            filterResults.count = charSequence.getCount();
            filterResults.values = charSequence;
        } else {
            filterResults.count = null;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        charSequence = this.mClient.getCursor();
        if (filterResults.values != null && filterResults.values != charSequence) {
            this.mClient.changeCursor((Cursor) filterResults.values);
        }
    }
}
