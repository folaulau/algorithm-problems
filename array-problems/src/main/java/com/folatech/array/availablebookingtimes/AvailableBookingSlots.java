package com.folatech.array.availablebookingtimes;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lombok.Data;

/**
 * Same problem as AvailableBookingTimes but Using LocaDateTime instead of int
 *
 */
public class AvailableBookingSlots {

	public AvailableBookingSlots() {
	}

	public static void main(String[] args) {

		AvailableBookingSlots booking = new AvailableBookingSlots();

		AppointmentSlot[] bookedAppointmentSlots = {
				new AppointmentSlot(LocalDateTime.of(2022, Month.NOVEMBER, 4, 10, 0),
						LocalDateTime.of(2022, Month.NOVEMBER, 4, 11, 0)),
				new AppointmentSlot(LocalDateTime.of(2022, Month.NOVEMBER, 4, 15, 0),
						LocalDateTime.of(2022, Month.NOVEMBER, 4, 16, 0)),
				new AppointmentSlot(LocalDateTime.of(2022, Month.NOVEMBER, 4, 12, 0),
						LocalDateTime.of(2022, Month.NOVEMBER, 4, 13, 0)), };

		List<AppointmentSlot> availableAppointmentSlots = booking.getAvailableTimes(bookedAppointmentSlots,
				LocalDateTime.of(2022, Month.NOVEMBER, 4, 8, 0), LocalDateTime.of(2022, Month.NOVEMBER, 4, 18, 0), 2);

		System.out.println("availableAppointmentSlots: " + availableAppointmentSlots);
	}

	List<AppointmentSlot> getAvailableTimes(AppointmentSlot[] bookedAppointmentArr, LocalDateTime startTime,
			LocalDateTime endTime, int duration) {

		Arrays.sort(bookedAppointmentArr,
				Comparator.comparingLong(b -> b.getStart().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()));

		List<AppointmentSlot> availableTimes = new ArrayList<>();

		int size = bookedAppointmentArr.length;

		for (int first = 0, second = 1; first < size; first++, second++) {
			AppointmentSlot bookedAppointments1 = (AppointmentSlot) bookedAppointmentArr[first];

			System.out.println("bookedAppointments1: " + bookedAppointments1);

			LocalDateTime bookedStartTime1 = bookedAppointments1.getStart();
			LocalDateTime bookedEndTime1 = bookedAppointments1.getEnd();

			if (first == 0) {

				if (bookedStartTime1.isAfter(startTime)) {

					long openHours = Duration.between(startTime, bookedStartTime1).toHours();

					if (openHours >= duration) {
						availableTimes.add(new AppointmentSlot(startTime, bookedStartTime1));
					}

				}

			} else {

				if (second >= size) {
					break;
				}

				AppointmentSlot bookedAppointments2 = bookedAppointmentArr[second];

				LocalDateTime bookedStartTime2 = bookedAppointments2.getStart();

				if (bookedStartTime2.isAfter(bookedEndTime1)) {

					long openHours = Duration.between(bookedEndTime1, bookedStartTime2).toHours();

					if (openHours >= duration) {
						availableTimes.add(new AppointmentSlot(bookedEndTime1, bookedStartTime2));
					}

				}

			}

		}

		return availableTimes;
	}
}

@Data
class AppointmentSlot {

	private LocalDateTime start;
	private LocalDateTime end;

	public AppointmentSlot(LocalDateTime start, LocalDateTime end) {
		this.start = start;
		this.end = end;
	}

//	public LocalDateTime getStart() {
//		return start;
//	}
//
//	public void setStart(LocalDateTime start) {
//		this.start = start;
//	}
//
//	public LocalDateTime getEnd() {
//		return end;
//	}
//
//	public void setEnd(LocalDateTime end) {
//		this.end = end;
//	}

}
