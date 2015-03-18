 package project.gps;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class taxi extends Activity{
	ListView lv=null;
	MyAdapter myAdapter2;
	DB1 db3;
	int j;
	boolean b;
	ArrayList<bean> mylist2 = null;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        
        Intent it2= getIntent();
        String s2=it2.getStringExtra("taxi");
        lv=(ListView)findViewById(R.id.mylist);
        db3=new DB1();
        mylist2 = new ArrayList<bean>();
        mylist2=db3.retrivetaxinumberList(s2);     
        myAdapter2 = new MyAdapter(this,0,mylist2);
        lv.setAdapter(myAdapter2);
      }
}

