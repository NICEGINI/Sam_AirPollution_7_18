package com.example.kcs.airpollution_7_18;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * Created by KCS on 2016-07-18.
 */
public class PA extends PagerAdapter {
    private LayoutInflater mInflater;
    private JSONArray airdata;
    private int ObjCount;

    public PA(LayoutInflater inflater, JSONArray airdata){
        super();
        mInflater = inflater;
        this.airdata = airdata;
        this.ObjCount = airdata.length();
    }

    public void SetTable(View v_table, int position){
        TextView tv_time_val = (TextView)v_table.findViewById(R.id.tv_time_val);
        TextView tv_co_val = (TextView)v_table.findViewById(R.id.tv_co_val);
        TextView tv_co2_val = (TextView)v_table.findViewById(R.id.tv_co2_val);
        TextView tv_no2_val = (TextView)v_table.findViewById(R.id.tv_no2_val);
        TextView tv_so2_val = (TextView)v_table.findViewById(R.id.tv_so2_val);
        TextView tv_pm_val = (TextView)v_table.findViewById(R.id.tv_pm2_5_val);
        TextView tv_o3_val = (TextView)v_table.findViewById(R.id.tv_o3_val);

        try
        {
            JSONObject obj = this.airdata.getJSONObject(position);
            tv_time_val.setText(obj.getString("time"));
            tv_co_val.setText(obj.getString("co"));
            tv_co2_val.setText(obj.getString("co2"));
            tv_so2_val.setText(obj.getString("so2"));
            tv_no2_val.setText(obj.getString("no2"));
            tv_pm_val.setText(obj.getString("pm2.5"));
            tv_o3_val.setText(obj.getString("o3"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCount(){
        return ObjCount; //can change
    }

    @Override
    public Object instantiateItem(ViewGroup pager, int position){
        View currentView = null;
        currentView = mInflater.inflate(R.layout.airpollutionpable_data, null);

        SetTable(currentView, position);
        ((ViewPager)pager).addView(currentView);

        return currentView;
    }

    @Override
    public void destroyItem(ViewGroup pager, int position, Object view){
        ((ViewPager)pager).removeView((View)view);
    }
    @Override
    public boolean isViewFromObject(View pager, Object obj){
        return pager == obj;
    }

    @Override public void restoreState(Parcelable arg0, ClassLoader arg1){}
    @Override public Parcelable saveState(){return null;}
}
