package blackdots.t.interviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import blackdots.t.interviewproject.Adapter.CartAdaper;
import blackdots.t.interviewproject.Pojo.BaseClass;
import blackdots.t.interviewproject.Pojo.BaseClass;
import blackdots.t.interviewproject.Pojo.BillingItem;
import blackdots.t.interviewproject.Pojo.CartItem;

public class MainActivity extends AppCompatActivity {

    RecyclerView item_Recyclerview;
    CartAdaper cartAdaper;
    LinearLayoutManager linearLayoutManager;
    List<BaseClass> cartItemList = new ArrayList<>();
    List<String> dateList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findviews();
        setAdapter();
        addDummydata();
    }

    private void setAdapter() {
        cartAdaper = new CartAdaper(this);
        item_Recyclerview.setAdapter(cartAdaper);
    }

    private void addDummydata() {

        BaseClass c2=new BaseClass();
        c2.setItemName("idly");
        c2.setDate("09-apr-2020 09:30 pm");

        BaseClass c3=new BaseClass();
        c3.setItemName("Dosa");
        c3.setDate("09-apr-2020 09:30 pm");

        BaseClass c4=new BaseClass();
        c4.setItemName("Poori");
        c4.setDate("10-apr-2020 08:30 am");

        BaseClass c5=new BaseClass();
        c5.setItemName("idly");
        c5.setDate("10-apr-2020 08:30 am");

        BaseClass c6=new BaseClass();
        c6.setItemName("biryani");
        c6.setDate("10-apr-2020 08:30 am");

        BaseClass c7=new BaseClass();
        c7.setItemName("Dosa");
        c7.setDate("11-apr-2020 10:30 pm");

        BaseClass c8=new BaseClass();
        c8.setItemName("biryani");
        c8.setDate("11-apr-2020 10:30 pm");

        BaseClass c1=new BaseClass();
        c1.setItemName("biryani");
        c1.setDate("09-apr-2020 09:30 pm");

        BillingItem b=new BillingItem();
        b.setBillingName("Dosa");
        b.setBillingDate("09-apr-2020 09:30 pm");

        CartItem c=new CartItem();
        c.setCartItemName("Idly Cart");
        c.setCartItemDate("08-apr-2020 09:30 pm");


        cartItemList.add(c2);
        cartItemList.add(c3);
        cartItemList.add(c4);
        cartItemList.add(c5);
        cartItemList.add(c6);
        cartItemList.add(c7);
        cartItemList.add(c8);
        cartItemList.add(c1);
        cartItemList.add(b);
        cartItemList.add(c);

        cartAdaper.addItems(cartItemList);

    }

    private void findviews() {
        item_Recyclerview = findViewById(R.id.item_Recyclerview);
        item_Recyclerview.setHasFixedSize(false);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        item_Recyclerview.setLayoutManager(linearLayoutManager);
    }
}
