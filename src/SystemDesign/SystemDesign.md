# System Design



Knowledge: scale from 0 to 10M users

Read the Alex book: Bookmark TO Page 25

Load balance:

- Nginx,(reverse proxy) HA proxy
- DNS load balance

http://mp.weixin.qq.com/s/C_Bz_vfFe2Sog4tUubrAew

Replicate DB master and slaves, write on master, read on slaves

Multiple reverse proxy load balance servers



Ten thousand users

Improve load/response by adding a cache layer and shifting static static (js,css/img/video files) to CDN content delivery network,

web server check (inside or outside) cache  first

cache will expire



## Twitter

## TinyURL





