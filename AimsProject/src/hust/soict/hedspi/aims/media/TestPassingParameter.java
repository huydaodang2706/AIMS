package hust.soict.hedspi.aims.media;

public class TestPassingParameter {
	public static void main(String[] args) {
		Book book = new Book(null, null, null, 0);
		book.setContent("ai biet dc nao ban");
		book.processContent();
		System.out.println(book.toString());
	}
	
	public static void swap(DigitalVideoDisc o1,DigitalVideoDisc o2) {
		String tmp = o1.getTitle();
		o1.setTitle(o2.getTitle());
		o2.setTitle(tmp);
	}
	
	public static void changeTitle(DigitalVideoDisc dvd,String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}
