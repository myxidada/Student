package com.example.administrator.studentsystem;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/8/17.
 */
public class SharedUitl {

    private SharedPreferences sp;

    public final String FILE_NAME="title";

    private static SharedUitl shareUitl;

    private SharedUitl(Context context){
        sp =context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
    }

    public static SharedUitl getInstance(Context context){
        if(shareUitl == null){
            shareUitl = new SharedUitl(context);
        }
        return shareUitl;
    }


    //存
    public void steSPData(String userName,String password){
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("userName",userName).putString("password",password);
        editor.commit();
    }

    //存权限和名字
    public void setSpData3(String name, String quanxian){
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("name",name).putString("quanxian",quanxian);
        editor.commit();
    }
    //取
    public String getSPData(){
        return sp.getString("userName",null);
    }
    public String getSPData2(){
        return sp.getString("password",null);
    }

    public String getSPitem1(){
        return sp.getString("name",null);
    }
    public String getSPitem2(){
        return sp.getString("quanxian",null);
    }


}
