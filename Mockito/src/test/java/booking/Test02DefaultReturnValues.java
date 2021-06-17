
package booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

class Test02DefaultReturnValues {
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
	void should_CountAvailablePlaces() {
		// given
		//neste caso o expected deveria retornar um valor vazio pq o metodo busca uma lista de rooms availables
		//portanto como estamos usando moks o resultado seria 0
		int expected =0;

		//when
		int actual = bookingService.getAvailablePlaceCount();

		//then
		assertEquals(expected,actual);

	}

}
