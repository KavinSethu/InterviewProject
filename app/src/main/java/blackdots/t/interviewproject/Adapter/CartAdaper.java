package blackdots.t.interviewproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import blackdots.t.interviewproject.Pojo.CartItem;
import blackdots.t.interviewproject.R;

public class CartAdaper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<CartItem> cartItemList = new ArrayList<>();
    private List<String> dateList = new ArrayList<>();


    public CartAdaper(Context context) {
        this.context = context;
        this.cartItemList = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (cartItemList.get(position).getViewtype() != null && cartItemList.get(position).getViewtype().equalsIgnoreCase("item")) {
            return 1;
        } else
            return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item_row, parent, false);
                return new ItemViewHolder(view);

            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_header, parent, false);
                return new HeaderViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        Log.d("LookType", ":" + cartItemList.get(position).getViewtype());

        if (cartItemList.get(position).getViewtype() != null && cartItemList.get(position).getViewtype().equalsIgnoreCase("item")) {

            ItemViewHolder holder = (ItemViewHolder) viewHolder;

            CartItem cartItem = cartItemList.get(position);
            holder.itemName.setText(cartItem.getName());

        } else {
            HeaderViewHolder holder = (HeaderViewHolder) viewHolder;

            CartItem cartItem = cartItemList.get(position);
            holder.headerName.setText(cartItem.getName());
        }
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView itemName;

        ItemViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.ItemName);

        }

    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        private TextView headerName;

        HeaderViewHolder(View itemView) {
            super(itemView);
            headerName = itemView.findViewById(R.id.headerName);

        }

    }

    public void addItems(List<CartItem> list) {

        for (int i = 0; i < list.size(); i++) {

            Log.d("Callled", "" + i);

            String orderdate = "";
            String itemName = "";

            orderdate = list.get(i).getOrderdate();

            //Substring the date to identify the date
            if (orderdate != null && orderdate.length() > 0)
                orderdate = orderdate.substring(0, 11);

            itemName = list.get(i).getName();

            //if order date not in list it will add in list
            //and also added as Header in main list
            if (orderdate != null && !dateList.contains(orderdate)) {
                Log.d("OrderDate", "" + orderdate);
                dateList.add(orderdate);

                CartItem cartheader = new CartItem();
                cartheader.setViewtype("header");
                cartheader.setName(orderdate);
                cartItemList.add(cartheader);
            }

            Log.d("OrderItem", "" + itemName);
            //add cart items
            CartItem cartItem = new CartItem();
            cartItem.setViewtype("item");
            cartItem.setName(itemName);
            cartItemList.add(cartItem);

        }
        notifyDataSetChanged();
    }

}
