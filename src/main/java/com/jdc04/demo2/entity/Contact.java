package com.jdc04.demo2.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_details")
public class Contact {

	@Id
	@GeneratedValue
	@Column(name = "contact_id")
	private Integer contactId;

	private String contactName; // if @Column is not provided than column name will be contact_name

	private String contactEmail;

	private long contactNumber;

	private Character ActiveSwitch;

	private LocalDate createDate;

	private LocalDate updateDate;

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Character getActiveSwitch() {
		return ActiveSwitch;
	}

	public void setActiveSwitch(Character activeSwitch) {
		ActiveSwitch = activeSwitch;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public Contact(Integer contactId, String contactName, String contactEmail, long contactNumber,
			Character activeSwitch, LocalDate createDate, LocalDate updateDate) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.contactNumber = contactNumber;
		ActiveSwitch = activeSwitch;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Contact() {
		super();
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail=" + contactEmail
				+ ", contactNumber=" + contactNumber + ", ActiveSwitch=" + ActiveSwitch + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

}
