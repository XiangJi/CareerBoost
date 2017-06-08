Htttp and https difference etc.

http是HTTP协议运行在TCP之上。所有传输的内容都是明文，客户端和服务器端都无法验证对方的身份。
https是HTTP运行在SSL/TLS之上，SSL/TLS运行在TCP之上。所有传输的内容都经过加密，加密采用对称加密，但对称加密的密钥用服务器方的证书进行了非对称加密。此外客户端可以验证服务器端的身份，如果配置了客户端验证，服务器方也可以验证客户端的身份。

在公共场所使用服务的时候，有https就用https。而http是明文传输的，如果有人抓到数据包，你在一个http
request里的数据都能见到。如果要在网站输入敏感信息, 一定确保是[https://开头的](https://开头的), 这个网站有敏感信息交互的，就用https

 

Restful Service

 