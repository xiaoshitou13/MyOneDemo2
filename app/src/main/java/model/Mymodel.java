package model;

import bean.MyDatas;
import bean.Myer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.Api;
import utils.Inter;
import utils.IutilsGet;

/**
 * Created by 白玉春 on 2017/11/4.
 */

public class Mymodel implements Imodel {
    @Override
    public void Qinqiu(String url,int page, Inter inter) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                 .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                 .build();

        IutilsGet get = retrofit.create(IutilsGet.class);

        Observable<Myer> observable = get.Get(page);

        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Myer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Myer myDatas) {

                        inter.Success(myDatas);
                    }
                });
    }
}
