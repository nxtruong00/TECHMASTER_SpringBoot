package vn.techmaster.jobhunt.model;

public enum City {
  HaNoi("Ha Noi"),
  HoChiMinh("Ho Chi Minh"),
  HaiPhong("Hai Phong"),
  DaNang("Da Nang"),

  Others("Others");

  public final String label;

  private City(String label) {
    this.label = label;
  }

}
