package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {
    // Declare variables here

    public void settings() {
        size(1000, 1000);
        //fullScreen(SPAN);
    }

    String[] sonnet;

    public void setup() {
        colorMode(HSB);
        loadFile("sonnet.txt");
        // Other setup code here
    }

    public void keyPressed() {
        // Code to handle key presses here
    }

    public void draw() {
        background(0);
        fill(255);
        noStroke();
        textSize(20);
        textAlign(CENTER, CENTER);
        // Code to draw things on the screen here
    }

    public void loadFile(String filename) {
        String[] lines = loadStrings(filename);
        for (String line : lines) {
            String[] words = split(line, ' ');
            for (int i = 0; i < words.length; i++) {
                String w = words[i].replaceAll("[^\\w\\s]","");
                String word = w.toLowerCase();
                if (!word.isEmpty()) {
                    if (i < words.length - 1) {
                        String nextWord = words[i + 1].replaceAll("[^\\w\\s]","").toLowerCase();
                        if (!nextWord.isEmpty()) {
                            addWord(word, nextWord);
                        }
                    } else {
                        addWord(word, null);
                    }
                }
            }
        }
    }

	private void addWord(String word, Object object) {
	}

}

class Word {
    private String word;
    private ArrayList<Follow> follows;

    public Word(String word) {
        this.word = word;
        this.follows = new ArrayList<>();
    }

    public String getWord() {
        return word;
    }

    public void addFollow(Follow follow) {
        follows.add(follow);
    }

    public ArrayList<Follow> getFollows() {
        return follows;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(word).append(": ");

        for (Follow follow : follows) {
            sb.append(follow.getWord()).append(", ");
        }

        // Remove the last comma and space
        if (follows.size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.toString();
    }
}

class Follow {
    private String word;
    private int count;

    public Follow(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        return word + ": " + count;
    }
}
