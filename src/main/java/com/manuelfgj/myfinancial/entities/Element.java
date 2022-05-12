package com.manuelfgj.myfinancial.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manuelfgj.myfinancial.entities.enums.Group;
import com.manuelfgj.myfinancial.entities.enums.Operation;
import com.manuelfgj.myfinancial.entities.enums.Type;

@Entity
@Table(name = "tb_element")
public class Element  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "elem_description")
	private String description;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	@Column(name = "elem_date")
	private Instant date;
	@Column(name = "elem_value")
	private Double value;
	@Column(name = "elem_operation")
	private Integer operation;
	@Column(name = "elem_group")
	private Integer group;
	@Column(name = "elem_type")
	private Integer type;
	private Integer portion;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Element() {		
	}


	public Element(Long id, String description, Instant date, Double value, Operation operation, Group group, Type type, Integer portion, User user) {
		super();
		this.id = id;
		this.description = description;
		this.setValue(value);
		this.date = date;
		setOperation(operation);
		setGroup(group);
		setType(type);
		this.portion = portion;
		this.user = user;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}
	
	public Operation getOperation() {
		return Operation.valueOf(operation);
	}

	public void setOperation(Operation operation) {
		if(operation != null) {
			this.operation = operation.getCode();
		}
	}
	
	public Group getGroup() {
		return Group.valueOf(group);
	}

	public void setGroup(Group group) {
		if(group != null) {
			this.group = group.getCode();
		}
	}
	
	public Type getType() {
		return Type.valueOf(type);
	}

	public void setType(Type type) {
		if(type != null) {
			this.type = type.getCode();
		}
	}
	
	public Integer getPortion() {
		return portion;
	}

	public void setPortion(Integer portion) {
		this.portion = portion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
