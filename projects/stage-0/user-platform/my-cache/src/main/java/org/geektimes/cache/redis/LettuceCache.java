package org.geektimes.cache.redis;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.geektimes.cache.AbstractCache;
import org.geektimes.cache.ExpirableEntry;
import org.geektimes.cache.serializer.CacheSerializer;

import javax.cache.CacheException;
import javax.cache.CacheManager;
import javax.cache.configuration.Configuration;
import java.io.Serializable;
import java.util.Set;

/**
 * @Author chenyue
 * @Date 2021-04-13
 */
public class LettuceCache<K extends Serializable, V extends Serializable> extends AbstractCache<K, V>  {

    private final StatefulRedisConnection<K, V> connection;
    private RedisCommands<K, V> syncCommands;

    protected LettuceCache(CacheManager cacheManager, String cacheName, Configuration<K, V> configuration,
                           StatefulRedisConnection<K, V> connection) {
        super(cacheManager, cacheName, configuration);
        this.connection = connection;
        syncCommands = connection.sync();
    }

    @Override
    protected boolean containsEntry(K key) throws CacheException, ClassCastException {
        return 0 != syncCommands.exists(key);
    }

    @Override
    protected ExpirableEntry<K, V> getEntry(K key) throws CacheException, ClassCastException {
        return ExpirableEntry.of(key, syncCommands.get(key));
    }

    @Override
    protected void putEntry(ExpirableEntry<K, V> entry) throws CacheException, ClassCastException {
        syncCommands.set(entry.getKey(), entry.getValue());
    }

    @Override
    protected ExpirableEntry<K, V> removeEntry(K key) throws CacheException, ClassCastException {
        ExpirableEntry<K, V> oldEntry = getEntry(key);
        syncCommands.del(key);
        return oldEntry;
    }

    @Override
    protected void clearEntries() throws CacheException {

    }

    @Override
    protected Set<K> keySet() {
        return null;
    }
}
