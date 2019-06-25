package me.map.Plots.Models;

public class UserForm {

    private User user;

    private String verify;

    public UserForm() {
    }

    public UserForm(User user, String verify) {
        this.user = user;
        this.verify = verify;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public Boolean ismatching(){
        if (user.getPassword().equals(verify)){
            return true;
        }
        return false;
    }
}
