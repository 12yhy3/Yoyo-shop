package yhy.project.entity;
public class Order {
    private Integer id;
    private String orderNumber;
    private Double total;
    private Integer amount;
    private Integer status;
    private Integer paytype;
    private String name;
    private String phone;
    private String address;
    private String systime;
    private Integer userId;

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setOrderNumber(final String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setTotal(final Double total) {
        this.total = total;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public void setPaytype(final Integer paytype) {
        this.paytype = paytype;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setSystime(final String systime) {
        this.systime = systime;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        Order other = (Order) o;
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
        Object this$total = getTotal();
        Object other$total = other.getTotal();
        if (this$total == null) {
            if (other$total != null) {
                return false;
            }
        } else if (!this$total.equals(other$total)) {
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
        Object this$status = getStatus();
        Object other$status = other.getStatus();
        if (this$status == null) {
            if (other$status != null) {
                return false;
            }
        } else if (!this$status.equals(other$status)) {
            return false;
        }
        Object this$paytype = getPaytype();
        Object other$paytype = other.getPaytype();
        if (this$paytype == null) {
            if (other$paytype != null) {
                return false;
            }
        } else if (!this$paytype.equals(other$paytype)) {
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
        Object this$orderNumber = getOrderNumber();
        Object other$orderNumber = other.getOrderNumber();
        if (this$orderNumber == null) {
            if (other$orderNumber != null) {
                return false;
            }
        } else if (!this$orderNumber.equals(other$orderNumber)) {
            return false;
        }
        Object this$name = getName();
        Object other$name = other.getName();
        if (this$name == null) {
            if (other$name != null) {
                return false;
            }
        } else if (!this$name.equals(other$name)) {
            return false;
        }
        Object this$phone = getPhone();
        Object other$phone = other.getPhone();
        if (this$phone == null) {
            if (other$phone != null) {
                return false;
            }
        } else if (!this$phone.equals(other$phone)) {
            return false;
        }
        Object this$address = getAddress();
        Object other$address = other.getAddress();
        if (this$address == null) {
            if (other$address != null) {
                return false;
            }
        } else if (!this$address.equals(other$address)) {
            return false;
        }
        Object this$systime = getSystime();
        Object other$systime = other.getSystime();
        return this$systime == null ? other$systime == null : this$systime.equals(other$systime);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Order;
    }

    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $total = getTotal();
        int result2 = (result * 59) + ($total == null ? 43 : $total.hashCode());
        Object $amount = getAmount();
        int result3 = (result2 * 59) + ($amount == null ? 43 : $amount.hashCode());
        Object $status = getStatus();
        int result4 = (result3 * 59) + ($status == null ? 43 : $status.hashCode());
        Object $paytype = getPaytype();
        int result5 = (result4 * 59) + ($paytype == null ? 43 : $paytype.hashCode());
        Object $userId = getUserId();
        int result6 = (result5 * 59) + ($userId == null ? 43 : $userId.hashCode());
        Object $orderNumber = getOrderNumber();
        int result7 = (result6 * 59) + ($orderNumber == null ? 43 : $orderNumber.hashCode());
        Object $name = getName();
        int result8 = (result7 * 59) + ($name == null ? 43 : $name.hashCode());
        Object $phone = getPhone();
        int result9 = (result8 * 59) + ($phone == null ? 43 : $phone.hashCode());
        Object $address = getAddress();
        int result10 = (result9 * 59) + ($address == null ? 43 : $address.hashCode());
        Object $systime = getSystime();
        return (result10 * 59) + ($systime == null ? 43 : $systime.hashCode());
    }

    public String toString() {
        return "Order(id=" + getId() + ", orderNumber=" + getOrderNumber() + ", total=" + getTotal() + ", amount=" + getAmount() + ", status=" + getStatus() + ", paytype=" + getPaytype() + ", name=" + getName() + ", phone=" + getPhone() + ", address=" + getAddress() + ", systime=" + getSystime() + ", userId=" + getUserId() + ")";
    }

    public Integer getId() {
        return this.id;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public Double getTotal() {
        return this.total;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Integer getPaytype() {
        return this.paytype;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }

    public String getSystime() {
        return this.systime;
    }

    public Integer getUserId() {
        return this.userId;
    }
}
