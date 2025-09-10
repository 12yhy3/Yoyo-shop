package yhy.project.entity.dto;


import yhy.project.entity.Goods;

public class GoodsDTO extends Goods {
    Integer tid;
    Integer types;

    public void setTid(final Integer tid) {
        this.tid = tid;
    }

    public void setTypes(final Integer types) {
        this.types = types;
    }

    @Override // yhy.project.entity.Goods
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GoodsDTO)) {
            return false;
        }
        GoodsDTO other = (GoodsDTO) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$tid = getTid();
        Object other$tid = other.getTid();
        if (this$tid == null) {
            if (other$tid != null) {
                return false;
            }
        } else if (!this$tid.equals(other$tid)) {
            return false;
        }
        Object this$types = getTypes();
        Object other$types = other.getTypes();
        return this$types == null ? other$types == null : this$types.equals(other$types);
    }

    @Override // yhy.project.entity.Goods
    protected boolean canEqual(final Object other) {
        return other instanceof GoodsDTO;
    }

    @Override // yhy.project.entity.Goods
    public int hashCode() {
        Object $tid = getTid();
        int result = (1 * 59) + ($tid == null ? 43 : $tid.hashCode());
        Object $types = getTypes();
        return (result * 59) + ($types == null ? 43 : $types.hashCode());
    }

    @Override // yhy.project.entity.Goods
    public String toString() {
        return "GoodsDTO(tid=" + getTid() + ", types=" + getTypes() + ")";
    }

    public Integer getTid() {
        return this.tid;
    }

    public Integer getTypes() {
        return this.types;
    }
}