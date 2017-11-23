package com.cjemison.eventApp.event;

import com.cjemison.eventApp.domain.StoreDataDTOEvent;
import com.cjemison.eventApp.service.DataCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CacheStoreDataDTOListner implements ApplicationListener<StoreDataDTOEvent> {
  private static final Logger LOGGER = LoggerFactory.getLogger(CacheStoreDataDTOListner.class);
  private final DataCache dataCache;

  public CacheStoreDataDTOListner(final DataCache dataCache) {
    this.dataCache = dataCache;
  }

  @Override
  public void onApplicationEvent(final StoreDataDTOEvent event) {
    LOGGER.info("event: {}", event);
    if (event != null && event.getDataDTO() != null) {
      dataCache.store(event.getDataDTO());
    }
  }
}
