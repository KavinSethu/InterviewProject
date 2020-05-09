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
import blackdots.t.interviewproject.Pojo.CartItem;

public class MainActivity extends AppCompatActivity {

    RecyclerView item_Recyclerview;
    CartAdaper cartAdaper;
    LinearLayoutManager linearLayoutManager;
    List<CartItem> cartItemList = new ArrayList<>();
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

        CartItem c1=new CartItem();
        c1.setName("biryani");
        c1.setOrderdate("09-apr-2020 09:30 pm");

        CartItem c2=new CartItem();
        c2.setName("idly");
        c2.setOrderdate("09-apr-2020 09:30 pm");

        CartItem c3=new CartItem();
        c3.setName("Dosa");
        c3.setOrderdate("09-apr-2020 09:30 pm");

        CartItem c4=new CartItem();
        c4.setName("Poori");
        c4.setOrderdate("10-apr-2020 08:30 am");

        CartItem c5=new CartItem();
        c5.setName("idly");
        c5.setOrderdate("10-apr-2020 08:30 am");

        CartItem c6=new CartItem();
        c6.setName("biryani");
        c6.setOrderdate("10-apr-2020 08:30 am");

        CartItem c7=new CartItem();
        c7.setName("Dosa");
        c7.setOrderdate("11-apr-2020 10:30 pm");

        CartItem c8=new CartItem();
        c8.setName("biryani");
        c8.setOrderdate("11-apr-2020 10:30 pm");

        cartItemList.add(c1);
        cartItemList.add(c2);
        cartItemList.add(c3);
        cartItemList.add(c4);
        cartItemList.add(c5);
        cartItemList.add(c6);
        cartItemList.add(c7);
        cartItemList.add(c8);

        cartAdaper.addItems(cartItemList);

    }

    private void findviews() {
        item_Recyclerview = findViewById(R.id.item_Recyclerview);
        item_Recyclerview.setHasFixedSize(false);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        item_Recyclerview.setLayoutManager(linearLayoutManager);
    }
}
