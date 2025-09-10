package yhy.project.entity.vo;

import yhy.project.entity.Item;
import yhy.project.entity.Order;

import java.util.List;

public class OrderVo extends Order {
    private List<Item> itemList;

    public void setItemList(final List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override // yhy.project.entity.Order
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OrderVo)) {
            return false;
        }
        OrderVo other = (OrderVo) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$itemList = getItemList();
        Object other$itemList = other.getItemList();
        return this$itemList == null ? other$itemList == null : this$itemList.equals(other$itemList);
    }

    @Override // yhy.project.entity.Order
    protected boolean canEqual(final Object other) {
        return other instanceof OrderVo;
    }

    @Override // yhy.project.entity.Order
    public int hashCode() {
        Object $itemList = getItemList();
        int result = (1 * 59) + ($itemList == null ? 43 : $itemList.hashCode());
        return result;
    }

    @Override // yhy.project.entity.Order
    public String toString() {
        return "OrderVo(itemList=" + getItemList() + ")";
    }

    public List<Item> getItemList() {
        return this.itemList;
    }
}