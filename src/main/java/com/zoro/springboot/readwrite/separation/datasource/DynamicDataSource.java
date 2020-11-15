package com.zoro.springboot.readwrite.separation.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/15 21:17
 *
 * @desc 动态切换数据源
 *
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DbThreadLocal.getDbType();
        if (typeKey == DbThreadLocal.WRITE) {
            log.info("使用了写库");
            return typeKey;
        }

        log.info("使用了读库");
        return DbThreadLocal.READ ;
    }
}
