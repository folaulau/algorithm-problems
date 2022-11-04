package com.folatech.array.availablebookingtimes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lombok.Data;
import lombok.Getter;

/**
 * Interview questions from neem
 * 
 * get available booking times given already booked time slots
 * 
 * 
 */
public class AvailableBookingTimes {

	public static void main(String[] args) {
		int[][] bookedAppointments = { { 3, 20 }, { -2, 0 }, { 0, 2 }, { 16, 17 }, { 19, 23 }, { 30, 40 }, { 27, 33 } };

		int startTime = -5;
		int endTime = 27;
		int duration = 2;

		List<int[]> availableTimes = getAvailableTimes(bookedAppointments, startTime, endTime, duration);

		System.out.println("\nAvailableTimes");

		for (int[] openTime : availableTimes) {
			System.out.println("openTime: " + Arrays.toString(openTime));
		}
	}

	static List<int[]> getAvailableTimes(int[][] bookedAppointmentArr, int startTime, int endTime, int duration) {

		Arrays.sort(bookedAppointmentArr, Comparator.comparingInt(b -> b[0]));

		List<int[]> availableTimes = new ArrayList<>();

		int size = bookedAppointmentArr.length;

		for (int first = 0, second = 1; first < size; first++, second++) {
			int[] bookedAppointments1 = bookedAppointmentArr[first];

			int bookedStartTime1 = bookedAppointments1[0];
			int bookedEndTime1 = bookedAppointments1[1];

			if (first == 0) {

				if (bookedStartTime1 < Math.abs(startTime)) {

					int openHours = Math.abs(startTime - bookedStartTime1);

					if (openHours >= duration) {
						availableTimes.add(new int[] { startTime, bookedStartTime1 });
					}

				}

			} else {

				if (second >= size) {
					break;
				}

				int[] bookedAppointments2 = bookedAppointmentArr[second];

				int bookedStartTime2 = bookedAppointments2[0];
//				int bookedEndTime2 = bookedAppointments2[1];

				if (bookedEndTime1 < Math.abs(bookedStartTime2)) {

					int openHours = Math.abs(bookedStartTime2 - bookedEndTime1);

					if (openHours >= duration) {
						availableTimes.add(new int[] { bookedEndTime1, bookedStartTime2 });
					}

				}

			}

		}

		return availableTimes;
	}
}
