package com.example.administrator.studentsystem.Fragment_Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.studentsystem.MainActivityT;
import com.example.administrator.studentsystem.MyRecyclerAdapter;
import com.example.administrator.studentsystem.R;
import com.example.administrator.studentsystem.SharedUitl;
import com.example.administrator.studentsystem.SqlFH.MainActivity;

/**
 * Created by Administrator on 2016/8/17.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {

    private TextView main_textView_permission,main_textView_userName;
    private RecyclerView main_recyclerView;
    private MyRecyclerAdapter adapter = new MyRecyclerAdapter();
    private EditText name, pwdr, pwdr2;
    private Button bt;
    private Spinner sp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.register_fragment, container, false);
    }
    
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name = (EditText) view.findViewById(R.id.name_r);
        pwdr = (EditText) view.findViewById(R.id.passworid_r);
        pwdr2 = (EditText) view.findViewById(R.id.passworid_r2);
        sp= (Spinner) view.findViewById(R.id.sp);
        bt = (Button) view.findViewById(R.id.register_fragment);
        bt.setOnClickListener(this);
        //侧滑相关控件
    }

    private void init() {

    }

    @Override
    public void onClick(View view) {
              if(name.getText().toString().trim().length()<4){
            Toast.makeText(getContext(),"用户名不能小于4个字符",Toast.LENGTH_SHORT).show();
        }else if(pwdr2.getText().toString().trim().length()<6){
            Toast.makeText(getContext(), "密码不能小于8个字符", Toast.LENGTH_SHORT).show();
        }else if(!pwdr.getText().toString().equals(pwdr2.getText().toString())){
            Toast.makeText(getContext(),"两次输入的密码不一致",Toast.LENGTH_SHORT).show();
        }else {
                  SharedUitl.getInstance(getContext()).steSPData(name.getText().toString(), pwdr.getText().toString());
                  SharedUitl.getInstance(getContext()).setSpData3(sp.getSelectedItem().toString(), sp.getSelectedItem().toString());
                  Intent intent = new Intent(getContext(), MainActivity.class);
                  startActivity(intent);
//                  String a =SharedUitl.getInstance(getContext()).getSPData();
//                  String b =SharedUitl.getInstance(getContext()).getSPitem2();
//                  if(a.equals("学生")) {
//                      Toast.makeText(getContext(), "欢迎你:" + a + "同学" + "你的权限为" + b, Toast.LENGTH_LONG).show();
//                  }else if(a.equals("教师")){
//                      Toast.makeText(getContext(),"欢迎你:"+a+"老师"+"你的权限为"+b,Toast.LENGTH_LONG).show();
//                  }
              }
    }
}

