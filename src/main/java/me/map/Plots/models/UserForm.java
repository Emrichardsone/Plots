package me.map.Plots.models;

public class UserForm {

    private User user;

    private String verify;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
        return getPassword().equals(verify);
}

}