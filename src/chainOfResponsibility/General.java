package chainOfResponsibility;

public class General extends Officer {
    private static final int CODE = 30;
    private static final String NAME = "General Mike";

    @Override
    public void processMessage(Message message) {
        if(message.getOfficerRank().equals(OfficerRank.GENERAL)
                && message.getCode() == CODE) {
            System.out.println(NAME + " received message " + message.getContent());
        } else {
            System.out.println("Wrong receiver!");
        }
    }
}
