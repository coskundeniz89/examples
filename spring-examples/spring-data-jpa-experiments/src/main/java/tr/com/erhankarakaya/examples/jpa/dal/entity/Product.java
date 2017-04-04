package tr.com.erhankarakaya.examples.jpa.dal.entity;

import mapper.Mappable;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product implements Mappable{
  @Id
  @SequenceGenerator(name="SEQ_GEN", sequenceName="SEQ_Product_Id", allocationSize=1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
  @Column(name = "ID", columnDefinition = "NUMBER")
  private Integer id;

  @Column(name = "TITLE", columnDefinition = "NVARCHAR2(250)")
  private String title;

  @Column(name = "QUANTITY", columnDefinition = "NUMBER")
  private Integer quantity;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
