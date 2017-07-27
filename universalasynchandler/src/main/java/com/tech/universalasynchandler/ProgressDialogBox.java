package com.tech.universalasynchandler;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public class ProgressDialogBox {
	  private static final String TAG = "ProgressDialogBox";
	    private static final String LOADING = "Loading...";

	    private static ProgressDialog progress;

	    private ProgressDialogBox()
	    {
	        // Singleton class
	    }

	    public static void show(final Context context, final ProcessCancelListener processCancelListener, String message)
	    {
	        close();
	        progress = new ProgressDialog(context);
	        progress.setMessage(message);
	        progress.setIndeterminate(true);
	        progress.setCancelable(false);

	        if (processCancelListener != null)
	        {
	            progress.setOnCancelListener(new OnCancelListener()
	            {
	                @Override
	                public void onCancel(DialogInterface dialog)
	                {
	                    processCancelListener.processCanceled();
	                }
	            });
	        }

	        if (progress == null)
	            return;
	        synchronized (progress)
	        {
	            try
	            {
	            	if(progress!=null)
	                progress.show();
	            } catch (Exception e)
	            {
	                AppLogs.printLogs(TAG, e.toString());
	            }
	        }
	    }

	    static void close()
	    {
	        try
	        {
	            if (progress != null)
	            {
	                synchronized (progress)
	                {
	                    progress.dismiss();
	                    progress = null;
	                }
	            }
	        } catch (Exception e)
	        {
				AppLogs.printLogs(TAG, e.toString());
	        }
	    }
}
