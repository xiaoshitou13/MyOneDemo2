package fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adater.Myadater;
import bean.MyDatas;
import bean.Myer;
import presenter.Mypresen;
import test.bwie.com.myonedemo2.R;
import utils.Api;
import view.Iview;


public class MyTwo extends Fragment implements Iview {

    int q =1;
    private View view;
    private RecyclerView mRecy;
    private SwipeRefreshLayout mSw;
    private Myadater myadater;
    private List<Myer.DataBean> l;
    private LinearLayoutManager manager;
    int i=0 ;
    private List<Myer.DataBean> m;
    private List<Myer.DataBean> n;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_two, container, false);

        initView(v);
        return v;
    }

    private void initView(View v) {
        mRecy = (RecyclerView) v.findViewById(R.id.recy);
        mSw = (SwipeRefreshLayout) v.findViewById(R.id.sw);
        manager = new LinearLayoutManager(getActivity());
        mRecy.setLayoutManager(manager);

        Mypresen mypresen = new Mypresen(getContext(),this);
        mypresen.Get("http://api.expoon.com",q);

        mSw.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mypresen.Get("http://api.expoon.com",1);

                        l = new ArrayList<Myer.DataBean>();

                        myadater.Sua(l);
                        mSw.setRefreshing(false);
                    }
                },2000);
            }
        });


        mRecy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(newState == RecyclerView.SCROLL_STATE_IDLE&&i+1==myadater.getItemCount()){
                            q++;
                             mypresen.Get("http://api.expoon.com",q);
                               n = new ArrayList<Myer.DataBean>();
                             myadater.Add(n);
                            Toast.makeText(getContext(), "好了", Toast.LENGTH_SHORT).show();
                        }
                    }

                },200);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                i = manager.findLastVisibleItemPosition();
            }
        });

    }

    @Override
    public String json() {
        return "";
    }

    @Override
    public void Gets(Myer myDatas) {
       // Toast.makeText(getContext(), ""+myDatas.getData().get(0).getNews_title(), Toast.LENGTH_SHORT).show();

                myadater = new Myadater(myDatas.getData(),getContext());
                mRecy.setAdapter(myadater);

              l.addAll(myDatas.getData());

        n.addAll(myDatas.getData());
    }
}
