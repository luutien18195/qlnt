package com.tainika.qlnt.qlnt.common;

import com.tainika.qlnt.qlnt.ultil.Message;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Result<T> {
    private String action;
    private String content;
    private String responseMessage;
    private T item;

    public Result(String action, T item) {
        this.action = action;
        this.item = item;
        this.content = item.toString();
    }

    public Result(String action, String content, T item) {
        this.action = action;
        this.content = content;
        this.item = item;
    }

    public Result<T> success() {
        this.responseMessage = String.format(Message.LOG.ACTION_SUCCESS.getName(), action, content);
        log.info(responseMessage);
        return this;
    }

    public Result<T> failure() {
        this.responseMessage = String.format(Message.LOG.ACTION_FAIL.getName(), action, content);
        log.info(responseMessage);
        return this;
    }

    public Result<T> error() {
        this.responseMessage = String.format(Message.LOG.ACTION_ERROR.getName(), action, content);
        log.error(responseMessage);
        return this;
    }
}
