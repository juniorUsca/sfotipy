package com.debugcomputercompany.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Outline;
import android.media.Image;
import android.os.Bundle;
import android.os.Debug;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public EditText editText;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Debug.startMethodTracing("calc");
        setContentView(R.layout.activity_main);

        int size = getResources().getDimensionPixelSize(R.dimen.fab_size);
        Outline outline = new Outline();
        outline.setOval(0,0,size,size);
        ImageButton imageButton = (ImageButton) findViewById(R.id.fab_I);
        //imageButton.set
        //imageButton.setOutlineProvider( (ViewOutlineProvider) (outline));
    }

    public void onClick(View view) {
        /*editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);

        textView.setText("Hola "+editText.getText().toString());*/
        Toast.makeText(this, "Hola estoy escuchando!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MyMusic.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        //Debug.stopMethodTracing();
        super.onDestroy();
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

}
