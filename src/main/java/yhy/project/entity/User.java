package yhy.project.entity;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String address;
    private Integer status;
    private String token;

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setPassword(final String password) {
        this.password = password;
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

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User other = (User) o;
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
        if (this$password == null) {
            if (other$password != null) {
                return false;
            }
        } else if (!this$password.equals(other$password)) {
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
        Object this$token = getToken();
        Object other$token = other.getToken();
        return this$token == null ? other$token == null : this$token.equals(other$token);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $status = getStatus();
        int result2 = (result * 59) + ($status == null ? 43 : $status.hashCode());
        Object $username = getUsername();
        int result3 = (result2 * 59) + ($username == null ? 43 : $username.hashCode());
        Object $password = getPassword();
        int result4 = (result3 * 59) + ($password == null ? 43 : $password.hashCode());
        Object $name = getName();
        int result5 = (result4 * 59) + ($name == null ? 43 : $name.hashCode());
        Object $phone = getPhone();
        int result6 = (result5 * 59) + ($phone == null ? 43 : $phone.hashCode());
        Object $address = getAddress();
        int result7 = (result6 * 59) + ($address == null ? 43 : $address.hashCode());
        Object $token = getToken();
        return (result7 * 59) + ($token == null ? 43 : $token.hashCode());
    }

    public String toString() {
        return "User(id=" + getId() + ", username=" + getUsername() + ", password=" + getPassword() + ", name=" + getName() + ", phone=" + getPhone() + ", address=" + getAddress() + ", status=" + getStatus() + ", token=" + getToken() + ")";
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

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getToken() {
        return this.token;
    }
}