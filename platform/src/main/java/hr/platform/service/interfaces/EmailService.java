package hr.platform.service.interfaces;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);

    void notQualifiedMessage(String to, String fullname, String position);

    void sendTests(String to, String fullname, String position, String tests);

    void approvedForInterview(String to, String fullname, String position);

    void sendJopOffer(String to, String fullname,String jopOffer);

    void firsDayAtWorkHome(String to, String fullname, String time, String link);

    void firsDayAtWorkOffice(String to, String fullname, String time);
}
