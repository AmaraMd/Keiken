package keikenpiscine;

public class ValidateIpv4Address {
    public static boolean validate(String ipAddress) {
        String[] octets = ipAddress.split("\\.");

        if (octets.length != 4) {
            return false;
        }

        for (String octet : octets) {
            int value;
            try {
                value = Integer.parseInt(octet);
            } catch (NumberFormatException e) {
                return false;
            }

            if (value < 0 || value > 255) {
                return false;
            }

            if (value == 0 || value == 255) {
                return false;
            }
        }

        return true;
    }
}
