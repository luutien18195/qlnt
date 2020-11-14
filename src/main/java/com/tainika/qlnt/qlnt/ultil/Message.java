package com.tainika.qlnt.qlnt.ultil;

public interface Message {
    interface LOG {
        String ACTION_FAIL = "%s action is failed: %s";
        String ACTION_SUCCESS = "%s action is successed!: {%s}";
    }

    interface ACTION {
        String SIGN_UP = "Sign up";
        String SIGN_IN = "Sign in";
        String GET_ALL = "Get all";
    }

    interface ALERT {
        String USER_EXISTED = "User existed";
    }
}
