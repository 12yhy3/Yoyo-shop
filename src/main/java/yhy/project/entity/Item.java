package yhy.project.entity;


public class Item {
    private Integer id;
    private String title;
    private String pic;
    private Double price;
    private Integer amount;
    private Integer goodsId;
    private Integer orderId;

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setPic(final String pic) {
        this.pic = pic;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
    }

    public void setGoodsId(final Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setOrderId(final Integer orderId) {
        this.orderId = orderId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        Item other = (Item) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$id = getId();
        Object other$id = other.getId();
        if (this$id == null) {
            if (other$id != null) {
                return false;
            }
        } else if (!this$id.equals(other$id)) {
            return false;
        }
        Object this$price = getPrice();
        Object other$price = other.getPrice();
        if (this$price == null) {
            if (other$price != null) {
                return false;
            }
        } else if (!this$price.equals(other$price)) {
            return false;
        }
        Object this$amount = getAmount();
        Object other$amount = other.getAmount();
        if (this$amount == null) {
            if (other$amount != null) {
                return false;
            }
        } else if (!this$amount.equals(other$amount)) {
            return false;
        }
        Object this$goodsId = getGoodsId();
        Object other$goodsId = other.getGoodsId();
        if (this$goodsId == null) {
            if (other$goodsId != null) {
                return false;
            }
        } else if (!this$goodsId.equals(other$goodsId)) {
            return false;
        }
        Object this$orderId = getOrderId();
        Object other$orderId = other.getOrderId();
        if (this$orderId == null) {
            if (other$orderId != null) {
                return false;
            }
        } else if (!this$orderId.equals(other$orderId)) {
            return false;
        }
        Object this$title = getTitle();
        Object other$title = other.getTitle();
        if (this$title == null) {
            if (other$title != null) {
                return false;
            }
        } else if (!this$title.equals(other$title)) {
            return false;
        }
        Object this$pic = getPic();
        Object other$pic = other.getPic();
        return this$pic == null ? other$pic == null : this$pic.equals(other$pic);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Item;
    }

    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $price = getPrice();
        int result2 = (result * 59) + ($price == null ? 43 : $price.hashCode());
        Object $amount = getAmount();
        int result3 = (result2 * 59) + ($amount == null ? 43 : $amount.hashCode());
        Object $goodsId = getGoodsId();
        int result4 = (result3 * 59) + ($goodsId == null ? 43 : $goodsId.hashCode());
        Object $orderId = getOrderId();
        int result5 = (result4 * 59) + ($orderId == null ? 43 : $orderId.hashCode());
        Object $title = getTitle();
        int result6 = (result5 * 59) + ($title == null ? 43 : $title.hashCode());
        Object $pic = getPic();
        return (result6 * 59) + ($pic == null ? 43 : $pic.hashCode());
    }

    public String toString() {
        return "Item(id=" + getId() + ", title=" + getTitle() + ", pic=" + getPic() + ", price=" + getPrice() + ", amount=" + getAmount() + ", goodsId=" + getGoodsId() + ", orderId=" + getOrderId() + ")";
    }

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPic() {
        return this.pic;
    }

    public Double getPrice() {
        return this.price;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public Integer getGoodsId() {
        return this.goodsId;
    }

    public Integer getOrderId() {
        return this.orderId;
    }
}
