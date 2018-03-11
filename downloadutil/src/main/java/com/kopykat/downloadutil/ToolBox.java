package com.kopykat.downloadutil;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;

/**
 * Created by zero on 11.03.18.
 */

public class ToolBox {

    Context context;

    public ToolBox(Context context) {
        this.context = context;
    }

    //Open downloaded folder
    private void openDownloadedFolder() {
        //First check if SD Card is present or not
        if (new CheckForSDCard().isSDCardPresent()) {

            //Get Download Directory File
            File apkStorage = new File(Environment.getExternalStorageDirectory() + "/" + Utils.downloadDirectory);

            //If file is not present then display Toast
            if (!apkStorage.exists())
                Toast.makeText(context, "Right now there is no directory. Please download some file first.", Toast.LENGTH_SHORT).show();

            else {
                //If directory is present Open Folder
                /** Note: Directory will open only if there is a app to open directory like File Manager, etc.  **/

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath() + "/" + Utils.downloadDirectory);
                intent.setDataAndType(uri, "file/*");
                context.startActivity(Intent.createChooser(intent, "Open Download Folder"));
            }

        } else
            Toast.makeText(context, "Oops!! There is no SD Card.", Toast.LENGTH_SHORT).show();

    }

    //Check if internet is present or not
    private boolean isConnectingToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

}
