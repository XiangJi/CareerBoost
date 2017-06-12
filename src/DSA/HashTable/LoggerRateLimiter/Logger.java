package DSA.HashTable.LoggerRateLimiter;

import java.util.HashMap;

public class Logger {
    private HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || map.get(message) + 10 <= timestamp) {
            map.put(message, timestamp);
            return true;
        } 
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */