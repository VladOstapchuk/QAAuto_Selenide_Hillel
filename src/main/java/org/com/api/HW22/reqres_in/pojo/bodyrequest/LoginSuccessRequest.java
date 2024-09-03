package org.com.api.HW22.reqres_in.pojo.bodyrequest;

import org.com.api.HW22.reqres_in.pojo.UserData;

public class LoginSuccessRequest {

    private UserData userData;

    public LoginSuccessRequest(String email, String password) {
        this.userData = new UserData(email, password);
    }
}
