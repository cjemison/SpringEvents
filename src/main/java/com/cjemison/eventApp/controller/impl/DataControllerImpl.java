package com.cjemison.eventApp.controller.impl;

import com.cjemison.eventApp.controller.DataController;
import com.cjemison.eventApp.domain.DataDTO;
import com.cjemison.eventApp.domain.DeleteDataDTOEvent;
import com.cjemison.eventApp.domain.StoreDataDTOEvent;
import com.cjemison.eventApp.service.DataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DataControllerImpl implements DataController {
  private static final Logger LOGGER = LoggerFactory.getLogger(DataControllerImpl.class);
  private final DataService dataService;
  private final ApplicationEventPublisher publisher;

  @Autowired
  public DataControllerImpl(final DataService dataService,
                            final ApplicationEventPublisher publisher) {
    this.dataService = dataService;
    this.publisher = publisher;
  }

  @Override
  @RequestMapping(value = "/data", method = RequestMethod.GET)
  public DeferredResult<ResponseEntity<?>> findAll() {
    LOGGER.info("findAll()");
    final DeferredResult<ResponseEntity<?>> deferredResult = getResponseEntityDeferredResult();
    deferredResult.setResult(ResponseEntity.ok(dataService.findAll()));
    return deferredResult;
  }

  @Override
  @RequestMapping(value = "/data", method = {RequestMethod.POST, RequestMethod.POST,
        RequestMethod.PATCH})
  public DeferredResult<ResponseEntity<?>> insert(@RequestBody final DataDTO dataDTO) {
    LOGGER.info("DataDTO: {}", dataDTO);
    dataDTO.setId(UUID.randomUUID().toString());
    publisher.publishEvent(new StoreDataDTOEvent(this, dataDTO));
    final DeferredResult<ResponseEntity<?>> deferredResult = getResponseEntityDeferredResult();
    final Map<String, String> map = createdMap();
    deferredResult.setResult(new ResponseEntity<>(map, HttpStatus.CREATED));
    return deferredResult;
  }

  @Override
  @RequestMapping(value = "/data/{id}", method = RequestMethod.DELETE)
  public DeferredResult<ResponseEntity<?>> delete(@PathVariable("id") final
                                                  String id) {
    LOGGER.info("id: {}", id);
    publisher.publishEvent(new DeleteDataDTOEvent(this, id));
    final DeferredResult<ResponseEntity<?>> deferredResult = getResponseEntityDeferredResult();
    final Map<String, String> map = createdMap();
    deferredResult.setResult(new ResponseEntity<>(map, HttpStatus.ACCEPTED));
    return deferredResult;
  }

  private DeferredResult<ResponseEntity<?>> getResponseEntityDeferredResult() {
    return new DeferredResult<>(60000L);
  }

  private Map<String, String> createdMap() {
    final Map<String, String> map = new HashMap<>();
    map.put("status", "done");
    return map;
  }
}
