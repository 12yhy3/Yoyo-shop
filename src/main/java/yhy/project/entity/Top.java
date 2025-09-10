package yhy.project.entity;
public class Top {
    private Integer id;
    private Integer type;
    private Integer goodsId;

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setType(final Integer type) {
        this.type = type;
    }

    public void setGoodsId(final Integer goodsId) {
        this.goodsId = goodsId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Top)) {
            return false;
        }
        Top other = (Top) o;
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
        Object this$type = getType();
        Object other$type = other.getType();
        if (this$type == null) {
            if (other$type != null) {
                return false;
            }
        } else if (!this$type.equals(other$type)) {
            return false;
        }
        Object this$goodsId = getGoodsId();
        Object other$goodsId = other.getGoodsId();
        return this$goodsId == null ? other$goodsId == null : this$goodsId.equals(other$goodsId);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Top;
    }

    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $type = getType();
        int result2 = (result * 59) + ($type == null ? 43 : $type.hashCode());
        Object $goodsId = getGoodsId();
        return (result2 * 59) + ($goodsId == null ? 43 : $goodsId.hashCode());
    }

    public String toString() {
        return "Top(id=" + getId() + ", type=" + getType() + ", goodsId=" + getGoodsId() + ")";
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getType() {
        return this.type;
    }

    public Integer getGoodsId() {
        return this.goodsId;
    }
}
