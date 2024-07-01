package finalexam.task1;

import java.util.Date;

public class Meeting {

    private String title;
    private Date date;
    private String location;
    private String[] participants;


    public Meeting(String title, Date date, String location, String[] participants) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.participants = participants;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String[] getParticipants() {
        return participants;
    }

    public void setParticipants(String[] participants) {
        this.participants = participants;
    }


    public void addParticipant(String participant) {
        String[] newParticipants = new String[participants.length + 1];
        System.arraycopy(participants, 0, newParticipants, 0, participants.length);
        newParticipants[participants.length] = participant;
        this.participants = newParticipants;
    }


    public void removeParticipant(String participant) {
        if (participants.length == 0) {
            return;
        }
        String[] newParticipants = new String[participants.length - 1];
        int index = 0;
        for (String p : participants) {
            if (!p.equals(participant)) {
                newParticipants[index++] = p;
            }
        }
        this.participants = newParticipants;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", participants=" + String.join(", ", participants) +
                '}';
    }
}

