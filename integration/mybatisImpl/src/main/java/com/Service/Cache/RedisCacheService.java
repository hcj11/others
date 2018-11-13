package com.Service.Cache;

import com.redis.redisTemplate.HashUtil;
import java.util.concurrent.locks.ReadWriteLock;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.HashOperations;

/**
 * 注意此处RedisCacheService 并不是spring容器中的吧bean ,so。 Created by hcj on 18-7-18
 */
public class RedisCacheService implements Cache {

  public RedisCacheService() {

  }

  private  String HASHKEY = "mybatis_key:";

  public RedisCacheService(final String id) {
    if (id == null) {
      throw new IllegalArgumentException("Cache instances require an ID");
    }
    System.out.println("id= " + id);
    // 缓存标识
    this.HASHKEY=id;
  }

  public HashUtil getHashUtil() {
    return (HashUtil) ApplicationContextHolder.getBean("hashUtil");
  }

  public HashOperations<String, Object, Object> operations() {
    HashUtil hashUtil = getHashUtil();
    return hashUtil.getHashOperationsYZ();
  }

  @Override
  public String getId() {
    return HASHKEY;
  }

  // 添加并发锁，
  @Override
  public synchronized  void putObject(Object key, Object value) {
    // 根据 HASHKEY 来查询，
    operations().put(HASHKEY, key, value);
  }

  @Override
  public synchronized Object getObject(Object key) {
    // linkHashMap ? 判断若redis库中有该数据，那么就直接返回， 否则需要先查询在事务，在txCache-> logCache
    // [判断是否是事务性，根据是否出错，来进行提交【到redis数据库】或者回滚【删除redis数据】], redisCache,
    // -> 返回logCache[记录请求量和命中量，以便遍计算命中率] -> PerpetualCache -> ,logCache->
    // txCache -> 返回到controller
    // todo 当dml之后，默认是删除所有缓存记录，所以，此处需要修改，
    return operations().get(HASHKEY, key);

  }

  @Override
  public Object removeObject(Object key) {
    // 删除数据和写入数据要同步
    return operations().delete(HASHKEY, key);
  }

  @Override
  public void clear() {

    // 此处需要, 分情况考虑， 只删除对应表中的缓存，或者针对性的删除，
    getHashUtil().getRedisTemplateYZ().delete(HASHKEY);
  }

  @Override
  public int getSize() {
    Long size = operations().size(HASHKEY);
    // 强转报错 超过int的量还是不常见的
    return Integer.parseInt(String.valueOf(size));

  }

  @Override
  public ReadWriteLock getReadWriteLock() {
    return null;
  }


}
