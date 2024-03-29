题目描述
【设计题】
今日头条会根据用户的浏览行为、内容偏好等信息，为每个用户抽象出一个标签化的用户画像，用于内容推荐。用户画像的存储、高并发访问，是推荐系统的重要环节之一。现在请你给出一个用户画像存储、访问方案，设计的时候请考虑一下几个方面：

# 用户画像如何存储
1. 建立用户关系映射表，用户和标签为常量，关系为映射。
    保存用户画像最好使用缓存，比如memcached，同时后端要落地到DB。
    使用用户身份证号作为唯一键或用户注册时间等

2. 有了内存缓存的话，访问速度自然会有提升，除此之外，还要提高缓存的利用率，这样请求不会到DB去请求。

3. 同时还要减少单机查询流量，将不同用户分配到不同的机器上，可以采用分布式，比如按照用户的地区. ID的号段进行分开，这样每个机器的请求都是独立的，可以命中缓存，提高系统的性能。 

4. 一致性哈希，保证节点变化后用户访问的机器不变，比如之前在1号机器访问的用户还是到1号机器。
如何保证在线高并发. 低延迟地访问
