package DSA.Misc.EncodeandDecodeTinyURL;

import java.util.HashMap;
import java.util.Map;

/*
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
 * and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * Design the encode and decode methods for the TinyURL service. There is no restriction
 * on how your encode/decode algorithm should work. You just need to ensure that a URL can be
 * encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 *
 * G F A
 * Like a design issue
 *
 */
public class Codec {
    // easy to predict, and range is limited by range of int
    Map<Integer, String> map = new HashMap<>();
    int                  i   = 0;

    public String encode(String longUrl) {
        map.put(i, longUrl);
        return "http://tinyurl.com/" + i++;
    }

    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }

    // 2.Using hashcode[Accepted]
    // map.put(longUrl.hashCode(), longUrl);
    // return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/",
    // "")));
    /*
     * The number of URLs that can be encoded is limited by the range of
     * \text{int}int, since \text{hashCode}hashCode uses integer calculations.
     *
     * The average length of the encoded URL isn't directly related to the
     * incoming \text{longURL}longURL length.
     *
     * The \text{hashCode()}hashCode() doesn't generate unique codes for
     * different string. This property of getting the same code for two
     * different inputs is called collision. Thus, as the number of encoded URLs
     * increases, the probability of collisions increases, which leads to
     * failure.
     */

    // 3 use random int number in hash code

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));