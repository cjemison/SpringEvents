package com.cjemison.eventApp.service.impl;

import com.cjemison.eventApp.domain.DataDTO;
import com.cjemison.eventApp.service.DataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
  public void store(final DataDTO dataDTO) {
    LOGGER.debug("DataDTO: {}", dataDTO);
    this.list.add(dataDTO);
  }

  @Override
  public void delete(final String id) {
    LOGGER.debug("Id: {}", id);
    int index = 0;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getId().equals(id)) {
        index = i;
      }
    }
    list.remove(index);
  }
}
