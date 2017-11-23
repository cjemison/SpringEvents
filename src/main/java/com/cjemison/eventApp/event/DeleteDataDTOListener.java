package com.cjemison.eventApp.event;


import com.cjemison.eventApp.domain.DeleteDataDTOEvent;
import com.cjemison.eventApp.service.DataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class DeleteDataDTOListener implements ApplicationListener<DeleteDataDTOEvent> {
  private static final Logger LOGGER = LoggerFactory.getLogger(DeleteDataDTOListener.class);
  private final DataService dataService;

  @Autowired
  public DeleteDataDTOListener(final DataService dataService) {
    this.dataService = dataService;
  }

  @Override
  public void onApplicationEvent(final DeleteDataDTOEvent event) {
    LOGGER.info("DeleteDataDTOEvent: {}", event);
    if (event != null && event.getId() != null) {
      dataService.delete(event.getId());
    }
  }
}
