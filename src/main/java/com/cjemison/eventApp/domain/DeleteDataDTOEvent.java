package com.cjemison.eventApp.domain;

import org.springframework.context.ApplicationEvent;

import java.util.Objects;

public class DeleteDataDTOEvent extends ApplicationEvent {
  private final String id;

  public DeleteDataDTOEvent(final Object source, final String id) {
    super(source);
    this.id = id;
  }

  public String getId() {
    return id;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (!(o instanceof DeleteDataDTOEvent)) return false;
    final DeleteDataDTOEvent that = (DeleteDataDTOEvent) o;
    return Objects.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "DeleteDataDTOEvent{" +
          "id='" + id + '\'' +
          "} " + super.toString();
  }
}
