    package org.EmLo;
     
    import java.io.PrintStream;
    import java.util.Properties;
    import javax.mail.*;
    import javax.mail.internet.InternetAddress;
    import javax.mail.internet.MimeMessage;
    import javax.servlet.http.HttpServletRequest;
     
    public class TestEmail
    {
     
    public TestEmail()
    {
    }
     
    public static string getFullURL(HttpServletRequest request)
    {
    return request.getRequestURL().append("?").append(request.getQueryString()).toString();
    }
     
    public static string sendEmail(string to, string msg, string applicant)
    {
    system.out.println("sending the emaaaaiil");
    string username = ""; // Enter email
    string password = ""; // Enter password
    properties props = new properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    Session session = Session.getInstance(props, new object() /* anonymous class not found */
    class _anm1 {}
     
    );
    try
    {
    Message message = new MimeMessage(session);
    message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(to));
    message.setSubject((new StringBuilder("New Application from: ")).append(applicant).toString());
    message.setContent((new StringBuilder("<b> There is a new EmLo application from ")).append(applicant).append(" :</b> ").append("<br>").append("<a href=").append(msg).append("> Click here to view the application!").append("</a>").toString(), "text/html");
    Transport.send(message);
    system.out.println("Done");
    }
    catch(MessagingException e)
    {
    e.printStackTrace();
    return "Your application was not submitted. Please check your internet connection.";
    }
    return "Thank you for your application! The committee might decide to ask followup questions. They will get back to you as soon as they can.";
    }
    }

// A decompiler was used to obtain this code.
