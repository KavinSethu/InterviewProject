package blackdots.t.interviewproject.Pojo;

public class BillingItem extends BaseClass{

    private String billingId;
    private String billingDate;
    private String billingName;
    private String viewtype;

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

    public String getBillingName() {
        return billingName;
    }

    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    @Override
    public String getItemName() {
        return billingName;
    }

    @Override
    public String getDate() {
        return billingDate;
    }

    @Override
    public String getViewType() {
        return viewtype;
    }

    public String getViewtype() {
        return viewtype;
    }

    public void setViewtype(String viewtype) {
        this.viewtype = viewtype;
    }
}
