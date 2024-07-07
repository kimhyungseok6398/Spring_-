package hello.core.order;

public class Order {
   private Long memberId;

   private String itemName;

   private int itemPrice;

   private int discountPrice;

    public Order(Long memberIdl, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberIdl;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }
    public int calculatePrice(){
        return itemPrice - discountPrice;

    }

    public Long getMemberIdl() {
        return memberId;
    }

    public void setMemberIdl(Long memberIdl) {
        this.memberId = memberIdl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
}
