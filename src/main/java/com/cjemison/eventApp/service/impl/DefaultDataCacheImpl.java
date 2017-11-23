package com.cjemison.eventApp.service.impl;

import com.cjemison.eventApp.domain.DataDTO;
import com.cjemison.eventApp.service.DataCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class DefaultDataCacheImpl implements DataCache {
  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultDataCacheImpl.class);
  private final ConcurrentHashMap<String, DataDTO> map = new ConcurrentHashMap<>();

  @Override
  public void store(final DataDTO dataDTO) {
    LOGGER.debug("DataDTO: {}", dataDTO);
    map.put(dataDTO.getId(), dataDTO);
  }

  @Override
  public void delete(final String id) {
    LOGGER.debug("Id: {}", id);
    map.remove(id);
  }
}
