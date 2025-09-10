package yhy.project.entity.vo;

import yhy.project.entity.Goods;
import yhy.project.entity.Type;

public class GoodsVo extends Goods {
    private Type type;

    @Override // yhy.project.entity.Goods
    public void setType(final Type type) {
        this.type = type;
    }

    @Override // yhy.project.entity.Goods
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GoodsVo)) {
            return false;
        }
        GoodsVo other = (GoodsVo) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$type = getType();
        Object other$type = other.getType();
        return this$type == null ? other$type == null : this$type.equals(other$type);
    }

    @Override // yhy.project.entity.Goods
    protected boolean canEqual(final Object other) {
        return other instanceof GoodsVo;
    }

    @Override // yhy.project.entity.Goods
    public int hashCode() {
        Object $type = getType();
        int result = (1 * 59) + ($type == null ? 43 : $type.hashCode());
        return result;
    }

    @Override // yhy.project.entity.Goods
    public String toString() {
        return "GoodsVo(type=" + getType() + ")";
    }

    @Override // yhy.project.entity.Goods
    public Type getType() {
        return this.type;
    }
}