import keikenpiscine.ValidateIpv4Address;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidateIpv4AddressTest {
    @Test
    public void testValidIpAddress() {
        String ipAddress = "192.168.1.1";
        assertTrue(ValidateIpv4Address.validate(ipAddress));
    }

    @Test
    public void testInvalidIpAddress() {
        String ipAddress = "256.0.0.0";
        assertFalse(ValidateIpv4Address.validate(ipAddress));
    }

    @Test
    public void testIpAddressWithInvalidOctet() {
        String ipAddress = "192.168.1.x";
        assertFalse(ValidateIpv4Address.validate(ipAddress));
    }

    @Test
    public void testIpAddressWithTooFewOctets() {
        String ipAddress = "192.168.1";
        assertFalse(ValidateIpv4Address.validate(ipAddress));
    }

    @Test
    public void testIpAddressWithTooManyOctets() {
        String ipAddress = "192.168.1.1.1";
        assertFalse(ValidateIpv4Address.validate(ipAddress));
    }

    @Test
    public void testIpAddressWithZeroOctet() {
        String ipAddress = "192.168.0.0";
        assertFalse(ValidateIpv4Address.validate(ipAddress));
    }

    @Test
    public void testIpAddressWithBroadcastOctet() {
        String ipAddress = "192.168.1.255";
        assertFalse(ValidateIpv4Address.validate(ipAddress));
    }
}
