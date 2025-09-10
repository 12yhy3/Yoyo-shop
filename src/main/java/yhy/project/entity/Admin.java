package yhy.project.entity;

public class Admin {
    private Integer id;
    private String username;
    private String password;

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) o;
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
        Object this$username = getUsername();
        Object other$username = other.getUsername();
        if (this$username == null) {
            if (other$username != null) {
                return false;
            }
        } else if (!this$username.equals(other$username)) {
            return false;
        }
        Object this$password = getPassword();
        Object other$password = other.getPassword();
        return this$password == null ? other$password == null : this$password.equals(other$password);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Admin;
    }

    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $username = getUsername();
        int result2 = (result * 59) + ($username == null ? 43 : $username.hashCode());
        Object $password = getPassword();
        return (result2 * 59) + ($password == null ? 43 : $password.hashCode());
    }

    public String toString() {
        return "Admin(id=" + getId() + ", username=" + getUsername() + ", password=" + getPassword() + ")";
    }

    public Integer getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}