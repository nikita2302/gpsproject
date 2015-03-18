 package project.gps;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class name extends Activity{
	ListView lv=null;
	MyAdapter myAdapter1;
	DB1 db2;
	int j;
	boolean b;
	ArrayList<bean> mylist1 = null;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        
        Intent it2= getIntent();
        String s1=it2.getStringExtra("custom");
        lv=(ListView)findViewById(R.id.mylist);
        db2=new DB1();
        mylist1 = new ArrayList<bean>();
        mylist1=db2.retrivecustomernameList(s1);     
        myAdapter1 = new MyAdapter(this,0,mylist1);
        lv.setAdapter(myAdapter1);
      }
}



