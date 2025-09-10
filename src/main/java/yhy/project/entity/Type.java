package yhy.project.entity;


public class Type {
    private Integer id;
    private String name;
    private Integer status;

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Type)) {
            return false;
        }
        Type other = (Type) o;
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
        return this$name == null ? other$name == null : this$name.equals(other$name);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Type;
    }

    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $status = getStatus();
        int result2 = (result * 59) + ($status == null ? 43 : $status.hashCode());
        Object $name = getName();
        return (result2 * 59) + ($name == null ? 43 : $name.hashCode());
    }

    public String toString() {
        return "Type(id=" + getId() + ", name=" + getName() + ", status=" + getStatus() + ")";
    }

    public Type() {
    }

    public Type(final Integer id, final String name, final Integer status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getStatus() {
        return this.status;
    }
}
