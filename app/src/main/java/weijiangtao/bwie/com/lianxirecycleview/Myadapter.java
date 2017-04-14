package weijiangtao.bwie.com.lianxirecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2017/4/14.
 * <p>
 * 未江涛
 */

 public class Myadapter extends RecyclerView.Adapter<Myadapter.Viewhouder> {
    
    private List<String> list;
    private Context context;
    private final List<Integer> mHeights;


    public Myadapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        //这是一个随机数的集合,用于动态生成item的 宽和高
        mHeights = new ArrayList<Integer>();

        for (int i = 0; i < list.size(); i++)
        {
            mHeights.add( (int) (100 + Math.random() * 300));
        }
    }




    @Override
    public Viewhouder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.item,null);
       final Viewhouder  holder = new Viewhouder(view);
        return holder;
    }
    //把数据赋值给控件
    @Override
    public void onBindViewHolder(Viewhouder holder, int position) {


        if (holder instanceof Viewhouder){
            Viewhouder holder1 = (Viewhouder) holder;

            //每个条目的高度设置成随机数
            ViewGroup.LayoutParams layoutParams = holder1.text11.getLayoutParams();

            layoutParams.height = mHeights.get(position);

            holder1.text11.setLayoutParams(layoutParams);
            holder1.text11.setText(list.get(position));

        }
        
        
       
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    
    
    public class Viewhouder extends RecyclerView.ViewHolder{
        private final TextView text11;

        public Viewhouder(View itemView) {
            super(itemView);
            text11 = (TextView) itemView.findViewById(R.id.text1);

        }
    }
    
    
}
