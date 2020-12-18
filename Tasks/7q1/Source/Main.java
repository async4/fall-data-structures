public class Main {

   public static void main(String[] args) {
      
      int column = 5;
      Grid grid = new Grid(column);
      
      grid.Add(new Computer("C1", 2.1f, 2, 128));
      grid.Add(new Computer("C2", 1.2f, 3, 128));
      grid.Add(new Computer("C3", 1.7f, 2, 256));
      grid.Add(new Computer("C4", 0.7f, 8, 512));
      grid.Add(new Computer("C5", 1.6f, 4, 840));

      /*
      grid.Add(new Computer("C6", 2.0f, 2, 128));
      grid.Add(new Computer("C7", 2.0f, 3, 128));
      grid.Add(new Computer("C8", 2.0f, 8, 128));
      grid.Add(new Computer("C9", 1.6f, 1, 128));
      grid.Add(new Computer("C10", 2.1f, 1, 512));
      grid.Add(new Computer("C11", 1.0f, 2, 128));
      grid.Add(new Computer("C12", 1.0f, 8, 256));
      grid.Add(new Computer("C13", 1.0f, 2, 256));
      grid.Add(new Computer("C14", 1.0f, 4, 128));
      grid.Add(new Computer("C15", 3.3f, 8, 512));
      grid.Add(new Computer("C16", 3.3f, 8, 256));
      */
      System.out.println(grid);
   }

}
