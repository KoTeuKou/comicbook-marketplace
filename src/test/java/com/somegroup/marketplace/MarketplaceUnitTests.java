package com.somegroup.marketplace;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class MarketplaceUnitTests {

    @Test
    public void testForNothing() {
        PasswordEncoder passwordEncoder = new StandardPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("password");
        Assertions.assertNotEquals(encodedPassword, "password+");
    }
}
