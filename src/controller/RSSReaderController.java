package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import model.Feed;
import model.RSSFeedParser;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RSSReaderController implements Initializable {

    private final String FEED_URL = "http://rss.cnn.com/rss/edition.rss";
    ObservableList<String> listViewList = FXCollections.observableArrayList();
    List<Feed> feedList = new ArrayList<>();
    @FXML
    private ListView<String> listView;
    @FXML
    private Label discriptionLabel;
    @FXML
    private Label titleLabel;
    private String link;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RSSFeedParser parser = new RSSFeedParser(FEED_URL);

        Feed feed = parser.readFeed();
        feed.getMessages().forEach(data -> {
            listViewList.add(data.getTitle());
            feedList.add(new Feed(data.getTitle(), data.getLink(), data.getDescription()));
        });
//        for (Feed.FeedMessage data : feed.getMessages()) {
//            listViewList.add(data.getTitle());
//            feedList.add(new Feed(data.getTitle(), data.getLink(), data.getDescription()));
//        }
        listView.setItems(listViewList);
    }


    @FXML
    void listViewClickAction(MouseEvent event) {

        String title = listView.getSelectionModel().getSelectedItem();
        feedList.forEach(data -> {
            if (data.getTitle().equals(title)) {
                titleLabel.setText(title);
                discriptionLabel.setText(data.getDescription());
                link = data.getLink();
            }
        });
//        for (Feed data : feedList) {
//            if (data.getTitle().equals(title)) {
//                titleLabel.setText(title);
//                discriptionLabel.setText(data.getDescription());
//                link = data.getLink();
//            }
////        }
    }

    @FXML
    void openFeedClickAction(MouseEvent event) {
        String url = link;

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
