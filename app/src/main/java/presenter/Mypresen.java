package presenter;

import android.content.Context;

import bean.Myer;
import model.Mymodel;
import utils.Inter;
import view.Iview;

/**
 * Created by 白玉春 on 2017/11/4.
 */

public class Mypresen {

    Context context;
    Iview iview;
    Mymodel mymodel;

    public Mypresen(Context context, Iview iview) {
        this.context = context;
        this.iview = iview;
        this.mymodel = new Mymodel();
    }

    public void Get(String u,int page){
        mymodel.Qinqiu(u,page, new Inter() {
            @Override
            public void Success(Myer myDatas) {
                iview.Gets(myDatas);
            }
        });

    }
}
