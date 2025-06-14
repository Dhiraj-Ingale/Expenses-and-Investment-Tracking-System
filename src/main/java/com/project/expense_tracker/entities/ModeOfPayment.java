package com.project.expense_tracker.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "modeofpayments")
public class ModeOfPayment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "mopId")
	private long mopId;
	
	@NotBlank(message="This field is mandatory.")
	@Column(name = "modeOfPayment")
	private String modeOfPayment;

	public long getMopId() {
		return mopId;
	}

	public void setMopId(long mopId) {
		this.mopId = mopId;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public ModeOfPayment() {
		super();
	}

	public ModeOfPayment(long mopId, @NotBlank(message = "This field is mandatory.") String modeOfPayment) {
		super();
		this.mopId = mopId;
		this.modeOfPayment = modeOfPayment;
	}

	@Override
	public String toString() {
		return "ModeOfPayments [mopId=" + mopId + ", modeOfPayment=" + modeOfPayment + "]";
	}

}
