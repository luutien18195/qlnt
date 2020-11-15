package com.tainika.qlnt.qlnt.ultil;

public interface StatusConstant {
    enum USER{
        TEMPORARY(0, "Tạm thời"),
        ACTIVE(1, "Hoạt động"),
        LOCK(2, "Đã khóa"),
        DELETED(3, "Đã xóa");

        Integer code;
        String content;

        USER(Integer code, String content) {
            this.code = code;
            this.content = content;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContentByStatusCode(Integer code) {
            for(int i = 0; i < USER.values().length; i++){
                if(USER.values()[i].getCode().equals(code))
                    return USER.values()[i].getContent();
            }
            return null;
        }
    }

    interface ROLE {
        String ADMIN = "ADMIN";
        String MANAGER = "MANAGER";
        String USER = "ROLE_USER";
        String GUEST = "GUEST";
    }
}
