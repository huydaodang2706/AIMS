package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();;

	public CompactDisc(String artist,String title,String category,float cost) {
		super();
		this.artist = artist;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void addTrack(Track input) {
		if(tracks.contains(input))
			System.out.println("Track already exists");
		else {
			tracks.add(input);
			System.out.println("Add track successfully");
		}
			
	}
	public void removeTrack(Track input) {
		if(!tracks.contains(input)) 
			System.out.println("Track not exists");
		else {
			tracks.remove(input);
			System.out.println("Delete track successfully");
		}
	}
	public int getLength() {
		int totalLength = 0;
		for(int i=0;i<tracks.size();i++) {
			totalLength += tracks.get(i).getLength();
		}
		return totalLength;
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing compactDisc: " + this.getTitle());
		System.out.println("Disc length: " + this.getLength());
		System.out.println("Playing list of track:");
		for(int i=0;i<tracks.size();i++) {
			tracks.get(i).play();
		}
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		if(this.getCost() == 0) {
			System.out.printf("%d. %s - %s - %s : %f$ (Lucky item)\n",this.getId(),this.getTitle(),this.getCategory(),this.getArtist());
		}else
			System.out.printf("%d. %s - %s - %s : %f$ \n",this.getId(),this.getTitle(),this.getCategory(),this.getArtist(),this.getCost());
	}
	
}
