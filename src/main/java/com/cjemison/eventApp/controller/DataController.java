package com.cjemison.eventApp.controller;

import com.cjemison.eventApp.domain.DataDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

public interface DataController {

  DeferredResult<ResponseEntity<?>> findAll();

  DeferredResult<ResponseEntity<?>> insert(final DataDTO dataDTO);

  DeferredResult<ResponseEntity<?>> delete(final String id);
}
