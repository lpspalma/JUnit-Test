
package booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class Test03ReturningCustomValues {
	private BookingService bookingService;
	private PaymentService paymentServiceMock;
	private RoomService roomServiceMock;
	private BookingDAO bookingDAOMock;
	private MailSender mailSenderMock;


	@BeforeEach
	void setup(){
		this.paymentServiceMock =mock(PaymentService.class);
		this.roomServiceMock =mock(RoomService.class);
		this.bookingDAOMock =mock(BookingDAO.class);
		this.mailSenderMock =mock(MailSender.class);

		this.bookingService = new BookingService(paymentServiceMock,roomServiceMock,
				bookingDAOMock,mailSenderMock);
	}

	@Test
	void should_CountAvailablePlaces_When_OneRoomAvailable() {
		// given
		//ensianr o mokito a retornar coisas
		when(this.roomServiceMock.getAvailableRooms())
				.thenReturn(Collections.singletonList(new Room("Room 1",2)));
		int expected =2;

		//when
		int actual = bookingService.getAvailablePlaceCount();

		//then
		assertEquals(expected,actual);

	}
	@Test
	void should_CountAvailablePlaces_When_MultiplesRoomsAvailable() {
		// given
		//ensianr o mokito a retornar coisas
		List<Room> rooms = Arrays.asList(new Room("Room 1",2),new Room("Room 2",4));
		when(this.roomServiceMock.getAvailableRooms())
				.thenReturn(rooms);
		int expected =6;

		//when
		int actual = bookingService.getAvailablePlaceCount();

		//then
		assertEquals(expected,actual);
	}

}
