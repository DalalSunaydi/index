package com.next.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.next.myapplication.adapter.DepartmentAdapter;
import com.next.myapplication.adapter.ViewPager2Adapter;
import com.next.myapplication.databinding.ActivityMainBinding;
import com.next.myapplication.model.VideoModel;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private List<VideoModel> videoModelList;
    private String urlpath="https://firebasestorage.googleapis.com/v0/b/my-application1-c2efd.appspot.com/o/280265560_405579844480502_8642498260401466040_n.mp4?alt=media&token=30c09db8-b503-4a7e-9a44-515c36b0a0cb";

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


    private List<String> departs;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private void setRecyclerViewData(){
        recyclerView=findViewById(R.id.banks_list);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new DepartmentAdapter(this,departs,false);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        departs=new ArrayList<>();

        departs.add("عمادة القبول والتسجيل");
        departs.add("عمادة شؤون الطالبات");
        departs.add("عمادة تقنية المعلومات");
        departs.add("قسم تقنية المعلومات");
        departs.add("قسم نظم المعلومات");
        departs.add("قسم علوم الحاسب");

        setRecyclerViewData();

//
//
//        videoModelList=new ArrayList<>();
//
//        videoModelList.add(new VideoModel("عمادة القبول والتسجيل","التسجيل",reg));
//        videoModelList.add(new VideoModel("عمادة القبول والتسجيل","الوثائق والخريجين",grades));
//        videoModelList.add(new VideoModel("عمادة تقنية المعلومات","بلاكبورد",blackBoard));
//        videoModelList.add(new VideoModel("عمادة القبول والتسجيل","قبول",qbol));
//        videoModelList.add(new VideoModel("عمادة تقنية المعلومات","تعريف بالعماده",video5));
//        videoModelList.add(new VideoModel("عمادة شؤون الطالبات","تعريف بالعماده",video6));
//        videoModelList.add(new VideoModel("قسم تقنية المعلومات","تعريف بالقسم",video7));
//        videoModelList.add(new VideoModel("قسم علوم الحاسب","تعريف بالقسم",video8));
//        videoModelList.add(new VideoModel("قسم نظم المعلومات","تعريف بالقسم",video9));

//        setSupportActionBar(binding.toolbar);
//        binding.toolbar.setTitle("الرئيسية          ");
//        /**set find id*/
//        ViewPager2 viewPager2 = findViewById(R.id.vpager);
//        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this,videoModelList);
//
//        // adding the adapter to viewPager2
//        // to show the views in recyclerview
//        viewPager2.setAdapter(viewPager2Adapter);
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

}