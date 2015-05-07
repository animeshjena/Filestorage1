package com.andani.animesh.filestorage1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainActivity2 extends ActionBarActivity {
TextView textView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        textView=(TextView)findViewById(R.id.textView);
    }

    public void saveintcache(View v)
    {
        File myfile=getCacheDir();
        File file=new File(myfile,"file1.txt");
        String data=readdata(file);
        if (data!=null)
        {
            textView.setText(data);
        }
        else
        {
            textView.setText("no data found");
        }
    }

    public void saveextcache(View v)
    {
        File myfile=getExternalCacheDir();
        File file=new File(myfile,"file2.txt");
        String data=readdata(file);
        if (data!=null)
        {
            textView.setText(data);
        }
        else
        {
            textView.setText("no data found");
        }
    }

    public void saveextprivate(View v)
    {
        File myfile=getExternalFilesDir("andani");
        File file=new File(myfile,"file3.txt");
        String data=readdata(file);
        if (data!=null)
        {
            textView.setText(data);
        }
        else
        {
            textView.setText("no data found");
        }

    }

    public void saveextpublic(View v)
    {
        File myfile= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS);
        File file=new File(myfile,"file4.txt");
        String data=readdata(file);
        if (data!=null)
        {
            textView.setText(data);
        }
        else
        {
            textView.setText("no data found");
        }

    }

    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "going back to main page", Toast.LENGTH_LONG).show();
    }

    private String readdata(File file) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fileInputStream.read()) != -1)
            {
                buffer.append((char) read);
            }

            return buffer.toString();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();


        }
        finally {
            if(fileInputStream!=null)
            {
                try
                {
                    fileInputStream.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    return null;

    }

}
