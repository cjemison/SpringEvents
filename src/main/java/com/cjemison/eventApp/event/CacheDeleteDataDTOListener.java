package com.cjemison.eventApp.event;


import com.cjemison.eventApp.domain.DeleteDataDTOEvent;
import com.cjemison.eventApp.service.DataCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class CacheDeleteDataDTOListener implements ApplicationListener<DeleteDataDTOEvent> {
  private static final Logger LOGGER = LoggerFactory.getLogger(CacheDeleteDataDTOListener.class);
  private final DataCache dataCache;

  @Autowired
  public CacheDeleteDataDTOListener(final DataCache dataCache) {
    this.dataCache = dataCache;
  }

  @Override
  public void onApplicationEvent(final DeleteDataDTOEvent event) {
    LOGGER.info("DeleteDataDTOEvent: {}", event);
    if (event != null && event.getId() != null) {
      dataCache.delete(event.getId());
    }
  }
}
