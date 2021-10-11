package com.laptrinhjavaweb.service.interf;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface IMailService {
    void sendMail();
    void sendMailForRoleUpdateMethod(String strOldRoleCode, String strUpdateRoleCode, String userNameCurrent, String userNameUpdate);
    void sendMailWithAPI(String subjectMail, String contentMail) throws MessagingException, UnsupportedEncodingException;
}
