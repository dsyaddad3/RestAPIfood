package com.restfood.dto;

import java.util.Objects;

public class ValidationDto{
    private boolean status;
    private String messages;

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getMessages() {
        return messages;
    }
    public void setMessages(String messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ValidationDto)) {
            return false;
        }
        ValidationDto val = (ValidationDto) o;
        return this.status == val.isStatus() &&
            this.messages.equals(val.getMessages());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status,this.messages);
    }
    
}
