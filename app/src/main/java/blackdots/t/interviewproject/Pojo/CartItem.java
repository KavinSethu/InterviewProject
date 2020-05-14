package blackdots.t.interviewproject.Pojo;

public class CartItem extends BaseClass{

    private String Image;
    private String cartItemName;
    private String cartItemDate;
    private String viewtype;

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getViewtype() {
        return viewtype;
    }

    public void setViewtype(String viewtype) {
        this.viewtype = viewtype;
    }

    public String getCartItemName() {
        return cartItemName;
    }

    public void setCartItemName(String cartItemName) {
        this.cartItemName = cartItemName;
    }

    public String getCartItemDate() {
        return cartItemDate;
    }

    public void setCartItemDate(String cartItemDate) {
        this.cartItemDate = cartItemDate;
    }

    @Override
    public String getItemName() {
        return cartItemName;
    }

    @Override
    public String getDate() {
        return cartItemDate;
    }

    @Override
    public String getViewType() {
        return viewtype;
    }
}
