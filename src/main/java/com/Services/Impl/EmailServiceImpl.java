package com.Services.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.FoodBillDetail;
import com.Entity.Ticket;
import com.Entity.TicketDetail;
import com.Repository.FoodBillDetailRepository;
import com.Repository.TicketDetailRepository;
import com.Services.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private TicketDetailRepository ticketDetailRepository;
	@Autowired
	private FoodBillDetailRepository foodBillDetailRepository;

	public void sendMail(String to, String subject, String text, Multipart mp) throws MessagingException {
		final String from = "HaiSaCinema@gmail.com";
		final String password = "songlong123";
		String toAddress = to;
		Session session;
		Message mesg;
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		};
		session = Session.getInstance(properties, auth);
		session.setDebug(false);
		mesg = new MimeMessage(session);
		mesg.setFrom(new InternetAddress(from));
		mesg.setSubject(subject);
		InternetAddress toAdd = new InternetAddress(toAddress);
		mesg.addRecipient(Message.RecipientType.TO, toAdd);
		if (text == null) {
			mesg.setContent(mp);
		} else {
			mesg.setText(text);
		}
		Transport.send(mesg);
	}

	public Multipart setTextTicket(Ticket ticket, String filePath) throws IOException, MessagingException {
		List<String> listSeat = new ArrayList<>();
		System.out.println(ticket.getTicketId());
		List<TicketDetail> lisTicketDetails = ticketDetailRepository.findAllByTicketTicketId(ticket.getTicketId());
		for (TicketDetail ticketDetail : lisTicketDetails) {
			listSeat.add(ticketDetail.getSeat().getSeatName());
		}
		String listFood = "";
		List<FoodBillDetail> listFoodBillDetails = foodBillDetailRepository
				.findAllByTicketTicketId(ticket.getTicketId());

		for (FoodBillDetail foodBillDetail : listFoodBillDetails) {
			String foodText = "&emsp;&emsp;&emsp;&emsp;&emsp;Tên: " + foodBillDetail.getFood().getName()
					+ ", Số lượng: " + foodBillDetail.getQuantity() + "<br>";
			listFood += foodText;
		}
		Multipart mp = new MimeMultipart("related");

		String cid = "qr";

		MimeBodyPart pixPart = new MimeBodyPart();
		pixPart.attachFile(filePath);
		pixPart.setContentID("<" + cid + ">");
		pixPart.setDisposition(MimeBodyPart.INLINE);

		String text = "<b>Đây là mã code của quý khách: (Xin vui lòng không chia sẻ với bất kỳ ai)</b>"
				+ "<div><img src=\"cid:" + cid + "\" /></div></html>" + "<br><b>Thông tin vé: </b>"
				+ "<br>	&emsp;&emsp;Số lượng vé: " + ticket.getTicketQuantity() + "<br>	&emsp;&emsp;Tên phim: "
				+ ticket.getShowtimes().getMovie().getMovieName() + "<br> &emsp;&emsp;Giờ chiếu: "
				+ ticket.getShowtimes().getPeriod().getStartTime() + "<br> &emsp;&emsp;Tên rạp: "
				+ ticket.getShowtimes().getRoom().getCinema().getName() + "<br> &emsp;&emsp;Tên phòng: "
				+ ticket.getShowtimes().getRoom().getRoomName() + "<br> &emsp;&emsp;Ngày chiếu: "
				+ ticket.getShowtimes().getDate() + "<br> &emsp;&emsp;Số ghế: " + listSeat
				+ "<br> &emsp;&emsp;Đồ ăn, nước uống: <br>" + listFood + "<br><b>Tổng tiền: " + ticket.getTotal()
				+ "</b>" + "<br>Cám ơn quý khách, chúc quý khách xem phim vui vẻ";

		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setText(text, "utf-8", "html");

		mp.addBodyPart(textPart);
		mp.addBodyPart(pixPart);
		return mp;
	}
}
