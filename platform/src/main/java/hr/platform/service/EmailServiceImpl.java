package hr.platform.service;

import hr.platform.service.interfaces.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class EmailServiceImpl implements EmailService {
    private static final String SIGNATURE = "Best regards.\n" +
            "Asen Rangelov,HR Specialist, Company name. ";


    @Autowired
    private JavaMailSender emailSender;


    @Override
    public void sendSimpleMessage(
            String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }

    @Override
    public void notQualifiedMessage(String to, String fullname, String position) {
        String subject = "Feedback for:" + position;
        String text = "Dear," + fullname + "\n" +
                "Thank you for your interest for our positions:" + position + ".\n" +
                "Unfortunately your profile does not match our criteria.\n" +
                SIGNATURE;
        this.sendSimpleMessage(to, subject, text);
    }

    @Override
    public void sendTests(String to, String fullname, String position, String tests) {
        String subject = "Next step of the recruitment process for:" + position;
        String text = "Dear," + fullname + "\n" +
                "Thank you for your interest for our positions:" + position + ".\n" +
                "Your profile matches our needs. The next step is to make this tests:"
                + tests +
                //// TODO: 02-May-21  implement the surveymonkey API or other one with surveys
                "\n" +
                SIGNATURE;
        this.sendSimpleMessage(to, subject, text);


    }

    @Override
    public void approvedForInterview(String to, String fullname, String position) {
        String subject = "Next step of the recruitment process for:" + position;
        String text = "Dear," + fullname + "\n" +

                "Your results from the tests pass our criteria.We are going to call" +
                "for a short interview by phone." + "\n" +
                SIGNATURE;
        this.sendSimpleMessage(to, subject, text);


    }

    @Override
    public void sendJopOffer(String to, String fullname, String jopOffer) {
        String subject = "Company job Offer";
        String text = "Dear," + fullname + "\n" +

                "We are going to be happy to work together." + "\n" +
                "Attached you are going to find you job offer and more details."
                + "\n" +
                SIGNATURE;
        this.sendSimpleMessage(to, subject, text);

// TODO: 02-May-21  attach job offer as pdf 
    }


    @Override
    public void firsDayAtWorkHome(String to, String fullname, String time, String link) {
        String subject = "First day at work";
        String text = "Dear," + fullname + "\n" +

                "To access the welcome training you need to join the video at:" + time + "\n" +
                "Link for the training:" + link +
                "\n" +
                SIGNATURE;
        this.sendSimpleMessage(to, subject, text);

    }

    @Override
    public void firsDayAtWorkOffice(String to, String fullname, String time) {
        String subject = "First day at work";
        String text = "Dear," + fullname + "\n" +

                "We are going to wait you at our office:" + time + "\n" +
                "\n" +
                SIGNATURE;
        this.sendSimpleMessage(to, subject, text);
    }
}
