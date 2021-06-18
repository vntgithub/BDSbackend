package vntrieu.train.bdsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Address {
  @Id
  @SequenceGenerator(
      name = "address_sequence",
      sequenceName = "address_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "address_sequence"
  )
  @Column(
      name = "id",
      updatable = false
  )
  private Long id;
  @Column(
      name = "street_id",
      nullable = false
  )
  private Long streetId;
  @Column(
      name = "ward_id",
      nullable = false
  )
  private Long wardId;
  @Column(
      name = "district_id",
      nullable = false
  )
  private Long districtId;
  @Column(
      name = "provitecity_id",
      nullable = false
  )
  private Integer provitecityId;

  @Override
  public String toString() {
    return "Address{" +
        "id=" + id +
        ", streetId=" + streetId +
        ", wardId=" + wardId +
        ", districtId=" + districtId +
        ", provitecityId=" + provitecityId +
        '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getStreetId() {
    return streetId;
  }

  public void setStreetId(Long streetId) {
    this.streetId = streetId;
  }

  public Long getWardId() {
    return wardId;
  }

  public void setWardId(Long wardId) {
    this.wardId = wardId;
  }

  public Long getDistrictId() {
    return districtId;
  }

  public void setDistrictId(Long districtId) {
    this.districtId = districtId;
  }

  public Integer getProvitecityId() {
    return provitecityId;
  }

  public void setProvitecityId(Integer provitecityId) {
    this.provitecityId = provitecityId;
  }

  public Address(Long id, Long streetId, Long wardId, Long districtId,
      Integer provitecityId) {
    this.id = id;
    this.streetId = streetId;
    this.wardId = wardId;
    this.districtId = districtId;
    this.provitecityId = provitecityId;
  }
}
