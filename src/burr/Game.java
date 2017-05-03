package burr;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/**
 * Represents a Game with players
 * @author Matthew Burr
 * @version 1.0
 * @since 2017-05-03
 */
public class Game {
  private Player player;
  private static Charset ENCODING = StandardCharsets.UTF_8;

  /**
   * Create a new Game
   * @param player a player in the Game
   */
  public Game(Player player) {
    this.player = player;
  }

  /**
   * Display the contents of the Game
   */
  public void display() {

    if (null != player) {
      player.display();
    }
    else {
      System.out.println("<empty>");
    }
  }

  /**
   * Save a game to a file
   * @param filename name of the file where the game will be saved
   */
  public void saveGame(String filename) {
    // Generate the JSON
    Gson gson = new Gson();
    Path path = Paths.get(filename);
    Writer writer = null;

    // Following code is reproduced/based on StackOverflow post:
    try {
      writer = Files.newBufferedWriter(path, ENCODING);
      gson.toJson(player, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (null != writer)
    {
      try {
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return;
  }

  /**
   * Load a new Game from a file
   * @param fileName file where the Game is stored
   * @return the Game that was saved in the file
   */
  public static Game loadGame(String fileName) {
    Gson gson = new Gson();
    Path path = Paths.get(fileName);
    Reader reader = null;
    Player player = null;

    try {
      reader = Files.newBufferedReader(path, ENCODING);
      player = gson.fromJson(reader, Player.class);
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (null != reader) {
      try {
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return new Game(player);
  }


}
