package com.cjemison.eventApp.domain;

import org.springframework.context.ApplicationEvent;

import java.util.Objects;

public class StoreDataDTOEvent extends ApplicationEvent{
  private final DataDTO dataDTO;

  public StoreDataDTOEvent(final Object source, final DataDTO dataDTO) {
    super(source);
    this.dataDTO = dataDTO;
  }

  public DataDTO getDataDTO() {
    return dataDTO;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (!(o instanceof StoreDataDTOEvent)) return false;
    final StoreDataDTOEvent that = (StoreDataDTOEvent) o;
    return Objects.equals(getDataDTO(), that.getDataDTO());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getDataDTO());
  }

  @Override
  public String toString() {
    return "StoreDataDTOEvent{" +
          "dataDTO=" + dataDTO +
          "} " + super.toString();
  }
}
