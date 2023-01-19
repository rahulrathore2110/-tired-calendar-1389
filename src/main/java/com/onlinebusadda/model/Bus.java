package com.onlinebusadda.model;

import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId;
	
	@NotNull(message = "Bus name cannot be null!")
	private String busName;
	
	@NotNull(message = "Bus driver name cannot be null!")
	private String driverName;
	
	@NotNull(message = "Bus type can not be null!")
	private String busType;
	
	
	@NotNull(message = "Start point cannot be null!")
	@NotBlank(message = "Start point cannot be blank!")
	private String routeFrom;
	
	@NotNull(message = "Destination point cannot be null!")
	@NotBlank(message = "Destination point cannot be blank!")
	private String routeTo;
	
	@NotNull(message = "Arrival time cannot be null!")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime arrivalTime;
	
	@NotNull(message = "Arrival time cannot be null!")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime departureTime;
	
	@NotNull(message = "seats should not be null")
	@Range(min=15,max=30, message = "Seats should be of between 15 to 30")
	private Integer seats;
	
	@NotNull(message = "seats should not be null")
	@Range(min=0,max=30, message = "Seats should be of between 0 to 30")
	private Integer availableSeats;
	
	@ManyToOne
	@JoinColumn(name = "route_FK")
	private Route route;
}