package blackdots.t.interviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import blackdots.t.interviewproject.Adapter.CartAdaper;
import blackdots.t.interviewproject.Pojo.CartItem;

public class OrderActivity extends AppCompatActivity {

    RecyclerView item_Recyclerview;
    CartAdaper cartAdaper;
    LinearLayoutManager linearLayoutManager;
    List<CartItem> cartItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        findviews();
        setAdapter();
        addDummydata();
    }

    private void addDummydata() {
    }

    private void setAdapter() {
        cartAdaper = new CartAdaper(this, cartItemList);
        item_Recyclerview.setAdapter(cartAdaper);
    }

    private void findviews() {
        item_Recyclerview = findViewById(R.id.item_Recyclerview);
        item_Recyclerview.setHasFixedSize(false);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        item_Recyclerview.setLayoutManager(linearLayoutManager);
    }
}
