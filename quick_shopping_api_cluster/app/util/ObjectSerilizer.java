package util;

import generatedEntities.Booking_Notif_OTA.Booking_Notif;
import java.io.IOException;
import com.google.protobuf.InvalidProtocolBufferException;


public class ObjectSerilizer {
	
	public byte[] objectToByte(Booking_Notif obj) throws IOException, ClassNotFoundException{
		Booking_Notif transport_obj = Booking_Notif.newBuilder(obj).build();
		return transport_obj.toByteArray();
	}
	
	public byte[] objectBuilder(String bookingID,String CheckinDate, String checkoutDate,String customerName,int HotelId,String phone,int customer_card_number, String paymentInstrumentId){
		Booking_Notif transport_obj = Booking_Notif.newBuilder().setBookingID(bookingID)
				                                                .setCheckinDate(CheckinDate)
				                                                .setCheckoutDate(checkoutDate)
				                                                .setCustomerName(customerName)
				                                                .setHotelId(HotelId)
				                                                .setPhone(phone).setCustomerNumber(customer_card_number).setPaymentInstrumentId(paymentInstrumentId)
				                                                .build();
		return transport_obj.toByteArray();
	}
	
	public Object byteToObject(byte[] data) throws InvalidProtocolBufferException{
		return Booking_Notif.parseFrom(data);
	}	
}