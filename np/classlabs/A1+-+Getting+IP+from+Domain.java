
//OCSALY Academy - Java Network Programming // LECTURER : Typhon .M

import java.io.IOException;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        InetAddress ocsaly = InetAddress.getByName("www.ocsaly.com");

        System.out.println("HOST ADDRESS        : " + ocsaly.getHostAddress());
        System.out.println("CANONICAL HOST NAME : " + ocsaly.getCanonicalHostName());
        System.out.println("HOST NAME           : " + ocsaly.getHostName());
        ocsaly.isReachable(10000);

    }
}