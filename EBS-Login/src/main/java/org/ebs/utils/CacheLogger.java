package org.ebs.utils;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheLogger implements CacheEventListener<Object, Object> {

    private static final Logger logger = LoggerFactory.getLogger(CacheLogger.class);

    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {
        logger.info("Key {} | EventType {} | OldValue {} | NewValue {}", cacheEvent.getKey(), cacheEvent.getType(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}
