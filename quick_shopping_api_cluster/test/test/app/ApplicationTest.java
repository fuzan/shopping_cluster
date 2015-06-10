package test.app;


import org.junit.*;
import static org.fest.assertions.Assertions.*;

import generatedEntities.Booking_Notif_OTA.Booking_Notif;
import com.google.protobuf.InvalidProtocolBufferException;
import util.ObjectSerilizer;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void testProtoBuf() {
    	ObjectSerilizer os = new ObjectSerilizer();
    	byte[] b = os.objectBuilder("BookingId", "2015 10 11 14:12:55", "2015 10 14 09:12:55", "zanFu", 123, "312 807 7711",11111111,"paymentInstrument_123");
    	try {
    		Booking_Notif bn = (Booking_Notif) os.byteToObject(b);
    		
    		assertThat(bn.getBookingID().toString()).isEqualTo("BookingId");
    		assertThat(bn.getHotelId()).isEqualTo(123);
    		assertThat(bn.getCustomerName()).isEqualTo("zanFu");
    		assertThat(bn.getCustomerNumber()).isEqualTo(11111111);
    		assertThat(bn.getPaymentInstrumentId()).isEqualTo("paymentInstrument_123");

		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @Test
    public void renderTemplate() {
        //Content html = index.render("Your new application is ready.");
        //assertThat(contentType(html)).isEqualTo("text/html");
        //assertThat(contentAsString(html)).contains("Your new application is ready.");
    }
}