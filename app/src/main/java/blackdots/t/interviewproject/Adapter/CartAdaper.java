package blackdots.t.interviewproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import blackdots.t.interviewproject.Pojo.BaseClass;
import blackdots.t.interviewproject.Pojo.CartItem;
import blackdots.t.interviewproject.R;

public class CartAdaper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<BaseClass> baseClassList = new ArrayList<>();
    private List<String> dateList = new ArrayList<>();


    public CartAdaper(Context context) {
        this.context = context;
        this.baseClassList = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (baseClassList.get(position).getViewType() != null && baseClassList.get(position).getViewType().equalsIgnoreCase("item")) {
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

        Log.d("LookType", ":" + baseClassList.get(position).getViewType());

        if (baseClassList.get(position).getViewType() != null && baseClassList.get(position).getViewType().equalsIgnoreCase("item")) {

            ItemViewHolder holder = (ItemViewHolder) viewHolder;

            BaseClass baseClass = baseClassList.get(position);
            holder.itemName.setText(baseClass.getItemName());

        } else {
            HeaderViewHolder holder = (HeaderViewHolder) viewHolder;

            BaseClass cartItem = baseClassList.get(position);
            holder.headerName.setText(cartItem.getItemName());
        }
    }

    @Override
    public int getItemCount() {
        return baseClassList.size();
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

    public void addItems(List<BaseClass> list) {

        for (int i = 0; i < list.size(); i++) {

            Log.d("Callled", "" + i);

            String orderdate = "";
            String itemName = "";

            orderdate = list.get(i).getDate();

            //Substring the date to identify the date
            if (orderdate != null && orderdate.length() > 0)
                orderdate = orderdate.substring(0, 11);

            itemName = list.get(i).getItemName();

            //if order date not in list it will add in list
            //and also added as Header in main list
            if (orderdate != null && !dateList.contains(orderdate)) {
                Log.d("OrderDate", "" + orderdate);
                dateList.add(orderdate);

                BaseClass cartheader = new BaseClass();
                cartheader.setViewType("header");
                cartheader.setItemName(orderdate);
                baseClassList.add(cartheader);
            }

            Log.d("OrderItem", "" + itemName);
            //add cart items
            BaseClass cartItem = new BaseClass();
            cartItem.setViewType("item");
            cartItem.setItemName(itemName);
            baseClassList.add(cartItem);

        }
        notifyDataSetChanged();
    }

}
