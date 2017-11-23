package com.cjemison.eventApp.service;

import com.cjemison.eventApp.domain.DataDTO;

import java.util.List;

public interface DataService {

  List<DataDTO> findAll();

  void store(final DataDTO dataDTO);

  void delete(final String id);
}
