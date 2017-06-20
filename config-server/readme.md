--http请求例子：
--在配置存储仓库只有master分支且有redis-dev-v1.*,redis-dev.*文件条件下
http://localhost:8888/redis/dev-v1/master 只会匹配到redis-dev-v1.*
http://localhost:8888/redis/dev/master 只会匹配到redis-dev.*
http://localhost:8888/redis-dev/v1/{label} 【其中{label}不是存储仓库拥有的分支时候，默认有一个master分支】不会匹配到任何配置文件
http://localhost:8888/redis-dev/v1/master或者http://localhost:8888/redis-dev/v1 会匹配到redis-dev-v1.*,redis-dev.*
http://localhost:8888/redis-dev/{profile}/faker 【其中{profile}为非v1时】只会匹配到redis-dev.*
http://localhost:8888/redis-dev/{profile} 等同于 http://localhost:8888/redis-dev/{profile}/master