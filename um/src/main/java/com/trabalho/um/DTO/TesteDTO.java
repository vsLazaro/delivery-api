package com.trabalho.um.DTO;

public class TesteDTO {
  private String from;
  private String to;

  public TesteDTO(String from, String to) {
    this.from = from;
    this.to = to;
  }

  public TesteDTO() {
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  @Override
  public String toString() {
    return "HistoryDTO [from=" + from + ", to=" + to + "]";
  }
}
