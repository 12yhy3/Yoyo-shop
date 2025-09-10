package yhy.project.entity;

public class Goods {
    private Integer id;
    private String name;
    private Double price;
    private String intro;
    private String cover;
    private String image1;
    private String image2;
    private Integer stock;
    private Integer typeId;
    private Integer status;
    private Type type;
    private boolean topToday;
    private boolean topHot;
    private boolean topNew;

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public void setIntro(final String intro) {
        this.intro = intro;
    }

    public void setCover(final String cover) {
        this.cover = cover;
    }

    public void setImage1(final String image1) {
        this.image1 = image1;
    }

    public void setImage2(final String image2) {
        this.image2 = image2;
    }

    public void setStock(final Integer stock) {
        this.stock = stock;
    }

    public void setTypeId(final Integer typeId) {
        this.typeId = typeId;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public void setType(final Type type) {
        this.type = type;
    }

    public void setTopToday(final boolean topToday) {
        this.topToday = topToday;
    }

    public void setTopHot(final boolean topHot) {
        this.topHot = topHot;
    }

    public void setTopNew(final boolean topNew) {
        this.topNew = topNew;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Goods)) {
            return false;
        }
        Goods other = (Goods) o;
        if (!other.canEqual(this) || isTopToday() != other.isTopToday() || isTopHot() != other.isTopHot() || isTopNew() != other.isTopNew()) {
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
        Object this$stock = getStock();
        Object other$stock = other.getStock();
        if (this$stock == null) {
            if (other$stock != null) {
                return false;
            }
        } else if (!this$stock.equals(other$stock)) {
            return false;
        }
        Object this$typeId = getTypeId();
        Object other$typeId = other.getTypeId();
        if (this$typeId == null) {
            if (other$typeId != null) {
                return false;
            }
        } else if (!this$typeId.equals(other$typeId)) {
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
        Object this$name = getName();
        Object other$name = other.getName();
        if (this$name == null) {
            if (other$name != null) {
                return false;
            }
        } else if (!this$name.equals(other$name)) {
            return false;
        }
        Object this$intro = getIntro();
        Object other$intro = other.getIntro();
        if (this$intro == null) {
            if (other$intro != null) {
                return false;
            }
        } else if (!this$intro.equals(other$intro)) {
            return false;
        }
        Object this$cover = getCover();
        Object other$cover = other.getCover();
        if (this$cover == null) {
            if (other$cover != null) {
                return false;
            }
        } else if (!this$cover.equals(other$cover)) {
            return false;
        }
        Object this$image1 = getImage1();
        Object other$image1 = other.getImage1();
        if (this$image1 == null) {
            if (other$image1 != null) {
                return false;
            }
        } else if (!this$image1.equals(other$image1)) {
            return false;
        }
        Object this$image2 = getImage2();
        Object other$image2 = other.getImage2();
        if (this$image2 == null) {
            if (other$image2 != null) {
                return false;
            }
        } else if (!this$image2.equals(other$image2)) {
            return false;
        }
        Object this$type = getType();
        Object other$type = other.getType();
        return this$type == null ? other$type == null : this$type.equals(other$type);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Goods;
    }

    public int hashCode() {
        int result = (1 * 59) + (isTopToday() ? 79 : 97);
        int result2 = (((result * 59) + (isTopHot() ? 79 : 97)) * 59) + (isTopNew() ? 79 : 97);
        Object $id = getId();
        int result3 = (result2 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $price = getPrice();
        int result4 = (result3 * 59) + ($price == null ? 43 : $price.hashCode());
        Object $stock = getStock();
        int result5 = (result4 * 59) + ($stock == null ? 43 : $stock.hashCode());
        Object $typeId = getTypeId();
        int result6 = (result5 * 59) + ($typeId == null ? 43 : $typeId.hashCode());
        Object $status = getStatus();
        int result7 = (result6 * 59) + ($status == null ? 43 : $status.hashCode());
        Object $name = getName();
        int result8 = (result7 * 59) + ($name == null ? 43 : $name.hashCode());
        Object $intro = getIntro();
        int result9 = (result8 * 59) + ($intro == null ? 43 : $intro.hashCode());
        Object $cover = getCover();
        int result10 = (result9 * 59) + ($cover == null ? 43 : $cover.hashCode());
        Object $image1 = getImage1();
        int result11 = (result10 * 59) + ($image1 == null ? 43 : $image1.hashCode());
        Object $image2 = getImage2();
        int result12 = (result11 * 59) + ($image2 == null ? 43 : $image2.hashCode());
        Object $type = getType();
        return (result12 * 59) + ($type == null ? 43 : $type.hashCode());
    }

    public String toString() {
        return "Goods(id=" + getId() + ", name=" + getName() + ", price=" + getPrice() + ", intro=" + getIntro() + ", cover=" + getCover() + ", image1=" + getImage1() + ", image2=" + getImage2() + ", stock=" + getStock() + ", typeId=" + getTypeId() + ", status=" + getStatus() + ", type=" + getType() + ", topToday=" + isTopToday() + ", topHot=" + isTopHot() + ", topNew=" + isTopNew() + ")";
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getCover() {
        return this.cover;
    }

    public String getImage1() {
        return this.image1;
    }

    public String getImage2() {
        return this.image2;
    }

    public Integer getStock() {
        return this.stock;
    }

    public Integer getTypeId() {
        return this.typeId;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isTopToday() {
        return this.topToday;
    }

    public boolean isTopHot() {
        return this.topHot;
    }

    public boolean isTopNew() {
        return this.topNew;
    }
}