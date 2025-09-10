package yhy.project.entity.vo;

import yhy.project.entity.Cart;

public class CartVo extends Cart {
    private Integer stock;

    public void setStock(final Integer stock) {
        this.stock = stock;
    }

    @Override // yhy.project.entity.Cart
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CartVo)) {
            return false;
        }
        CartVo other = (CartVo) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$stock = getStock();
        Object other$stock = other.getStock();
        return this$stock == null ? other$stock == null : this$stock.equals(other$stock);
    }

    @Override // yhy.project.entity.Cart
    protected boolean canEqual(final Object other) {
        return other instanceof CartVo;
    }

    @Override // yhy.project.entity.Cart
    public int hashCode() {
        Object $stock = getStock();
        int result = (1 * 59) + ($stock == null ? 43 : $stock.hashCode());
        return result;
    }

    @Override // yhy.project.entity.Cart
    public String toString() {
        return "CartVo(stock=" + getStock() + ")";
    }

    public CartVo(final Integer stock) {
        this.stock = stock;
    }

    public CartVo() {
    }

    public Integer getStock() {
        return this.stock;
    }
}