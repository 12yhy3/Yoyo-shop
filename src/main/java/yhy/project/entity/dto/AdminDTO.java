package yhy.project.entity.dto;

import yhy.project.entity.Admin;

public class AdminDTO extends Admin {
    private String token;
    private String newPwd;

    public void setToken(final String token) {
        this.token = token;
    }

    public void setNewPwd(final String newPwd) {
        this.newPwd = newPwd;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminDTO)) {
            return false;
        }
        AdminDTO other = (AdminDTO) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$token = getToken();
        Object other$token = other.getToken();
        if (this$token == null) {
            if (other$token != null) {
                return false;
            }
        } else if (!this$token.equals(other$token)) {
            return false;
        }
        Object this$newPwd = getNewPwd();
        Object other$newPwd = other.getNewPwd();
        return this$newPwd == null ? other$newPwd == null : this$newPwd.equals(other$newPwd);
    }

    @Override
    protected boolean canEqual(final Object other) {
        return other instanceof AdminDTO;
    }

    @Override
    public int hashCode() {
        Object $token = getToken();
        int result = (1 * 59) + ($token == null ? 43 : $token.hashCode());
        Object $newPwd = getNewPwd();
        return (result * 59) + ($newPwd == null ? 43 : $newPwd.hashCode());
    }

    @Override
    public String toString() {
        return "AdminDTO(token=" + getToken() + ", newPwd=" + getNewPwd() + ")";
    }

    public String getToken() {
        return this.token;
    }

    public String getNewPwd() {
        return this.newPwd;
    }
}