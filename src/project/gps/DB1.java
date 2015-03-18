package project.gps;
	import java.util.ArrayList;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


	public class DB1 {
ArrayList<bean> nameList;
bean b;
		 SQLiteDatabase sqlite = null;
		 public DB1(){}
		 public boolean openMyDb()
		 {
			 sqlite = SQLiteDatabase.openDatabase("/sdcard/taxiDb.sqlite", null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
			 if(sqlite!=null)
			 {
				
				 return true;
			 }
			 else
			 { 
				 return false;
			 }
					 
			 
		 }
		 public boolean closeMyDb()
		 {
			 if(sqlite!=null)
			 {
				 sqlite.close();
				 return true;
			 }
			 else return false;
		 }
		 public boolean insertMyDb(String tdphno,String tname,String tano,String start_loc,String des_loc,String cname1,String date1,String distance,String cost)
		 {
			 openMyDb();
			 System.out.println("insert  reached");
			 long l = -1;
			 ContentValues cv = new ContentValues();
			 cv.put("taxidriverphno",tdphno);
			 cv.put("taxidrivername",tname);
			 cv.put("taxino",tano);
			 cv.put("startlocation",start_loc);
			 cv.put("deslocation",des_loc);
			 cv.put("customername",cname1);
			 cv.put("date",date1);
			 cv.put("distance", distance);
			 cv.put("cost", cost);
			
			 	
			 l = sqlite.insert("taxiinfo", null, cv);
			 if(l==-1)
			 {
				  return false;
			 }
			
			 System.out.println("inserted");
			 closeMyDb();
			 return true;
		 }
		 public ArrayList<bean> retriveUsernameList(String dt)
			{
			 //retrieve for total distance on a specific date
			 openMyDb();
			 Cursor cursor= sqlite.query("taxiinfo", null, "date="+"'"+dt+"'" ,null, null, null, null, null);
	
			  nameList= new ArrayList<bean>();
				b= new bean();
				while(cursor.moveToNext())
				{
				String taxidrivername=cursor.getString(1);
				String taxino=cursor.getString(2);
				String custname=cursor.getString(5);
				b.setTaxidrivername(taxidrivername);
				b.setTaxino(taxino);
				b.setCustomername(custname);
				nameList.add(b);
				}
				closeMyDb();
				return nameList;
			}
		 public ArrayList<bean> retrivecustomernameList(String name)
			{
             //retrieve for specific customer name
			 openMyDb();
			 Cursor cursor= sqlite.query("taxiinfo", null, "customername="+"'"+name+"'" ,null, null, null, null, null);
			  nameList= new ArrayList<bean>();
				b= new bean();
				while(cursor.moveToNext())
				{
				String taxidrivername=cursor.getString(1);
				String taxino=cursor.getString(2);
				String custname=cursor.getString(5);
				b.setTaxidrivername(taxidrivername);
				b.setTaxino(taxino);
				b.setCustomername(custname);
				nameList.add(b);
				}
				closeMyDb();
				return nameList;
	
			}
		 
		 
		 public ArrayList<bean> retrivetaxinumberList(String taxin)
			{
       
			 openMyDb();
			 Cursor cursor= sqlite.query("taxiinfo", null, "taxino="+"'"+taxin+"'" ,null, null, null, null, null);
			  nameList= new ArrayList<bean>();
				b= new bean();
				while(cursor.moveToNext())
				{
				String taxidrivername=cursor.getString(1);
				String taxino=cursor.getString(2);
				String custname=cursor.getString(5);
				b.setTaxidrivername(taxidrivername);
				b.setTaxino(taxino);
				b.setCustomername(custname);
				nameList.add(b);
				}
				closeMyDb();
				return nameList;
			}
	}
		


