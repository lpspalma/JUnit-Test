
package booking;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

class Test01FirstMock {
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
	void should_CalculateCorrectPrice_When_CorrectInput() {
		// given
		BookingRequest bookingRequest =new BookingRequest("1", LocalDate.of(2021,01,03),
				LocalDate.of(2021,01,10),2,false);
		double expected = 7 * 2 * 50;

		//when
		double actual = bookingService.calculatePrice(bookingRequest);

		//then
		assertEquals(expected, actual, 0.01);

	}

}
