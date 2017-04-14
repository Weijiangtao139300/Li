package weijiangtao.bwie.com.lianxirecycleview;




import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import weijiangtao.bwie.com.lianxirecycleview.view.MyDecoration;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String>list=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("shangke");
            
        }

        RecyclerView recy = (RecyclerView) findViewById(R.id.recy);

        
       // LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        //九宫格
       // GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4);

        //瀑布流
        StaggeredGridLayoutManager stg = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recy.setLayoutManager(stg);

      //  分割线
      //  MyDecoration myDecoration=new MyDecoration(this,MyDecoration.VERTICAL_LIST);
        GridDecoration gridDecoration=new GridDecoration(this);
        recy.addItemDecoration(gridDecoration);
        
        
        recy.setAdapter(new Myadapter(list,this));

    }
}
