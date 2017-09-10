# String	

ACSII code: 0 - 255 ---- int[256]

if all a - z, use diff int[26], like "x" - "a" : 0 ~25

Methods

charAt

indexOf ( char c)  :

length()

matches(String regex)

replace(char oldChar, char newChar)



split(String regex)
Splits this string around matches of the given regular expression



substring(int beginIndex, int endIndex)
Returns a new string that is a substring of this string.



toCharArray()



trim()
Returns a copy of the string, with leading and trailing whitespace omitted.



StringBuffer vs StringBuilder (synced)

append(char or char array or string )

charAt

delete(int index)

toString()

reverse()



When back from char array to string:

```java
char[] charArray = {'a', 'b', 'c'};
String str = String.valueOf(charArray);
```