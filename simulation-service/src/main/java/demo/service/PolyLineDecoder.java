package demo.service;

import org.springframework.data.geo.Point;

import java.util.ArrayList;
import java.util.List;

/*
source: http://jeffreysambells.com/2010/05/27/decoding-polylines-from-google-maps-direction-api-with-java
 */
public class PolyLineDecoder {
    public PolyLineDecoder() {

    }

    public List<Point> decodePoly(String encoded) {
        List<Point> poly = new ArrayList<Point>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20 && index < len);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20 && index < len);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            Point p = new Point((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }

        return poly;
    }

//    public static void main(String[] args) {
//        String encoded = "}_ulFvq|tM@wLtOCnG@RHhArAzDvEZZTN|DjAz@Tv@Xp@f@j@j@b@j@vAhBhB~Bh@x@Zp@b@jAdCfIjDlLrClJVt@z@hBjBhEv@~A^l@|@hAtAlA|CdCdBtA|AnAVZTh@Jd@d@nGRhDNvBbD?hG?nJ?zC@`GApI?XLdC@zEBb@?Nh@`BxGx@`Dx@pDzB~IhBhHjCrK`CxJ|AnGdC|JfAhEhCtKn@`CtAzF~@jD@ZGd@Q`@Ij@Ch@Dj@L^XZZLZFJ@VCRGHGJKPIPQV?tAn@NDrFlCfCnA\\\\VNLBL@`@JRFFH@PDLLLVLPPLRBNAPETKp@c@XMBCLEh@AdAANIhBCvB@dBFl@?lA?JGzBA~EAvC?xB~InBAlA?@";
//        PolyLineDecoder decoder = new PolyLineDecoder();
//        List<Point> points = decoder.decodePoly(encoded);
//        for (Point p : points) {
//            System.out.println(p.getX() + "," + p.getY());
//        }
//        System.out.println(points.size());
//
//    }
}
