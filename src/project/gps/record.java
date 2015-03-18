package project.gps;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class record extends Activity{
	ListView lv=null;
	MyAdapter myAdapter;
	DB1 db1;
	ArrayList<bean> mylist = null;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        Intent it1= getIntent();
        String s=it1.getStringExtra("01/01/01");
        lv=(ListView)findViewById(R.id.mylist);
        db1=new DB1();
        mylist = new ArrayList<bean>();
        mylist=db1.retriveUsernameList(s);     
        myAdapter = new MyAdapter(this,0,mylist);
        lv.setAdapter(myAdapter);
	}

}
