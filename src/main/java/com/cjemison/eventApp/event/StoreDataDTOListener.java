package com.cjemison.eventApp.event;

import com.cjemison.eventApp.domain.StoreDataDTOEvent;
import com.cjemison.eventApp.service.DataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StoreDataDTOListener implements ApplicationListener<StoreDataDTOEvent> {
  private static final Logger LOGGER = LoggerFactory.getLogger(StoreDataDTOListener.class);
  private final DataService dataService;

  @Autowired
  public StoreDataDTOListener(final DataService dataService) {
    this.dataService = dataService;
  }

  @Override
  public void onApplicationEvent(final StoreDataDTOEvent event) {
    LOGGER.info("StoreDataDTOEvent: {}", event);
    if (event != null && event.getDataDTO() != null) {
      dataService.store(event.getDataDTO());
    }
  }
}
