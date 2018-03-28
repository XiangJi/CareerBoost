# Iterator

是为了实现对collection容器遍历的interface，本事是个cursor

boolean hasnext

object next

remove 不建议使用 一般只用容器本身的remove



1. 迭代器可以提供统一的迭代方式。
2. 迭代器也可以在对客户端透明的情况下，提供各种不同的迭代方式。
3. 迭代器提供一种快速失败机制，防止多线程下迭代的不安全操作。

在ArrayList类创建迭代器之后，除非通过迭代器自身remove或add对列表结构进行修改，否则在其他

​          线程中以任何形式对列表进行修改，迭代器马上会抛出异常，快速失败。 