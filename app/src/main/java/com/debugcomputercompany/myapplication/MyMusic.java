package com.debugcomputercompany.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.debugcomputercompany.myapplication.Fragments.AmigosFragment;
import com.debugcomputercompany.myapplication.Fragments.DestacadosFragment;
import com.debugcomputercompany.myapplication.Fragments.ProfileFragment;

public class MyMusic extends Activity implements ActionBar.TabListener {

    private Fragment[] fragments = new Fragment[]{
            new DestacadosFragment(),
            new AmigosFragment(),
            new ProfileFragment()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_music);
        setTabs();

        FragmentManager manager = getFragmentManager();
        FragmentTransaction fragmentTransaction= manager.beginTransaction();
        for (Fragment fragment : fragments){
            fragmentTransaction.add(R.id.main_music, fragment).hide(fragment);
        }
        fragmentTransaction.show(fragments[0]).commit();

        int size = getResources().getDimensionPixelSize(R.dimen.fab_size);
        Outline outline = new Outline();
        outline.setOval(0, 0, size, size);
        //ImageButton imageButton = (ImageButton) findViewById(R.id.fab_I);
    }

    private void setTabs(){
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(actionBar.newTab().setText("Musica").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Amigos").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Perfil").setTabListener(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_music, menu);
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
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        for (Fragment fragment : fragments){
            ft.hide(fragment);
        }
        ft.show(fragments[tab.getPosition()]);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
