package com.example.datsan.ativity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.datsan.R;
import com.example.datsan.emptyFragment;
import com.example.datsan.fragment.phanrangFragment;
import com.example.datsan.fragment.q1Fragment;

import java.util.ArrayList;

public class bookingActivity extends AppCompatActivity {
    ArrayList<String> cityList,districtTPHCMList,districtNTList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_booking);
        Spinner citysp=findViewById(R.id.cityspinner);
        Spinner districtsp=findViewById(R.id.districtspinner);
        String [] city={"<--- Your city --->","Thanh pho Ho Chi Minh","Ninh Thuan"};
        final String [] HCM={"<--- District --->","Quan 1","Quan 2","Quan 3","Quan 4","Quan 5","Quan 6","Quan 7","Quan 8","Quan 9","Quan 10","Quan 11","Quan 12"};
        final String [] NT={"<--- District --->","Huyen Ninh Son","Huyen Ninh Phuoc","Huyen Bac Ai","Huyen Thuan Bac","Huyen Thuan Nam","Huyen Ninh Hai","Thanh pho Phan Rang Thap Cham"};
        ArrayAdapter<String> cityAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,city);
        ArrayAdapter<String> hcmAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,HCM);
        ArrayAdapter<String> ntAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,NT);
        citysp.setAdapter(cityAdapter);
        citysp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==1) {
                    districtsp.setAdapter(hcmAdapter);
                    districtsp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            Fragment fragment=null;
                            switch (i)
                            {
                                case 0:
                                    fragment=new emptyFragment();
                                    break;
                                case 1:
                                    fragment=new phanrangFragment();
                                    break;
                                case 2:
                                    fragment=new q1Fragment();
                                    break;
                                case 3:
                                    fragment=new q1Fragment();
                                    break;
                                case 4:
                                    fragment=new q1Fragment();
                                    break;
                                case 5:
                                    fragment=new q1Fragment();
                                    break;
                                case 6:
                                    fragment=new q1Fragment();
                                    break;
                                case 7:
                                    fragment=new q1Fragment();
                                    break;
                                case 8:
                                    fragment=new q1Fragment();
                                    break;
                                case 9:
                                    fragment=new q1Fragment();
                                    break;
                                case 10:
                                    fragment=new q1Fragment();
                                    break;
                                case 11:
                                    fragment=new q1Fragment();
                                    break;
                            }

                            getSupportFragmentManager().beginTransaction().replace(R.id.bookingarea,fragment).commit();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }
                else
                    {
                        districtsp.setAdapter(ntAdapter);
                        districtsp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                Fragment fragment=null;
                                switch (i)
                                {
                                    case 0:
                                        fragment= new emptyFragment();
                                        break;
                                    case 1:
                                        fragment=new phanrangFragment();
                                        break;
                                    case 2:
                                        fragment=new q1Fragment();
                                        break;
                                    case 3:
                                        fragment=new phanrangFragment();
                                        break;
                                    case 4:
                                        fragment=new q1Fragment();
                                        break;
                                    case 5:
                                        fragment=new phanrangFragment();
                                        break;
                                    case 6:
                                        fragment=new q1Fragment();
                                        break;
                                    case 7:
                                        fragment=new q1Fragment();
                                        break;
                                }
                                getSupportFragmentManager().beginTransaction().replace(R.id.bookingarea,fragment).commit();

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}