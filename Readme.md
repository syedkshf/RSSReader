**Title** : RSS Feed Reader

**Description** : This project is a RSS new feed reader that reads the RSS feed of a news network (CNN) and presents in GUI manner (JavaFX) where the title and snippet of the news is displayed. When the title of the news snippet is clicked, it will open the corresponding webpage of the news network in your browser.

**Classes:**

- Main.java _(execute and run this)_
- RSSReaderController.java
- Feed.java
- RSSFeedParser.java

**Main.java**

The Main class extends the javafx.application.Application class. The start() method is overridden which is the main entry point for the JavaFX application. The scene container (view) for the application is defined in RSSReader.fxml file

**RSSReader.fxml**

In this file the UI of the JavaFX is defined. It also links the controller defined in the RSSReaderController.java for the application.

**Feed.java**

The Feed.java defines the structure of an RSS feed to be used by the application. It has an inner class FeedMessage which represents one RSS message.

**This class is also where Inner Classes is demonstrated.**

**RSSReaderController.java**

This class implements the Initializable inteface where we override the initialize method which allows us to interact with it after everything defined in @FXML is set up and ready.

Two other methods are defined here i.e listViewClickAction which defines what to do when we click on the feed list of the JavaFX application and the openFeedClickAction to open the feed link in the browser.

**This class is also where Lamba Expressions are demonstrated.**

**RSSFeedParser.java**

This class is used to fetch the RSS Feed from the link provided (CNN). It defines a readFeed method which parses the XML document and stores the feed in it. Helper methods to achieve this are also defined in this class.

**Execution:**

To start the application, run the Main.java class but before that you need to configure your project dependencies to run JavaFX application.

**Download the JavaFX SDK**** ﻿**

1. Download the [JavaFX SDK](https://gluonhq.com/products/javafx/) package suitable for your operating system.
2. Unpack the archive and place the folder to a meaningful location, for example: **/Users/jetbrains/Desktop/javafx-sdk-12**.

**Make sure the JavaFX plugin is enabled**** ﻿**

To be able to work with JavaFX in IntelliJ IDEA, the  **JavaFX**  bundled plugin must be enabled:

1. In the  **Settings/Preferences**  dialog _(__Ctrl+Alt+S)_, select  **Plugins**.
2. Switch to the  **Installed**  tab and make sure that the  **JavaFX**  plugin is enabled. If the plugin is disabled, select the checkbox next to it.
3. Apply the changes and close the dialog. Restart the IDE if prompted.

### Add the JavaFX library﻿

These actions are required if you use Java 11 and later. If you use Java 10 and earlier, run the application created together with the project to make sure that everything is working as intended.

1. From the main menu, select  **File | Project Structure**  _(__Ctrl+Alt+Shift+S)_.
2. Open the  **Libraries**  section, click  **+** , and select  **Java**.
3. Specify the path to the  **lib**  folder in the JavaFX SDK package, for example: **/Users/jetbrains/Desktop/javafx-sdk-12/lib**.
4. In the  **Choose Modules**  dialog, select the necessary module and click  **OK**.
5. Apply the changes and close the  **Project Structure**  dialog.

### Add VM options﻿

These actions are required if you use Java 11 and later. If you use Java 10 and earlier, you can [run the sample application](https://www.jetbrains.com/help/idea/javafx.html#run) created together with the project to make sure that everything is working as intended.

1. From the main menu, select  **Run | Edit Configurations**.
2. Select  **Application | Main**  from the list on the left.
3. From the  **More options**  list, select  **Add VM options**.
4. In the  **VM options**  field, specify the following options, but make sure to replace _/path/to/javafx/sdk_ with the path the  **lib**  directory of the downloaded JavaFX SDK distribution (for example:  **/Users/jetbrains/Desktop/javafx-sdk-12/lib**  ):

--module-path /path/to/javafx/sdk --add-modules javafx.controls,javafx.fxml

If your path contains spaces, wrap it in double quotes, for example: **&quot;/Users/jetbrains/Desktop/My Folder/javafx-sdk-12/lib&quot;**.

If you&#39;re using JavaFX SDK 14 together with OpenJDK 14, add one more VM option:

--add-exports javafx.graphics/com.sun.javafx.sg.prism=ALL-UNNAMED

1. Apply the change and close the dialog.

### Run the application﻿

1. From the main menu, select  **Run | Run &#39;Main&#39;**  _(__Shift+F10)_.
2. The IDE starts compiling your code.
3. When the compilation is complete, the application window appears.
4. This means that the project is configured correctly and everything works as it should. The window is empty at the moment as we haven&#39;t added any elements yet.