package yhy.project.entity;


public class Cart {
    private Integer id;
    private String title;
    private String pic;
    private Double price;
    private Integer num;
    private Integer goodsId;
    private Integer userId;

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

    public void setNum(final Integer num) {
        this.num = num;
    }

    public void setGoodsId(final Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) o;
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
        Object this$num = getNum();
        Object other$num = other.getNum();
        if (this$num == null) {
            if (other$num != null) {
                return false;
            }
        } else if (!this$num.equals(other$num)) {
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
        Object this$userId = getUserId();
        Object other$userId = other.getUserId();
        if (this$userId == null) {
            if (other$userId != null) {
                return false;
            }
        } else if (!this$userId.equals(other$userId)) {
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
        return other instanceof Cart;
    }

    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $price = getPrice();
        int result2 = (result * 59) + ($price == null ? 43 : $price.hashCode());
        Object $num = getNum();
        int result3 = (result2 * 59) + ($num == null ? 43 : $num.hashCode());
        Object $goodsId = getGoodsId();
        int result4 = (result3 * 59) + ($goodsId == null ? 43 : $goodsId.hashCode());
        Object $userId = getUserId();
        int result5 = (result4 * 59) + ($userId == null ? 43 : $userId.hashCode());
        Object $title = getTitle();
        int result6 = (result5 * 59) + ($title == null ? 43 : $title.hashCode());
        Object $pic = getPic();
        return (result6 * 59) + ($pic == null ? 43 : $pic.hashCode());
    }

    public String toString() {
        return "Cart(id=" + getId() + ", title=" + getTitle() + ", pic=" + getPic() + ", price=" + getPrice() + ", num=" + getNum() + ", goodsId=" + getGoodsId() + ", userId=" + getUserId() + ")";
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

    public Integer getNum() {
        return this.num;
    }

    public Integer getGoodsId() {
        return this.goodsId;
    }

    public Integer getUserId() {
        return this.userId;
    }
}
