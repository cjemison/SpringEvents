package com.cjemison.eventApp.service;

import com.cjemison.eventApp.domain.DataDTO;

public interface DataCache {

  void store(final DataDTO dataDTO);

  void delete(final String id);
}
