package org.com.api.HW22.reqres_in.pojo.bodyrequest;

public class LoginSuccessRequest {

    private UserData userData;

    public LoginSuccessRequest(String email, String password) {
        this.userData = new UserData(email, password);
    }
}
