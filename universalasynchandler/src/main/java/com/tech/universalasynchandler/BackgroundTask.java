package com.tech.universalasynchandler;

import android.content.Context;
import android.os.AsyncTask;

public class BackgroundTask extends AsyncTask<Void, Void, Object> {

	private BackgroundThread bgtask;
	private Context context;
	private boolean isCancelled;
	private String loadingMessage;

	public BackgroundTask(Context context, BackgroundThread bgtask,
                          String loadingMessage) {
		this.context = context;
		this.bgtask = bgtask;
		this.loadingMessage = loadingMessage;
	}


	@Override
	protected void onPreExecute() {
		ProgressDialogBox.show(context, new ProcessCancelListener() {
			@Override
			public void processCanceled() {
				isCancelled = true;
				cancel(true);
				
			}
		}, loadingMessage);
	}

	@Override
	protected Object doInBackground(Void... params) {
		return bgtask.runTask();
	}

	@Override
	protected void onPostExecute(Object data) {
		ProgressDialogBox.close();
		if (!isCancelled) {
			bgtask.taskCompleted(data);
		}
	}

	@Override
	protected void onCancelled() {
		ProgressDialogBox.close();
		super.onCancelled();
	}

}
