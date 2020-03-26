/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangmaple.fptu_maildesktopapp;

import java.io.Serializable;

/**
 *
 * @author bangmaple
 */
public final class SendMailDAO implements Serializable {

    public SendMailDAO() {
    }
    public void sendMail(final String userName, final String password, final String toAddress, final String subject, final String message) throws Exception {
        MailUtil.sendEmail("smtp.gmail.com", "587", userName, password, toAddress, subject, message);
    }
}
