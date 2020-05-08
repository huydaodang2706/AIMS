package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media{
	    
	private List<String> authors = new ArrayList<String>();
	private String content;
    private List<String> contentTokens = new ArrayList<>();
    private Map<String, Integer> wordFrequency = new TreeMap<>();

	public Book(List<String> authors,String title, String category, float cost) {
		super();
		this.authors = authors;
		this.cost = cost;
		this.category = category;
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		if(authors.contains(authorName.toLowerCase())) {
			System.out.println("Author has been in the list");
			return;
		}
		authors.add(authorName.toLowerCase());
		System.out.println("Add author successfully");
	}
	
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName.toLowerCase())) {
			authors.remove(authorName.toLowerCase());
			System.out.println("Successfully delete an author");
		}else {
			System.out.println("This author does not exists");
		}
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		if(this.getCost() == 0) {
			System.out.printf("%d. %s - %s : %f$ (Lucky item)\n",this.getId(),this.getTitle(),this.getCategory(),this.getCost());
		}else
			System.out.printf("%d. %s - %s : %f$ \n",this.getId(),this.getTitle(),this.getCategory(),this.getCost());
		System.out.print("List of authors:");
		for(int i=0;i<authors.size();i++) {
			System.out.print(authors.get(i) + " ");
		}
		System.out.println("");
	}
	

    public void processContent() {
    	int n;
        int count  = 1;
        String[] tempStr = content.split("[\\p{Punct}\\s]+", 0); //hard to understand regex here
        for(String tmp : tempStr) {
            if(!tmp.isEmpty())
                contentTokens.add(tmp.toLowerCase());
        }
        Collections.sort(contentTokens);
        n = contentTokens.size();
        if(contentTokens.isEmpty()) {
            System.out.println("No content.");
            return;
        }
        if(n == 1) {
            wordFrequency.put(contentTokens.get(0), 1);
            return;
        }
        for(int i = 1; i < n ; i++) {
            if(!contentTokens.get(i-1).equals(contentTokens.get(i))) {
                wordFrequency.put(contentTokens.get(i-1), count);
                count = 0;
            }
            else if(i == n - 1) {// check last element.
                wordFrequency.put(contentTokens.get(i), count + 1);
            }
            count++;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String temp;
        temp = Integer.toString(id) + "\n" + title + "\n" + category + "\n" + Float.toString(cost) + "\n";
        str.append(temp);
        str.append(content);
        temp = ("\n" + contentTokens.size() + " word.\n");
        str.append(temp);
        for(Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            temp = "[" + entry.getKey() + "," + entry.getValue() + "]" + "\n";
            str.append(temp);
        }
        
        return str.toString();
    }

}
