package Util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailUtilTest {

    @Test
    void proveriMailTacan() {
        String mail = "jovan@gmail.com";
        Assertions.assertEquals(false, EmailUtil.proveriMail(mail));
    }

    @Test
    void proveriMailNetacan() {
        String mail = "jovan.com";
        Assertions.assertEquals(true, EmailUtil.proveriMail(mail));
    }

    @Test
    void proveriMailPrazan() {
        String mail = "";
        Assertions.assertEquals(true, EmailUtil.proveriMail(mail));
    }
}