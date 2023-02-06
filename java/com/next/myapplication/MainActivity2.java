package com.next.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.next.myapplication.adapter.DepartmentAdapter;
import com.next.myapplication.adapter.ViewPager2Adapter;
import com.next.myapplication.model.VideoModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private List<VideoModel> departs;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<List<VideoModel>> listDetails;

    private String reg="https://firebasestorage.googleapis.com/v0/b/my-application1-c2efd.appspot.com/o/%D8%A7%D9%84%D8%AA%D8%B3%D8%AC%D9%8A%D9%84.mp4?alt=media&token=02d0e3a2-16b5-46b5-ac8e-cca07039943c";
    private String grades="https://firebasestorage.googleapis.com/v0/b/my-application1-c2efd.appspot.com/o/%D8%A7%D9%84%D9%88%D8%AB%D8%A7%D8%A6%D9%82%20%D9%88%D8%A7%D9%84%D8%AE%D8%B1%D9%8A%D8%AC%D9%8A%D9%86.mp4?alt=media&token=91663756-53b8-4e9a-a46d-d4187e746cab";
    private String blackBoard=
            "https://firebasestorage.googleapis.com/v0/b/my-application1-c2efd.appspot.com/o/%D8%A8%D9%84%D8%A7%D9%83%D8%A8%D9%88%D8%B1%D8%AF.mp4?alt=media&token=a13ee28d-ec9f-4964-8bba-6af5cbdbf869";
    private String qbol=
            "https://firebasestorage.googleapis.com/v0/b/my-application1-c2efd.appspot.com/o/%D8%B9%D9%85%D8%A7%D8%AF%D8%A9%20%D8%A7%D9%84%D9%82%D8%A8%D9%88%D9%84%20%D9%88%D8%A7%D9%84%D8%AA%D8%B3%D8%AC%D9%8A%D9%84.mp4?alt=media&token=48ad5d1e-2fed-42ec-96e3-15aaedbb1127";
    private String video5
            ="https://firebasestorage.googleapis.com/v0/b/my-application1-c2efd.appspot.com/o/%D8%B9%D9%85%D8%A7%D8%AF%D8%A9%20%D8%AA%D9%82%D9%86%D9%8A%D8%A9%20%D8%A7%D9%84%D9%85%D8%B9%D9%84%D9%88%D9%85%D8%A7%D8%AA.mp4?alt=media&token=1e609b8b-75e6-47a2-8a4d-0e15a302057f";

    private String video6
            ="https://firebasestorage.googleapis.com/v0/b/my-application1-c2efd.appspot.com/o/%D8%B9%D9%85%D8%A7%D8%AF%D8%A9%20%D8%B4%D8%A4%D9%88%D9%86%20%D8%A7%D9%84%D8%B7%D8%A7%D9%84%D8%A8%D8%A7%D8%AA.mp4?alt=media&token=ab7e409f-0ab8-406b-b281-960b7410b5d8";
    private String video7
            ="https://firebasestorage.googleapis.com/v0/b/my-application1-c2efd.appspot.com/o/%D9%82%D8%B3%D9%85%20%D8%AA%D9%82%D9%86%D9%8A%D8%A9%20%D8%A7%D9%84%D9%85%D8%B9%D9%84%D9%88%D9%85%D8%A7%D8%AA.mp4?alt=media&token=c9d2509b-f1c9-4af4-a31c-722213271b48";
    private String video8
            ="https://firebasestorage.googleapis.com/v0/b/my-application1-c2efd.appspot.com/o/%D9%82%D8%B3%D9%85%20%D8%B9%D9%84%D9%88%D9%85%20%D8%A7%D9%84%D8%AD%D8%A7%D8%B3%D8%A8.mp4?alt=media&token=83008b18-bf7b-411e-832e-f986ce495720";
    private String video9
            ="https://firebasestorage.googleapis.com/v0/b/my-application1-c2efd.appspot.com/o/%D9%82%D8%B3%D9%85%20%D9%86%D8%B8%D9%85%20%D8%A7%D9%84%D9%85%D8%B9%D9%84%D9%88%D9%85%D8%A7%D8%AA.mp4?alt=media&token=a8d72e27-92d0-4404-911e-ea99e597d9fe";


    private void setRecyclerViewData(){
        recyclerView=findViewById(R.id.banks_list);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new ViewPager2Adapter(this,departs);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        departs=new ArrayList<>();
        listDetails=new ArrayList<>();
        List<VideoModel> temp1=new ArrayList<>();

        temp1.add(new VideoModel("قبول",qbol));
        temp1.add(new VideoModel("الوثائق والخريجين",grades));
        temp1.add(new VideoModel("التسجيل",reg));
        temp1.add(new VideoModel("الارشاد الاكاديمي",""));
        listDetails.add(temp1);
        List<VideoModel> temp2=new ArrayList<>();
        temp2.add(new VideoModel("تعريف عمادة شؤون الطالبات",video6));
        listDetails.add(temp2);
        List<VideoModel> temp3=new ArrayList<>();

        temp3.add(new VideoModel("تعريف بالعماده",video5));
        temp3.add(new VideoModel("بلاكبورد",blackBoard));
        temp3.add(new VideoModel("تواصل",""));
        temp3.add(new VideoModel("الخدمات الذاتيه",""));
        listDetails.add(temp3);
        List<VideoModel> temp4=new ArrayList<>();

        temp4.add(new VideoModel("تعريف بالقسم",video7));
        listDetails.add(temp4);
        List<VideoModel> temp5=new ArrayList<>();
        temp5.add(new VideoModel("تعريف بالقسم",video9));
        listDetails.add(temp5);
        List<VideoModel> temp6=new ArrayList<>();
        temp6.add(new VideoModel("تعريف بالقسم",video8));
        listDetails.add(temp6);



        Intent intent = getIntent();
        String str = intent.getStringExtra("deparment_id");
        String depStr=intent.getStringExtra("deparment_str");
        TextView custom_title=findViewById(R.id.custom_title);
        custom_title.setText(depStr);

        Log.i("ssssss",str);
        Log.i("zzzzz", String.valueOf(listDetails));
        departs=listDetails.get(Integer.parseInt(str));



        setRecyclerViewData();
    }
}