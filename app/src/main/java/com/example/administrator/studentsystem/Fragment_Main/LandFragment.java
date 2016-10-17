package com.example.administrator.studentsystem.Fragment_Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.studentsystem.R;
import com.example.administrator.studentsystem.SharedUitl;
import com.example.administrator.studentsystem.SqlFH.MainActivity;

/**
 * Created by Administrator on 2016/8/17.
 */
public class LandFragment extends Fragment{

    private Button land;
    private EditText names,pwd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.land_fragment,container,false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        names = (EditText) view.findViewById(R.id.name);
        pwd = (EditText) view.findViewById(R.id.passworid);
        names.setText(SharedUitl.getInstance(getContext()).getSPData());
        pwd.setText(SharedUitl.getInstance(getContext()).getSPData2());
        land= (Button) view.findViewById(R.id.land_fragment);
        land.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
//                String a =SharedUitl.getInstance(getContext()).getSPData();
//                String b =SharedUitl.getInstance(getContext()).getSPitem2();
//                if(a.equals("学生")) {
//                    Toast.makeText(getContext(), "欢迎你:" + a + "同学" + "你的权限为" + b, Toast.LENGTH_LONG).show();
//                }else if(a.equals("教师")){
//                    Toast.makeText(getContext(),"欢迎你:"+a+"老师"+"你的权限为"+b,Toast.LENGTH_LONG).show();
//                }
            }
        });
    }
}
