package com.cjemison.eventApp.service.impl;

import com.cjemison.eventApp.domain.DataDTO;
import com.cjemison.eventApp.service.DataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultDataServiceImpl implements DataService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultDataServiceImpl.class);
  private final List<DataDTO> list = new ArrayList<>();

  @Override
  public List<DataDTO> findAll() {
    return list;
  }

  @Override
  @Async
  public void store(final DataDTO dataDTO) {
    LOGGER.info("DataDTO: {}", dataDTO);
    this.list.add(dataDTO);
  }

  @Override
  @Async
  public void delete(final String id) {
    LOGGER.info("Id: {}", id);
    int index = 0;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getId().equals(id)) {
        index = i;
      }
    }
    list.remove(index);
  }
}
