package com.example.bbs;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public abstract class SiteAsyncTask<Input, Progress, Result> extends AsyncTask<Input, Progress, Result>{

    protected ProgressDialog pdlg = null;
    protected Context mContext = null;

    public SiteAsyncTask( Context context ) {
        this.mContext = context;
    }

    @Override
    protected void onPreExecute() {
        pdlg = new ProgressDialog(this.mContext);
        pdlg.setMessage("기달려....");
        pdlg.show();
    }


    @Override
    protected void onPostExecute(Result list) {
        if( pdlg != null ){
            pdlg.dismiss();
            pdlg = null;
        }
    }
}