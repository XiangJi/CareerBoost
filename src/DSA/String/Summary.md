# String	

ACSII code: 0 - 255 ---- int[256]

if all a - z, use diff int[26], like "x" - "a" : 0 ~25

注意string to int method: Integer.parseInt()

String 是对象 比较用equals

String是不可变的对象 所以不能pass by "reference"

Methods

charAt

indexOf ( char c)  :

length()

matches(String regex)

replace(char oldChar, char newChar)

startsWith(String word, int offset)  ---> return boolean

split(String regex)
Splits this string around matches of the given regular expression

substring(int beginIndex, int endIndex)
Returns a new string that is a substring of this string.

String s = String.join(" ", sentence) + " ";// 先join成一个string 最后加个空格 

string.*substring* (j, i) mean index j to i - 1, stringBuilder也是一样的

```java
String s = "abcdefg";
System.out.println(s.substring(0, 6));
StringBuilder sb = new StringBuilder(s);
System.out.println(sb.substring(0, 7).toString());

abcdef
abcdefg
```

toCharArray() ： 用这个节省时间

trim()
Returns a copy of the string, with leading and trailing whitespace omitted.



StringBuffer vs StringBuilder (synced)

append(char or char array or string )

charAt

delete(int index)

setCharAt

toString()

reverse()



When back from char array to string:

```java
char[] charArray = {'a', 'b', 'c'};
String str = String.valueOf(charArray);
```


java io:

## 字符流与字节流的区别

经过以上的描述，我们可以知道字节流与字符流之间主要的区别体现在以下几个方面：

- 字节流操作的基本单元为字节；字符流操作的基本单元为Unicode码元。

- 字节流默认不使用缓冲区；字符流使用缓冲区。

- 字节流通常用于处理二进制数据，实际上它可以处理任意类型的数据，但它不支持直接写入或读取Unicode码元；字符流通常处理文本数据，它支持写入及读取Unicode码元。

- #### io.File 文件和文件夹的读写查,,字节流,,InputStream, OutputStream 抽象类,,FileInputSteam FileOutputSteam,,BufferedInputStream,,BufferedOutputSteam提高读写效率,,​,,字符流,,Reader / Writer 抽象类,,BufferedReader BufferdWriter,,InputStreamReader OutputStreamWriter,,字节流转字符流,,​,,​,,​