package com.tainika.qlnt.qlnt.service;

import com.tainika.qlnt.qlnt.ultil.Message;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class MessageResultService<T> {
    private String action;
    private String content;
    private String responseMessage;
    private T item;

    public MessageResultService(String action, T item) {
        this.action = action;
        this.item = item;
        this.content = item.toString();
    }

    public MessageResultService(String action, String content, T item) {
        this.action = action;
        this.content = content;
        this.item = item;
    }

    public MessageResultService<T> widthSuccessResponse() {
        this.responseMessage = String.format(Message.LOG.ACTION_SUCCESS.getName(), action, content);
        log.info(responseMessage);
        return this;
    }

    public MessageResultService<T> widthFailureResponse() {
        this.responseMessage = String.format(Message.LOG.ACTION_FAIL.getName(), action, content);
        log.info(responseMessage);
        return this;
    }

    public MessageResultService<T> widthErrorResponse() {
        this.responseMessage = String.format(Message.LOG.ACTION_ERROR.getName(), action, content);
        log.error(responseMessage);
        return this;
    }
}
