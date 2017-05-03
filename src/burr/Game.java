package burr;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Matthew on 5/2/2017.
 */
public class Game {
  private Player player;

  public Game(Player player) {
    this.player = player;
  }

  public void display() {
    player.display();
  }

  public void saveGame(String filename) {

    // Generate the JSON
    Gson gson = new Gson();
    String data = gson.toJson(player);

    // Following code is reproduced/based on StackOverflow post:
    // http://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
    try {
      PrintWriter pw = new PrintWriter(filename, "UTF-8");
      pw.print(data);
      pw.flush();
      pw.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    return;
  }

  public static Game loadGame(String fileName) {
    Path path = Paths.get(fileName);
    Charset encoding = StandardCharsets.UTF_8;
    StringBuilder rawData = new StringBuilder();
    try {
      Files.lines(path, encoding).forEachOrdered(l -> { rawData.append(l); });
    } catch (IOException e) {
      e.printStackTrace();
    }

    String data = rawData.toString();
    Gson gson = new Gson();
    Player player = gson.fromJson(data, Player.class);
    return new Game(player);
  }


}
