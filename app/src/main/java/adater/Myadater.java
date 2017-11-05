package adater;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import bean.Myer;
import test.bwie.com.myonedemo2.R;

/**
 * Created by 白玉春 on 2017/11/4.
 */

public class Myadater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Myer.DataBean> list;
    Context context ;

    public Myadater(List<Myer.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       return  new OneHoder(LayoutInflater.from(parent.getContext()).inflate(R.layout.en,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof  OneHoder){
            if(list.get(position).getNews_title()!=null){
                ((OneHoder) holder).i1.setImageURI(Uri.parse(list.get(position).getPic_url()));
                ((OneHoder) holder).t1.setText(list.get(position).getNews_title());
            }

        }
    }

    @Override
    public int getItemCount() {
        return list !=null ? list.size() : 0;
    }

    class OneHoder extends RecyclerView.ViewHolder{
        SimpleDraweeView i1;
        TextView t1;
        public OneHoder(View itemView) {
            super(itemView);
            i1 = itemView.findViewById(R.id.si);
            t1 = itemView.findViewById(R.id.tv);
        }
    }

    public void Sua(List<Myer.DataBean> newlist){
        if(newlist!=null){
            this.list.clear();
            this.list.addAll(newlist);
            notifyDataSetChanged();
        }
    }

    public void Add(List<Myer.DataBean> n){
        if(n!=null){
            this.list.addAll(n);
            notifyDataSetChanged();
        }
    }
}

