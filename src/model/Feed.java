package model;

import java.util.ArrayList;
import java.util.List;

public class Feed {

    final String title;
    final String link;
    final String description;

    final List<FeedMessage> entries = new ArrayList<FeedMessage>();

    public Feed(String title, String link, String description) {
        this.title = title;
        this.link = link;
        this.description = description;
    }

    public class FeedMessage {

        String title;
        String description;
        String link;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }


        @Override
        public String toString() {
            return "FeedMessage [title=" + title + ", description=" + description
                    + ", link=" + link
                    + "]";
        }
    }

    public List<FeedMessage> getMessages() {
        return entries;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Feed [description=" + description
                + ", link=" + link + ", title=" + title + "]";
    }

}