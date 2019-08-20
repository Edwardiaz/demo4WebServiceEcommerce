package com.ws.entity;

import java.io.Serializable;
//import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import com.ws.entity.Products;

@Entity
@Table(name = "products")
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idProducts")
	private Integer idProducts;
	@Column(name = "productCode")
	private char productCode;
	@Column(name = "sku")
	private String sku;
	@Column(name = "nameProducts")
	private String nameProducts;
	@Column(name = "description")
	private String description;
	@Column(name = "colour")
	private String colour;
//	@Temporal(TemporalType.DATE)
	@Column(name = "updateDate")
	private String updateDate;
	@Column(name = "price")
	private double price;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "taxes")
	private double taxes;
	@Column(name = "additionalShippingCost")
	private double additionalShippingCost;
	@Column(name = "wholeSalePrice")
	private double wholeSalePrice;
	@Column(name = "productDeliveryDate")
	private String productDeliveryDate;
	@Column(name = "width")
	private float width;
	@Column(name = "height")
	private float height;
	@Column(name = "depth")
	private float depth;
	@Column(name = "weight")
	private float weight;
	@Column(name = "idOrders")
	private int idOrders;
    
    @OneToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private Set<ProductsCategory> productsCategorySet;

	public Products() {
	}

	public Products(Integer idProducts) {
		this.idProducts = idProducts;
	}

	public Integer getIdProducts() {
		return idProducts;
	}

	public void setIdProducts(Integer idProducts) {
		this.idProducts = idProducts;
	}

	public char getProductCode() {
		return productCode;
	}

	public void setProductCode(char productCode) {
		this.productCode = productCode;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNameProducts() {
		return nameProducts;
	}

	public void setNameProducts(String nameProducts) {
		this.nameProducts = nameProducts;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTaxes() {
		return taxes;
	}

	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}

	public double getAdditionalShippingCost() {
		return additionalShippingCost;
	}

	public void setAdditionalShippingCost(double additionalShippingCost) {
		this.additionalShippingCost = additionalShippingCost;
	}

	public double getWholeSalePrice() {
		return wholeSalePrice;
	}

	public void setWholeSalePrice(double wholeSalePrice) {
		this.wholeSalePrice = wholeSalePrice;
	}

	public String getProductDeliveryDate() {
		return productDeliveryDate;
	}

	public void setProductDeliveryDate(String productDeliveryDate) {
		this.productDeliveryDate = productDeliveryDate;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getDepth() {
		return depth;
	}

	public void setDepth(float depth) {
		this.depth = depth;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getIdOrders() {
		return idOrders;
	}

	public void setIdOrders(int idOrders) {
		this.idOrders = idOrders;
	}
	

	public Set<ProductsCategory> getProductsCategorySet() {
		return productsCategorySet;
	}

	public void setProductsCategorySet(Set<ProductsCategory> productsCategorySet) {
		this.productsCategorySet = productsCategorySet;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducts != null ? idProducts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.idProducts == null && other.idProducts != null) || (this.idProducts != null && !this.idProducts.equals(other.idProducts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Products[ idProducts =" + idProducts + " ]";
    }
    
}