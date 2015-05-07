package com.andani.animesh.filestorage1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends ActionBarActivity
{
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);

    }
    public void intCache(View v)
    {
        File file=getCacheDir();
        String data=editText.getText().toString();
        File myfile=new File(file,"file1.txt");
         writedata(myfile,data);

    }

    public void extcache(View v)
    {
        String data=editText.getText().toString();
        File file=getExternalCacheDir();

        File myfile=new File(file,"file2.txt");
        writedata(myfile,data);

    }
    public void extprivate(View v)
    {
        File file=getExternalFilesDir("andani");
        String data=editText.getText().toString();
        File myfile=new File(file,"file3.txt");
        writedata(myfile,data);
    }
    public void extpublic(View v)
    {
        File file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS);
        String data=editText.getText().toString();
        File myfile=new File(file,"file4.txt");
        writedata(myfile,data);
    }
    public void next(View v)
    {
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
        Toast.makeText(this,"going to next page",Toast.LENGTH_LONG).show();
    }
    private   void writedata(File myfile,String data)
    {
        FileOutputStream outputStream=null;
        try
        {

            outputStream=new FileOutputStream(myfile);
            outputStream.write(data.getBytes());
            Toast.makeText(this,data+" was written succesfully at "+myfile.getAbsolutePath(),Toast.LENGTH_LONG).show();
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
       finally
        {
            if(outputStream!=null)
            {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
