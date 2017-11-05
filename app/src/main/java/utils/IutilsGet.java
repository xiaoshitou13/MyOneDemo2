package utils;

import bean.MyDatas;
import bean.Myer;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 白玉春 on 2017/11/4.
 */

public interface IutilsGet {

    @GET("/AppNews/getNewsList/type/1/p/{page}")
    Observable<Myer> Get(@Path("page") int channid);


}
