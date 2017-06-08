Different SQL JOINs

Before we continue with examples, we will listthe types of the different SQL JOINs you can use:

- **INNER     JOIN**:     Returns all rows when there is at least one match in BOTH tables
- **LEFT     JOIN**:     Return all rows from the left table, and the matched rows from the right     table
- **RIGHT     JOIN**:     Return all rows from the right table, and the matched rows from the left     table
- **FULL     JOIN**:     Return all rows when there is a match in ONE of the tables
- [http://stackoverflow.com/questions/38549/difference-between-inner-and-outer-joins](http://stackoverflow.com/questions/38549/difference-between-inner-and-outer-joins)
- Full     outer join is the union, inner is the intersection.
- ![visual explanation of joins](file:///C:/Users/xiangji/AppData/Local/Temp/msohtmlclip1/01/clip_image002.jpg)

 

\3. If two tables are given Author and books , how many maxand min records will you get if you apply inner join , right outer join , leftouter join?

有时为了得到完整的结果，我们需要从两个或更多的表中获取结果。我们就需要执行 join。 

SELECT Persons.LastName,Persons.FirstName, Orders.OrderNo

FROM Persons, Orders

WHERE Persons.Id_P =Orders.Id_P 

隐式join

显式 join

·       JOIN: 如果表中有至少一个匹配，则返回行

·       LEFT JOIN: 即使右表中没有匹配，也从左表返回所有的行

·       RIGHT JOIN: 即使左表中没有匹配，也从右表返回所有的行

·       FULL JOIN: 只要其中一个表中存在匹配，就返回行

FULL JOIN 关键字会从左表 (Persons) 和右表 (Orders) 那里返回所有的行。如果 "Persons" 中的行在表 "Orders" 中没有匹配，或者如果 "Orders" 中的行在表 "Persons" 中没有匹配，这些行同样会列出。

 

SQL joins are used to combine rows from two or more tables.

what is primer key, unique like id, for one table

foreign key, **外键**（英语：foreign key，台湾译作**外来键**），又称**外部键**。其实在关系数据库中，每个数据表都是由关系来连系彼此的关系，父数据表（Parent Entity）的[主键](https://zh.wikipedia.org/wiki/%E4%B8%BB%E9%94%AE)（primary key）会放在另一个数据表，当做属性以创建彼此的关系，而这个属性就是外键。

比如，学生跟老师之间是教学的关系，学生数据表会有个属性叫指导老师（FK），而这个值就是对应到老师数据表的老师代号（PK），学生的指导老师就是外键。

 

[http://a4academics.com/interview-questions/53-database-and-sql/411-sql-interview-questions-and-answers-database?showall=&limitstart](http://a4academics.com/interview-questions/53-database-and-sql/411-sql-interview-questions-and-answers-database?showall=&limitstart)=

 

SQL has many built-in functions for performing calculationson data.

- AVG()     - Returns the average value
- COUNT()     - Returns the number of rows
- FIRST()     - Returns the first value
- LAST()     - Returns the last value
- MAX()     - Returns the largest value
- MIN()     - Returns the smallest value
- SUM()     - Returns the sum

·       Aggregate functions often need an added GROUP BY statement.

·       

## ·       The GROUP BY Statement

·       The GROUP BY statement is used in conjunction with the aggregatefunctions to group the result-set by one or more columns.

按照group的东西做累计

http://blog.csdn.net/qbg19881206/article/details/8648991

### **SQL Statement:**

Edit the SQL Statement, and click "Run SQL" to see theresult.

Run SQL »

### **Result:**

Number ofRecords: 3

| **ShipperName****** | **NumberOfOrders** |
| ------------------- | ------------------ |
| Federal Shipping    | 68                 |
| Speedy Express      | 54                 |
| United Package      | 74                 |

 

 

SQL Server資料庫查詢速度慢的原因有很多，常見的有以下幾種：

1、沒有索引或者沒有用到索引(這是查詢慢最常見的問題，是程式設計的缺陷)

2、I/O輸送量小，形成了瓶頸效應。

3、沒有創建計算列導致查詢不優化。

4、記憶體不足

5、網路速度慢

6、查詢出的資料量過大(可以採用多次查詢，其他的方法降低資料量)

7、鎖或者鎖死(這也是查詢慢最常見的問題，是程式設計的缺陷)

8、sp_lock,sp_who,活動的使用者查看，原因是讀寫競爭資源。

9、返回了不必要的行和列

10、查詢語句不好，沒有優化

 

MySQL特点

而且由于 MySQ L是[开放源码](http://baike.baidu.com/view/394804.htm)软件，因此可以大大降低总体拥有成本。[Linux](http://baike.baidu.com/view/1634.htm)**作为**[操作系统](http://baike.baidu.com/view/880.htm)**，**[Apache](http://baike.baidu.com/subview/28283/5418752.htm)**和**** **[Nginx](http://baike.baidu.com/view/926025.htm)**作为**** Web ****服务器，****MySQL ****作为**[数据库](http://baike.baidu.com/view/1088.htm)**，****PHP/Perl/**[Python](http://baike.baidu.com/view/21087.htm)**作为服务器端**[脚本](http://baike.baidu.com/view/54.htm)[解释器](http://baike.baidu.com/view/592974.htm)**。由于这四个软件都是免费或**[开放源码](http://baike.baidu.com/view/394804.htm)**软件（**[FLOSS](http://baike.baidu.com/view/1483082.htm)**)****，因此使用这种方式不用花一分钱（除开人工成本）就可以建立起一个稳定、免费的**[网站系统](http://baike.baidu.com/view/3998653.htm)**，被业界称为****“**[LAMP](http://baike.baidu.com/view/365086.htm)**“****或****“**[LNMP](http://baike.baidu.com/view/3714049.htm)**”****组合**[3][ ](undefined) 。

## 系统特性

[编辑](javascript:;)

1．使用 C和 [C++](http://baike.baidu.com/view/824.htm)编写，并使用了多种[编译器](http://baike.baidu.com/view/487018.htm)进行测试，保证了[源代码](http://baike.baidu.com/view/60376.htm)的可移植性。

2．支持 [AIX](http://baike.baidu.com/view/349664.htm)、[FreeBSD](http://baike.baidu.com/view/21459.htm)、HP-UX、[Linux](http://baike.baidu.com/view/1634.htm)、[Mac OS](http://baike.baidu.com/view/157344.htm)、[Novell](http://baike.baidu.com/view/68826.htm)Netware、[OpenBSD](http://baike.baidu.com/view/337596.htm)、OS/2 Wrap、Solaris、[Windows](http://baike.baidu.com/view/4821.htm)等多种操作系统。

**3****．为多种**[编程语言](http://baike.baidu.com/view/552871.htm)**提供了**** **[API](http://baike.baidu.com/view/16068.htm)**。这些编程语言包括**** **[C](http://baike.baidu.com/view/10075.htm)**、****C++****、**[Python](http://baike.baidu.com/view/21087.htm)**、**[Java](http://baike.baidu.com/view/29.htm)**、**[Perl](http://baike.baidu.com/view/46614.htm)**、**[PHP](http://baike.baidu.com/view/99.htm)**、****Eiffel****、****Ruby,.NET****和**** Tcl ****等****。**

4．支持多线程，充分利用 CPU 资源。

5．优化的 [SQL](http://baike.baidu.com/view/34.htm)查询算法，有效地提高查询速度。

6．既能够作为一个单独的应用程序应用在[客户端服务器](http://baike.baidu.com/view/3028815.htm)网络环境中，也能够作为一个库而嵌入到其他的软件中。

7．提供多语言支持，常见的编码如中文的 [GB 2312](http://baike.baidu.com/view/93250.htm)、[BIG5](http://baike.baidu.com/view/98718.htm)，日文的 [Shift_JIS](http://baike.baidu.com/view/1568180.htm)等都可以用作数据表名和数据列名。

**8****．提供**** **[TCP/IP](http://baike.baidu.com/view/7729.htm)**、****ODBC ****和**** **[JDBC](http://baike.baidu.com/view/25611.htm)**等多种**[数据库](http://baike.baidu.com/view/1088.htm)**连接途径****。**

9．提供用于管理、检查、优化数据库操作的[管理工具](http://baike.baidu.com/view/1251417.htm)。

10．支持大型的数据库。可以处理拥有上千万条记录的大型数据库。

11．支持多种[存储引擎](http://baike.baidu.com/view/1238930.htm)。

12.MySQL是开源的，所以你不需要支付额外的费用。

13.MySQL使用标准的 [SQL](http://baike.baidu.com/view/34.htm)数据语言形式。

14.MySQL对 PHP 有很好的支持，[PHP](http://baike.baidu.com/subview/99/5828265.htm)是目前最流行的 Web 开发语言。

15.MySQL是可以定制的，采用了 [GPL](http://baike.baidu.com/view/130692.htm)协议，你可以修改源码来开发自己的 MySQL 系统。

16.在线 DDL/更改功能，数据架构支持动态应用程序和开发人员灵活性（5.6[4]  新增）

17.复制全局事务标识，可支持自我修复式集群（5.6[4]  新增）

18.复制无崩溃从机，可提高可用性（5.6[4]  新增）

19.复制多线程从机，可提高性能（5.6[4][ ](undefined) 新增）

 