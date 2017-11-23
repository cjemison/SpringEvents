package com.cjemison.eventApp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

public class DataDTO {
  @JsonProperty("id")
  private String id;
  @JsonProperty("firstName")
  private String firstName;
  @JsonProperty("middleName")
  private String middleName;
  @JsonProperty("lastName")
  private String lastName;

  public DataDTO() {
  }

  private DataDTO(final String id,
                  final String firstName,
                  final String middleName,
                  final String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(final String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (!(o instanceof DataDTO)) return false;
    final DataDTO dataDTO = (DataDTO) o;
    return Objects.equals(getId(), dataDTO.getId()) &&
          Objects.equals(getFirstName(), dataDTO.getFirstName()) &&
          Objects.equals(getMiddleName(), dataDTO.getMiddleName()) &&
          Objects.equals(getLastName(), dataDTO.getLastName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getFirstName(), getMiddleName(), getLastName());
  }

  @Override
  public String toString() {
    return "DataDTO{" +
          "id='" + id + '\'' +
          ", firstName='" + firstName + '\'' +
          ", middleName='" + middleName + '\'' +
          ", lastName='" + lastName + '\'' +
          '}';
  }

  public static DataDTO.Builder builder() {
    return new DataDTO.Builder();
  }

  public static class Builder {
    private String id = UUID.randomUUID().toString();
    private String firstName = "";
    private String middleName = "";
    private String lastName = "";

    public Builder id(final String value) {
      this.id = id;
      return this;
    }

    public Builder firstName(final String value) {
      this.firstName = firstName;
      return this;
    }

    public Builder middleName(final String value) {
      this.middleName = value;
      return this;
    }

    public Builder lastName(final String value) {
      this.lastName = value;
      return this;
    }

    public DataDTO build() {
      return new DataDTO(id, firstName, middleName, lastName);
    }
  }
}
